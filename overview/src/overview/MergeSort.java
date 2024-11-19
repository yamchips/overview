package overview;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

  public static List<Integer> mergeSort(List<Integer> L) {
    if (L.size() < 2) {
      return new ArrayList<>(L); // Return a copy of the list
    } else {
      int middle = L.size() / 2;
      List<Integer> left = mergeSort(L.subList(0, middle));
      List<Integer> right = mergeSort(L.subList(middle, L.size()));
      return merge(left, right);
    }
  }

  public static List<Integer> merge(List<Integer> left, List<Integer> right) {
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
    List<Integer> L = List.of(12, 11, 13, 5, 6, 7);
    System.out.println("Given List: " + L);

    List<Integer> sortedL = mergeSort(L);

    System.out.println("Sorted List: " + sortedL);
    

    
  }
}
