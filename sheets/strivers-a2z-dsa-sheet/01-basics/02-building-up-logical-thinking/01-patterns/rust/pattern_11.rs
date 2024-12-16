fn main() {
    const N: u8 = 5;

    let mut to_print = 1;
    for i in 0..N {
        to_print = if is_even(i) { 1 } else { 0 };

        for j in 0..(i + 1) {
            print!(" {} ", to_print);
            to_print = (to_print + 1) % 2;
        }
        println!();
    }
}

fn is_even(n: u8) -> bool {
    n & 1 == 0
}
