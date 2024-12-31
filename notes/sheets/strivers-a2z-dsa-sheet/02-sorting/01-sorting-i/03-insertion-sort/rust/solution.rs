fn main() {
    let mut array = vec![1, 3, 4, 5, 6];
    insertion_sort(&mut array);
    println!("{:?}", array);

    let mut array2 = vec![6, 5, 4, 3, 1];
    insertion_sort(&mut array2);
    println!("{:?}", array2);
}

fn insertion_sort(arr: &mut Vec<i32>) {
    for i in 1..arr.len() {
        // Move elements of arr[0..i-1], that are greater than arr[i],
        // one position ahead of their current position
        let mut j = i;
        while j > 0 && arr[j] < arr[j - 1] {
            arr.swap(j, j - 1);
            j -= 1;
        }
    }
}
