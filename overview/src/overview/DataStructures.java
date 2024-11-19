package overview;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DataStructures {

  public static void main(String[] args) {
    /* LinkedList: a built-in type, doubly-linked list, each node consumes more memory 
       because it stores pointers to next and previous. 
       Insert/delete/get at first/last takes O(1) time. 
       Get/delete i-th element takes O(n) time.
     */
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add("apple"); // add to last
    linkedList.addFirst("pear");
    linkedList.addLast("banana");
    System.out.println(linkedList);
    
    
    System.out.println(linkedList.getFirst());
    System.out.println(linkedList.getLast());
    System.out.println(linkedList.get(1));
    
    String first = linkedList.remove();
    System.out.println(first);
    String last = linkedList.removeLast();
    System.out.println(last);
    System.out.println(linkedList);
    
    /* Array: built-in data type. We often use its field length. 
       String also has a length(), but with parenthesis.*/
    int[] nums = {5, 1, 2, 3, 4};
    
    //int[] nums = new int[5];
    //System.out.println();
    System.out.println(nums.length);
    // use Arrays.toString() to print
    System.out.println(Arrays.toString(nums));
    // Arrays.sort() sorts array in place
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    // If we want to sort String[] array by their length, we need to create a new Comparator
    Comparator<String> lengthComparator = new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
      }
    };
    String[] strs = {"flow", "flower", "flag", "flamingo", "fa"};
    // sort only sort by lexicographical order
    Arrays.sort(strs);
    
    
    System.out.println(Arrays.toString(strs));
    Arrays.sort(strs, lengthComparator);
    System.out.println(Arrays.toString(strs));
    
    // StringBuilder
    StringBuilder sb = new StringBuilder();
    // most common method: append
    sb.append("test");
    // delete the last element
    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb); // tes
    // insert string at a specific position
    sb.insert(1, 'w'); // 1 means insert at index 1, original index 1 becomes index 2
    System.out.println(sb); // twes
    // replace
    sb.replace(0, 2, "java");
    System.out.println(sb); // javaes
    // delete a range
    sb.delete(0, 2);
    System.out.println(sb);
    // reverse
    sb.reverse();
    System.out.println(sb);
    String res = sb.toString();
    
    /* Stack: built-in data type. LIFO queue.
       add element: push; delete element: pop; inspect element: peek. */
    Stack<Character> stack = new Stack<>();
    stack.push('a');
    stack.push('b');
    stack.push('c');
    System.out.println(stack);
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack);
    stack.forEach(null);
    
    /* ArrayDeque: inherited from Deque. FIFO queue.
       add element: offer; delete element: poll; inspect element: peek. */
    Queue<Character> queue = new ArrayDeque<>();
    queue.offer('a');
    queue.offer('b');
    queue.offer('c');
    System.out.println("ArrayDeque");
    System.out.println(queue);
    System.out.println(queue.peek());
    queue.poll();
    queue.offer('d');
    System.out.println(queue);
    
    
    /* ArrayDeque: Double-ended queue. Use Deque interface. 
       add element: offerLast/offerFirst; delete element: pollFirst/pollLast;
       inspect element: peekFirst/peekLast. */
    Deque<Character> dq = new ArrayDeque<>();
    dq.offerLast('a');
    dq.offerFirst('b');
    dq.offerLast('c');
    
    System.out.println(dq.pollFirst());
    System.out.println(dq.peekFirst());
    System.out.println(dq.peekLast());
    
    
    
  }

}
