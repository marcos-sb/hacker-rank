/*
  Delete Node at a given position in a linked list
  Node is defined as
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* Delete(Node *head, int position)
{
    if(position == 0) {
        Node* oldhead = head;
        head = head->next;
        delete(oldhead);
        return head;
    } else if(position == 1) { //basis case
        Node* next = head->next; //next will be deleted
        head->next = next->next;
        delete(next);
        return head;
    } else {
        Delete(head->next, position-1);
        return head;
    }
}
