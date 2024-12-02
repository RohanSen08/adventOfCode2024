import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dayTwo {
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
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Part one: ");
        File file = new File("src/dayTwo.txt");
        Scanner input = new Scanner(file);
        int sum = 0;
        while (input.hasNext()) {
            String[] levels = input.nextLine().split(" ");
            int[] intLevels = new int[levels.length];
            for (int i = 0; i < levels.length; i++) {
                intLevels[i] = Integer.parseInt(levels[i]);
            }
            boolean positive = true;
            boolean broken = false;
            for (int i = 0; i < intLevels.length-1; i++) {
                if (!isSafe(intLevels)) {
                    broken = true;
                }
            }
            if (!broken){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
