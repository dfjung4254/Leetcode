package com.devjk.kakaoBizInterview2021;

import java.util.ArrayList;
import java.util.List;

public class kakao2 {

  public static List<List<String>> Solution(List<List<String>> arr, int orderBy, int orderDesc, int pageSize, int pageTarget) {

    List<List<String>> answer = new ArrayList<>();
    customSort(arr, orderBy, orderDesc);

    int arrSize = arr.size();
    int startIndex = pageSize * pageTarget;
    for (int index = startIndex; index < startIndex + pageSize; index++) {
      if (index >= arrSize) {
        break;
      }
      answer.add(arr.get(index));
    }

    return arr;
  }

  private static void customSort(List<List<String>> arr, int orderBy, int orderDesc) {
    arr.sort((l1, l2) -> {
      if (orderBy == 0) {
        return customStringCompare(l1.get(orderBy), l2.get(orderBy), orderDesc);
      }
      return customIntegerCompare(l1.get(orderBy), l2.get(orderBy), orderDesc);
    });
  }

  private static int customStringCompare(String l1, String l2, int orderDesc) {
    if (orderDesc == 0) {
      return l1.compareTo(l2);
    }
    return l2.compareTo(l1);
  }

  private static int customIntegerCompare(String l1, String l2, int orderDesc) {
    if (orderDesc == 0) {
      return Integer.parseInt(l1) - Integer.parseInt(l2);
    }
    return Integer.parseInt(l2) - Integer.parseInt(l1);
  }

}

class kakao2_Solution {

  public static void main(String[] args) {

  }

}