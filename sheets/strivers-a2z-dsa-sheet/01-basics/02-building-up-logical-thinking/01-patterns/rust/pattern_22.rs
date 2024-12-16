fn main() {
    const N: u8 = 5;

    top_pattern(N);
    bottom_pattern(N);
}

fn top_pattern(n: u8) {
    for i in 0..n {
        for j in 0..i {
            print!(" {} ", n - j);
        }

        for j in 0..2 * (n - i) - 1 {
            print!(" {} ", n - i);
        }

        for j in (0..i).rev() {
            print!(" {} ", n - j);
        }

        println!();
    }
}

fn bottom_pattern(n: u8) {
    for i in (0..n - 1).rev() {
        for j in 0..i {
            print!(" {} ", n - j);
        }

        for j in 0..2 * n - 1 - 2 * i {
            print!(" {} ", n - i);
        }

        for j in (0..i).rev() {
            print!(" {} ", n - j);
        }

        println!();
    }
}
