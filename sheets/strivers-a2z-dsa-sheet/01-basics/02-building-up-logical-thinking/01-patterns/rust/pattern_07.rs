fn main() {
    const N: u8 = 5;

    let mut k = 0;
    for i in 0..N {
        // print spaces
        for j in 0..(N - i - 1) {
            print!("   ");
        }

        // print pattern
        for j in 0..(i + 1) {
            print!(" * ");
        }

        // print next pattern
        for j in 0..k {
            print!(" * ");
        }
        println!();
        k += 1;
    }
}
