package codes.college.litcoder.module2.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LegoBlocks {

    private static final int MODULO = 1000000007;

    /**
     * Calculates the number of solid layouts for a given height and width.
     *
     * @param height The number of rows in the layout.
     * @param width  The number of columns in the layout.
     * @return The number of solid layouts.
     */
    public static int solution(int height, int width) {
        // step 1: no of layouts in a single row
        int[] layouts = { 0, 1, 2, 4, 8 };
        for (int w = 5; w <= width; w++) {
            layouts[w] = (layouts[w - 1] +
                    layouts[w - 2] +
                    layouts[w - 3] +
                    layouts[w - 4]) %
                    MODULO;
        }

        // step 2: total no of layouts in H rows
        int[] totalLayouts = layouts.clone();
        for (int h = 2; h <= height; h++) {
            for (int i = 0; i <= width; i++) {
                totalLayouts[i] = (layouts[i] * totalLayouts[i]) % MODULO;
            }
        }

        // step 3: no of bad layouts in H rows
        // step 4: no of good layouts in H rows
        List<Integer> solidLayouts = new ArrayList<>(width + 1);
        solidLayouts.add(0);
        solidLayouts.add(1);
        for (int w = 2; w <= width; w++) {
            int unsolidSum = 0;
            for (int i = 1; i < w; i++) {
                unsolidSum = (unsolidSum +
                        ((totalLayouts[i] * solidLayouts.get(w - i)) %
                                MODULO))
                        %
                        MODULO;
            }
            solidLayouts.add((totalLayouts[w] - unsolidSum) % MODULO);
        }

        return solidLayouts.get(width) % MODULO;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = scanner.nextInt();
        int width = scanner.nextInt();
        System.out.println(solution(height, width));

        scanner.close();
    }
}
