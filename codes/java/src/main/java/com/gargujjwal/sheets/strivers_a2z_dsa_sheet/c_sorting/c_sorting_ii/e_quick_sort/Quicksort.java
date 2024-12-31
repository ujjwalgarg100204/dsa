package com.gargujjwal.sheets.strivers_a2z_dsa_sheet.c_sorting.c_sorting_ii.e_quick_sort;

public class Quicksort {
  public static void quickSort(int arr[], int low, int high) {
    if (low < high) {
      int partitionIdx = partition(arr, low, high);
      quickSort(arr, low, partitionIdx);
      quickSort(arr, partitionIdx + 1, high);
    }
  }

  // hoares
  public static int partition(int arr[], int low, int high) {
    int i = low - 1;
    int j = high + 1;
    int pivot = arr[low];
    while (true) {
      do {
        i++;
      } while (arr[i] < pivot);

      do {
        j--;
      } while (arr[j] > pivot);

      if (i >= j) {
        return j;
      }
      swap(arr, i, j);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
