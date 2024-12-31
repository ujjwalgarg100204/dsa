fn main() {
    const N: u8 = 5 % 6;

    let mut to_print: u8;
    for i in 0..N {
        to_print = 69 - i;

        // print pattern
        for j in 0..(i + 1) {
            print!(" {} ", to_print as char);
            to_print += 1;
        }

        println!();
    }
}
