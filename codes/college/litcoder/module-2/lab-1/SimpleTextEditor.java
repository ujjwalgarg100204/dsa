import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CustomStack editor = new CustomStack();

        String[] commands = sc.nextLine().split("[ ,]");
        int i = 0;
        while (i < commands.length) {
            int increment = 2;
            if (commands[i].equals("1")) {
                editor.insert(commands[i + 1]);
            } else if (commands[i].equals("2")) {
                editor.delete(Integer.parseInt(commands[i + 1]));
            } else if (commands[i].equals("3")) {
                System.out.println(
                        editor.get(Integer.parseInt(commands[i + 1])));
            } else {
                editor.undo();
                increment = 1;
            }
            i += increment;
        }

        sc.close();
    }
}

/**
 * CustomStack class represents a stack data structure used for text editing
 * operations.
 * It supports insertion, deletion, retrieval, and undo operations on a sequence
 * of strings.
 */
class CustomStack {

    private Deque<String> editor;
    private Deque<String> temp;

    public CustomStack() {
        this.editor = new ArrayDeque<>();
        this.temp = new ArrayDeque<>();
    }

    /**
     * Inserts the given value into the editor.
     *
     * @param val the value to be inserted
     */
    public void insert(String val) {
        this.editor.addLast(val);
    }

    /**
     * Deletes a specified number of characters from the editor.
     * If the count exceeds the length of the current top editor string, it will
     * delete the entire string.
     *
     * @param count The number of characters to delete.
     */
    public void delete(int count) {
        while (true) {
            int lenTopEditor = this.editor.peekLast().length();
            if (count - lenTopEditor <= 0) {
                break;
            }
            count -= lenTopEditor;
            this.temp.addLast(this.editor.pop());
        }

        // check for deleting the entire string
        if (this.editor.peekLast().length() == count) {
            this.editor.pop();
        } else {
            String last = this.editor.pop();
            this.editor.addLast(last.substring(0, count - 1));
        }

        cleanup();
    }

    /**
     * Retrieves the character at the specified index in the text editor.
     *
     * @param index The index of the character to retrieve.
     * @return The character at the specified index, or '0' if the index is out of
     *         range.
     */
    public char get(int index) {
        for (String text : this.editor) {
            if (index > text.length()) {
                index -= text.length();
                continue;
            }

            return text.charAt(index - 1);
        }
        return '0';
    }

    /**
     * Undoes the last operation performed on the text editor.
     */
    public void undo() {
        this.editor.pop();
    }

    /**
     * Cleans up the temporary stack by transferring its elements back to the editor
     * stack.
     */
    private void cleanup() {
        while (!this.temp.isEmpty()) {
            this.editor.addLast(this.temp.pop());
        }
    }
}
