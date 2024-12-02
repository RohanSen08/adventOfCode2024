import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dayTwo {
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
                if (i==0){
                    positive = intLevels[i] < intLevels[i+1];
                }
                if (intLevels[i] > intLevels[i+1]){
                    if (positive){
                        broken = true;
                        break;
                    } else if (Math.abs(intLevels[i]-intLevels[i+1])<1||Math.abs(intLevels[i]-intLevels[i+1])>3){
                        broken = true;
                        break;
                    }
                }
                else if (intLevels[i] < intLevels[i+1]){
                    if (!positive){
                        broken = true;
                        break;
                    } else if (Math.abs(intLevels[i]-intLevels[i+1])<1||Math.abs(intLevels[i]-intLevels[i+1])>3){
                        broken = true;
                        break;
                    }
                } else if (intLevels[i] == intLevels[i+1]){
                    broken = true;
                    break;
                }
            }
            if (!broken){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
