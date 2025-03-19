package src;
import java.util.Scanner;
public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = {{1,1}, {1,0}};
        int n = scanner.nextInt();
        System.out.println(getFibMatrix(matrix,n));
    }

    public static int[][] getMatrixInDoublePower(int[][] arr, int[][] m) {
        int[][] res = new int[arr.length][arr.length];
        for(int i = 0;  i < arr.length; i++) {
            for(int j = 0; j<arr.length; j++) {
                for(int k = 0; k < arr.length; k++) {
                    res[i][j] += arr[i][k] * m[k][j];
                }
            }
        }
        return res;
    }

    public static int getFibMatrix(int[][] matrix, int p) {
        int[][] res = {{1,0},{0,1}};
        while(p > 0) {
            if(p % 2 != 0) {
                res = getMatrixInDoublePower(res, matrix);
            }
            matrix = getMatrixInDoublePower(matrix,matrix);
            p /=2;
        }
        return res[0][0];
    }

}
