package com.devjk.interviews.lineInterview2020_1;

public class line2020_5 {

    public int solution(int[] cards) {
        int answer = 0;

        int playerSum = 0;
        int playerAce = 0;
        int dealerSum = 0;
        int dealerOpened = 0;
        int dealerOpenedAce = 0;
        int dealerAce = 0;

        for(int i = 0; i < cards.length; i++){
            if(i == 0 || i == 2){
                if(cards[i] != 1){
                    playerSum += cards[i];
                }else{
                    playerAce++;
                }
                continue;
            }
            if(i == 1){
                if(cards[i] != 1){
                    dealerSum += cards[i];
                }else{
                    dealerAce++;
                }
                continue;
            }
            if(i == 3){
                if(cards[i] != 1){
                    dealerOpened += cards[i];
                    dealerSum += cards[i];
                }else{
                    dealerOpenedAce++;
                    dealerAce++;
                }
                continue;
            }

            if(playerSum == 10 && playerAce == 1){
                if(getDealerMake21()){
                    break;
                }else{
                    answer = 3;
                }
            }
            if(playerSum == 21){
                /* check dealer */
                if(getDealerMake21()){
                    break;
                }else{
                    answer = 2;
                }
            }else if(getPlayerSum() < 21){
                /* 계산 후 card[i] 를 더하기 */
                if(dealerOpenedAce == 1 || dealerOpened >= 7){

                }else if(dealerOpened == 4 || dealerOpened == 5 || dealerOpened == 6){
                    /* 그만 받음 */

                }else if(dealerOpened == 2 || dealerOpened == 3){

                }
                if(getPlayerSum() >= 17) {
                    /* 그만 받음 */

                }else{
                    if(cards[i] != 1){
                        playerSum += cards[i];
                    }else{
                        playerAce++;
                    }
                    continue;
                }


            }else{
                answer = -2;
                break;
            }

        }

        return answer;
    }

    private boolean getDealerMake21(){
        return false;
    }

    private int getPlayerSum(){
        return 0;
    }

}
