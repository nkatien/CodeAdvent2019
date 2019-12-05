import java.util.ArrayList;

public class PartTwo {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> numbers = PartOne.getValues(args);

        System.out.println("Recursive sum = " + calculate(numbers));
    }

    public static int calculate(ArrayList<Integer> numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += recurse(number);
        }
        
        return sum;
    }
    
    public static int recurse(int number){
        int sum = 0;

        while(number > 0) {
            number = PartOne.calculate(number);
            if (number < 0) continue;
            sum += number;
        }
        
        return sum;
    }
}
