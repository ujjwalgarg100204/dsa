fn main() {
    let mut array = vec![1, 3, 4, 5, 6];
    recursive_insertion_sort(&mut array);
    println!("{:?}", array);

    let mut array2 = vec![6, 5, 4, 3, 1];
    recursive_insertion_sort(&mut array2);
    println!("{:?}", array2);
}

fn recursive_insertion_sort(arr: &mut [i32]) {
    let n = arr.len();
    if n == 1 {
        return;
    }

    // first sort all the array before last element
    recursive_insertion_sort(&mut arr[..n - 1]);

    // now put the last element in the correct place
    let mut j = n - 1;
    while j > 0 && arr[j - 1] > arr[j] {
        arr.swap(j, j - 1);
        j -= 1;
    }
}
