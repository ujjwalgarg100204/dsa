package codes.college.litcoder.contests.contest1;

import java.util.Scanner;

class DS {

    final int[] size;
    final int[] parent;

    public DS(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findPar(int n) {
        if (parent[n] == n)
            return n;
        parent[n] = findPar(parent[n]);
        return parent[n];
    }

    public void union(int i, int j) {
        int a = findPar(i);
        int b = findPar(j);
        if (a == b) {
            size[b]++;
            return;
        }
        if (size[a] < size[b]) {
            parent[a] = b;
            size[b] += (size[a] + 1);
        } else {
            parent[b] = a;
            size[a] += (size[b] + 1);
        }
    }
}

public class CountServerThatCommunicates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int gridSize = sc.nextInt();
        int[][] grid = new int[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(countServers(grid));

        sc.close();
    }

    public static int countServers(int[][] grid) {
        DS ds = new DS(grid.length + grid[0].length + 1);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ds.union(i, j + grid.length);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < ds.parent.length; i++) {
            if (ds.parent[i] == i && ds.size[i] > 1)
                ans += ds.size[i];
        }
        return ans;
    }
}
