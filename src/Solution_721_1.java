import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_721_1 {

  public List<List<String>> accountsMerges(List<List<String>> accounts) {

    List<List<String>> nameNode = new ArrayList<>();
    Map<Integer, Integer> rootMap = new HashMap<>();
    Map<String, Integer> indexMap = new HashMap<>();

    accounts.forEach(account -> {
      matchProcess(account, nameNode, indexMap, rootMap);
    });

    Map<Integer, List<String>> userMailList = new HashMap<>();
    indexMap.forEach((email, index) -> {
      int targetIndex = getRootIndex(index, rootMap);
      userMailList.computeIfAbsent(targetIndex, x -> new ArrayList<>()).add(email);
    });



    return null;
  }

  private void matchProcess(List<String> account, List<List<String>> nameNode, Map<String, Integer> indexMap, Map<Integer, Integer> rootMap) {

    List<String> matchedEmails = getMatchedEmails(account, indexMap);

    if (matchedEmails.isEmpty()) {
      int index = newNameIndex(account, nameNode, indexMap);
      rootMap.put(index, index);
      return;
    }

    int rootIndex = getRootIndex(indexMap.get(matchedEmails.get(0)), rootMap);
    matchedEmails.forEach(matchedEmail -> {
      rootMap.put(indexMap.get(matchedEmail), rootIndex);
    });

  }

  private int getRootIndex(int index, Map<Integer, Integer> rootMap) {
    if(rootMap.get(index) == index) {
      return index;
    }
    int rootIndex = getRootIndex(rootMap.get(index), rootMap);
    rootMap.put(index, rootIndex);
    return rootIndex;
  }

  private List<String> getMatchedEmails(List<String> account, Map<String, Integer> indexMap) {
    return account.stream()
            .skip(1)
            .filter(indexMap::containsKey)
            .collect(Collectors.toList());
  }

  private int newNameIndex(List<String> account, List<List<String>> nameNode, Map<String, Integer> indexMap) {

    String name = account.get(0);

    nameNode.add(new ArrayList<>() {{
      add(name);
    }});

    int index = nameNode.size() - 1;
    account.stream().skip(1).forEach(email -> {
      indexMap.put(email, index);
    });

    return index;
  }

}
