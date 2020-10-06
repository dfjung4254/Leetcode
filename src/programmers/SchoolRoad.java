package programmers;

public class SchoolRoad {

    public int solution(int m, int n, int[][] puddles) {

        int[][] map = new int[n + 1][m + 1];
        int[][] pMap = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            int pm = puddle[0];
            int pn = puddle[1];
            pMap[pn][pm] = -1;
        }

        map[1][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(pMap[i][j] != -1){
                    map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1000000007;
                }
            }
        }

        return map[n][m];
    }

}
