import greenfoot.*; 


/**
 * health of hero
 * 
 * @author Derek Nguyen 
 * @version v1.0
 */
public class Counter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int points;
    private String prefix;
    private String suffix;
    
    public Counter()
    {
        this(new String(), new String());
    }

    /**
     * Create a new counter, initialised to 0.
     */
    public Counter(String prefix, String suffix)
    {
        background = getImage();  // get image from class
        points = 100;
        this.prefix = prefix;
        this.suffix = suffix;
        updateImage();
    }
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        Hero me = (getWorld().getObjects(Hero.class).get(0)); 
        if(me == null)
        {
            getWorld().removeObject(this); //removes when hero die
            return;
        }
        points = me.gethp();
        updateImage();
    }
    /**
     * Set a new counter value.  This will not animate the counter.
     */
    public void setValue(int newValue) //updater
    {
        points = newValue;
        updateImage();
    }
    
    /**
     * Sets a text prefix that should be displayed before
     * the counter value (e.g. "Score: ").
     */
    public void setPrefix(String prefix) //type setter
    {
        this.prefix = prefix;
        updateImage();
    }
    public void setSuffix(String suffix) //unit setter
    {
        this.suffix = suffix;
        updateImage();
    }

    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage() //updater
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(prefix + points + suffix, 33, Color.BLACK, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 60, image.getHeight()+20);
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
