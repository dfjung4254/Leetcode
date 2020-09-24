package programmers;

import java.util.*;

public class MaximumExpression {

    public long solution(String expression) {
        long answer = 0;

        Map<Character, Integer>[] maps = new HashMap[6];
        for(int i = 0; i < 6; i++){
            maps[i] = new HashMap<>();
        }
        maps[0].put('*', 3); maps[0].put('+', 2); maps[0].put('-', 1);
        maps[1].put('*', 3); maps[1].put('+', 1); maps[1].put('-', 2);
        maps[2].put('*', 2); maps[2].put('+', 3); maps[2].put('-', 1);
        maps[3].put('*', 2); maps[3].put('+', 1); maps[3].put('-', 3);
        maps[4].put('*', 1); maps[4].put('+', 2); maps[4].put('-', 3);
        maps[5].put('*', 1); maps[5].put('+', 3); maps[5].put('-', 2);

        for(Map<Character, Integer> map : maps){

            List<String> list = new ArrayList<>();
            Stack<Character> st = new Stack<>();

            char[] chExpression = expression.toCharArray();
            int i = 0;
            int beforeIdx = 0;
            for(; i < chExpression.length; i++){
                char ch = chExpression[i];
                if(ch < '0'){
                    /* 기호 */
                    list.add(expression.substring(beforeIdx, i));
                    beforeIdx = i + 1;
                    while(!st.isEmpty() && map.get(st.peek()) >= map.get(ch)){
                        list.add(String.valueOf(st.pop()));
                    }
                    st.push(ch);
                }
            }
            list.add(expression.substring(beforeIdx, i));
            while(!st.isEmpty()){
                list.add(String.valueOf(st.pop()));
            }

            /* calculate */
            i = 0;
            while(list.size() > 1){
                String prefix = list.get(i);
                if("*".equals(prefix)){
                    long num1 = Long.parseLong(list.get(i - 2));
                    long num2 = Long.parseLong(list.get(i - 1));
                    long cal = num1 * num2;
                    list.remove(i - 2); list.remove(i - 2);
                    list.remove(i - 2); list.add(i - 2, String.valueOf(cal));
                    i = i - 2;
                }else if("+".equals(prefix)){
                    long num1 = Long.parseLong(list.get(i - 2));
                    long num2 = Long.parseLong(list.get(i - 1));
                    long cal = num1 + num2;
                    list.remove(i - 2); list.remove(i - 2);
                    list.remove(i - 2); list.add(i - 2, String.valueOf(cal));
                    i = i - 2;
                }else if("-".equals(prefix)){
                    long num1 = Long.parseLong(list.get(i - 2));
                    long num2 = Long.parseLong(list.get(i - 1));
                    long cal = num1 - num2;
                    list.remove(i - 2); list.remove(i - 2);
                    list.remove(i - 2); list.add(i - 2, String.valueOf(cal));
                    i = i - 2;
                }
                i++;
            }

            Long tp = Math.abs(Long.parseLong(list.get(0)));
            if(answer < tp){
                answer = tp;
            }
        }

        return answer;
    }

}
