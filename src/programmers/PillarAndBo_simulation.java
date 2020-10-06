package programmers;

import java.util.ArrayList;
import java.util.List;

public class PillarAndBo_simulation {

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
        int[][] answer;

        int[][][] map = new int[2][n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
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
                }
            }else if(cmd == REMOVE){
                if(isRemoveAvailable(x, y, type, map)){
                    map[type][x][y] = EMPTY;
                }
            }
        }

        List<int[]> list = new ArrayList<>();
        for(int t = 0; t < 2; t++){
            for(int x = 0; x < map[t].length; x++){
                for(int y = 0; y < map[t][x].length; y++){
                    if(map[t][x][y] == STRUCT[t][ORIGIN]){
                        list.add(new int[]{x, y, t});
                    }
                }
            }
        }

        list.sort((o1, o2) -> {
            if(o1[0] > o2[0]){
                return 1;
            }else if(o1[0] < o2[0]){
                return -1;
            }else{
                return Integer.compare(o1[1], o2[1]);
            }
        });

        answer = new int[list.size()][3];
        for(int i = 0; i < answer.length; i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
            answer[i][2] = list.get(i)[2];
        }

        return answer;
    }

    private boolean isAddAvailable(int x, int y, int type, int[][][] map){

        if(type == PILLAR){
            return (y == 0)
                    || (x - 1 >= 0 && map[BO][x - 1][y] == STRUCT[BO][ORIGIN])
                    || (map[BO][x][y] == STRUCT[BO][ORIGIN])
                    || (map[PILLAR][x][y - 1] == STRUCT[type][ORIGIN]);
        }else if(type == BO){
            return (y - 1 >= 0 && map[PILLAR][x][y - 1] == STRUCT[PILLAR][ORIGIN])
                    || (y - 1 >= 0 && x + 1 < map[type].length && map[PILLAR][x + 1][y - 1] == STRUCT[PILLAR][ORIGIN])
                    || (x - 1 >= 0 && map[BO][x - 1][y] == STRUCT[BO][ORIGIN]) && (x + 1 < map[type].length && map[BO][x + 1][y] == STRUCT[BO][ORIGIN]);
        }

        return false;
    }

    private boolean isRemoveAvailable(int x, int y, int type, int[][][] map){

        map[type][x][y] = EMPTY;
        boolean deleteAvailable = true;
        for(int t = 0; t < 2; t++){
            for(int tx = 0; tx < map[t].length; tx++){
                for(int ty = 0; ty < map[t][tx].length; ty++){
                    if(map[t][tx][ty] == STRUCT[t][ORIGIN]){
                        if(!isAddAvailable(tx, ty, t, map)){
                            deleteAvailable = false;
                        }
                    }
                }
            }
        }
        if(!deleteAvailable){
            map[type][x][y] = STRUCT[type][ORIGIN];
        }

        return deleteAvailable;
    }

}
