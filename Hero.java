import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    private int hp;
    private GreenfootImage idle;
    private GreenfootImage blocker;
    private GreenfootImage dasher;
    public int counter;
    public int ds;
    
    public Hero()
    {
        hp = 100;
        idle = new GreenfootImage("Hero.png");
        blocker = new GreenfootImage("Heroblock.png");
        dasher = new GreenfootImage("Herodash.png");
        setImage(idle);
        setRotation(270);
        counter = 50;
        ds = 30;
    }
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("w")) //up
        {
            movefor();
        }
        if(Greenfoot.isKeyDown("s")) //down
        {
            moveback();
        }
        if(Greenfoot.isKeyDown("a")) //left
        {
            moveleft();
        }
        if(Greenfoot.isKeyDown("d")) //right
        {
            moveright();
        }
        if(Greenfoot.isKeyDown("j") && this.counter == 50) //block, changes color, and resets cd
        {
            this.setImage(blocker);
            block();
            this.counter = 0;
        }
        if(Greenfoot.isKeyDown("k") && this.ds == 30) //block, changes color, resets cd
        {
            this.setImage(dasher);
            dash();
            this.ds = 0;
        }
        if(this.hp <= 0) //if die
        {
            zero();
        }
        if(this.counter < 50)
        {
            counter++;
        }
        if(this.ds < 30)
        {
            ds++;
        }
        if(this.counter == 50 && this.ds == 30) //resets image
        {
            this.setImage(idle);
        }
       
    }
    public void movefor()
    {
        setRotation(270);
        move(8); 
    }
    public void moveback()
    {
        setRotation(90);
        move(8);
    }
    public void moveleft()
    {
        setRotation(180);
        move(8);
    }
    public void moveright()
    {
        setRotation(0);
        move(8);
    }
    public void block() //for all intercepting fireballs, send them back 
    {
        List<Projectile> x = new ArrayList();
        x = getObjectsInRange(110, Projectile.class);
        for(Projectile z: x)
        {
            reflectedfire ball = new reflectedfire(new Vector(z.getRotation(), 15), z.getRotation());
                getWorld().addObject (ball, z.getX(), z.getY());
                ball.move(2);
                getWorld().removeObject(z);
        }
        return;
    }
    public void dash()
    {
         move(150);
    }
    public void hit(int damage) //if you get hit
    {
        this.hp -= damage;
    }
    public int gethp()
    {
        return this.hp;
    }
    public void sethp(int hep)
    {
        this.hp = hep;
    }
    public int getcd()
    {
        return 50 - this.counter;
    }
    public int getds()
    {
        return 30 - this.ds;
    }
    public void zero() //if die
    {
        ((Arena)getWorld()).gameOver();
    }
}
