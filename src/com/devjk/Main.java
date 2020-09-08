package com.devjk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

    Leetcode Problem Solving
    Jung Keun Hwa

 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        
        while(true){
            System.out.println("* 나의 계산기 *");
            System.out.println("1. 덧셈");
            System.out.println("2. 뺄셈");
            System.out.println("3. 곱셈");
            System.out.println("4. 나눗셈");
            System.out.println("5. 종료");
            System.out.print("입력 : ");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            switch(br.readLine()){
                case "1":
                    System.out.println("덧셈결과 : " + calculate(1));
                    break;
                case "2":
                    System.out.println("뺄셈결과 : " + calculate(2));
                    break;
                case "3":
                    System.out.println("곱셈결과 : " + calculate(3));
                    break;
                case "4":
                    System.out.println("나눗셈결과 : " + calculate(4));
                    break;
                case "5":
                    System.out.println("계산기를 종료합니다.");
                    return;
                default:
                    System.out.println("1-5 사이 입력하세요");
                    break;
            }
            
        }
    }

    public static int calculate(int type) throws IOException {
        int ret = 0;
        System.out.print("숫자 2개 입력 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        try{
            if(input.length != 2){
                throw new Exception();
            }

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            if(type == 1){
                ret =  a + b;
            }else if(type == 2){
                ret =  a - b;
            }else if(type == 3){
                ret =  a * b;
            }else {
                ret =  a / b;
            }

        }catch (ArithmeticException ae){
            System.out.println("나눗셈 제대로 입력해라 ㅡㅡ");
        }catch (Exception e){
            System.out.println("제대로 입력해라 ㅡㅡ");
        }

        return ret;
    }

}
