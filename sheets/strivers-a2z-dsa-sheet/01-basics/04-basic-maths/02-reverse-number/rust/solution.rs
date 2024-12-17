fn main() {
    assert_eq!(solution(-123), -321);
    assert_eq!(solution(123), 321);
    assert_eq!(solution(120), 21);
}

fn solution(mut n: i32) -> i32 {
    let mut last_digit = 0;
    let mut answer = 0;

    while n != 0 {
        last_digit = n % 10;
        n /= 10;

        if answer > i32::MAX / 10 || answer < i32::MIN / 10 {
            return 0;
        }

        answer = answer * 10 + last_digit;
    }

    answer
}
