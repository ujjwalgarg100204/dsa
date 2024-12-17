fn main() {
    let mut array = vec![1, 3, 4, 5, 6];
    merge_sort(&mut array);
    println!("{:?}", array);

    let mut array2 = vec![6, 5, 4, 3, 1];
    merge_sort(&mut array2);
    println!("{:?}", array2);
}

fn merge_sort(arr: &mut Vec<i32>) {
    if arr.len() > 1 {
        let mid = arr.len() / 2;

        let mut left = arr[..mid].to_vec();
        let mut right = arr[mid..].to_vec();

        merge_sort(&mut left);
        merge_sort(&mut right);

        merge(arr, &left, &right);
    }
}

fn merge(dst: &mut Vec<i32>, left: &[i32], right: &[i32]) {
    let (mut i, mut j, mut k) = (0, 0, 0);
    while i < left.len() && j < right.len() {
        if left[i] < right[j] {
            dst[k] = left[i];
            i += 1;
        } else {
            dst[k] = right[j];
            j += 1;
        }
        k += 1;
    }

    while i < left.len() {
        dst[k] = left[i];
        i += 1;
        k += 1;
    }

    while j < right.len() {
        dst[k] = right[j];
        j += 1;
        k += 1;
    }
}
