fn main() {
    const N: u8 = 5;

    let mut k = N - 1;
    for i in 0..N {
        // print spaces
        for j in 0..i {
            print!("   ");
        }
        for j in 0..(N - i) {
            print!(" * ");
        }

        for j in 0..k {
            print!(" * ");
        }

        k -= 1;
        println!();
    }
}
