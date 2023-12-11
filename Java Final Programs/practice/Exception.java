import java.util.*;

class ExceptionHandlng {
    public static void main(String[] args) {
        int num1, num2;
        Scanner sc = new Scanner(System.in);
        try {
            System.err.print("Enter Number1: ");
            num1 = sc.nextInt();
            System.err.print("Enter Number2: ");
            num2 = sc.nextInt();
            if (num2 == 0) {
                throw new ArithmeticException("Arithmetic Exception: Division By Zero!");
            }
            double result = (double) num1 / num2;
            System.out.print("Result: " + result);
        } catch (java.util.InputMismatchException e) {
            System.err.print("Number Format Exception");
        } catch (ArithmeticException e) {
            System.err.print(e.getMessage());
        } catch (Exception e) {
            System.err.print("Exception: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}