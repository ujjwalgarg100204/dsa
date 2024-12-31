fn main() {
    const N: u8 = 4;

    for i in 0..N {
        for j in 0..N {
            if (i == 0 || i == N - 1) {
                print!(" * ");
                continue;
            }

            if (j == 0 || j == N - 1) {
                print!(" * ");
            } else {
                print!("   ");
            }
        }

        println!();
    }
}
