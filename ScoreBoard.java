import greenfoot.*;
/**
 * Creates the end screen that you see
 * 
 * @author Derek Nguyen 
 * @version v1.0
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 400;
    /**
     * Scoreboard creators
     */
    /**
     * Create a score board for the final result.
     */
    public ScoreBoard()
    {
        makeImage("Game Over", "you tried...");
    }
    public ScoreBoard(char c)
    {
        makeImage("Vicotry!!!!");
    }
    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix) //for the lose screen
    {
        GreenfootImage image = new GreenfootImage("end.png"); //(WIDTH, HEIGHT);
        setImage(image);
    }
    private void makeImage(String win) //for the win screen
    {
        GreenfootImage image = new GreenfootImage("win.png");
        setImage(image);
    }
}
