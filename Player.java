import javax.swing.*;
import java.awt.*;

/**
 * Created by Dewey Milton on 3/9/2016
 * Used some Methods and code ideas from youTube Video https://www.youtube.com/watch?v=fSqH1lfr0Tg
 *
 * Player class controls methods for player 1
 */
public class Player {

        private int yPos = Pong.WINDOW_HEIGHT / 2;
        private int yVelocity;
        private int xPos = 45;
        private Ball ball;

        private int width = 10;
        private int height = 60;

        /*
          Player constructor
          @param Ball
         */
        public Player(Ball ball) {
                this.ball = ball;
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
          @return X Position
         */
        public int getX()
        {
                return xPos;
        }

        /*
          update
          updates player position
         */
        public void update()
        {
          yPos = yPos + yVelocity;
        }

        /*
          paint
          paints player graphics
         */
        public void paint(Graphics g)
        {
           g.setColor(Color.blue);
           g.fillRect(xPos, yPos, width, height);

        }

        /*
         setYVelocity
         @param speed
          sets Velocity Speed
         */
        public void setYVelocity(int speed)
        {
           yVelocity = speed;
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
         @return Height
         */
        public int getHeight()
        {
                return height;
        }
}
