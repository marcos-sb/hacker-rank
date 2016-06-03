/*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/
int FindMergeNode(Node headA, Node headB) {
    Node currA = headA;
    Node currB;
    while(currA != null) {
        currB = headB;
        while(currB != null) {
            if(currB == currA) return currA.data;
            else currB = currB.next;
        }
        currA = currA.next;
    }
    return -1;
}
