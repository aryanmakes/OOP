import java.util.ArrayList;
import java.util.List;

class CountElementsWithProperty {
    public static <T> int CountElementWithProperty(List<T> list, PropertyChecker<T> checker) {
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
        for (int i = 1; i <= 170; i++) {
            numbers.add(i);
        }
        int evenCount = CountElementWithProperty(numbers, n -> n % 2 == 0);
        int oddCount = CountElementWithProperty(numbers, n -> n % 2 != 0);
        System.out.println("EVEN NUMBERS: " + evenCount);
        System.out.println("ODD NUMBERS: " + oddCount);

    }

}

interface PropertyChecker<T> {
    boolean check(T element);
}
