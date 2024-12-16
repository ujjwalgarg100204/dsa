fn main() {
    const N: u8 = 5;

    let mut to_print: u8;
    for i in 0..N {
        to_print = 65;
        // print spaces
        for j in 0..(N - i - 1) {
            print!("   ");
        }

        // print pattern
        for j in 0..(i + 1) {
            print!(" {} ", to_print as char);
            to_print += 1;
        }

        // print 2nd pattern
        to_print -= 1;
        for j in 0..i {
            to_print -= 1;
            print!(" {} ", to_print as char);
        }

        println!();
    }
}
