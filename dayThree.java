import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class dayThree {
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println("Part one: ");
    File file = new File("src/dayThree.txt");
    Scanner input = new Scanner(file);
    long sum = 0;
    while (input.hasNextLine()) {
        String regex = "mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input.nextLine());
        while (matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                sum += x * y;
            }
        }
      System.out.println(sum);
  }
}
