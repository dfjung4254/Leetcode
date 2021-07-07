package com.devjk.interviews.naverWebtoon2021_1;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution2 {

  public String[] solution(String s) {

    HashSet<Integer> indexs = new HashSet<>();
    int left = 0;
    int right = s.length() - 1;
    indexs.add(right);
    ArrayList<Character> leftString = new ArrayList<>();
    ArrayList<Character> rightString = new ArrayList<>();

    while(left < right) {

      leftString.add(s.charAt(left));
      rightString.add(s.charAt(right));

      if(isEqual(leftString, rightString)) {

        indexs.add(left);
        indexs.add(right - 1);
        leftString.clear();
        rightString.clear();

      }

      left++;
      right--;
    }

    Integer[] sortedIndexs = indexs.stream().sorted().toArray(Integer[]::new);

    ArrayList<String> answers = new ArrayList<>();
    int baseIndex = 0;
    for(Integer index : sortedIndexs) {
      StringBuilder sb = new StringBuilder();
      while(baseIndex <= index) {
        sb.append(s.charAt(baseIndex));
        baseIndex++;
      }
      answers.add(sb.toString());
    }

    return answers.toArray(new String[0]);
  }

  private boolean isEqual(ArrayList<Character> leftString, ArrayList<Character> rightString) {
    int size = leftString.size();
    for(int i = 0; i < size; i++) {
      if(leftString.get(i) != rightString.get(size - i - 1)) {
        return false;
      }
    }

    return true;
  }

}
