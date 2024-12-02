import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class dayOne {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Part one: ");
        File file = new File("src/dayOne.txt");
        Scanner input = new Scanner(file);
        int[] list1 = new int[1000];
        int[] list2 = new int[1000];
        int index = 0;
            while (input.hasNext()) {
                list1[index]=input.nextInt();
                list2[index]=input.nextInt();
                index++;
            }
            Arrays.sort(list1);
            Arrays.sort(list2);
            long sum = 0;
            for (int i = 0; i < list1.length; i++) {
                sum += Math.abs(list1[i] - list2[i]);
            }
            System.out.println(sum);
        }
}
