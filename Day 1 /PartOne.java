import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PartOne {

  public static void main(String[] args) {
    ArrayList<Integer> numbers = getValues(args);

    System.out.print("Sum is " + calculate(numbers));
  }

  public static int calculate(ArrayList<Integer> numbers) {
    int sum = 0;

    for (int number : numbers) {
      sum += calculate(number);
    }
    
    return sum;
  }

  public static int calculate(int number) {
    return roundDown(number/3) - 2;
  }

  public static int roundDown(float number) {
    return (int)number;
  }

  public static ArrayList<Integer> getValues(String ...fileNames) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (String fileName: fileNames) {
      FileInputStream stream = null;

      try {
        stream = new FileInputStream(fileName);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

      BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
      String line;

      try {
        while ((line = reader.readLine()) != null) {
          Integer number = Integer.parseInt(line);
          numbers.add(number);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

      try {
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
  }
  return numbers;
}

}
