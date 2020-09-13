package com.devjk.lineInterview2020_1;

public class line2020_4 {

    private final int UP = 0;
    private final int RIGHT = 1;
    private final int DOWN = 2;
    private final int LEFT = 3;

    private final int[] GO_I = {-1, 0, 1, 0};
    private final int[] GO_J = {0, 1, 0, -1};
    private final int[] LB_I = {1, -1, -1, 1};
    private final int[] LB_J = {-1, -1, 1, 1};
    private final int[] L_I = {0, -1, 0, 1};
    private final int[] L_J = {-1, 0, 1, 0};

    public int solution(int[][] maze) {
        int answer = 0;

        int n = maze.length;
        /* 확장 */
        int[][] extendedMaze = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            extendedMaze[0][i] = 1;
            extendedMaze[i][0] = 1;
            extendedMaze[n + 1][i] = 1;
            extendedMaze[i][n + 1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                extendedMaze[i][j] = maze[i - 1][j - 1];
            }
        }

        for(int i = 0; i < n + 2; i++){
            for(int j = 0; j < n + 2; j++){
                System.out.print(extendedMaze[i][j]);
            }
            System.out.println();
        }

        answer = goMaze(extendedMaze, n);


        return answer;
    }

    private int goMaze(int[][] maze, int n) {

        /* 1,1 -> n,n */
        int cnt = 0;
        int curDirection = UP;
        int curI = 1;
        int curJ = 1;
        int curLbI = 0;
        int curLbJ = 0;
        int curLI = 0;
        int curLJ = 0;
        int curGoI = 0;
        int curGoJ = 0;
        while (curI != n || curJ != n) {
            curLbI = curI + LB_I[curDirection];
            curLbJ = curJ + LB_J[curDirection];
            curLI = curI + L_I[curDirection];
            curLJ = curJ + L_J[curDirection];
            curGoI = curI + GO_I[curDirection];
            curGoJ = curJ + GO_J[curDirection];
            System.out.println(curLI + " / " + curLJ);
            if (maze[curLbI][curLbJ] == 1) {
                if (maze[curLI][curLJ] == 1) {
                    /* 오른쪽으로 회전하면서 앞이 비어있는거 찾음 */
                    while (maze[curGoI][curGoJ] == 1) {
                        curDirection = (curDirection + 1) % 4;
                        curGoI = curI + GO_I[curDirection];
                        curGoJ = curJ + GO_J[curDirection];
                    }
                    System.out.println("changed Direction1 : " + curDirection);
                } else {
                    /* direction 현재의 왼쪽으로 수정 */
                    curDirection = (curDirection + 3) % 4;
                    System.out.println("changed Direction2 : " + curDirection);
                }
            } else {
                if(maze[curLI][curLJ] == 1){
                    /* 오른쪽으로 회전하면서 앞이 비어있는거 찾음 */
                    while (maze[curGoI][curGoJ] == 1) {
                        curDirection = (curDirection + 1) % 4;
                        curGoI = curI + GO_I[curDirection];
                        curGoJ = curJ + GO_J[curDirection];
                    }
                    System.out.println("changed Direction3 : " + curDirection);
                }else{
                    /* 없는 케이스 같은데.. */
                }
            }

            curI = curI + GO_I[curDirection];
            curJ = curJ + GO_J[curDirection];
            cnt++;
            System.out.println("GO : " + curI + "/" + curJ + "/" + curDirection + " -> cnt : " + cnt);

        }

        return cnt;
    }

}
