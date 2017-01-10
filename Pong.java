/**
 * Created by Dewey Milton on 3/9/2016.
 *used some methods, and code Ideas from youTube Video https://www.youtube.com/watch?v=fSqH1lfr0Tg in order to learn how to construct pong game
 *
 * Pong class controls and creates the initial start up of the game, and takes in information needed to begin the game
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

/*
   creates main frame specs
 */
public class Pong extends JFrame {
    private recordKeep topScores;
    final static int WINDOW_WIDTH = 800;
    final static int WINDOW_HEIGHT = 400;
    private boolean is2Player;
    private String player1;
    private String player2;
    JMenuBar menuBar;
    JMenu file;
    JMenuItem exit;

    /*
     Constructor
     */
    public Pong() {
        start();
    }

    /*
    start()
    Starts the game and asks for player info and whether to use existing or new scores
     */
    public void start() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        file = new JMenu("File");
        menuBar.add(file);

        exit = new JMenuItem("Exit");
        file.add(exit);

        event e = new event();
        exit.addActionListener(e);

        is2Player = false;
        this.topScores = new recordKeep();
        Scanner scan = new Scanner(System.in);

        String choice = JOptionPane.showInputDialog("One or Two Players");
        if (choice == null) {
            System.exit(0);
        }
        switch (choice) {
            case "1":
                player1 = JOptionPane.showInputDialog("Player 1 Name");
                player2 = JOptionPane.showInputDialog("Computer Name");
                break;
            case "2":
                player1 = JOptionPane.showInputDialog("Player 1 Name");
                player2 = JOptionPane.showInputDialog("Player 2 Name");
                is2Player = true;
                break;
        }

        if (player1 == null || player2 == null) {
            System.exit(0);
        }

        String options = JOptionPane.showInputDialog("Would you like to use existing scores, Y or N");
        if (options == null) {
            System.exit(0);
        }
        switch (options.toUpperCase()) {
            case "N":
                topScores.resetScores();
                break;
            case "Y":
                this.topScores = topScores.loadScores();
                break;
        }

        setSize(WINDOW_WIDTH + 200, WINDOW_HEIGHT + 100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        repaint();
        setTitle("Speed Ball 2016");

        add(new GamePanel(topScores, is2Player, player1, player2));


        setVisible(true);


    }

    /*
     Creates actionlisteners
     */
    private class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }


}
