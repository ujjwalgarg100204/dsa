import java.util.ArrayDeque;
import java.util.Deque;

/**
 * CelebrityProblem
 */
public class CelebrityProblem {

    public int brute(int[][] mat, int n) {
        for (int i = 0; i < n; i++) {
            if (_is_celebrity(i, mat)) {
                return i;
            }
        }
        return -1;
    }

    public int optimal(int[][] mat, int n) {
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() != 1) {
            int first = stack.pop();
            int sec = stack.pop();

            if (_knows(first, sec, mat)) {
                stack.push(sec);
            } else if (_knows(sec, first, mat)) {
                stack.push(first);
            }
        }

        int possbileCelebrity = stack.pop();

        return _is_celebrity(possbileCelebrity, mat) ? possbileCelebrity : -1;
    }

    private boolean _knows(int first, int sec, int[][] mat) {
        return mat[first][sec] == 1;
    }

    private boolean _is_celebrity(int person, int[][] mat) {
        // check row if all 0s
        boolean rowIsAllZero = true;
        for (int j = 0; j < mat.length; j++) {
            rowIsAllZero = mat[person][j] == 0;
            if (!rowIsAllZero) {
                break;
            }
        }

        // check col is all 1s
        boolean colIsAllOne = true;
        for (int j = 0; j < mat.length; j++) {
            if (person == j) {
                continue;
            }

            colIsAllOne = mat[j][person] == 1;
            if (!colIsAllOne) {
                break;
            }
        }

        return rowIsAllZero && colIsAllOne;
    }
}
