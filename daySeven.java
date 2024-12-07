import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class daySeven {
    private static void generateCombinations(long[] nums, int index, long current, List<Long> result) {
        if (index == nums.length) {
                result.add(current);
                return;
            }
            generateCombinations(nums, index + 1, current + nums[index], result);
            generateCombinations(nums, index + 1, current * nums[index], result);
    }
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/daySeven.txt");
        Scanner input = new Scanner(file);
        long sum = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] tools = line.split(" ");
            long target = Long.parseLong(tools[0].substring(0,tools[0].length()-1));
            long[] nums = new long[tools.length-1];
            for (int i = 1; i < tools.length; i++) {
                nums[i-1] = Integer.parseInt(tools[i]);
                }
            List<Long> result = new ArrayList<>();
            generateCombinations(nums, 0, 0, result);
            if (result.contains(target)) {
                sum += target;
            }
            }
        System.out.println(sum);
        }
    }
