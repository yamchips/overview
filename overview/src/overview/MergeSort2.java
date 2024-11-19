package overview;

import java.util.ArrayList;
import java.util.List;

public class MergeSort2 {

  private static List<Integer> mergeSort(List<Integer> list) {
    if (list.size() < 2) {
      return list;
    } else {
      int middle = list.size() / 2;
      List<Integer> left = list.subList(0, middle);
      List<Integer> right = list.subList(middle, list.size());
      List<Integer> sortedLeft = mergeSort(left);
      List<Integer> sortedRight = mergeSort(right);
      return merge(sortedLeft, sortedRight);
    }
  }
  
  private static List<Integer> merge(List<Integer> left, List<Integer> right) {
    List<Integer> result = new ArrayList<>();
    int i = 0, j = 0;
    while (i < left.size() && j < right.size()) {
      if (left.get(i) < right.get(j)) {
        result.add(left.get(i));
        i++;
      } else {
        result.add(right.get(j));
        j++;
      }
    }
    while (i < left.size()) {
      result.add(left.get(i));
      i++;
    }
    while (j < right.size()) {
      result.add(right.get(j));
      j++;
    }
    return result;
  }
  
  public static void main(String[] args) {
    

  }

}
