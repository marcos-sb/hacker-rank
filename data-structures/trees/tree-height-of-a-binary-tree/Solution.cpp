
/*The tree node has data, left child and right child
struct node
{
    int data;
    node* left;
    node* right;
};

*/
int height(node * root)
{
    if(root == NULL) return 0;
    return max(height(root->left), height(root->right)) + 1;
}
