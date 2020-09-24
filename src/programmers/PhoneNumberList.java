package programmers;

import java.util.Arrays;

public class PhoneNumberList {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++){
            String str1 = phone_book[i];
            String str2 = phone_book[i + 1];
            int size1 = str1.length();
            int size2 = str2.length();
            if(size1 > size2){
                String splited = str1.substring(0, size2);
                if(str2.equals(splited)){
                    return false;
                }
            }else{
                String splited = str2.substring(0, size1);
                if(str1.equals(splited)){
                    return false;
                }
            }
        }

        return answer;
    }

}
