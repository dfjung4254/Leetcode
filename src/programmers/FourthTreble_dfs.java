package programmers;

public class FourthTreble_dfs {

    public int solution(int n) {
        int answer = 0;

        /* brute force */
        answer = dfs(n, 0);

        return answer;
    }

    private int dfs(int n, int addCnt){

        int cnt = 0;

        if(Math.pow(3, addCnt / 2) > n){
            return 0;
        }

        if(n == 3){
            if(addCnt == 2){
                return 1;
            }
        }

        if(n > 3){
            if(addCnt >= 2 && n % 3 == 0){
                cnt += dfs(n / 3, addCnt - 2);
            }
            cnt += dfs(n - 1, addCnt + 1);
        }

        return cnt;
    }

}
