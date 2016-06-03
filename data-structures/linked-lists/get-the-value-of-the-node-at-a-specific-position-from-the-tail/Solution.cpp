/*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
int GetNode(Node *head,int positionFromTail)
{
    int pStart = 0;
    Node* curr = head;
    while(pStart < positionFromTail) {
        curr = curr->next;
        pStart++;
    }
    Node* fromStart = head;
    while(curr->next != NULL) {
        curr = curr->next;
        fromStart = fromStart->next;
    }
    return fromStart->data;
}
