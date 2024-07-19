package codes.college.litcoder.module3.lab2;

import java.util.Scanner;

public class NoPrefixSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] passwords = sc.nextLine().split(" ");

        if (containsPrefixSet(passwords)) {
            System.out.println("BAD PASSWORD");
        } else {
            System.out.println("GOOD PASSWORD");
        }
        sc.close();
    }

    /**
     * Checks if the given array of passwords contains any prefix set.
     * A prefix set is a pair of passwords where one password is a prefix of
     * another.
     *
     * @param passwords the array of passwords to be checked
     * @return true if the array contains a prefix set, false otherwise
     */
    private static boolean containsPrefixSet(String[] passwords) {
        // for each password check all passwords
        for (int i = 0; i < passwords.length; i++) {
            for (int j = 0; j < passwords.length; j++) {
                if (i == j) {
                    continue;
                }

                if (passwords[j].startsWith(passwords[i])) {
                    return true;
                }
            }
        }

        return false;
    }
}
