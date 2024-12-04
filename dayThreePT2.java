import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DayThreePT2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/dayThree.txt");
        Scanner input = new Scanner(file);
        long sum = 0;
        String mulRegex = "mul\\((\\d+),(\\d+)\\)";
        String doRegex = "do\\(\\)";
        String dontRegex = "don't\\(\\)";
        Pattern mulPattern = Pattern.compile(mulRegex);
        Pattern doPattern = Pattern.compile(doRegex);
        Pattern dontPattern = Pattern.compile(dontRegex);
        boolean isEnabled = true;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Matcher mulMatcher = mulPattern.matcher(line);
            Matcher doMatcher = doPattern.matcher(line);
            Matcher dontMatcher = dontPattern.matcher(line);
            int currentIndex = 0;
            while (currentIndex < line.length()) {
                if (doMatcher.find(currentIndex) && doMatcher.start() == currentIndex) {
                    isEnabled = true;
                    currentIndex = doMatcher.end();
                } else if (dontMatcher.find(currentIndex) && dontMatcher.start() == currentIndex) {
                    isEnabled = false;
                    currentIndex = dontMatcher.end();
                } else if (mulMatcher.find(currentIndex) && mulMatcher.start() == currentIndex) {
                    if (isEnabled) {
                        int x = Integer.parseInt(mulMatcher.group(1));
                        int y = Integer.parseInt(mulMatcher.group(2));
                        sum += (long) x * y;
                    }
                    currentIndex = mulMatcher.end();
                } else {
                    currentIndex++;
                }
            }
        }
        System.out.println("Sum of results: " + sum);
    }
}