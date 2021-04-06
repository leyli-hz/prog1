import org.apache.log4j.Logger;

import java.util.Scanner;

public class Main {
    private int[][][] ms = {
            {
                    {8, 1, 6}, {3, 5, 7}, {4, 9, 2}
            },
            {
                    {4, 9, 2}, {3, 5, 7}, {8, 1, 6}
            },
            {
                    {6, 1, 8}, {7, 5, 3}, {2, 9, 4}
            },
            {
                    {2, 9, 4}, {7, 5, 3}, {6, 1, 8}
            },
            {
                    {8, 3, 4,}, {1, 5, 9}, {6, 7, 2}
            },
            {
                    {4, 3, 8}, {9, 5, 1,}, {2, 7, 6}
            },
            {
                    {6, 7, 2}, {1, 5, 9}, {8, 3, 4}
            },
            {
                    {2, 7, 6}, {9, 5, 1}, {4, 3, 8}
            }};
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Main main = new Main();
        logger.debug("fill the matrix");
        int[][] a = main.get_matrix();
        logger.debug("calculate the min cost");
        System.out.println(main.compare_min_Cost(a));
    }

    public int[][] get_matrix() {
        Scanner out = new Scanner(System.in);
        int[][] mtx = new int[3][3];
        int temp = 0;
        boolean flag = true;
        System.out.println("please enter 9 number betwean 1 to 9 . ");
        int[] temp_ar = new int[3];
        for (int i = 0; i < 3; i++) {
            int k = 0;
            while (k < 3) {
                temp_ar[k] = out.nextInt();
                k++;
            }
            for (int j = 0; j < 3; j++) {
                temp = temp_ar[j];
                do {
                    logger.debug("check the value ");
                    flag = checkValue(temp);
                    if (!flag) {
                        logger.debug("enter new value instead of " + temp);
                        temp = out.nextInt();
                    }
                } while (!flag);
                mtx[i][j] = temp;
            }
        }
        return mtx;
    }

    public int compare_min_Cost(int[][] matrix) {
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < ms.length; i++) {
            int cost = 0;
            for (int j = 0; j < ms[i].length; j++) {
                for (int k = 0; k < ms[i][j].length; k++) {
                    cost += Math.abs(ms[i][j][k] - matrix[j][k]);
                }

            }
            if (minCost > cost) {
                minCost = cost;
            }
        }
        return minCost;
    }

    public boolean checkValue(int n) {
        if (1 > n || n > 9) {
            System.out.println(n + "is out of range (1<x<9) . try again!!");
            return false;
        } else {
            return true;
        }
    }
}

