# Palindrome Number

- Problem Link: [Leetcode](https://leetcode.com/problems/palindrome-number/description/)

## Solution

ATQ, all negative and non-zero numbers with trailing zeros (eg: 10, 130) will
never become a palindrome number. Next step is just to reverse the number
and see if its equal to original

```rust
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
```
