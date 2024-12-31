fn main() {}

#[allow(dead_code)]
fn quicksort_hoares(arr: &mut [i32]) {
    if arr.len() > 1 {
        let partition_idx = hoares_partition(arr);
        quicksort_hoares(&mut arr[..partition_idx + 1]);
        quicksort_hoares(&mut arr[partition_idx + 1..]);
    }
}

#[allow(dead_code)]
fn quicksort_lomuto(arr: &mut [i32]) {
    if arr.len() > 1 {
        let partition_idx = lomuto_partition(arr);
        quicksort_lomuto(&mut arr[..partition_idx]);
        quicksort_lomuto(&mut arr[partition_idx + 1..]);
    }
}

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

    #[test]
    fn test_quicksort_hoares() {
        let mut arr = [3, 6, 8, 10, 1, 2, 1];
        quicksort_hoares(&mut arr);
        assert_eq!(arr, [1, 1, 2, 3, 6, 8, 10]);

        let mut arr = [5, 4, 3, 2, 1];
        quicksort_hoares(&mut arr);
        assert_eq!(arr, [1, 2, 3, 4, 5]);

        let mut arr = [1, 2, 3, 4, 5];
        quicksort_hoares(&mut arr);
        assert_eq!(arr, [1, 2, 3, 4, 5]);

        let mut arr: [i32; 0] = [];
        quicksort_hoares(&mut arr);
        assert_eq!(arr, []);
    }

    #[test]
    fn test_quicksort_lomuto() {
        let mut arr = [3, 6, 8, 10, 1, 2, 1];
        quicksort_lomuto(&mut arr);
        assert_eq!(arr, [1, 1, 2, 3, 6, 8, 10]);

        let mut arr = [5, 4, 3, 2, 1];
        quicksort_lomuto(&mut arr);
        assert_eq!(arr, [1, 2, 3, 4, 5]);

        let mut arr = [1, 2, 3, 4, 5];
        quicksort_lomuto(&mut arr);
        assert_eq!(arr, [1, 2, 3, 4, 5]);

        let mut arr: [i32; 0] = [];
        quicksort_lomuto(&mut arr);
        assert_eq!(arr, []);
    }
}
