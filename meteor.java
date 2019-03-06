import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * makes things go boom! :D
 * 
 * @author Derek Nguyen 
 * @version v1.0
 */
public class meteor extends Actor
{
    private int counter;
    public meteor()
    {
        counter = 0;
    }
    public void act() 
    {
        if(counter < 40) //delay
        {
            turn(5);
        }
        if(counter >= 40)
        {
            explode();
        }
        counter++;
    } 
    public void explode()
    {
        if(this.counter == 45)//the start explosion
        {
         this.setImage("ev1.png"); 
         damage();
        }
        if(this.counter == 50)
        {
            this.setImage("ev2.png");
            damage();
        }
        if(this.counter == 70)
        {
            this.setImage("ev3.png");
            damage();
        }
        if(this.counter == 90)
        {
            getWorld().removeObject(this); //after it disappears
        }
    }
    public void damage() //if you run into explosion, you take dmg
    {
        Hero me = (Hero)getOneIntersectingObject(Hero.class);
        if (me != null) 
        {
            me.hit(50);
        }
    }
}
