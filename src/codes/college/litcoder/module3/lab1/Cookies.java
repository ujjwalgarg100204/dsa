package codes.college.litcoder.module3.lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Represents an element in an array.
 */
class ArrayElement {

    int index;
    int value;

    /**
     * Constructs a new ArrayElement object with the specified index and value.
     *
     * @param index the index of the element
     * @param value the value of the element
     */
    public ArrayElement(int index, int value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Sets the index of the element.
     *
     * @param index the new index value
     * @return the updated ArrayElement object
     */
    public ArrayElement setIndex(int index) {
        this.index = index;
        return this;
    }

    /**
     * Sets the value of the element.
     *
     * @param value the new value
     * @return the updated ArrayElement object
     */
    public ArrayElement setValue(int value) {
        this.value = value;
        return this;
    }

    /**
     * Returns a string representation of the ArrayElement object.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "index: " + index + " value: " + value;
    }
}

public class Cookies {

    /**
     * Finds the two smallest elements in a given list of integers.
     *
     * @param arr the list of integers
     * @return a list containing the two smallest elements as ArrayElement objects
     */
    public static List<ArrayElement> leastTwoElements(List<Integer> arr) {
        ArrayElement firstMin = new ArrayElement(0, arr.get(0));
        ArrayElement secMin = new ArrayElement(0, arr.get(1));

        for (int i = 0; i < arr.size(); i++) {
            int val = arr.get(i);

            if (firstMin.value < val && secMin.value > val) {
                secMin.setIndex(i).setValue(val);
            } else if (firstMin.value > val) {
                secMin.setIndex(firstMin.index).setValue(firstMin.value);
                firstMin.setIndex(i).setValue(val);
            }
        }

        List<ArrayElement> result = new ArrayList<>();
        result.add(firstMin);
        result.add(secMin);
        return result;
    }

    /**
     * Calculates the minimum number of steps required to reach the target sweetness
     * level.
     *
     * @param targetSweetness The target sweetness level to achieve.
     * @param candySweetness  The list of candy sweetness levels.
     * @return The minimum number of steps required.
     */
    public static int solution(
            int targetSweetness,
            List<Integer> candySweetness) {
        List<ArrayElement> minElements = leastTwoElements(candySweetness);
        int steps = 0;

        while (minElements.get(0).value < targetSweetness) {
            int newSweetness = minElements.get(0).value + 2 * minElements.get(1).value;

            // delete least two sweetness
            candySweetness.remove(minElements.get(0).index);
            candySweetness.remove(minElements.get(1).index);

            // add new sweetness
            candySweetness.add(newSweetness);

            // recalculate first and second minimums
            minElements = leastTwoElements(candySweetness);

            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetSweetness = scanner.nextInt();
        scanner.nextLine();
        List<Integer> candySweetness = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(solution(targetSweetness, candySweetness));

        scanner.close();
    }
}
