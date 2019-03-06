import greenfoot.*; 
/**
 * Creates the boss health bar
 * 
 * @author Derek Nguyen 
 * @version v1.0
 */
public class BossCounter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int points;
    private String prefix;
    private String suffix;
    
    public BossCounter()
    {
        this(new String(), new String());
    }

    /**
     * Create a new counter, initialised to 0.
     */
    public BossCounter(String prefix, String suffix)
    {
        background = getImage();  // get image from class
        points = 1000000;
        this.prefix = prefix;
        this.suffix = suffix;
        updateImage();
    }
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() //gets the boss's health
    {
        Boss bb = (getWorld().getObjects(Boss.class).get(0));
        if(bb == null)
        {
            getWorld().removeObject(this);
            return;
        }
        points = bb.gethp();
        updateImage();
    }
    /**
     * Set a new counter value.  This will not animate the counter.
     */
    public void setValue(int newValue) //constantly reloads the bar
    {
        points = newValue;
        updateImage();
    }
    public int gethp() //sends the values of boss
    {
        return this.points;
    }
    
    /**
     * Sets a text prefix that should be displayed before
     * the counter value (e.g. "Score: ").
     */
    public void setPrefix(String prefix) //sets personal stuff
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
        GreenfootImage text = new GreenfootImage(prefix + points + suffix, 50, Color.WHITE, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 900, image.getHeight()+60);
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
