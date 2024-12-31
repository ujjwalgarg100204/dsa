fn main() {
    const N: u8 = 5;

    let mut to_print: u8 = 65;
    for i in 0..N {
        for _ in 0..(i + 1) {
            print!(" {} ", to_print as char);
        }

        println!();
        to_print += 1;
    }
}
