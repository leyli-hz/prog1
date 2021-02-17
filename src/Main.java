import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[][] a = main.get_matrix();
        System.out.println(main.compare_min_Cost(a));
    }

    public int[][] get_matrix() {
        Scanner out = new Scanner(System.in);
        int[][] mtx = new int[3][3];
        int temp = 0;
        boolean flag = true;
        System.out.println("please enter 9 number betwean 1 to 9 . ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    temp = out.nextInt();
                    if (1 > temp || temp > 9) {
                        System.out.println("the number is out of range(1<x<9)! try again!");
                        flag = false;
                    } else {
                        mtx[i][j] = temp;
                        flag = true;
                    }
                } while (!flag);
            }
        }
        return mtx;
    }

    public int compare_min_Cost(int[][] matrix) {
        int[][][] ms = {
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
}

