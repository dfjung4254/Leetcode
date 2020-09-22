package programmers;

public class CountPandY {

    boolean solution(String s) {

        int pCount = 0;
        int yCount = 0;
        String loweredS = s.toLowerCase();
        for(char ch : loweredS.toCharArray()){
            if(ch == 'p'){
                pCount++;
            }else if(ch == 'y'){
                yCount++;
            }
        }

        return (pCount == yCount);
    }

}
