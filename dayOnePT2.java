import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class dayOnePT2 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Part two: ");
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
            int count = 0;
            for (int j = 0; j < list2.length; j++) {
                if (list1[i] == list2[j]) {
                    count++;
                }
            }
            sum += (long) list1[i] * count;
        }
        System.out.println(sum);
    }
}
