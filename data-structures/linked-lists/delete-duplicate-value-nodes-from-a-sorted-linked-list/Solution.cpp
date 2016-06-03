/*
  Remove all duplicate elements from a sorted linked list
  Node is defined as
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* RemoveDuplicates(Node *head)
{
    if(head->next == NULL) return head;
    if(head->next->data == head->data) {
        Node* next = head->next;
        head->next = next->next;
        delete(next);
        RemoveDuplicates(head);
    } else {
        RemoveDuplicates(head->next);
    }
    return head;
}
