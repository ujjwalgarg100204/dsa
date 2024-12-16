fn main() {
    const N: u8 = 5;

    for i in 0..5 {
        for j in 0..(N - i) {
            print!(" * ");
        }
        println!();
    }
}
