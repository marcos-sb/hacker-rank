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

Node SortedInsert(Node head,int data) {
    if(head == null) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        newNode.prev = null;
        return newNode;
    } else if(head.data < data) {
        Node newNode = SortedInsert(head.next,data);
        head.next = newNode;
        return head;
    } else { //head.data >= data
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        newNode.prev = head.prev;
        head.prev = newNode;
        return newNode;
    }
}
