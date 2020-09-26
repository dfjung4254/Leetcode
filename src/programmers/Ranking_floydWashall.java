package programmers;

public class Ranking_floydWashall {

    private final int INF = 987654321;

    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] fw = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                fw[i][j] = INF;
            }
        }

        for(int[] result : results){
            fw[result[0]][result[1]] = 1;
        }

        /* floyd-washall */
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(fw[i][j] > fw[i][k] + fw[k][j]){
                        fw[i][j] = fw[i][k] + fw[k][j];
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            boolean hasRank = true;
            for(int j = 1; j <= n; j++){
                if(i != j){
                    if(fw[i][j] == INF && fw[j][i] == INF){
                        hasRank = false;
                        break;
                    }
                }
            }
            if(hasRank){
                answer++;
            }
        }

        return answer;
    }

}
