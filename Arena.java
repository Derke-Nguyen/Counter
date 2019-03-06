import greenfoot.*;
import java.util.*;
/**
 * Creates the Arena, main part of the game
 * 
 * @author Derek Nguyen 
 * @version v1.0
 */
public class Arena extends World
{
    GreenfootSound bgm;
    boolean end = false;
    public Arena()
    {    
        // Create a new world with 1600x800 cells with a cell size of 1x1 pixels.
        super(1600, 800, 1); 
        GreenfootImage back = new GreenfootImage("background.png");
        this.setBackground(back);
        addObject(new Counter("HP: ", "/100"), 105, 710); //Health and cooldown bars
        addObject(new BossCounter("Villain HP: ", "/1000000"), 800, 50);
        addObject(new blockCounter("Block Cooldown: ", " ticks"), 110, 750);
        addObject(new dashCounter("Dash Cooldown: ", " ticks"), 110, 780);
        addObject(new Hero(),800,700);
        addObject(new Boss(),800,400);
        bgm = new GreenfootSound("battle.mp3");
        bgm.playLoop();
    }
    public void started() //starts title song
    {
        bgm.playLoop();
    }
    public void gameOver() //if you lose
    {
        end = true;
        List x = getObjects(Actor.class);
        removeObjects(x);
        addObject(new ScoreBoard(), 800, 400);
        bgm.pause();
        bgm = new GreenfootSound("loss.mp3");
        bgm.playLoop();
    }
    public void gameOverb() //if you win
    {
        end = true;
        List x = getObjects(Actor.class);
        removeObjects(x);
        addObject(new ScoreBoard('b'), 800, 400);
        bgm.pause();
        bgm = new GreenfootSound("win.mp3");
        bgm.playLoop();
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space") && end)
        {
            bgm.pause();
            Greenfoot.setWorld(new TitleScreen());
        }
    }
    public void stopped()
    {
      bgm.pause();  //pauses song
    }
    
}
