/*
  Insert Node at a given position in a linked list
  The linked list will not be empty and position will always be valid
  First element in the linked list is at position 0
  Node is defined as
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* InsertNth(Node* head, int data, int position) {
    if(position == 0 || head == NULL) {
        Node* newN = new Node();
        newN->data = data;
        newN->next = head;
        return newN;
    } else {
        head->next = InsertNth(head->next, data, position-1);
        return head;
    }
}
