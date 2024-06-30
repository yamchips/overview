package backTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    List<String> res = Solution.letterCombinations("23");
    res.forEach(s -> System.out.println(s));
    // List<List<Integer>> res = Solution.combinationSum(new int[] { 2, 3, 6, 7 },
    // 7);
//    res.forEach(innerList -> {
//      String line = innerList.stream().map(String::valueOf).collect(Collectors.joining(" "));
//      System.out.println(line);
//    });
  }

  public static List<String> letterCombinations(String digits) {
    if (digits.length() == 0)
      return new ArrayList<>();
    Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", 
        '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    List<String> res = new ArrayList<>();
    for (int i = 0; i < digits.length(); i++) {
      char[] letters = map.get(digits.charAt(i)).toCharArray();
      if (i == 0) {
        for (int j = 0; j < letters.length; j++) {
          String newString = letters[j] + "";
          res.add(newString);
        }
      } else {
        int size = res.size();
        for (int k = 0; k < size; k++) {
          for (int j = 0; j < letters.length; j++) {
            String newString = res.get(k) + letters[j];
            res.add(newString);
          }
        }
      }
    }
    res.removeIf(s -> s.length() < digits.length());
    return res;

  }

  public static List<List<String>> solveNQueens(int n) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(list, new ArrayList<>(), n);
    List<List<String>> res = transfer(list, n);
    return res;
  }

  private static void backtrack(List<List<Integer>> list, List<Integer> temp, int n) {
    if (!isgoal(temp)) {
      return;
    } else if (temp.size() == n) {
      list.add(new ArrayList<>(temp));
      return;
    }
    for (int i = 0; i < n; i++) {
      if (temp.contains(i))
        continue;
      temp.add(i);
      backtrack(list, temp, n);
      temp.remove(temp.size() - 1);
    }
  }

  private static boolean isgoal(List<Integer> temp) {
    for (int i = 0; i < temp.size(); i++) {
      for (int j = i + 1; j < temp.size(); j++) {
        if (temp.get(i) == temp.get(j) || Math.abs(temp.get(j) - temp.get(i)) == j - i)
          return false;
      }
    }
    return true;
  }

  private static List<List<String>> transfer(List<List<Integer>> list, int n) {
    List<List<String>> res = new ArrayList<>();
    for (List<Integer> element : list) {
      List<String> solution = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int pos = element.get(i);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
          if (j != pos) {
            sb.append('.');
          } else {
            sb.append('Q');
          }
        }
        solution.add(sb.toString());
      }
      res.add(new ArrayList<>(solution));
    }
    return res;
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    // Arrays.sort(candidates);
    backtrack2(res, new ArrayList<Integer>(), candidates, target, 0);
    return res;
  }

  private static void backtrack2(List<List<Integer>> res, ArrayList<Integer> temp, int[] candidates,
      int remain, int p1) {
    if (remain == 0) {
      res.add(new ArrayList<>(temp));
      return;
    }
    if (remain < 0) {
      return;
    }
    for (int i = p1; i < candidates.length; i++) {
      temp.add(candidates[i]);
      backtrack2(res, temp, candidates, remain - candidates[i], p1);
      temp.remove(temp.size() - 1);
    }
  }

  private static void backtrack(List<List<Integer>> res, ArrayList<Integer> temp, int[] candidates,
      int target, int p1) {
    if (temp.stream().mapToInt(Integer::intValue).sum() == target) {
      res.add(new ArrayList<>(temp));
      return;
    }
    if (temp.stream().mapToInt(Integer::intValue).sum() > target) {
      return;
    }

    while (p1 < candidates.length) {
      if (temp.stream().mapToInt(Integer::intValue).sum() < target) {
        temp.add(candidates[p1]);
      }
      backtrack(res, temp, candidates, target, p1);
      temp.remove(temp.size() - 1);
      p1++;
    }

  }

  public static List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    helper(res, new StringBuilder(), 0, 0, n);
    return res;
  }

  private static void helper(List<String> res, StringBuilder sb, int open, int close, int n) {
    if (open == n && close == n) {
      res.add(sb.toString());
      return;
    }

    if (open < n) {
      sb.append("(");
      helper(res, sb, open + 1, close, n);
      sb.setLength(sb.length() - 1);
    }
    if (close < open) {
      sb.append(")");
      helper(res, sb, open, close + 1, n);
      sb.setLength(sb.length() - 1);
    }
  }

  public static List<List<Integer>> subsets3(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack3(list, new ArrayList<>(), nums, 0);
    return list;
  }

  private static void backtrack3(List<List<Integer>> list, List<Integer> tempList, int[] nums,
      int start) {
    list.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      tempList.add(nums[i]);
      backtrack3(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }

  public static List<List<Integer>> subsets2(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    // list.add(new ArrayList<>());
    backtrack2(list, new ArrayList<>(), nums);
    return list;
  }

  private static void backtrack2(List<List<Integer>> list, ArrayList<Integer> temp, int[] nums) {
    if (!hasduplicate(list, temp))
      list.add(new ArrayList<>(temp));
    for (int n : nums) {
      if (temp.contains(n))
        continue;
      temp.add(n);
      backtrack2(list, temp, nums);
      temp.remove(temp.size() - 1);
    }
  }

  private static boolean hasduplicate(List<List<Integer>> list, ArrayList<Integer> temp) {
    for (List<Integer> element : list) {
      if (element.size() == temp.size()) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : temp) {
          map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : element) {
          if (map.containsKey(num)) {
            map.put(num, map.get(num) - 1);
          } else {
            continue;
          }
        }
        int sum = 0;
        for (int val : map.values()) {
          sum += val;
        }
        if (sum == 0)
          return true;
      }
    }
    return false;
  }

  public static List<List<Integer>> subsets(int[] nums) {
    Set<Set<Integer>> list = new HashSet<>();
    list.add(new HashSet<Integer>());
    backtrack(list, new HashSet<Integer>(), nums);
    List<List<Integer>> res = new ArrayList<>();
    for (Set<Integer> element : list) {
      List<Integer> temp = new ArrayList<>(element);
      res.add(temp);
    }
    return res;
  }

  private static void backtrack(Set<Set<Integer>> list, Set<Integer> temp, int[] nums) {
    if (temp.size() > 0) {
      list.add(new HashSet<>(temp));
    }
    for (int i = 0; i < nums.length; i++) {
      if (temp.contains(nums[i])) {
        continue;
      } else {
        temp.add(nums[i]);
        backtrack(list, temp, nums);
        temp.remove(nums[i]);
      }
    }
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(list, new ArrayList<Integer>(), nums);
    return list;
  }

  private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums) {
    // is goal met?
    if (temp.size() == nums.length) {
      list.add(new ArrayList<>(temp)); // we need to create a new array, because we will change temp
                                       // later
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (temp.contains(nums[i])) {
          continue;
        } else {
          temp.add(nums[i]);
          backtrack(list, temp, nums);
          temp.remove(temp.size() - 1);
        }
      }
    }
  }

  public static List<List<Integer>> permute1(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack1(list, new ArrayList<>(), nums);
    return list;
  }

  private static void backtrack1(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (tempList.contains(nums[i]))
          continue;
        tempList.add(nums[i]);
        backtrack1(list, tempList, nums);
        tempList.remove(tempList.size() - 1);
      }
    }
  }

}
