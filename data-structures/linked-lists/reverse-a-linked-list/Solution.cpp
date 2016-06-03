/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element
  Node is defined as
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* newHead;

Node* _rev(Node *head) {
    if(head->next == NULL) {
        newHead = head;
        return newHead;
    } else {
        _rev(head->next)->next = head;
        head->next = NULL;
        return head;
    }
}

Node* Reverse(Node *head)
{
    _rev(head);
    return newHead;
}
