fn main() {}

#[allow(dead_code)]
fn naive_partition(arr: &mut [i32]) {
    let mut arr_cpy = arr.to_vec();
    let pivot = *arr.last().expect("empty array provided");

    let mut i = 0;
    // first pass for all lower elements
    for &elem in arr.iter() {
        if elem <= pivot {
            arr_cpy[i] = elem;
            i += 1;
        }
    }

    // second pass for all larger elements
    for &elem in arr.iter() {
        if elem > pivot {
            arr_cpy[i] = elem;
            i += 1;
        }
    }

    // copy the changes to original array
    arr.copy_from_slice(&arr_cpy);
}

#[allow(dead_code)]
fn lomuto_partition(arr: &mut [i32]) -> usize {
    let mut i: isize = -1;

    let pivot = *arr.last().expect("empty array provided");
    for j in 0..arr.len() - 1 {
        if arr[j] < pivot {
            i += 1;
            arr.swap(i as usize, j);
        }
    }
    arr.swap((i + 1) as usize, arr.len() - 1);
    (i + 1) as usize
}

#[allow(dead_code)]
fn hoares_partition(arr: &mut [i32]) -> usize {
    let pivot = *arr.first().expect("empty array provided");

    let mut i: isize = -1;
    let mut j = arr.len();

    loop {
        i += 1;
        while arr[i as usize] < pivot {
            i += 1;
        }

        j -= 1;
        while arr[j] > pivot {
            j -= 1;
        }

        if i as usize >= j {
            return j;
        }

        arr.swap(i as usize, j);
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    fn is_partitioned(arr: &[i32], pivot: i32) -> bool {
        let mut found_pivot = false;
        for &elem in arr {
            if elem == pivot {
                found_pivot = true;
            } else if found_pivot {
                // Once we have found the pivot, all subsequent elements must be greater
                if elem < pivot {
                    return false; // Found a smaller or equal element after pivot
                }
            } else if elem > pivot {
                // If we encounter an element greater than pivot before the pivot is found
                return false;
            }
        }
        true // Passed all checks
    }

    fn is_hoares_partioned(arr: &[i32], pivot: i32, returned_pvt_idx: usize) -> bool {
        for (idx, &val) in arr.iter().enumerate() {
            if idx <= returned_pvt_idx && val >= pivot {
                return false;
            }

            if idx > returned_pvt_idx && val < pivot {
                return false;
            }
        }

        true
    }

    #[test]
    fn test_naive_partition_should_succeed() {
        let mut array = [3, 8, 2, 5, 7, 4, 1, 6];
        let pivot = *array.last().unwrap();
        naive_partition(&mut array);
        assert!(is_partitioned(&array, pivot));
    }

    #[test]
    #[should_panic(expected = "empty array provided")]
    fn test_naive_paritition_empty_arry() {
        let mut array: [i32; 0] = [];
        naive_partition(&mut array); // This should panic
    }

    #[test]
    fn test_naive_partition_single_element_array() {
        let mut array = [42];
        naive_partition(&mut array);
        assert_eq!(array, [42]); // Single element should stay the same
    }

    #[test]
    fn test_naive_partition_all_elements_equal() {
        let mut array = [5, 5, 5, 5, 5];
        naive_partition(&mut array);
        assert_eq!(array, [5, 5, 5, 5, 5]); // All equal should stay the same
    }

    #[test]
    fn test_lomuto_partition_should_succeed() {
        let mut array = [3, 8, 2, 5, 7, 4, 1, 6];
        let pivot = *array.last().unwrap();
        lomuto_partition(&mut array);
        assert!(is_partitioned(&array, pivot));
    }

    #[test]
    #[should_panic(expected = "empty array provided")]
    fn test_lomuto_paritition_empty_arry() {
        let mut array: [i32; 0] = [];
        lomuto_partition(&mut array); // This should panic
    }

    #[test]
    fn test_lomuto_partition_single_element_array() {
        let mut array = [42];
        lomuto_partition(&mut array);
        assert_eq!(array, [42]); // Single element should stay the same
    }

    #[test]
    fn test_lomuto_partition_all_elements_equal() {
        let mut array = [5, 5, 5, 5, 5];
        lomuto_partition(&mut array);
        assert_eq!(array, [5, 5, 5, 5, 5]); // All equal should stay the same
    }

    #[test]
    fn test_lomuto_partition_where_all_elements_are_smaller_than_pivot() {
        let mut array = [70, 60, 80, 40, 30];
        let pivot = *array.last().unwrap();
        lomuto_partition(&mut array);
        assert!(is_partitioned(&array, pivot));
    }

    #[test]
    fn test_hoares_partition_should_succeed() {
        let mut array = [3, 8, 2, 5, 7, 4, 1, 6];
        let pivot = *array.first().unwrap();
        let pivot_idx = hoares_partition(&mut array);
        println!("{:?}", array);
        assert!(is_hoares_partioned(&array, pivot, pivot_idx));
    }

    #[test]
    #[should_panic(expected = "empty array provided")]
    fn test_hoares_paritition_empty_arry() {
        let mut array: [i32; 0] = [];
        hoares_partition(&mut array); // This should panic
    }

    #[test]
    fn test_hoares_partition_single_element_array() {
        let mut array = [42];
        hoares_partition(&mut array);
        assert_eq!(array, [42]); // Single element should stay the same
    }

    #[test]
    fn test_hoares_partition_all_elements_equal() {
        let mut array = [5, 5, 5, 5, 5];
        hoares_partition(&mut array);
        assert_eq!(array, [5, 5, 5, 5, 5]); // All equal should stay the same
    }

    #[test]
    fn test_hoares_partition_where_all_elements_are_larger_than_pivot() {
        let mut array = [70, 60, 80, 40, 30];
        let pivot = *array.first().unwrap();
        let pivot_idx = hoares_partition(&mut array);
        assert!(is_hoares_partioned(&array, pivot, pivot_idx));
    }
}
