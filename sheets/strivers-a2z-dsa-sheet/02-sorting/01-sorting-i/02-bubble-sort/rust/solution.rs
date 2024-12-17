fn main() {
    let mut array = vec![1, 3, 4, 5, 6];
    bubble_sort(&mut array);
    println!("{:?}", array);

    let mut array2 = vec![6, 5, 4, 3, 1];
    bubble_sort(&mut array2);
    println!("{:?}", array2);
}

fn bubble_sort(arr: &mut Vec<i32>) {
    for i in 0..arr.len() {
        let mut is_sorted = true;

        for j in i + 1..arr.len() {
            if arr[j] < arr[i] {
                is_sorted = false;
                arr.swap(i, j);
            }
        }

        if is_sorted {
            return;
        }
    }
}
