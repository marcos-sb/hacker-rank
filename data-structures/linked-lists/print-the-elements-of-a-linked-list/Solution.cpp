/*
  Print elements of a linked list on console
  head pointer input could be NULL as well for empty list
  Node is defined as
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
void Print(Node *head)
{
    if(head == NULL) return;
    cout << head->data << "\n";
    Node * curr = head;
    while((curr = curr->next) != NULL)
        cout << curr->data << "\n";
}
