import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * deals 5k to boss
 * 
 * @author Derek Nguyen 
 * @version v1.0
 */
public class reflectedfire extends Projectile
{
    public reflectedfire(Vector speed, int rotation)
    {
        super(speed,rotation, 5);
        this.turn(180);
    }
    /**
     * Act - do whatever the reflectedfire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (this.isAtEdge())
        {
            getWorld().removeObject(this);
            return;
        }
        if(reflect())
        {
            getWorld().removeObject(this);
            return;
        }
        move(5);
    }    
    public boolean reflect()
    {
        int damage = 5000;
        Boss be = (Boss)getOneIntersectingObject(Boss.class);
        if (be != null) 
        {
            be.hit(damage);
            return true;
        }
        return false;
    }
}
