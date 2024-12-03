import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class dayThree {
  public static main(String[] args){
    System.out.println("Part one: ");
    File file = new File("src/dayTwo.txt");
    Scanner input = new Scanner(file);
    long sum = 0;
    while (input.hasNext()) {
        String input = input.nextLine();
        String[] parse = input.split("mul");
        String acceptable = "0123456789)";

        int index = parse.length()-1;
        while (index>=0){
          if (parse[index].charAt(0)!='('){
            index--;
          }
          else {
            String first = "-1";
            String second = "-1";
            for (int i = 1; i<parse[index].length(); i++){
              if (acceptable.indexOf(parse[index].charAt(i))==-1){

              }
            }
          }
          index--;
        }
    }
    System.out.println(sum);
  }
}
