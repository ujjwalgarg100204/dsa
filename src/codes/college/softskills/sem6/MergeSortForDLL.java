package codes.college.softskills.sem6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * MergeSortForDLL
 */
public class MergeSortForDLL {

  private class Node {

    int data;
    Node next;
    Node prev;

    public Node() {

    }

    public Node(int data) {
      this.data = data;
    }

  }

  public String problemLink() {
    return "https://www.naukri.com/code360/problems/sort-linked-list_920517";
  }

  public Node brute(Node head) {
    // convert linked list to array
    List<Integer> list = new ArrayList<>();
    for (Node temp = head; temp != null; temp = temp.next) {
      list.add(temp.data);
    }

    // sort the array
    list.sort(Comparator.comparingInt(integer -> integer));

    // copy the sorted array back to DLL
    Node temp = head;
    for (int i : list) {
      temp.data = i;
      temp = temp.next;
    }

    return head;
  }

  public Node optimal(Node head) {
    if (head != null && head.next != null) {
      Node mid = _getMiddleOfDLL(head);

      Node left = head;
      Node right = mid.next;

      // separate two halves
      mid.next = null;

      left = optimal(left);
      right = optimal(right);

      return _merge(left, right);
    }

    return head;
  }

  private Node _merge(Node left, Node right) {
    Node newHead = new Node();
    Node tail = newHead;

    while (left != null && right != null) {
      if (left.data < right.data) {
        tail.next = left;
        left = left.next;
      } else {
        tail.next = right;
        right = right.next;
      }
      tail = tail.next;
    }

    if (left != null) {
      tail.next = left;
    } else if (right != null) {
      tail.next = right;
    }

    return newHead.next;
  }

  private static Node _getMiddleOfDLL(Node head) {
    Node slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

}
