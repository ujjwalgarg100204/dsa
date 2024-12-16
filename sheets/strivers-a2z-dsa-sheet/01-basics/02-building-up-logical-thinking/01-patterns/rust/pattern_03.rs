fn main() {
    const N: u8 = 5;

    for i in 0..N {
        for j in 1..(i + 2) {
            print!(" {} ", j);
        }
        println!();
    }
}
