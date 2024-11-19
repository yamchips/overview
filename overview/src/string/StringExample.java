package string;

import java.util.Arrays;

public class StringExample {

  public static void main(String[] args) {
    int[] scores = new int[] { 88, 77, 51, 66 };
    Score s = new Score(scores);
    s.printScores();
    scores[2] = 99;
    s.printScores();
  }

}

class Score {
  private int[] scores;

  /*
   * If the parameter might change, we need to copy it.
   */
  public Score(int[] scores) {
    int[] copied = Arrays.copyOf(scores, scores.length);
    this.scores = copied;
  }

  public void printScores() {
    System.out.println(Arrays.toString(scores));
  }
}