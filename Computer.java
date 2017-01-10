import java.awt.*;

/**
 * Created by Dewey Milron on 3/9/2016.
 * Had help with the construct and methods from youTube video at https://www.youtube.com/watch?v=fSqH1lfr0Tg
 *
 * Computer Class controls all methods used for the AI
 */
public class Computer {

    private GamePanel field;
    private int yPos = Pong.WINDOW_HEIGHT / 2;
    private int xPos = Pong.WINDOW_WIDTH - 15 - (60 - getWidth());

    private int testY = Pong.WINDOW_HEIGHT / 2;
    private int yVelocity = 0;

    private int width = 10;
    private int height = 60;

    /*
      Constructor takes
      @param Gamepanel to see everything in the game and access the ball location
     */
    public Computer(GamePanel game) {
       this.field = game;
    }

    /*
       getY
       @return Y position
     */
    public int getY()
    {
        return yPos;
    }

    /*
      getX
       @return x Position
     */
    public int getX()
    {
        return xPos;
    }

    /*
      update
      updates AI movement
     */
    public void update()
    {
        if(field.getBall().getxVelocity() > 0) {
            if (field.getBall().getY() < this.yPos) {
                yVelocity = -5;
            } else if (field.getBall().getY() > this.yPos)
                yVelocity = 5;
        }
        else
        yVelocity = 0;

        yPos = yPos + yVelocity;
    }

    /*
      paint
      paints CPU Graphics
     */
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(xPos, yPos, width, height);
    }

    /*
      getWidth
      @return width of CPU player
     */
    public int getWidth()
    {
        return width;
    }

    /*
      getHeight
       @return hieght of cpu player
     */
    public int getHeight()
    {
        return height;
    }
}
