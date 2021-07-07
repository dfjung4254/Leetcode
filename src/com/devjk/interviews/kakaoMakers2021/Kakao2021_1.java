package com.devjk.interviews.kakaoMakers2021;

public class Kakao2021_1 {

  public int solution(int[] gift_cards, int[] wants) {
    int answer = 0;

    int size = gift_cards.length;
    int[] map = new int[size + 1];
    for(int want : wants) {
      map[want]++;
    }
    for(int gift_card : gift_cards) {
      if(map[gift_card] > 0) {
        map[gift_card]--;
      }else{
        answer++;
      }
    }

    return answer;
  }

}
