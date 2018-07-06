package Problems.按某种路劲打印矩阵;

public class RotateMatrix {
    public static void rotate(int[][] matrix){
        int tr = 0;
        int tc = 0;
        int dr = matrix.length - 1;
        int dc = matrix[0].length - 1;
        while (tr < dr){
            rotateEdge(matrix, tr++, tc++, dr--, dc--);
        }
    }

    public static void rotateEdge(int[][] matrix, int tr, int tc, int dr, int dc) {
        int tmp = 0;
        for (int i = 0; tc + i < dc; i++) {
            tmp = matrix[tr][tc + i];
            matrix[tr][tc + i] = matrix[dr - i][tc];
            matrix[dr - i][tc] = matrix[dr][dc - i];
            matrix[dr][dc - i] = matrix[tr + i][dc];
            matrix[tr + i][dc] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
