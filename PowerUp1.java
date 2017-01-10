import java.awt.*;

/**
 * Created by Dewey Milton on 3/25/2016.
 * Used some methods and code ideas from youTube video https://www.youtube.com/watch?v=fSqH1lfr0Tg
 *
 * PowerUp1, controls methods for top powerUp
 */
public class PowerUp1 {

        private int yPos;
        private int xVelocity;
        private int xPos;
        private Ball ball;
        private int speed;
        private int size;
        private int width;
        private int height;

        /*
          @param Ball to see ball location
         */
        public PowerUp1(Ball ball) {
            this.ball = ball;
            this.yPos = 30;
            this.xVelocity = 10;
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
          @return x Position
         */
        public int getX()
        {
            return xPos;
        }

        /*
         Update
         Updates powerUp1 position
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
            Paints the powerUp onto the screen
         */
        public void paint(Graphics g)
        {
            g.setColor(Color.GREEN);
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
          @return height
         */
        public int getHeight()
        {
            return height;
        }
    }


