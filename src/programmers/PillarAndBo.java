package programmers;

public class PillarAndBo {

    private final int ORIGIN = 0;
    private final int AWAY = 1;
    private final int EMPTY = 9;
    private final int PILLAR = 0;
    private final int BO = 1;
    private final int ADD = 1;
    private final int REMOVE = 0;
    private final int[][] STRUCT = {
        {0, 2}, /* PILLAR */
        {1, 3}  /* BO */
    };
    private final int[] AWAY_X = {0, 1};
    private final int[] AWAY_Y = {1, 0};

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};

        int[][][] map = new int[2][n + 1][n + 1];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                for(int k = 0; k < 2; k++){
                    map[k][i][j] = EMPTY;
                }
            }
        }

        /* simulation */
        for(int[] buildCmd : build_frame){
            int x = buildCmd[0];
            int y = buildCmd[1];
            int type = buildCmd[2];
            int cmd = buildCmd[3];
            if(cmd == ADD){
                if(isAddAvailable(x, y, type, map)){
                    map[type][x][y] = STRUCT[type][ORIGIN];
                    map[type][x + AWAY_X[type]][y + AWAY_Y[type]] = STRUCT[type][AWAY];
                }
            }else if(cmd == REMOVE){
                if(isRemoveAvailable(x, y, type, map)){
                    map[type][x][y] = EMPTY;
                    map[type][x + AWAY_X[type]][y + AWAY_Y[type]] = EMPTY;
                }
            }


        }

        return answer;
    }

    private boolean isAddAvailable(int x, int y, int type, int[][][] map){



        return false;
    }

    private boolean isRemoveAvailable(int x, int y, int type, int[][][] map){


        return false;
    }

}
