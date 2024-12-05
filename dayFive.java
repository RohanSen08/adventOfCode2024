import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class dayFive {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/dayFIve.txt");
        Scanner input = new Scanner(file);
        String[] directions = new String[2352];
        long sum = 0;
        for (int i = 0; i<2352; i+=2) {
          String instruction = "";
          instruction = input.nextLine();
          String[] instructionSplit = instruction.split("|");
          directions[i] = instructionSplit[0];
          directions[i+1] = instructionSplit[1];
        }
        for (int j = 0; j<204; j++) {
          String values = "";
          boolean isGood = true;
          values = input.nextLine();
          for (int i = 0; i<2352; i+=2) {
            if (Arrays.asList(values).contains(directions[i]) && Arrays.asList(values).contains(directions[i+1])){
              if ((values.indexOf(directions[i])>values.indexOf(directions[i+1]))){
                  isGood = false;
              }
            }
            if (isGood){
              String[] splitVal = values.split(",");
              sum+=Integer.valueOf(splitVal[splitVal.length/2]);
            }
          }
        }
        System.out.println(sum);
    }
}
