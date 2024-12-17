fn main() {
    let mut array = vec![1, 3, 4, 5, 6];
    selection_sort(&mut array);
    println!("{:?}", array);

    let mut array2 = vec![6, 5, 4, 3, 1];
    selection_sort(&mut array2);
    println!("{:?}", array2);
}

fn selection_sort(arr: &mut Vec<i32>) {
    for i in 0..arr.len() {
        // replace i with minimum number in front of it
        let mut min_idx = i;
        for j in i..arr.len() {
            if arr[j] < arr[min_idx] {
                min_idx = j;
            }
        }

        arr.swap(i, min_idx);
    }
}
