import greenfoot.*;
/**
 * Object to pick up to restore health
 * 
 * @author Derek Nguyen 
 * @version v1.0
 */
public class hpack extends Actor
{
    GreenfootSound boop;
    public hpack()
    {
        boop = new GreenfootSound("drop.mp3");
        boop.play();
    }
    public void heal() //heals hero
    {
        Hero me = (Hero)getOneIntersectingObject(Hero.class);
        if (me != null) 
        {
            me.hit(-10);
            if(me.gethp() > 100)
            {
                me.sethp(100);
            }
            getWorld().removeObject(this);
        }
    }
    public void act() 
    {
        heal();
    }    
}
