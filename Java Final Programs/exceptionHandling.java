import java.util.Scanner;

class ExceptionHandling {
    public static void main(String[] args) {
        int num1, num2;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Num1: ");
            num1 = scanner.nextInt();

            System.out.print("Enter Num2: ");
            num2 = scanner.nextInt();

            if (num2 == 0) {
                throw new ArithmeticException("Arithmetic Exception: Division by zero");
            }

            double result = (double) num1 / num2;
            System.out.println("Result: " + result);

        } catch (java.util.InputMismatchException e) {
            System.err.println("Number Format Exception");

        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}
