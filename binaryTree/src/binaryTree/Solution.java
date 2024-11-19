package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {

  public int maxDepthDFS(TreeNode root) {
    if(root == null) {
        return 0;
    }
    
    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> value = new Stack<>();
    stack.push(root);
    value.push(1);
    int max = 0;
    while(!stack.isEmpty()) {
        TreeNode node = stack.pop();
        int temp = value.pop();
        max = Math.max(temp, max);
        if(node.left != null) {
            stack.push(node.left);
            value.push(temp+1);
        }
        if(node.right != null) {
            stack.push(node.right);
            value.push(temp+1);
        }
    }
    return max;
}

  
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    while (root != null || !stack.empty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      res.add(root.val);
      root = root.right;
    }
    return res;
  }

  public int maxDepth(TreeNode root) {
    int max = 0;
    Queue<TreeNode> nodes = new ArrayDeque<>();
    Queue<Integer> value = new ArrayDeque<>();

    if (root == null)
      return max;
    nodes.offer(root);
    value.offer(1);
    while (!nodes.isEmpty()) {
      TreeNode curr = nodes.poll();
      int currVal = value.poll();
      max = currVal > max ? currVal : max;
      if (curr.left != null) {
        value.offer(currVal + 1);
        nodes.offer(curr);
      }
      if (curr.right != null) {
        value.offer(currVal + 1);
        nodes.offer(curr);
      }
    }

    return max;

  }
}
