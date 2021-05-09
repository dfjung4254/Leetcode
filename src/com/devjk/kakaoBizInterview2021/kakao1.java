package com.devjk.kakaoBizInterview2021;

import java.util.*;
import java.util.stream.Collectors;

public class kakao1 {

  public static List<String> Solution(List<List<String>> arr) {

    List<String> answer = new ArrayList<>();
    Map<String, Integer> userPointMap = new HashMap<>();
    setUserSortedMap(userPointMap, arr);

    // debug
    System.out.println("no filtered");
    userPointMap.forEach((k, v) -> {
      System.out.println(k + " / " + v);
    });

    Map<String, Integer> filteredMap = userPointMap.entrySet()
            .stream()
            .filter(entry -> entry.getValue() < 0)
            .sorted((entry1, entry2) -> {
              if (entry1.getValue() == entry2.getValue()) {
                return entry1.getKey().compareTo(entry2.getKey());
              }
              return entry1.getValue() - entry2.getValue();
            })
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

    System.out.println("filtered");
    filteredMap.forEach((k, v) -> {
      System.out.println(k + " / " + v);
    });

    if (filteredMap.isEmpty()) {
      answer.add("None");
      return answer;
    }

    int minPoint = 0;
    for (Map.Entry<String, Integer> entry : filteredMap.entrySet()) {
      if (minPoint == 0) {
        minPoint = entry.getValue();
      }
      if (minPoint < entry.getValue()) {
        break;
      }
      answer.add(entry.getKey());
    }

    return answer;
  }

  private static void setUserSortedMap(Map<String, Integer> userPointMap, List<List<String>> arr) {
    arr.forEach(transaction -> {
      String borrower = transaction.get(0);
      String lender = transaction.get(1);
      int point = Integer.parseInt(transaction.get(2));
      processPoint(userPointMap, borrower, lender, point);
    });
  }

  private static void processPoint(Map<String, Integer> userPointMap, String borrower, String lender, int point) {
    if (!userPointMap.containsKey(borrower)) {
      userPointMap.put(borrower, 0);
    }
    if (!userPointMap.containsKey(lender)) {
      userPointMap.put(lender, 0);
    }
    userPointMap.put(borrower, userPointMap.get(borrower) - point);
    userPointMap.put(lender, userPointMap.get(lender) + point);
  }

}

class kakao1_solution {

  public static void main(String[] args) {
    kakao1 sol = new kakao1();

    List<List<String>> arr = new ArrayList<>();
    arr.add(new ArrayList<>() {{
      add("Prodo");
      add("Apeach");
      add("3");
    }});
    arr.add(new ArrayList<>() {{
      add("Tudo");
      add("Prodo");
      add("4");
    }});
    arr.add(new ArrayList<>() {{
      add("Apeach");
      add("Max");
      add("2");
    }});
    arr.add(new ArrayList<>() {{
      add("Max");
      add("Tudo");
      add("5");
    }});
    arr.add(new ArrayList<>() {{
      add("Save");
      add("Apeach");
      add("10");
    }});
    arr.add(new ArrayList<>() {{
      add("SaveTim");
      add("Apeahc");
      add("10");
    }});

    List<String> ans = sol.Solution(arr);
    System.out.println(ans);
  }

}
