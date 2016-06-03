/*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
     Node prev;
  }
*/

Node reverse_(Node head) {
    if(head == null) return null;
    else if(head.next == null) {
        head.prev = null;
        return head;
    } else {
        reverse_(head.next).next = head;
        head.prev = head.next;
        head.next = null;
        return head;
    }
}

Node Reverse(Node head) {
    Node head_ = reverse_(head);
    while(head_ != null && head_.prev != null)
        head_ = head_.prev;
    return head_;
}
