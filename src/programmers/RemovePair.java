package programmers;

import java.util.Stack;

public class RemovePair {

    public int solution(String s)
    {
        int answer = 0;

        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek() == ch){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        answer = (st.isEmpty()) ? 1 : 0;

        return answer;
    }

}
