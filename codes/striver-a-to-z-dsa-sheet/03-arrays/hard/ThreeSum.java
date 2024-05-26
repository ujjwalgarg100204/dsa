import java.util.*;

public class ThreeSum {

    public String getProblemLink() {
        return "https://leetcode.com/problems/3sum/description";
    }

    public List<List<Integer>> brute(int[] arr) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    // check if sum is 0
                    if (arr[i] + arr[j] + arr[k] != 0) {
                        continue;
                    }

                    List<Integer> triplet = new ArrayList<>(
                            List.of(arr[i], arr[j], arr[k]));
                    triplet.sort(Integer::compare);
                    set.add(triplet);
                }
            }
        }

        return new ArrayList<>(set);
    }

    public List<List<Integer>> better(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        Set<List<Integer>> set = new HashSet<>();
        // populate the map
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            // decrement count of arr[i] in map
            addToValue(map, arr[i], -1);

            final int reqSum = -1 * arr[i];
            // find rest of two numbers
            for (int j = 0; j < arr.length; j++) {
                if (i == j)
                    continue;

                // decrement count of arr[j] in map
                addToValue(map, arr[j], -1);

                int thirdNum = reqSum - arr[j];
                // if third num exists and its count is > 0
                if (map.containsKey(thirdNum) && map.get(thirdNum) > 0) {
                    List<Integer> triplet = new ArrayList<>(
                            List.of(arr[i], arr[j], thirdNum));
                    triplet.sort(Integer::compare);
                    set.add(triplet);
                }

                // increment count of arr[j] in map
                addToValue(map, arr[j], 1);
            }

            // increment count of arr[i] in map
            addToValue(map, arr[i], 1);
        }
        return new ArrayList<>(set);
    }

    private static void addToValue(
            Map<Integer, Integer> map,
            int key,
            int toAdd) {
        map.replace(key, map.get(key) + toAdd);
    }

    public List<List<Integer>> differentBetter(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Set<List<Integer>> triplets = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int thirdDig = -1 * (arr[i] + arr[j]);
                if (set.contains(thirdDig)) {
                    List<Integer> triplet = new ArrayList<>(
                            List.of(arr[i], arr[j], thirdDig));
                    triplet.sort(Integer::compare);
                    triplets.add(triplet);
                }
                set.add(arr[j]);
            }
            set.clear();
        }
        return new ArrayList<>(triplets);
    }

    public List<List<Integer>> optimal(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    triplets.add(List.of(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    // move j ahead till j is not equal to its prev value
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }

                    // move k behind till k is not equal to its prev value
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return triplets;
    }

}
