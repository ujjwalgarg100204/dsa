import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class QueuesUsingStacks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();

        int[] inputs = Arrays
                .stream(sc.nextLine().split("[ ,]"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int i = 0;
        while (i < inputs.length) {
            if (inputs[i] == 1) {
                q.enqueue(inputs[i + 1]);
                i += 2;
            } else if (inputs[i] == 2) {
                q.dequeue();
                i++;
            } else {
                System.out.println(q.front());
                i++;
            }
        }

        sc.close();
    }
}

/**
 * A Queue implementation using two Stacks.
 */
class Queue {

    private Deque<Integer> mainStack;
    private Deque<Integer> tempStack;

    public Queue() {
        this.mainStack = new ArrayDeque<>();
        this.tempStack = new ArrayDeque<>();
    }

    /**
     * Adds an element to the queue.
     *
     * @param num the element to be added
     */
    public void enqueue(int num) {
        mainStack.push(num);
    }

    /**
     * Removes and returns the element at the front of the queue.
     * This operation has a time complexity of O(n), where n is the number of
     * elements in the queue.
     *
     * @return the element at the front of the queue
     */
    public int dequeue() {
        // empty main stack into temp stack to get
        // elements which was enqueued first
        switchStack(mainStack, tempStack);

        int dequeued = this.tempStack.pop();

        // set the stacks back to normal
        switchStack(tempStack, mainStack);

        return dequeued;
    }

    /**
     * Returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     */
    public int front() {
        // empty main stack into temp stack to get
        // elements which was enqueued first
        switchStack(mainStack, tempStack);

        int frontElement = this.tempStack.peek();

        // set the stacks back to normal
        switchStack(tempStack, mainStack);

        return frontElement;
    }

    /**
     * Switches the elements from one stack to another.
     *
     * @param from the stack from which elements are to be switched
     * @param to   the stack to which elements are to be switched
     */
    private static void switchStack(Deque<Integer> from, Deque<Integer> to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }
}
