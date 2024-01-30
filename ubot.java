/* Class node is defined as :
    class Node 
       int val;   //Value
       int ht;      //Height
       Node left;   //Left child
       Node right;   //Right child
   */

  static int height(Node root)
   {
       if(root==null)
           return -1;
       else
           return root.ht;
   }
   static int setHeight(Node root)
    {
        if(root==null)
            return -1;
        else
            return 1+ Math.max(height(root.left),height(root.right));
    }
    static Node right(Node root)
    {
        Node newNode=root.left;
        root.left=root.left.right;
        newNode.right=root;
        root.ht=setHeight(root);
        newNode.ht=setHeight(newNode);
        return newNode;
    }
    static Node left(Node root)
    {
        Node newNode=root.right;
        root.right=root.right.left;
        newNode.left=root;
         root.ht=setHeight(root);
        newNode.ht=setHeight(newNode);
       
        return newNode;
    }
   static Node insert(Node root,int val)
    {
       if(root==null)
       {
           Node temp=new Node();
           temp.val=val;
           temp.left=temp.right=null;
           return temp;
       }
       else if(val<=root.val)
           root.left=insert(root.left,val);
       else if(val>root.val)
           root.right=insert(root.right,val);
           
       int bal=height(root.left)-height(root.right);
       if(bal>1)
       {
           if(height(root.left.left)>=height(root.left.right))
           {
               root=right(root);
           }
           else
           {
               root.left=left(root.left);
               root=right(root);
           }
       }
       if(bal<-1)
       {
           if(height(root.right.right)>=height(root.right.left))
           {
               root=left(root);
           }
           else
           {
               root.right=right(root.right);
               root=left(root);
           }
       }
       else
       {
           root.ht=setHeight(root);
       }
       return root;
    }