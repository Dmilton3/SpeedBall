import java.awt.*;

/**
 * Created by ASUS on 3/24/2016.
 */
public class Player2 {


    private int yPos = Pong.WINDOW_HEIGHT / 2;
    private int xPos = Pong.WINDOW_WIDTH - 15 - (60 - getWidth());
    private int yVelocity;
    private Ball ball;

        private int width = 10;
        private int height = 60;

        public Player2(Ball ball) {
            this.ball = ball;
        }

        public int getY()
        {
            return yPos;
        }

        public int getX()
        {
            return xPos;
        }

        public void update()
        {
            yPos = yPos + yVelocity;
        }

        public void paint(Graphics g)
        {
            g.setColor(Color.red);
            g.fillRect(xPos, yPos, width, height);

        }

        public void ballCollision(){

        }


        public void setYVelocity(int speed)
        {
            yVelocity = speed;
        }

        public int getWidth()
        {
            return width;
        }

        public int getHeight()
        {
            return height;
        }
    }


