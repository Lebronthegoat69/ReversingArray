
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ReversingArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Array, Stack, and Queue Reversal");
        System.out.println("--------------------------------");

        System.out.print("How many values would you like to enter? ");
        int count = scanner.nextInt();

        if (count <= 0) {
            System.out.println("Please enter a number greater than zero.");
            scanner.close();
            return;
        }

        int[] numbers = new int[count];
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            int value = scanner.nextInt();

            numbers[i] = value;
            stack.push(value);
            queue.add(value);
        }

        System.out.println("\nOriginal Collections:");
        System.out.println("The values in the Array are now: "
                + arrayToString(numbers));
        System.out.println("The values in the Stack collection are now: "
                + stackToString(stack));
        System.out.println("The values in the Queue collection are now: "
                + queueToString(queue));

        // Reverse the actual array by swapping elements.
        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }

        // Reverse the stack.
        Collections.reverse(stack);

        // Reverse the queue by using a temporary list.
        List<Integer> queueValues = new ArrayList<>(queue);
        Collections.reverse(queueValues);
        queue.clear();
        queue.addAll(queueValues);

        System.out.println("\nReversed Collections:");
        System.out.println("The reversed values in the Array are now: "
                + arrayToString(numbers));
        System.out.println("The reversed values in the Stack collection are now: "
                + stackToString(stack));
        System.out.println("The reversed values in the Queue collection are now: "
                + queueToString(queue));

        scanner.close();
    }

    public static String arrayToString(int[] numbers) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            result.append(numbers[i]);

            if (i < numbers.length - 1) {
                result.append(", ");
            }
        }

        return result.toString();
    }

    public static String stackToString(Stack<Integer> stack) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stack.size(); i++) {
            result.append(stack.get(i));

            if (i < stack.size() - 1) {
                result.append(", ");
            }
        }

        return result.toString();
    }

    public static String queueToString(Queue<Integer> queue) {
        StringBuilder result = new StringBuilder();

        for (Integer value : queue) {
            if (result.length() > 0) {
                result.append(", ");
            }

            result.append(value);
        }

        return result.toString();
    }
}