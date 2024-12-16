fn main() {
    const N: u8 = 5;

    for i in 0..N {
        for _ in 0..(i + 1) {
            print!(" * ");
        }
        println!();
    }
}
