fn main() {
    const N: u8 = 5 % 27;

    let mut to_print: u8 = 65;
    for i in 0..N {
        to_print = 65;
        for _ in 0..(i + 1) {
            print!(" {} ", to_print as char);
            to_print = to_print + 1;
        }

        println!();
    }
}
