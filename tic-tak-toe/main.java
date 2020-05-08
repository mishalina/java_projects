package tictactoe;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] arr = new char[3][3];
        for (char[] chars : arr) {
            Arrays.fill(chars, ' ');
        }
        play(scan, arr);
    }
    public static void play(Scanner scan, char[][] arr) {
        int i = 1;
        drawMatrix(arr);
        String result = analize(arr);
        if (result.equals(" ")) {
            enterCoors(scan, arr, i++);
            play(scan,arr);
        } else {
            System.out.println(result);
        }
    }
    public static int[] getcoors(int a, int b) {
        int temp = b;
        int[] str = new int[2];
        b = a - 1;
        if (temp == 1) {
            a = 2;
        } else if (temp == 3) {
            a = 0;
        } else if (temp == 2) {
            a = 1;
        } else {
            System.out.println("error");
        }
        str[0] = a;
        str[1] = b;
        return str;
    }

    public static void drawMatrix(char[][] arr) {
        System.out.println("---------");
        for (char[] item : arr) {
            System.out.print("|");
            for (char it : item) {
                System.out.print(" " + it);
            }
            System.out.println(" |");
            System.out.println();
        }
        System.out.println("---------");
    }

    public static void enterCoors(Scanner scan, char[][] arr, int i) {
        System.out.println("Enter coordinates: ");
        while (!scan.hasNextInt()) {
            System.out.println("You should enter numbers!");
            scan.next(); // this is important!
            enterCoors(scan, arr, i);
        }
        int q = scan.nextInt();
        int w = scan.nextInt();
        if ((q == 1 || q == 2 || q == 3) && (w == 1 || w == 2 || w == 3)) {
            int[] str = getcoors(q, w);
            q = str[0];
            w = str[1];

            if (arr[q][w] == ' ') {
                for (int u = 0; u < arr.length; u++) {
                    for (int j = 0; j < arr[u].length; j++) {
                        if (i % 2 == 0) {
                            arr[q][w] = 'O';
                        } else {
                            arr[q][w] = 'X';
                        }
                    }
                }
                drawMatrix(arr);
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                enterCoors(scan, arr, i);
            }
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            enterCoors(scan, arr, i);
        }

    }
    public static String analize(char[][] arr) {
        //analize symbols in array and count
        int x = 0, o = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ( j + 2 < arr[i].length) {
                    if (arr[i][j] == 'X' && arr[i][j + 1] == 'X' && arr[i][j + 2] == 'X') {
                        x = 3;
                    }
                }
                if ( i + 2 < arr.length) {
                    if (arr[i][j] == 'X' && arr[i + 1][j] == 'X' && arr[i + 2][j] == 'X') {
                        x = 3;
                    }
                }
                if (arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X') {
                    x = 3;
                }
                if (arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X') {
                    x = 3;
                }
                if ( j + 2 < arr[i].length) {
                    if (arr[i][j] == 'O' && arr[i][j + 1] == 'O' && arr[i][j + 2] == 'O') {
                        o = 3;
                    }
                }
                if ( i + 2 < arr.length) {
                    if (arr[i][j] == 'O' && arr[i + 1][j] == 'O' && arr[i + 2][j] == 'O') {
                        o = 3;
                    }
                }
                if (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O') {
                    o = 3;
                }
                if (arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O') {
                    o = 3;
                }
            }
        }
        //issue result from data
        String result = " ";
        if (x == 3 && o == 3) {
            result = "Impossible";
        } else if (x == 3) {
            result = "X wins";
        } else if (o == 3) {
            result = "O wins";
        }
        return result;
    }
}
