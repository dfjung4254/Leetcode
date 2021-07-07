package com.devjk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_721 {

  public List<List<String>> accountsMerge(List<List<String>> accounts) {

    List<List<String>> nameNode = new ArrayList<>();
    List<List<String>> emailNode = new ArrayList<>();
    Map<String, Integer> indexMap = new HashMap<>();
    List<List<String>> answer = new ArrayList<>();

    accounts.forEach(account -> {

      String name = account.get(0);
      int size = account.size();
      String matchedEmail = account.stream()
              .filter(indexMap::containsKey)
              .findFirst()
              .orElse(null);

      int index;
      if (matchedEmail == null) {
        nameNode.add(new ArrayList<>() {{
          add(name);
        }});
        emailNode.add(new ArrayList<>());
        index = emailNode.size() - 1;
      }else {
        index = indexMap.get(matchedEmail);
      }

      int targetIndex = index;
      account.stream()
              .skip(1)
              .filter(email -> !indexMap.containsKey(email))
              .forEach(email -> {
                emailNode.get(targetIndex).add(email);
                indexMap.put(email, targetIndex);
              });

    });

    int size = nameNode.size();
    for(int i = 0; i < size; i++) {
      List<String> name = nameNode.get(i);
      List<String> emails = emailNode.get(i);
      List<String> list = Stream.concat(name.stream(), emails.stream().sorted(String::compareTo))
              .collect(Collectors.toList());
      answer.add(list);
    }

    return answer;
  }

  private boolean isInNode(List<String> account, int size, Map<String, Integer> map) {
    return account.stream().anyMatch(obj -> map.containsKey(obj));
  }

}
