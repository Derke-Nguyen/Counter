import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * The Main enemy
 * 
 * @author Derek Nguyen 
 * @version v1.0
 */
public class Boss extends Actor
{
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int healthb; //health
    public GreenfootImage b1; //base image
    public int counter; //sets delays and stuff
    public int transition; //sets up transition stages
    public int lag; //transition stages
    public int load; //loads stuff
    public GreenfootImage b2; //chasing image
    public Boss()
    {
        healthb = 1000000; //1,000,000
        b1 = new GreenfootImage("boss.png");
        b2 = new GreenfootImage("bossdash.png");
        setImage(b1);
        counter = 0;
        transition = 0;
        lag = 0;
        load = 0;
    }
    public void act()
    {
        Hero me = (Hero)getOneIntersectingObject(Hero.class);
        if (me != null)  //if hero is touched
        {
            me.hit(2);
        }
        if(this.healthb >= 800000 && (load == 207))// 1 - 0.8 fireball spin
        {
            Phase1();
        }
        if(transition == 0 && this.healthb <= 799999 && this.healthb >= 600000) //sets to chase
        {
            transition = 1;
            setImage(b2);
            return;
        }
        
        if(this.healthb >= 600000 && this.healthb <= 799999) // 0.79 - 0.6
        {
            Phase2();
        }
        if(transition == 1 && this.healthb <= 599999 && this.healthb >= 500000) //sets back to idle
        {
            this.setLocation(800,400);
            transition--;
            setImage(b1);
            return;
        }
        if(this.healthb >= 500000 && this.healthb <= 599999 ) //0.59 - 0.5 meteor
        {
            Phase3();
        }
        if(transition == 0 && this.healthb <= 500000 && this.healthb >= 200000) //sets to chase
        {
            this.setLocation(800,400);
            counter = 0;
            transition++;
            setImage(b2);
        }
        if(this.healthb >200000  && this.healthb <= 499999) // 0.49 - 0.2 health drop
        {
            Phase4();
        }
        if(transition == 1 && this.healthb <= 200000)//sets to idle
        {
            this.setLocation(800,400);
            counter = 0;
            transition++;
            this.healthb--;
            GreenfootImage rest = getImage();  
            rest.scale(rest.getHeight() / 2, rest.getWidth() / 2);
            setImage(b1);
        }
        if(this.healthb < 200000) //lazor
        {
            if(lag == 19)
            {
                getWorld().addObject(new laser(), getX(), getY());
                getWorld().addObject(new laser(1), getX(), getY());
            }
            if(lag == 20)
            {
                Phase5();
            }
            if(lag != 20)
            {
                lag++;
            }
        }
        if(this.healthb <= 0)
        {
            zero();
        }
        if(load != 207)
        {
            load++;
        }
    }
    public void Phase1() //spinny fireballs
    {
        turn(2);
        if( counter == 0)
        {
            fire();
        }
        counter++;
        if(counter == 3)
        {
            counter = 0;
        }

    }
    public void Phase2() //random direction dash
    {
        if(counter == 1)
        {
            int rot = (int)(Math.random() * (360));
            this.setRotation(rot);
        }
        if(counter>32)
        {
            this.move(17);
        }
        if(this.isAtEdge())
        {
            this.healthb -= 20000;
            this.setLocation(800,400);
            counter = 0;
        }
        counter++;
        return;
    }
    public void Phase3() //EXPLOSION!!!
    {
        this.setLocation(800,400);
        turn(20);
        meteor();
        this.healthb -= 100;
    }
    public void Phase4() //chases you and health packs
    {
        setImage(b2);
        Hero me = (Hero)getWorld().getObjects(Hero.class).get(0);
        if (isAtEdge()) 
        {
            this.turnTowards(me.getX(), me.getY());
            this.move(15);
        }
        this.move(15);
        if(counter > 200)
        {
            getWorld().addObject(new hpack(), getX(), getY());
            counter = 0;
            this.healthb -= 40000;
            return;
        }
        counter++;
    }
    public void Phase5() //lasers and fireballs
    {
        turn(-1);
        this.healthb -= 25;
        if( counter == 1)
        {
            fire();
        }
        if(counter == 10)
        {
            counter = 0;
        }
        counter++;
    }
    public void fire() //shoots fireball
    {
        fire fireball = new fire(new Vector(getRotation(), 15), getRotation());
        getWorld().addObject (fireball, getX(), getY());
        fireball.move(2);
    }
    public int gethp()
    {
        return this.healthb;
    }
    public void meteor()
    {
        if( counter == 3)
        {
            int x = (int)(Math.random() * (1600));
            int y = (int)(Math.random() * (800));
            getWorld().addObject(new meteor(), x, y);
        }
        if(counter == 16)
        {
            counter = 0;
        }
        counter++;
    }
    public void hit(int damage) //when reflected
    {
        this.healthb -= damage;
    }
    public void zero() //when die
    {
        ((Arena)getWorld()).gameOverb();
    }
    
    
}
