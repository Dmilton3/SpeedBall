import java.awt.*;

/**
 * Created by ASUS on 3/9/2016.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/*
 * Created by Dewey Milton with the assistance of the YouTube video https://www.youtube.com/watch?v=fSqH1lfr0Tg
 * for some methods, code and ideas for Pong game
 * Date 3/9/2016.
 *
 */

/*
   Ball controls all methods needed for the ball in the game
 */
public class Ball {

        Random rand = new Random();

        private int x = rand.nextInt(Pong.WINDOW_WIDTH);
        private int y = rand.nextInt(Pong.WINDOW_HEIGHT);
        private int speed = 7;

        private int xVelocity = 7;
        private int yVelocity = -7;
        private int size = 15;

    /*
       update
       updates ball position
     */
    public void update()
    {
        x = x + xVelocity;
        y = y + yVelocity;

        if(x < 0){
            xVelocity = 7;
        }
        else if(x + size > Pong.WINDOW_WIDTH - 7){
            xVelocity = - 7;
        }


        if(y < 0){
            yVelocity =  7 ;
        }
        else if(y + size > Pong.WINDOW_HEIGHT - 65){
            yVelocity = - 7 ;
        }


    }

    /*
      newBall
      Creates a new ball for new game  and reset
     */
    public void newBall(){
        this.x = rand.nextInt(Pong.WINDOW_WIDTH / 2);
        if(this.x < 100){
            this.x += 100;
        }
        else if(this.x > Pong.WINDOW_WIDTH - 100){
            this.x -= 100;
        }
        this.y = rand.nextInt(Pong.WINDOW_HEIGHT / 2);
    }

    /*
       getxVelocity
       @return xVelocity
     */
    public int getxVelocity(){
        return this.xVelocity;
    }

    /*
      getX
      @return X position
     */
    public int getX()
    {
        return this.x;
    }

    /*
      getY
      @return Y position
     */
    public int getY()
    {
        return this.y;
    }

    /*
      paint
      Paints Ball Graphics
     */
    public void paint(Graphics g)
    {
        g.setColor(Color.black);
        g.fillOval(x, y, size, size);
    }

    /*
      setXvelocity
      sets x velocity
       @param xVel xVelocity
       @param yVel yVelocity
     */
    public void setXYvelocity(int xVel, int yVel){
        this.yVelocity = 0;
        this.xVelocity = 0;
    }

    /*
        resetBall
        New position for ball when reset game
     */
    public void resetBall(){
        this.x = rand.nextInt(Pong.WINDOW_WIDTH);
        this.y = rand.nextInt(Pong.WINDOW_HEIGHT);
        this.xVelocity = 4;
        this.yVelocity = -4;
    }

    /*
    reverseDirection
    reverse direction of the ball
     */
    private void reverseDirection()
    {
        xVelocity = -xVelocity;
    }

    /*
      powerReverse
      speeds up reverse for power ups
     */
    private void powerReverse(){
        if(xVelocity < 0) {
            xVelocity = xVelocity - 2;
        }
        else{
            xVelocity = xVelocity + 2;
        }

    }

    /*
      powerReverseBottom
      Speeds up reverse for bottom power up
     */
    private void powerReverseBottom(){
        if(xVelocity < 0) {
            xVelocity = xVelocity - 2;
        }
        else{
            xVelocity = xVelocity + 2;
        }
    }

    /*
    collisionCheck
    Checks for contact of players
    @param Player player to look for
     */
    public void collisionCheck(Player player)
    {
        if(this.x >= player.getX() && this.x <= player.getX() + player.getWidth())
        {
           if(this.y >= player.getY() - 10 && this.y <= player.getY() + player.getHeight() + 10)
           {
               reverseDirection();
           }
        }
        else if(this.x == player.getX() && this.y >= player.getY()){
          reverseDirection();
    }
    }

    /*
    collisionCheckCpu
    @param Computer computer player
     */
    public void collisionCheckCpu(Computer computer)
    {
        if(this.x > computer.getX() - 5 && this.x < computer.getX() + computer.getWidth())
        {
            if(this.y > computer.getY() - 10 && this.y < computer.getY() + computer.getHeight() + 10)
            {
                System.out.println("Collision");
                reverseDirection();
            }
        }
    }

    /*
      collisionCheckPlayer2
      Looks for player 2 contact
      @param Player player 2
     */
    public void collisionCheckPlayer2(Player2 player2){
        if(this.x > player2.getX() - 5  && this.x < player2.getX() + player2.getWidth())
        {
            if(this.y > player2.getY() - 10 && this.y < player2.getY() + player2.getHeight() + 10)
            {
                reverseDirection();
            }
        }

    }

    /*
      collisionCheckPowerUp1
      looks for contact of top power up
      @param PowerUp1 top power Up
     */
    public void collisionCheckPowerUp1(PowerUp1 powerUp1) {
        if (this.x > powerUp1.getX() && this.x < powerUp1.getX() + powerUp1.getWidth() + 5) {
            if (this.y < powerUp1.getY() && this.y < powerUp1.getY() + powerUp1.getHeight() + 10) {
                powerReverse();
            }
        }
    }

    /*
      collisionCheckPowerUp2
      Looks for contact with bottom powerUp
      @param bottom power Up
     */
    public void collisionCheckPowerUp2(PowerUp2 powerUp2) {
        if (this.x > powerUp2.getX() && this.x < powerUp2.getX() + powerUp2.getWidth() + 5) {
            if (this.y > powerUp2.getY() && this.y > powerUp2.getY() + powerUp2.getHeight() - 10) {
                powerReverseBottom();
            }
        }
    }
}
