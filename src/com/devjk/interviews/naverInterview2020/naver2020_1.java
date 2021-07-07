package com.devjk.interviews.naverInterview2020;

public class naver2020_1 {

    public String solution_origin(String m, String k){

        StringBuffer sb = new StringBuffer();
        int keyIndex = 0;
        int size = m.length();
        int keySize = k.length();
        for(int i = 0; i < size; i++){
            char ch = m.charAt(i);
            if(keyIndex < keySize && ch == k.charAt(keyIndex)){
                keyIndex++;
            }else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public String solution2(String m, String k){

        StringBuilder sb = new StringBuilder();

        int keyIndex = 0;
        int keySize = k.length();
        for(char ch : m.toCharArray()){
            if(keyIndex < keySize && k.charAt(keyIndex) == ch){
                keyIndex++;
            }else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }

}
