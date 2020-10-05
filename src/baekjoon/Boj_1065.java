package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1065 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strN = br.readLine();
        int n = Integer.parseInt(strN);
        int answer = 0;

        for(int num = 1; num <= n; num++){
            String strNum = String.valueOf(num);
            int size = strNum.length();
            boolean isHansoo = true;
            boolean isFirst = true;
            int before = -1;
            for(int i = 0; i < size - 1; i++){
                int cur = strNum.charAt(i) - strNum.charAt(i + 1);
                if(isFirst){
                    before = cur;
                    isFirst = false;
                    continue;
                }
                if(cur != before){
                    isHansoo = false;
                    break;
                }
            }
            if(isHansoo){
                answer++;
            }
        }

        System.out.println(answer);

    }

}
