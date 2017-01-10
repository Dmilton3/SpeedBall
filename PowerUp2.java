import java.awt.*;

/**
 * Created by Dewey Milton on 3/25/2016.
 * Used some code ideas and methods from youTube video https://www.youtube.com/watch?v=fSqH1lfr0Tg
 *
 * PowerUp2 controls methods for the bottom powerUp
 */
public class PowerUp2 {


        private int yPos;
        private int xVelocity;
        private int xPos;
        private Ball ball;
        private int size;
        private int width;
        private int height;

        /*
          Constructor for PowerUp2
          @param Ball takes ball to see on game
         */
        public PowerUp2(Ball ball) {
            this.ball = ball;
            this.yPos = 300;
            this.xVelocity = -10;
            this.xPos = Pong.WINDOW_WIDTH / 2;
            this.width = 100;
            this.height = 10;
            this.size = 30;
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
          @return x position
         */
        public int getX()
        {
            return xPos;
        }

        /*
          update
          updates position of Powerup 2
         */
        public void update()
        {
            xPos = xPos + xVelocity;


            if(xPos < 20){
                xVelocity = 7;
            }
            else if(xPos + size > Pong.WINDOW_WIDTH - 70){
                xVelocity = -7;
            }

        }

        /*
          paint
          paints powerUp2 onto the bottom of the screen
         */
        public void paint(Graphics g)
        {
            g.setColor(Color.BLACK);
            g.fillRect(xPos, yPos, width, height);

        }

        /*
          getWidth
          @return width
         */
        public int getWidth()
        {
            return width;
        }

        /*
          getHeight
          @return Height of powerup2
         */
        public int getHeight()
        {
            return height;
        }
    }


