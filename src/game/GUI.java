package game;

import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {

    byte choice[][] = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
    List<byte[]> list;
    JButton clear;
    JButton buttons[][] = new JButton[3][3];
    boolean comp = false;
    byte arr[][] = new byte[3][3];
    boolean chance = true;

    public void addButtons() {
        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setBounds(i * 90 + 100, j * 90 + 40, 80, 80);
                buttons[i][j].addActionListener(this);
                this.add(buttons[i][j]);
            }

        }

    }

    public GUI() {
        this.setTitle("TIC TAC TOE");
        this.setSize(520, 550);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clear = new JButton("reset");
        clear.setBounds(120, 400, 80, 60);
        clear.addActionListener(this);
        addButtons();
        this.add(clear);
        list = new ArrayList<>();
        fillList();
        clear.doClick();
    }

    public void fillList() {
        list.clear();
        for (int i = 0; i < 9; i++) {
            list.add(choice[i]);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 520, 550);
        g.setColor(Color.GREEN);
        g.drawString("CHANCE OF ", 110, 400);
        g.setColor(Color.RED);
        g.fillRect(200, 380, 30, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            arr = new byte[3][3];
            fillList();
            for (byte i = 0; i < 3; i++) {
                for (byte j = 0; j < 3; j++) {

                    buttons[i][j].setBackground(Color.WHITE);
                }
            }
            int flag = JOptionPane.showConfirmDialog(null, "play with COMPUTER?", "Submit", JOptionPane.YES_NO_OPTION);
            if (flag == 0) {
                comp = true;

            } else {
                comp = false;
            }
            return;
        }
        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 3; j++) {
                if (comp) {
                    if (e.getSource() == buttons[i][j]) {
                        try {
                            if (arr[j][i] != 0) {
                                return;
                            }
                            buttons[i][j].setBackground(Color.RED);
                            arr[j][i] = 1;
                            remover(list, j, i);
                            Graphics g = getGraphics();
                            g.setColor(Color.YELLOW);
                            g.fillRect(200, 380, 30, 30);
                            computer.method(arr, buttons, list);
                        } catch (Exception exce) {

                        }

                    }

                } else {

                    if (e.getSource() == buttons[i][j]) {
                        if (arr[j][i] != 0) {
                            return;
                        }
                        remover(list, j, i);
                        if (chance) {

                            buttons[i][j].setBackground(Color.RED);
                            arr[j][i] = 1;
                            chance = false;
                            Graphics g = getGraphics();
                            g.setColor(Color.YELLOW);
                            g.fillRect(200, 380, 30, 30);

                        } else {
                            buttons[i][j].setBackground(Color.YELLOW);
                            arr[j][i] = 2;
                            chance = true;
                            Graphics g = getGraphics();
                            g.setColor(Color.RED);
                            g.fillRect(200, 380, 30, 30);
                        }
                        System.out.println(list);
                    }
                }
            }
        }
        byte k = game.method(arr);
        if (k == 1) {
            int flag = JOptionPane.showConfirmDialog(null, "RED is the winner Do you want to play again?", "Submit", JOptionPane.YES_NO_OPTION);
            if (flag == 1) {
                System.exit(0);
            } else {
                clear.doClick();
            }
        } else if (k == 2) {
            int flag = JOptionPane.showConfirmDialog(null, "YELLOW is the winner Do you want to play again?", "Submit", JOptionPane.YES_NO_OPTION);
            if (flag == 1) {
                System.exit(0);
            } else {
                clear.doClick();
            }
        }
        if (list.isEmpty()) {
            int flag = JOptionPane.showConfirmDialog(null, "DRAW !!! Do you want to play again?", "Submit", JOptionPane.YES_NO_OPTION);
            if (flag == 0) {
                clear.doClick();
            } else {
                System.exit(0);
            }
        }

    }

    public void remover(List<byte[]> list, int j, int k) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] == k && list.get(i)[1] == j) {
                list.remove(i);
            }

        }

    }

    public static void main(String args[]) {
        GUI frame = new GUI();
        frame.setVisible(true);
    }

}
