package programmers;

import java.util.*;

public class BlockGame_simulation {

    private final int[] DI = {0, 1, 0, -1};
    private final int[] DJ = {1, 0, -1, 0};
    private final int[][][] PUZZLE_TYPE = {
            {{0, 1}, {0, 2}, {1, 2}},
            {{0, 1}, {1, 0}, {2, 0}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{0, 1}, {-1, 1}, {-2, 1}},
            {{0, 1}, {0, 2}, {1, 0}},
            {{1, 0}, {2, 0}, {2, 1}},
            {{0, 1}, {0, 2}, {-1, 2}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{-1, 1}, {0, 1}, {0, 2}},
            {{1, 0}, {1, 1}, {2, 0}},
            {{0, 1}, {0, 2}, {1, 1}},
            {{-1, 1}, {0, 1}, {1, 1}}
    };

    private final int[][][] PUZZLE_EMPTY = {
            {{1, 0}, {1, 1}},
            {{1, 1}, {2, 1}},
            {{0, 1}, {0, 2}},
            {{-1, 0}, {-2, 0}},
            {{1, 1}, {1, 2}},
            {{0, 1}, {1, 1}},
            {{-1, 0}, {-1, 1}},
            {{1, 0}, {2, 0}},
            {{-1, 0}, {-1, 2}},
            {{0, 1}, {2, 1}},
            {{1, 0}, {1, 2}},
            {{-1, 0}, {1, 0}}
    };

    public int solution(int[][] board) {
        int answer = 0;

        boolean[][] visited = new boolean[board.length][board.length];
        List<Block> blocks = new ArrayList<>();

        /* set blocks */
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != 0 && !visited[i][j]){
                    List<int[]> list = new ArrayList<>();
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    list.add(new int[]{i, j});
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int d = 0; d < 4; d++){
                            int ni = cur[0] + DI[d];
                            int nj = cur[1] + DJ[d];
                            if(isValidPoint(ni, nj, board.length) && !visited[ni][nj] && board[ni][nj] == board[cur[0]][cur[1]]){
                                q.offer(new int[]{ni, nj});
                                list.add(new int[]{ni, nj});
                                visited[ni][nj] = true;
                            }
                        }
                    }
                    blocks.add(new Block(getEmpty(list, board), list));
                }
            }
        }

        boolean isEnd = false;
        while(!isEnd){
            isEnd = true;
            Iterator<Block> iter = blocks.iterator();
            while(iter.hasNext()){
                Block block = iter.next();
                int[] empty1 = block.empty1;
                int[] empty2 = block.empty2;
                if(isUpFullEmpty(empty1, empty2, board)){
                    deleteAll(board, block.list);
                    answer++;
                    System.out.println("delete : ");
                    for(int i = 0; i < board.length; i++){
                        for(int j = 0; j < board.length; j++){
                            System.out.print(board[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    isEnd = false;
                    iter.remove();
                }
            }
        }


        return answer;
    }

    private void deleteAll(int[][] board, List<int[]> list){
        for(int[] p : list){
            board[p[0]][p[1]] = 0;
        }
    }

    private boolean isUpFullEmpty(int[] e1, int[] e2, int[][] board){

        int i = e1[0];
        int j = e1[1];
        System.out.println("deleteConsidering : " + i + " / " + j);
        while(i >= 0){
            if(board[i--][j] != 0){
                return false;
            }
        }

        i = e2[0];
        j = e2[1];
        System.out.println("deleteConsidering : " + i + " / " + j);
        while(i >= 0){
            if(board[i--][j] != 0){
                return false;
            }
        }

        System.out.println("deleteSuccess");

        return true;
    }

    private int[][] getEmpty(List<int[]> list, int[][] board){

        list.sort(((o1, o2) -> {
            if(o1[1] > o2[1]){
                return 1;
            }else if(o1[1] < o2[1]){
                return -1;
            }else{
                return Integer.compare(o1[0], o2[0]);
            }
        }));

        int[] init = list.get(0);
        int tp = 0;
        System.out.println("start consider : " + init[0] + " / " + init[1]);
        for(; tp < 12; tp++){
            boolean isFind = true;
            for(int i = 0; i < 3; i++){
                int ti = init[0] + PUZZLE_TYPE[tp][i][0];
                int tj = init[1] + PUZZLE_TYPE[tp][i][1];
                System.out.println("considering : " + ti + " / " + tj);
                if(!isValidPoint(ti, tj, board.length)
                || board[init[0]][init[1]] != board[ti][tj]){
                    isFind = false;
                    break;
                }
            }
            if(isFind){
                System.out.println("block : " + board[init[0]][init[1]] + " is type : " + tp);
                break;
            }
        }

        int[][] ret = new int[2][2];
        ret[0][0] = init[0] + PUZZLE_EMPTY[tp][0][0];
        ret[0][1] = init[1] + PUZZLE_EMPTY[tp][0][1];
        ret[1][0] = init[0] + PUZZLE_EMPTY[tp][1][0];
        ret[1][1] = init[1] + PUZZLE_EMPTY[tp][1][1];

        return ret;
    }

    private boolean isValidPoint(int i, int j, int size){
        return (i >= 0 && i < size && j >= 0 && j < size);
    }

    private class Block {
        List<int[]> list;
        int[] empty1;
        int[] empty2;
        public Block(int[][] empty, List<int[]> list){
            this.empty1 = empty[0];
            this.empty2 = empty[1];
            this.list = list;
        }
    }

}
