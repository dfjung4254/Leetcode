package programmers;

public class TargetNumber {

    public int solution(int[] numbers, int target) {
        int answer = 0;

        /* bruteforce */
        boolean[] list = new boolean[numbers.length];
        answer = dfs(numbers, -1, list, target);

        return answer;
    }

    private int dfs(int[] numbers, int index, boolean[] list, int target){

        int cnt = 0;

        if(index >= numbers.length - 1){
            int tmp = 0;
            for(int i = 0; i < list.length; i++){
                if(list[i]){
                    tmp += numbers[i];
                }else{
                    tmp -= numbers[i];
                }
            }
            if(target == tmp){
                return 1;
            }
            return 0;
        }

        list[index + 1] = true;
        cnt += dfs(numbers, index + 1, list, target);
        list[index + 1] = false;
        cnt += dfs(numbers, index + 1, list, target);

        return cnt;
    }

}
