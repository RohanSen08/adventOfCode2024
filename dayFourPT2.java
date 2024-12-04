import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class dayFourPT2 {
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
        int count = countXMasPatterns(grid);
        System.out.println("The number of X-MAS patterns is: " + count);
    }
    private static int countXMasPatterns(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                if (grid[row][col] == 'A' && isXMas(grid, row, col)) {
                    count++;
                }
            }
        }
        return count;
    }
    private static boolean isXMas(char[][] grid, int row, int col) {
        boolean diagonal1 = checkMAS(grid, row - 1, col - 1, row + 1, col + 1);
        boolean diagonal2 = checkMAS(grid, row - 1, col + 1, row + 1, col - 1);
        return diagonal1 && diagonal2;
    }
    private static boolean checkMAS(char[][] grid, int row1, int col1, int row2, int col2) {
        if (!isInBounds(grid, row1, col1) || !isInBounds(grid, row2, col2)) {
            return false;
        }
        char c1 = grid[row1][col1];
        char c2 = grid[row2][col2];
        return (c1 == 'M' && c2 == 'S') || (c1 == 'S' && c2 == 'M');
    }
    private static boolean isInBounds(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}