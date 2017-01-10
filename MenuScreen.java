

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.Visibility;

/**
 * Created by ASUS on 3/23/2016.
 */
public class MenuScreen extends JFrame implements ActionListener {

    private JButton btnNewGame, btnExisting, btn2Player, btnExit;
    private JTextField player1Name;
    private JTextField player2Name;
    private JLabel name, name2;


    public MenuScreen(){
        btnNewGame = new JButton("Reset Scores");
        btnExisting = new JButton("Single Player");
        btn2Player = new JButton("Two Players");

        btnExit = new JButton("Exit");

        player1Name = new JTextField("");
        player2Name = new JTextField("");

        name = new JLabel("Player 1 Name");
        name2 = new JLabel("Player 2 Name");

        this.setLayout(null);
        setVisible(true);

        btnNewGame.addActionListener(new resetClickHandler());
        btnExisting.addActionListener(new singleClickHandler());
        btn2Player.addActionListener(new twoPlayerClickHandler());

        btnExit.addActionListener(new exitButtonClickHandler());

        name.setBounds(10,10,60,20);
        name2.setBounds(10,30,120,20);
        player1Name.setBounds(70,10,130,20);
        player2Name.setBounds(70, 30, 130,40);

        btnNewGame.setBounds(140,55,100,20);
        btnExisting.setBounds(240,55,100,20);
        btn2Player.setBounds(340,55,100,20);
        btnExit.setBounds(440,55,100,20);

        this.add(name);
        this.add(name2);
        this.add(player1Name);
        this.add(player2Name);
        this.add(btnNewGame);
        this.add(btnExit);
        this.add(btn2Player);
        this.add(btnExisting);

        this.setSize(500,300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class resetClickHandler implements ActionListener {

        /**
         * Takes in two inputs from the text boxes, and builds a resultStack by calling the addNumbers method from the calculator
         *
         * @param e Performs action
         */
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class singleClickHandler implements ActionListener {

        /**
         * Takes in two inputs from the text boxes, and builds a resultStack by calling the addNumbers method from the calculator
         *
         * @param e Performs action
         */
        public void actionPerformed(ActionEvent e) {
            Pong pong = new Pong();


        }
    }


    private class twoPlayerClickHandler implements ActionListener {

        /**
         * Takes in two inputs from the text boxes, and builds a resultStack by calling the addNumbers method from the calculator
         *
         * @param e Performs action
         */
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class exitButtonClickHandler implements ActionListener {

        /**
         * Takes in two inputs from the text boxes, and builds a resultStack by calling the addNumbers method from the calculator
         *
         * @param e Performs action
         */
        public void actionPerformed(ActionEvent e) {

            System.exit(0);
        }
    }


}
