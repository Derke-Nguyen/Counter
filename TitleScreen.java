import greenfoot.*;

/**
 * the title screen of the game where you can grab info
 * 
 * @author Derek Nguyen 
 * @version v1.0
 */
public class TitleScreen extends World
{
    private int counter;
    private boolean pause;
    private GreenfootImage t1;
    private GreenfootImage t2;
    private GreenfootImage t3;
    private GreenfootImage t4;
    private GreenfootSound bgm;
    private boolean ready;
    public TitleScreen()
    {
        super(1600, 800, 1);
        t1 = new GreenfootImage("title screen2.png");
        t2 = new GreenfootImage("instruc.png");
        t3 = new GreenfootImage("cont.png");
        t4 = new GreenfootImage("credits.png");
        setBackground(t1);
        bgm = new GreenfootSound("title.mp3");
        bgm.playLoop();
        counter = 0;
        pause = false;
        ready = false;
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space") && ready) //starts game
        {
            bgm.pause();
            Greenfoot.setWorld(new Arena());
        }
        if(Greenfoot.isKeyDown("o") && ready) //gives the objective of the game
        {
            setBackground(t3);
        }
        if(Greenfoot.isKeyDown("h") && ready) //gives the controls
        {
            setBackground(t2);
        }if(Greenfoot.isKeyDown("b") && ready) //returns to title screen
        {
            setBackground(t1);
        }
        if(Greenfoot.isKeyDown("c") && ready) //prints out the credits
        {
            setBackground(t4);
        }
        if(counter < 30)
        {
            counter++;
        }
        if(counter == 30)
        {
            ready = true;
        }
    }
}
