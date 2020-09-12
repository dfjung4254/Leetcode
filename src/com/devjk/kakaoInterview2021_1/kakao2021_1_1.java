package com.devjk.kakaoInterview2021_1;

public class kakao2021_1_1 {

    public String solution(String new_id) {

        System.out.println("input : " + new_id);

        new_id = proc1(new_id);

        System.out.println("proc1 : "  + new_id);

        new_id = proc2(new_id);

        System.out.println("proc2 : " + new_id);

        new_id = proc3(new_id);

        System.out.println("proc3 : " + new_id);

        new_id = proc4(new_id);

        System.out.println("proc4 : " + new_id);

        new_id = proc5(new_id);

        System.out.println("proc5 : " + new_id);

        new_id = proc6(new_id);

        System.out.println("proc6 : " + new_id);

        new_id = proc7(new_id);

        System.out.println("proc7 : " + new_id);


        return new_id;
    }

    private String proc1(String str){
        return str.toLowerCase();
    }

    private String proc2(String str){

        StringBuilder sb = new StringBuilder(str);
        int size = sb.length();
        for(int i = 0; i < size; i++){
            if(isAnotherChar(sb.charAt(i))){
                sb.deleteCharAt(i);
                i--;
                size--;
            }
        }

        return sb.toString();
    }

    private boolean isAnotherChar(char ch){

        boolean ret = true;
        if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')
        || (ch == '-') || (ch == '_') || (ch == '.')){
            ret = false;
        }
        return ret;
    }

    private String proc3(String str){

        StringBuilder sb = new StringBuilder(str);
        int size = sb.length();
        for(int i = 0; i < size; i++){
            if(sb.charAt(i) == '.'){
                int j = i;
                while(j < size){
                    if(sb.charAt(j) != '.'){
                        break;
                    }
                    j++;
                }
                sb.replace(i, j, ".");
                size -= (j - i - 1);
            }
        }
        return sb.toString();
    }

    private String proc4(String str){

        StringBuilder sb = new StringBuilder(str);
        if(sb.charAt(0) == '.'){
            sb.deleteCharAt(0);
        }
        if(sb.length() != 0 && sb.charAt(sb.length() - 1) == '.'){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private String proc5(String str){
        if(str.length() == 0){
            return "a";
        }
        return str;
    }

    private String proc6(String str){

        if(str.length() > 15){
            StringBuilder sb = new StringBuilder(str.substring(0, 15));
            if(sb.length() != 0 && sb.charAt(sb.length() - 1) == '.'){
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return  str;
    }

    private String proc7(String str){

        StringBuilder sb = new StringBuilder(str);
        int size = sb.length();
        char ch = sb.charAt(size - 1);
        if(size <= 2){
            for(int i = 1; i <= 3 - size; i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
