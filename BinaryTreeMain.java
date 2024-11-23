package Tree;

public class BinaryTreeMain{
static class Node{
    int data ;
    Node left;
    Node right;

    public Node(){

        this.data= -1;
        this.left= null;
        this.right= null;
    }
    public Node(int data){

        this.data= data;
        this.left= null;
        this.right= null;
    }
}



static class BinaryTree {
    int idx=-1;
    public Node buildTree(int [] nodes){
     idx++;
     if(idx >=nodes.length || nodes[idx]==-1 ) return null;
     Node newNode= new Node(nodes[idx]);
     newNode.left=buildTree(nodes);
     newNode.right=buildTree(nodes);

     return newNode;
    }
    public void preOrder(Node head){

        if(head==null) return ;
        System.out.print(head.data+" ");
        preOrder(head.left);
        preOrder(head.right);
        System.out.println();

    }
    public void InOrder(Node head){
        if (head==null) {
            return ;
        }
        InOrder(head.left);
        System.out.print (head.data+" ");
         InOrder(head.right);

    }
    public void postOrder(Node head){
        if (head==null) {
            return ;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.print (head.data+" ");

    }

}


public static void main(String[] args) {
    System.out.println("hiii i am building a inary treee");
    int [] nodes = {5,2,8,1,3,7,9};
    BinaryTree tree = new BinaryTree();
    Node head = tree.buildTree(nodes);
    System.out.println(head.data);
    tree.InOrder(head);
   
}
}