/*
  Print elements of a linked list in reverse order as standard output
  head pointer could be NULL as well for empty list
  Node is defined as
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
void ReversePrint(Node *head)
{
    if(head == NULL) return;
    if(head->next == NULL)
        cout << head->data << "\n";
    else {
        ReversePrint(head->next);
        cout << head->data << "\n";
    }
}
