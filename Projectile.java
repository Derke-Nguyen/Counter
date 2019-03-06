import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * base for all projectiles
 * 
 * @author Derek Nguyen 
 * @version v1.0
 */
public class Projectile extends Actor
{
    private Vector velocity;
   private int X;
   private int Y;
   private int damage;
    /** The damage this bullet will deal */
    
    public Projectile(Vector speed, int rotation, int dmg)
    {
        this.velocity = speed;
        setRotation(rotation);
        damage = dmg;
    }
    public int getdmg() //sets how much dmg it will deal
    {
        return this.damage;
    }
    
    /**
     * The bullet will damage asteroids if it hits them.
     */
    public void act()
    {
        if (this.isAtEdge())
        {
            getWorld().removeObject(this);
            return;
        }
        if(checkspellHit(this.damage))
        {
            getWorld().removeObject(this);
            return;
        }
        
    }
    public void mirror() //if hero reflects it
    {
        this.turn(180);
    }
    
    /**
     * Check whether we have hit an asteroid.
     */
    public boolean checkspellHit(int damage) //how much dmg is dealt
    {
        Hero me = (Hero)getOneIntersectingObject(Hero.class);
        if (me != null) 
        {
            me.hit(damage);
            return true;
        }
        return false;
    }
} 
