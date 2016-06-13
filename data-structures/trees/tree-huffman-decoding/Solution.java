/*
   class Node
      public  int frequency; // the frequency of this tree
       public  char data;
       public  Node left, right;

*/

void decode(final String s, Node root) {
    if(s == null) return;
    char [] sb = new char [s.length];
    int i = 0;
    int k = 0;
    Node curr = root;
    while(i < s.length()) {
        if(s.charAt(i++) == '0') {
            curr = curr.left;
        } else {
            curr = curr.right;
        }
        if(curr.data != '\0') {
            sb[k++] = curr.data;
            curr = root;
        }
    }
    for(int _i = 0; _i < k; _i++)
        System.out.print(sb[_i]);
}
