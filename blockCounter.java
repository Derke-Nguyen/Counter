import greenfoot.*; 
/**
 * shows cd of abilities
 * 
 * @author Derek Nguyen 
 * @version v1.0
 */
public class blockCounter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int points;
    private String prefix;
    private String suffix;
    
    public blockCounter()
    {
        this(new String(), new String());
    }

    /**
     * Create a new counter, initialised to 0.
     */
    public blockCounter(String prefix, String suffix)
    {
        background = getImage(); 
        points = 0;
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
            getWorld().removeObject(this);
            return;
        }
        points = me.getcd();
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
    public void setPrefix(String prefix) //sets type 
    {
        this.prefix = prefix;
        updateImage();
    }

    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage() //updater
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(prefix + points + suffix, 22, Color.BLACK, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
