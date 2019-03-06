import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * basically it spins
 * 
 * @author Derek Nguyen 
 * @version v1.0
 */
public class laser extends Actor
{
    private int counter;
    /**
     * Act - do whatever the laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public laser()
    {
        this.counter = 0;
    }
    public laser(int x)
    {
        this.counter = 0;
        this.setRotation(90);
    }
    public void act() 
    {
        checkspellHit(1); //hero touch: 1 dmg
        if(counter == 70)
        {
            turn(1);
        }
        if(counter != 70)
        {
            counter++;
        }
    } 
    public void checkspellHit(int damage)
    {
        Hero me = (Hero)getOneIntersectingObject(Hero.class);
        if (me != null) 
        {
            me.hit(damage);
        }
    }
}
