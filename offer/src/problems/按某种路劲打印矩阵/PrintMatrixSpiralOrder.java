/**
 * 打印转圈矩阵，就是顺/逆时针转圈打印到最里面的圈
 * 思路：用宏观思维，将问题分解，每次打印边框，逐渐缩小边框就行，而不是想着如何一步步沿着它的轨迹打印下去，每次打印框，轨迹自然就连起来了
 */
package Problems.按某种路劲打印矩阵;

import org.omg.PortableInterceptor.INACTIVE;

public class PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix){
        int tr = 0;  //左上角行标
        int tc = 0; //左上角列标
        int dr = matrix.length - 1;
        int dc = matrix[0].length - 1;
        while (tr <= dr && tc <= dc){
            printEdge(matrix, tr++, tc++, dr--, dc--);
        }
    }

    public static void printEdge(int[][] matrix, int tr, int tc, int dr, int dc) {
        if (tr == dr){ //如果同一行
            for (int i = tc; i <= dc; i++) {
                System.out.print(matrix[tr][i] + " ");
            }
        }else if (tc == dc){  //如果同一列
            for (int i = tr; i <= dr; i++) {
                System.out.print(matrix[i][tc] + " ");
            }
        }else {
            int curc = tc;
            int curr = tr;
//          顺时针旋转打印
//            while (curc != dc){
//                System.out.print(matrix[curr][curc++] + " ");
//            }
//            while (curr != dr){
//                System.out.print(matrix[curr++][curc] + " ");
//            }
//            while (curc != tc){
//                System.out.print(matrix[curr][curc--] + " ");
//            }
//            while (curr != tr){
//                System.out.print(matrix[curr--][curc] + " ");
//            }
//           逆时针
            while (curr != dr){
                System.out.println(matrix[curr++][curc]);
            }
            while (curc != dc){
                System.out.println(matrix[curr][curc++]);
            }
            while (curr != tr){
                System.out.println(matrix[curr--][curc]);
            }
            while (curc != tc){
                System.out.println(matrix[curr][curc--]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{12,13,14,5}
        ,{11,16,15,6},{10,9,8,7}};
        spiralOrderPrint(matrix);
    }

}
