fn main() {
    const N: u8 = 5;

    top_pattern(N);
    bottom_pattern(N - 1);
}

fn top_pattern(n: u8) {
    for i in 0..n {
        for _ in 0..(i + 1) {
            print!(" * ");
        }
        println!();
    }
}

fn bottom_pattern(n: u8) {
    for i in 0..5 {
        for j in 0..(n - i) {
            print!(" * ");
        }
        println!();
    }
}
