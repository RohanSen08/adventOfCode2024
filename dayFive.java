import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DayFive {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/dayFive.txt");
        Scanner input = new Scanner(file);
        List<String> rules = new ArrayList<>();
        List<String> updates = new ArrayList<>();
        boolean isRuleSection = true;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.trim().isEmpty()) {
                isRuleSection = false;
                continue;
            }
            if (isRuleSection) {
                rules.add(line.trim());
            } else {
                updates.add(line.trim());
            }
        }
        List<int[]> rulePairs = new ArrayList<>();
        for (String rule : rules) {
            String[] parts = rule.split("\\|");
            rulePairs.add(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
        }
        long sum = 0;
        for (String update : updates) {
            String[] pagesStr = update.split(",");
            List<Integer> pages = new ArrayList<>();
            for (String page : pagesStr) {
                pages.add(Integer.parseInt(page));
            }
            boolean isGood = true;
            for (int[] pair : rulePairs) {
                int pageA = pair[0];
                int pageB = pair[1];
                if (pages.contains(pageA) && pages.contains(pageB)) {
                    if (pages.indexOf(pageA) > pages.indexOf(pageB)) {
                        isGood = false;
                        break;
                    }
                }
            }
            if (isGood) {
                sum += pages.get(pages.size() / 2);
            }
        }
        System.out.println(sum);
    }
}
