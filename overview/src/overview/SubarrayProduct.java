package overview;

public class SubarrayProduct {

  private static long count(int[] numbers, int k) {
    int left = 0, n = numbers.length;
    int product = 1, count = 0;
    for (int right = 0; right < n; right++) {
      product *= numbers[right];
      while (product > k && left <= right) {
        product /= numbers[left];
        left++;
      }
      count += right - left + 1;
    }
    return count;
  }
  
  public static void main(String[] args) {
//    int[] numbers = new int[] {2, 1, 2, 4};
//    int[] numbers = new int[] {2, 3, 4};
    int[] numbers = new int[] {2, 1, 2, 10};
//    int[] numbers = new int[] {2, 1, 1, 10, 2, 1};
    int k = 6;
    long res = count(numbers, k);
    System.out.printf("result is %d\n", res);

  }

}
