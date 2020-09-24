package programmers;

public class StockPrice {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length - 1; i++){
            int cnt = 1;
            for(int j = i + 1; j < prices.length; j++){
                if(prices[i] > prices[j] || j == prices.length - 1){
                    answer[i] = cnt;
                    break;
                }
                cnt++;
            }
        }

        return answer;
    }

}
