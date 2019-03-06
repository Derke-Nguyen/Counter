import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * deals 5 to hero
 * 
 * @author Derek Nguyen 
 * @version v1.0
 */
public class fire extends Projectile
{
    public fire(Vector speed, int rotation)
    {
        super(speed,rotation, 5);
        setRotation(rotation);
    }
    public void act() 
    {
        super.act();
        move(5);
    }    
}
