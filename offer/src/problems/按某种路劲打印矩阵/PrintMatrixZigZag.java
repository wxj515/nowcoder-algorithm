/**
 * 按之字形打印矩阵
 * 思路：同样是化繁为简，利用宏观思想，不拘泥于想着如何让一条路线不断得绕道重点，而是拆分成每一条，然后设置个简单的变量让它每次打印的顺序调转就行
 */
package Problems.按某种路劲打印矩阵;

public class PrintMatrixZigZag {
    public static void printMatrixZigZag(int[][] matrix){
        int ar = 0;
        int ac = 0;
        int br = 0;
        int bc = 0;
        int endr = matrix.length - 1;
        int endc = matrix[0].length - 1;
        boolean fromUp = false;
        while (ar != endr + 1) {
            printLevel(matrix, ar, ac, br, bc, fromUp);
            ar = ac == endc ? ar + 1 : 0;
            ac = ac == endc ? endc : ac + 1;
            br = br == endr ? endr : br + 1;
            bc = br == endr ? bc + 1 : 0;
            fromUp = !fromUp;
        }
    }

    public static void printLevel(int[][] matrix, int ar, int ac, int br, int bc, boolean fromUp) {
        if (fromUp){
            while (ar != br + 1)
                System.out.println(matrix[ar++][ac--] + " ");
        }else {
            while (br != ar - 1)
                System.out.println(matrix[br--][bc++] + " ");
        }
    }
}

