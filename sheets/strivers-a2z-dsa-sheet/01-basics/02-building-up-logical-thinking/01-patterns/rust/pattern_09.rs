fn bottom_pattern(n: u8) {
    let mut k = n - 1;
    for i in 0..n {
        // print spaces
        for j in 0..i {
            print!("   ");
        }
        for j in 0..(n - i) {
            print!(" * ");
        }

        for j in 0..k {
            print!(" * ");
        }

        k -= 1;
        println!();
    }
}

fn top_pattern(n: u8) {
    let mut k = 0;
    for i in 0..n {
        // print spaces
        for j in 0..(n - i - 1) {
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
fn main() {
    const N: u8 = 5;

    top_pattern(N);
    bottom_pattern(N);
}
