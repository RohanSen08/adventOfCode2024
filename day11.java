import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class day11 {
  public static void main(String[] args) throws FileNotFoundException{
    File file = new File("day11.txt");
    Scanner input = new Scanner(file);
    ArrayList<Integer> values = new ArrayList<>();
    for (String a : input.split(" ")){
      values.add(Integer.parseInt(a));
    }
    for (int i = 0; i<25; i++){
      
    }
  }
}
