fn main() {
    let mut array = vec![1, 3, 4, 5, 6];
    recursive_bubble_sort(&mut array);
    println!("{:?}", array);

    let mut array2 = vec![6, 5, 4, 3, 1];
    recursive_bubble_sort(&mut array2);
    println!("{:?}", array2);
}

fn recursive_bubble_sort(arr: &mut [i32]) {
    let n = arr.len();
    if n == 1 {
        return;
    }

    for i in 0..n - 1 {
        if arr[i] > arr[i + 1] {
            arr.swap(i, i + 1);
        }
    }

    recursive_bubble_sort(&mut arr[..n - 1]);
}
