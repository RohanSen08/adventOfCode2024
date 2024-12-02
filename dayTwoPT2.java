import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class DayTwoPT2 {
    public static boolean isSafe(int[] levels) {
        boolean increasing = levels[1] > levels[0];
        for (int i = 1; i < levels.length; i++) {
            int diff = levels[i] - levels[i - 1];
            if ((increasing && diff < 1) || (!increasing && diff > -1) || Math.abs(diff) > 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSafeWithRemoval(int[] levels) {
        for (int i = 0; i < levels.length; i++) {
            int[] modifiedLevels = new int[levels.length - 1];
            int index = 0;
            for (int j = 0; j < levels.length; j++) {
                if (j != i) {
                    modifiedLevels[index++] = levels[j];
                }
            }
            if (isSafe(modifiedLevels)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/dayTwo.txt");
        Scanner input = new Scanner(file);

        int safeCount = 0;
        while (input.hasNext()) {
            String[] levelStrings = input.nextLine().split(" ");
            int[] intLevels = new int[levelStrings.length];
            for (int i = 0; i < levelStrings.length; i++) {
                intLevels[i] = Integer.parseInt(levelStrings[i]);
            }

            if (isSafe(intLevels) || isSafeWithRemoval(intLevels)) {
                safeCount++;
            }
        }
        System.out.println("Safe reports: " + safeCount);
    }
}
