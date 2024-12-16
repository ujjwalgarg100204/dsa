fn main() {
    const N: u8 = 5;

    let mut to_print: u8 = 65;
    for i in 0..5 {
        to_print = 65;

        for j in 0..(N - i) {
            print!(" {} ", to_print as char);
            to_print += 1;
        }
        println!();
    }
}
