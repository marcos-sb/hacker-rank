/*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* Insert(Node *head,int data)
{
    Node *_newNode = new Node;
    _newNode-> data = data;
    _newNode->next = NULL;

    if(head != NULL) {
        Node *currNode = head;
        while(currNode->next != NULL) {
            currNode = currNode->next;
        }
        currNode->next = _newNode;
        return head;
    }
    return _newNode;
}
