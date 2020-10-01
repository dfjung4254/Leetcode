package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class MovingBlock_bfs_expert {

    private final int[][] DI1 = {
            {0, 0, -1, 1, -1, 0, 1, 0}, /* 가로 - right,left, up, down, rightUp, leftUp, rightDown, leftDown */
            {-1, 1, 0, 0, 1, 1, 0, 0}  /* 세로 - up, down, right, left downRight, downLeft, upRight, upLeft */
    };
    private final int[][] DJ1 = {
            {1, -1, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, -1, 1, -1, 0, 0}
    };
    private final int[][] DI2 = {
            {0, 0, -1, 1, 0, -1, 0, 1},
            {-1, 1, 0, 0, 0, 0, -1, -1}
    };
    private final int[][] DJ2 = {
            {1, -1, 0, 0, 0, -1, 0, -1},
            {0, 0, 1, -1, 0, 0, 1, -1}
    };
    /* DI1 기준 */
    private final int[][] BI = {
            {0, 0, 0, 0, -1, -1, 1, 1},
            {0, 0, 0, 0, 0, 0, 1, 1}
    };
    /* DJ1 기준 */
    private final int[][] BJ = {
            {0, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, -1, 1, -1}
    };
    private final int[][] DIR = {
            {0, 0, 0, 0, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 0}
    };

    public int solution(int[][] b) {
        int answer = 0;

        int n = b.length;

        /* bfs - upgrade */
        int[][] board = new int[n + 1][n + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i + 1][j + 1] = b[i][j];
            }
        }

        boolean[][][][] visited = new boolean[101][101][101][101];

        Queue<int[]> q = new LinkedList<>();
        /* di1, dj1, di2, dj2, direction, dist */
        q.offer(new int[]{1, 1, 1, 2, 0, 0});
        visited[1][1][1][2] = true;
        visited[1][2][1][1] = true;
        while(!q.isEmpty()){
            int[] cp = q.poll();
            int ci1 = cp[0];
            int cj1 = cp[1];
            int ci2 = cp[2];
            int cj2 = cp[3];
            int dir = cp[4];
            int dist = cp[5];
            if(ci1 > ci2 || cj1 > cj2){
                int cpi = ci1;
                int cpj = cj1;
                ci1 = ci2;
                cj1 = cj2;
                ci2 = cpi;
                cj2 = cpj;
            }

            /* debug */
            System.out.println("curdist : " + dist);
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(i == ci1 && j == cj1){
                        System.out.print("* ");
                    }else if(i == ci2 && j == cj2){
                        System.out.print("* ");
                    }else{
                        System.out.print(board[i][j] + " ");
                    }
                }
                System.out.println();
            }
            System.out.println();

            if((ci1 == n && cj1 == n) || (ci2 == n && cj2 == n)){
                /* find minimum */
                answer = dist;
                break;
            }
            for(int d = 0; d < 8; d++){
                int ni1 = ci1 + DI1[dir][d];
                int nj1 = cj1 + DJ1[dir][d];
                int ni2 = ci2 + DI2[dir][d];
                int nj2 = cj2 + DJ2[dir][d];
                int ndir = DIR[dir][d];
                int ndist = dist + 1;
                int checki = ci1 + BI[dir][d];
                int checkj = cj1 + BJ[dir][d];
                if(isValidLocation(ni1, nj1, ni2, nj2, checki, checkj, board)
                && !visited[ni1][nj1][ni2][nj2]){
                    q.offer(new int[]{ni1, nj1, ni2, nj2, ndir, ndist});
                    visited[ni1][nj1][ni2][nj2] = true;
                    visited[ni2][nj2][ni1][nj1] = true;
                }
            }

        }

        return answer;
    }

    private boolean isValidLocation(int i1, int j1, int i2, int j2, int ci, int cj, int[][] board){
        boolean b1, b2, b3;

        int n = board.length;
        b1 = (i1 >= 1 && i1 < n && j1 >= 1 && j1 < n && board[i1][j1] == 0);
        b2 = (i2 >= 1 && i2 < n && j2 >= 1 && j2 < n && board[i2][j2] == 0);
        b3 = (ci >= 1 && ci < n && cj >= 1 && cj < n && board[ci][cj] == 0);

        return (b1 && b2 && b3);
    }

}
