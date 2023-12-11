import java.util.ArrayList;
import java.util.List;

class CountElementsWithProperty {
    public static <T> int countElementsWithProperty(List<T> list, PropertyChecker<T> checker) {
        int count = 0;
        for (T element : list) {
            if (checker.check(element)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList();
        for (int i = 1; i <= 20; i++) {
            numbers.add(i);
        }

        int evenCount = countElementsWithProperty(numbers, n -> n % 2 == 0);
        int oddCount = countElementsWithProperty(numbers, n -> n % 2 != 0);

        System.out.println("Number of even numbers: " + evenCount);
        System.out.println("Number of odd numbers: " + oddCount);
    }
}

interface PropertyChecker<T> {
    boolean check(T element);
}