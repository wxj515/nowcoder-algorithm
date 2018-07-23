/**
 * 岛问题：相邻的1连成一片就是一个岛
 */
package Hash;

public class CountIslang {
    public static int countIslangs(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m.length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j, int N, int M) {
        if (i >= N || i < 0 || j >= M || j < 0 || m[i][j] != 1)
            return;
        m[i][j] = 2;
        //分别从上下右左四个方向去遍历
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }
}
