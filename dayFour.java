import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class dayFour {
  public static void main(String[] args) throws IOException {
    ArrayList<String> lines = new ArrayList<>();
    File file = new File("src/dayFour.txt");
    Scanner input = new Scanner(file);
    String line;
    while (input.hasNextLine()) {
      lines.add(input.nextLine());
    }
    int rows = lines.size();
    int cols = lines.get(0).length();
    char[][] grid = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      grid[i] = lines.get(i).toCharArray();
    }
    String word = "XMAS";
    int count = countOccurrences(grid, word);
    System.out.println("The word '" + word + "' occurs " + count + " times.");
  }
  private static int countOccurrences(char[][] grid, String word) {
    int rows = grid.length;
    int cols = grid[0].length;
    int totalCount = 0;
    int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1}
    };
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        for (int[] dir : directions) {
          if (isWordPresent(grid, word, row, col, dir[0], dir[1])) {
            totalCount++;
          }
        }
      }
    }

    return totalCount;
  }
  private static boolean isWordPresent(char[][] grid, String word, int startRow, int startCol, int deltaRow, int deltaCol) {
    int rows = grid.length;
    int cols = grid[0].length;
    int wordLength = word.length();
    for (int i = 0; i < wordLength; i++) {
      int newRow = startRow + i * deltaRow;
      int newCol = startCol + i * deltaCol;
      if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
        return false;
      }
      if (grid[newRow][newCol] != word.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}