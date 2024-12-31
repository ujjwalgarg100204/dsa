fn main() {
    const N: u8 = 5;

    top_pattern(N);
    bottom_pattern(N);
}

fn top_pattern(n: u8) {
    for i in 0..n {
        // print stars
        for j in 0..(n - i) {
            print!(" * ");
        }

        // print spaces
        for j in 0..2 * i {
            print!("   ");
        }

        // print stars
        for j in 0..(n - i) {
            print!(" * ");
        }

        println!();
    }
}

fn bottom_pattern(n: u8) {
    for i in (0..n).rev() {
        // print stars
        for j in 0..(n - i) {
            print!(" * ");
        }

        // print spaces
        for j in 0..2 * i {
            print!("   ");
        }

        // print stars
        for j in 0..(n - i) {
            print!(" * ");
        }

        println!();
    }
}
