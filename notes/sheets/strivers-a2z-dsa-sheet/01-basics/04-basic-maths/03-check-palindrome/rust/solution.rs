fn main() {
    assert_eq!(solution(121), true);
    assert_eq!(solution(10), false);
    assert_eq!(solution(0), true);
}

fn solution(mut n: i32) -> bool {
    // if there is trailing zero then its not a palindrome
    // or its a negative number
    if n < 0 || (n > 0 && n % 10 == 0) {
        return false;
    }

    let nCpy = n;
    let mut reversed_number = 0;
    while n != 0 {
        reversed_number = reversed_number * 10 + n % 10;
        n /= 10;
    }

    reversed_number == nCpy
}
