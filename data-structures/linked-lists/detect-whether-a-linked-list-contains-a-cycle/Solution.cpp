/*
  Detect loop in a linked list
  List could be empty also
  Node is defined as
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
int HasCycle(Node* head)
{
    Node* next = head;
    Node* nextnext = head;
    while(nextnext != NULL && nextnext->next != NULL) {
        next = next->next;
        nextnext = nextnext->next->next;
        if(next == nextnext) return 1;
    }
    return 0;
}
