package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JButton;

public class computer {

    public static byte method(byte arr[][], JButton buttons[][], List<byte[]> list) {
        Random sc = new Random();

        while (true&&list.size()!=0) {
            int i = sc.nextInt(0, list.size());
            int j = list.get(i)[0], k = list.get(i)[1];
            if (arr[k][j] == 0) {
                arr[k][j] = 2;
                buttons[j][k].setBackground(Color.YELLOW);
                list.remove(i);
                break;
            }
        }
        for (byte[] a : list) {
            System.out.print(a[0] + " " + a[1] + "  ");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        if (arr[1][1] != 0) {
            if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
                return arr[1][1];
            }

            if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]) {
                return arr[1][1];
            }
            if (arr[1][1] == arr[1][0] && arr[1][1] == arr[1][2]) {
                return arr[1][1];
            }
            if (arr[1][1] == arr[0][1] && arr[1][1] == arr[2][1]) {
                return arr[1][1];
            }
        }
        if (arr[1][0] != 0) {
            if (arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0]) {
                return arr[1][0];
            }
        }
        if (arr[0][1] != 0) {
            if (arr[0][0] == arr[0][1] && arr[0][1] == arr[0][2]) {
                return arr[0][1];
            }
        }
        if (arr[2][1] != 0) {
            if (arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2]) {
                return arr[2][1];
            }
        }
        if (arr[1][2] != 0) {
            if (arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2]) {
                return arr[1][2];
            }
        }
        return -1;
        
    }

    public static void main(String args[]) {

    }
}
