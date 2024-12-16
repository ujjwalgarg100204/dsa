fn main() {
    const N: u8 = 4;

    for i in 0..N {
        for j in 0..(i + 1) {
            print!(" {} ", j + 1);
        }
        for j in 0..(2 * (N - i - 1)) {
            print!("   ");
        }
        for j in (0..(i + 1)).rev() {
            print!(" {} ", j + 1);
        }
        println!();
    }
}
