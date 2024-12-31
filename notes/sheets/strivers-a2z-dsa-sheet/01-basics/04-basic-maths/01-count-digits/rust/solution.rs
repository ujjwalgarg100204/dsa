fn main() {
    assert_eq!(solution(12), 2, "Failed with input 2");
    assert_eq!(solution(2446), 1, "Failed with input 2446");
    assert_eq!(solution(23), 0, "Failed with input 23");
}

fn solution(mut n: i32) -> u32 {
    let mut answer = 0;
    let nCpy = n;

    let mut last_digit = 0;

    while n > 0 {
        last_digit = n % 10;
        if last_digit != 0 && nCpy % last_digit == 0 {
            answer += 1;
        }
        n /= 10;
    }

    answer
}
