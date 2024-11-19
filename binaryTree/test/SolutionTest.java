

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import binaryTree.Solution;
import binaryTree.TreeNode;

public class SolutionTest {
  Solution sol = new Solution();
  
  @Test
  public void test1() {
    
    
    // create a tree [3,9,20,null,null,15,7]
//    TreeNode fifteen = new TreeNode(15);
//    TreeNode seven = new TreeNode(7);
//    TreeNode twenty = new TreeNode(20, fifteen, seven);
//    TreeNode nine = new TreeNode(9);
//    TreeNode three = new TreeNode(3, nine, twenty);
//    
//    assertEquals(sol.maxDepth(three), 3);
  
    // create a tree [2, null, 3, null, 4, null, 5, null, 6]
    TreeNode six = new TreeNode(6);
    TreeNode five = new TreeNode(5, null, six);
    TreeNode four = new TreeNode(4, null, five);
    TreeNode three = new TreeNode(3, null, four);
    TreeNode two = new TreeNode(2, null, three);
    
    assertEquals(sol.maxDepth(two), 5);
    
  }
  
  @Test
  public void test() {
    // create a tree [1,null,2,3]
    TreeNode four = new TreeNode(4);
    TreeNode five = new TreeNode(5);
    TreeNode six = new TreeNode(6);
    TreeNode seven = new TreeNode(7);
    TreeNode three = new TreeNode(3, six, seven);
    
    TreeNode two = new TreeNode(2, four, five);
    TreeNode one = new TreeNode(1, two, three);
    List<Integer> res = sol.inorderTraversal(one);
    for (int i : res) {
      System.out.println(i);
    }
    
  }

}
