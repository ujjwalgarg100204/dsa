# Odd Even Linked List

Problem Link: **[leetcode](https://leetcode.com/problems/odd-even-linked-list/)**

Similar to problem: [[3. Segregate Even and Odds in LL]]

## Solution Optimal Code

```java
public codes.college.softskills.sem6.ListNode optimal(codes.college.softskills.sem6.ListNode head) {
    // create odds and evens linked list
    codes.college.softskills.sem6.ListNode odds = new codes.college.softskills.sem6.ListNode(Integer.MAX_VALUE);
    codes.college.softskills.sem6.ListNode oddsTail = odds;
    codes.college.softskills.sem6.ListNode evens = new codes.college.softskills.sem6.ListNode(Integer.MAX_VALUE);
    codes.college.softskills.sem6.ListNode evensTail = evens;

    boolean isEven = false;
    for (codes.college.softskills.sem6.ListNode i = head; i != null; i = i.next) {
        if (isEven) {
            evensTail.next = i;
            evensTail = evensTail.next;
        } else {
            oddsTail.next = i;
            oddsTail = oddsTail.next;
        }
        isEven = !isEven;
    }

    // clean last value of the linked list
    evensTail.next = null;
    oddsTail.next = null;

    // append the evens ll to odd ll and return even ll head
    // remember odds first node is dummy node
    oddsTail.next = evens.next;

    // remember evens first node is dummy node
    return odds.next;
}
```
