import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {2, 2, 2, 4, 3, 3};
        int result = singleNumber(numbers);
        System.out.println("Result -> " + result);
    }

    public static int singleNumber(int[] numbers) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int number : numbers) {
            if (numMap.containsKey(number)) {
                Integer value = numMap.get(number) + 1;
                numMap.put(number, value);
            } else {
                numMap.put(number, 1);
            }
        }
        return numMap.entrySet().stream()
                .filter(numEntry -> numEntry.getValue().equals(1))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
    }

}