
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;


/**
 * Created by Dewey Milton on 3/9/2016.
 * GamePanel Runs and Holds the game screen and controls the flow of the game
 * Some methods, code and ideas for Pong game were used from the YouTube Video https://www.youtube.com/watch?v=fSqH1lfr0Tg
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener
{
    private Player player1;
    private Ball ball = new Ball();
    private Player2 player2;
    private Computer cpu;
    public static Sound sound;
    private int player1Score;
    private int player2Score;
    private Timer time;
    private StopWatch clock;
    private recordKeep topScores;
    private String player1Name;
    private String player2Name;
    private boolean is2Player;
    private PowerUp1 powerUp1;
    private PowerUp2 powerUp2;

    /*
    Constructor for Gamepanel
    @param _scores takes score template
    @param _is2Player states whether 2 player or not
    @param _player1 Player 1 name
    @param _player2 Player 2 name
     */
    public GamePanel(recordKeep _Scores, boolean _is2Player, String _player1, String _player2)
      {
          this.powerUp1 = new PowerUp1(this.ball);
          this.powerUp2 = new PowerUp2(this.ball);
          this.is2Player = _is2Player;
          this.player1 = new Player(this.ball);
          if(is2Player) {
              this.player2 = new Player2(this.ball);
          }
          else {
              this.cpu = new Computer(this);
          }
          this.time = new Timer(25, this);
          time.start();
          this.clock = new StopWatch(0,0,0,0,true);
          this.addKeyListener(this);
          this.setFocusable(true);
          sound = new Sound();
          this.topScores = _Scores;
          this.is2Player = _is2Player;
          this.player1Name = _player1;
          this.player2Name = _player2;
          this.player1Score = 0;
          this.player2Score = 0;
      }


    /*
       Updates all the methods of the game in order to keep things moving
     */
    private void update()
    {
        powerUp1.update();
        powerUp2.update();
        player1.update();
        ball.update();
        if(is2Player){
            player2.update();
        }
        else {
            cpu.update();
        }
        clock.update();

        ball.collisionCheckPowerUp1(powerUp1);
        ball.collisionCheckPowerUp2(powerUp2);

        ball.collisionCheck(player1);
        if(is2Player){
            ball.collisionCheckPlayer2(player2);
        }
        else {
            ball.collisionCheckCpu(cpu);
        }
        scoreUpdate();

    }

    /*
        scoreUpdate
        updates the score whenever a goal is achieved and checks whether or not player has won
     */
    public void scoreUpdate(){
        if(this.ball.getX() <= 15 && this.ball.getX() >= 0){
            if(this.ball.getY() >= Pong.WINDOW_HEIGHT / 2 - 80 && this.ball.getY() <= Pong.WINDOW_HEIGHT / 2 + 15){
                this.ball.newBall();
                sound.playBuzzer();
                player2Score++;
                System.out.println("CPU Score " + player2Score);
                if(player2Score == 7){
                      player2Score = clock.scoreCalc();
                        topScores.checkScore(player2Name, player2Score);
                        reset();
                }
            }
        }
        else if(this.ball.getX() >= Pong.WINDOW_WIDTH - 25){
            if(this.ball.getY() >= Pong.WINDOW_HEIGHT / 2 - 90 && this.ball.getY() <= Pong.WINDOW_HEIGHT / 2 + 60){
                this.ball.newBall();
                sound.playBuzzer();
                player1Score++;
                System.out.println("Player 1 Score " + player1Score);
                if(player1Score == 7){
                   player1Score = clock.scoreCalc();
                    topScores.checkScore(player1Name, player1Score);
                    reset();
                }
            }
        }
    }

    /*
    reset
    Resets the game back for a new game
     */
    private void reset(){
        String scores = topScores.toString();
        this.ball.setXYvelocity(0,0);
        int choice = JOptionPane.showConfirmDialog(null, scores + "\n Would you like to start a new game?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(choice == JOptionPane.NO_OPTION){
            System.exit(0);
        }
        else if(choice == JOptionPane.YES_OPTION){
            this.player2Score = 0;
            this.player1Score = 0;
            this.clock.resetTime();
            this.ball.resetBall();
        }
    }

    /*
      paintComponent
      Paints all the graphics on the screen
     */
    public void paintComponent(Graphics g)
    {


        //Air Hockey Field
        g.setColor(Color.white);
        g.fillRect(0, 0, Pong.WINDOW_WIDTH + 200, Pong.WINDOW_HEIGHT);

         //ScoreBoard
        g.setColor(Color.BLACK);
        g.fillRect(0, 335, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);
        g.setColor(Color.GREEN);
        g.drawString(player1Name + ": " + player1Score, 130, 360);
        g.drawString(player2Name + ": " + player2Score, 550, 360);


        //Time Clock
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString(clock.getTime(), Pong.WINDOW_WIDTH + 30, 40);
        powerUp1.paint(g);
        powerUp2.paint(g);
        paintScore(g);
        player1.paint(g);
        ball.paint(g);

        if(is2Player){
            player2.paint(g);
        }
        else {
            cpu.paint(g);
        }
        //Field Seperator
        g.setColor(Color.BLACK);
        g.drawLine(Pong.WINDOW_WIDTH / 2, Pong.WINDOW_HEIGHT, Pong.WINDOW_WIDTH / 2, 335);
        g.drawLine(Pong.WINDOW_WIDTH, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT + 100);

        //Field Seperators
        g.setColor(Color.RED);
        g.drawLine(Pong.WINDOW_WIDTH / 2, Pong.WINDOW_HEIGHT + 200, Pong.WINDOW_WIDTH / 2, 0);
        g.drawOval(Pong.WINDOW_WIDTH / 2 - 25, Pong.WINDOW_HEIGHT / 2 - 50, 50, 50);
        g.setColor(Color.BLACK);
        g.fillRect(Pong.WINDOW_WIDTH - 25, Pong.WINDOW_HEIGHT / 2 - 80, 20, 100);
        g.fillRect(0, Pong.WINDOW_HEIGHT / 2 - 80, 15, 100);

    }

    /*
    paintScore
    Paints the score board
     */
    private void paintScore(Graphics g){
        String scoreBoard = "";
        g.setColor(Color.blue);
        g.drawString("Top Low Scores!", Pong.WINDOW_WIDTH + 25, 75);
        g.setFont(new Font("TimesRoman", Font.BOLD, 15));

        g.drawString(topScores.indexString(0), Pong.WINDOW_WIDTH + 30, 100);
        g.drawString(topScores.indexString(1), Pong.WINDOW_WIDTH + 30, 125);
        g.drawString(topScores.indexString(2), Pong.WINDOW_WIDTH + 30, 150);
        g.drawString(topScores.indexString(3), Pong.WINDOW_WIDTH + 30, 175);
        g.drawString(topScores.indexString(4), Pong.WINDOW_WIDTH + 30, 200);
        g.drawString(topScores.indexString(5), Pong.WINDOW_WIDTH + 30, 225);
        g.drawString(topScores.indexString(6), Pong.WINDOW_WIDTH + 30, 250);
        g.drawString(topScores.indexString(7), Pong.WINDOW_WIDTH + 30, 275);
        g.drawString(topScores.indexString(8), Pong.WINDOW_WIDTH + 30, 300);
        g.drawString(topScores.indexString(9), Pong.WINDOW_WIDTH + 30, 325);

        if(player1Score >= 7 || player2Score >= 7){
            repaint();
        }

    }





    /*
       getBall
       @return Ball
     */
    public Ball getBall()
    {
        return this.ball;
    }

    /*
       actionPerformed
       controls actions for timer
     */
    public void actionPerformed(ActionEvent e)
    {
        update();
        repaint();
    }

    /*
    keyPressed
     Controls player movements
     */
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            if(player1.getY() >= 20)
            {
                player1.setYVelocity(-10);
            }
            else
                player1.setYVelocity(20);
        }
        else if(e.getKeyCode() == KeyEvent.VK_Z)
        {
            if(player1.getY() < Pong.WINDOW_HEIGHT - 95)
            {
                player1.setYVelocity(10);
            }
            else
                player1.setYVelocity(-10);
        }

        if(is2Player) {


            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (player2.getY() >= 20) {
                    player2.setYVelocity(-10);
                } else
                    player2.setYVelocity(20);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (player2.getY() < Pong.WINDOW_HEIGHT - 95) {
                    player2.setYVelocity(10);
                } else
                    player2.setYVelocity(-10);
            }
        }
    }

    /*
    keyReleased
     Player movement stop control
     */
    public void keyReleased(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_Z)
        {
            player1.setYVelocity(0);
        }

        if(is2Player){
            if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN){
                player2.setYVelocity(0);
            }
        }
    }


    /*
      keyTyped
      To use key methods
     */
    public void keyTyped(KeyEvent e)
    {

    }



}
