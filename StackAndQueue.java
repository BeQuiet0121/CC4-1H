package stackandqueue;

import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class StackAndQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose data structure (stack/queue): ");
        String choice = scanner.nextLine().toLowerCase();

        System.out.print("Enter array size (n): ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (choice.equals("stack")) {
            Stack<Integer> stack = new Stack<>();
            handleStackOperations(scanner, stack, n);
        } else if (choice.equals("queue")) {
            Queue<Integer> queue = new LinkedList<>();
            handleQueueOperations(scanner, queue, n);
        } else {
            System.out.println("Invalid choice. Please run the program again.");
        }

        scanner.close();
    }

    public static void handleStackOperations(Scanner scanner, Stack<Integer> stack, int n) {
        while (true) {
            System.out.print("Choose operation (push/pop/print/exit): ");
            String operation = scanner.nextLine().toLowerCase();

            if (operation.equals("push")) {
                if (stack.size() < n) {
                    System.out.print("Enter integer value: ");
                    int value = scanner.nextInt();
                    scanner.nextLine();
                    stack.push(value);
                    System.out.println("Pushed " + value);
                } else {
                    System.out.println("Stack is full!");
                }
            } else if (operation.equals("pop")) {
                if (!stack.isEmpty()) {
                    System.out.println("Popped " + stack.pop());
                } else {
                    System.out.println("Stack is empty!");
                }
            } else if (operation.equals("print")) {
                printStack(stack);
            } else if (operation.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid operation. Try again.");
            }
        }
    }

    public static void handleQueueOperations(Scanner scanner, Queue<Integer> queue, int n) {
        while (true) {
            System.out.print("Choose operation (enqueue/dequeue/print/exit): ");
            String operation = scanner.nextLine().toLowerCase();

            if (operation.equals("enqueue")) {
                if (queue.size() < n) {
                    System.out.print("Enter integer value: ");
                    int value = scanner.nextInt();
                    scanner.nextLine();
                    queue.add(value);
                    System.out.println("Enqueued " + value);
                } else {
                    System.out.println("Queue is full!");
                }
            } else if (operation.equals("dequeue")) {
                if (!queue.isEmpty()) {
                    System.out.println("Dequeued " + queue.poll());
                } else {
                    System.out.println("Queue is empty!");
                }
            } else if (operation.equals("print")) {
                printQueue(queue);
            } else if (operation.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid operation. Try again.");
            }
        }
    }

    public static void printStack(Stack<Integer> stack) {
        System.out.println("Stack contents: " + stack);
    }

    public static void printQueue(Queue<Integer> queue) {
        System.out.println("Queue contents: " + queue);
    }
}