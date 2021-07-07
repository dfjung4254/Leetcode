package com.devjk.interviews.nhnInterview;

import java.util.Stack;

public class nhn2020_3 {

    public static void solution(int numOfOrder, String[] orderArr) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

        /* use stack */
        for(String order : orderArr){
            StringBuilder curOrder = new StringBuilder(order);
            StringBuilder changedOrder = parseOrder(curOrder);
            System.out.println(changedOrder);
        }

    }

    private static StringBuilder parseOrder(StringBuilder curOrder){
        StringBuilder ret = new StringBuilder();

        int size = curOrder.length();
        if(size > 1){
            char first = curOrder.charAt(0);
            char second = curOrder.charAt(1);
            StringBuilder remainOrder = new StringBuilder();
            if(isRGB(first)){
                /* RGB */
                if(isRGB(second) || isNum(second)){
                    for(int i = 1; i < size; i++){
                        remainOrder.append(curOrder.charAt(i));
                    }
                    ret.append(first).append(parseOrder(remainOrder));
                }else if(second == '('){
                    int thisStackIndex = getCloseIndex(curOrder, 1, size);
                    for(int i = 2; i < thisStackIndex; i++){
                        remainOrder.append(curOrder.charAt(i));
                    }
                    StringBuilder receiveOrder = parseOrder(remainOrder);
                    int receiveSize = receiveOrder.length();
                    for(int i = 0; i < receiveSize; i++){
                        ret.append(first);
                        ret.append(receiveOrder.charAt(i));
                    }
                    StringBuilder remainOrder2 = new StringBuilder();
                    for(int i = thisStackIndex; i < size; i++){
                        remainOrder2.append(curOrder.charAt(i));
                    }
                    ret.append(parseOrder(remainOrder2));
                }else{
                    /* ) */
                    ret.append(first);
                    for(int i = 2; i < size; i++){
                        remainOrder.append(curOrder.charAt(i));
                    }
                    StringBuilder receiveOrder = parseOrder(remainOrder);
                    ret.append(receiveOrder);
                }
            }else if(isNum(first)){
                /* 1 ~ 9 */
                if(isRGB(second)){
                    int cnt = Character.getNumericValue(first);
                    for(int i = 0; i < cnt; i++){
                        ret.append(second);
                    }
                    for(int i = 2; i < size; i++){
                        remainOrder.append(curOrder.charAt(i));
                    }
                    ret.append(parseOrder(remainOrder));
                }else {
                    /* ( */
                    int thisStackIndex = getCloseIndex(curOrder, 1, size);
                    for(int i = 2; i < thisStackIndex; i++){
                        remainOrder.append(curOrder.charAt(i));
                    }
                    StringBuilder receiveOrder = parseOrder(remainOrder);
                    int cnt = Character.getNumericValue(first);
                    for(int i = 0; i < cnt; i++){
                        ret.append(receiveOrder);
                    }
                    StringBuilder remainOrder2 = new StringBuilder();
                    for(int i = thisStackIndex; i < size; i++){
                        remainOrder2.append(curOrder.charAt(i));
                    }
                    ret.append(parseOrder(remainOrder2));
                }
            }else if(first == '('){
                /* first == (, ) */
                int thisStackIndex = getCloseIndex(curOrder, 1, size);
                for(int i = 1; i < thisStackIndex; i++){
                    remainOrder.append(curOrder.charAt(i));
                }
                ret.append(parseOrder(remainOrder));
                StringBuilder remainOrder2 = new StringBuilder();
                for(int i = thisStackIndex; i < size; i++){
                    remainOrder2.append(curOrder.charAt(i));
                }
                ret.append(parseOrder(remainOrder2));
            }else{
                for(int i = 1; i < size; i++){
                    remainOrder.append(curOrder.charAt(i));
                }
                ret.append(parseOrder(remainOrder));
            }
        }else if(size > 0){
            char first = curOrder.charAt(0);
            if(isRGB(first)){
                ret.append(first);
            }
        }

        return ret;
    }

    private static boolean isRGB(char ch){
        return (ch == 'R' || ch == 'G' || ch == 'B');
    }
    private static boolean isNum(char ch){
        return(ch >= '1' && ch <= '9');
    }

    private static int getCloseIndex(StringBuilder curOrder, int startIndex, int size){
        Stack<Character> st = new Stack<>();
        int index = startIndex;
        for(; index < size; index++){
            char curChar = curOrder.charAt(index);
            if(curChar == '('){
                st.push(curChar);
            }else if(curChar == ')'){
                st.pop();
            }
            if(st.isEmpty()){
                break;
            }
        }

        return index;
    }



}
