package Tree;

import java.util.LinkedList;
import java.util.Queue;

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
    public void levelOrderInSameLine(Node head){
        if (head==null) {
            return ;
        }
        System.out.println("printing level order traversal");
        Queue <Node>q = new LinkedList<>();
        q.add(head);
        while (!q.isEmpty()) {
        Node n = q.poll();
        System.out.print(n.data+" ");
        if (n.left!=null) {
            q.add(n.left);
            
        }
        if (n.right!=null) {
            q.add(n.right);
            
        }
            
        }


    }

    public void levelOrderInDiffLine(Node head){
    //     if (head==null) {
    //         return ;
    //     }
    //     System.out.println("printing level order traversal");
    //     Queue <Node>q = new LinkedList<>();
    //     q.add(head);
    //     q.add(null);
    //     while (!q.isEmpty()) {
    //     Node n = q.poll();
    //     if(n==null){
    //         q.add(null);
    //         System.out.println();
    //     }
    //     else{
    //         System.out.println(n.data+" ");
    //         if (n.left!=null) {
    //             q.add(n.left);
                
    //         }
    //         if (n.right!=null) {
    //             q.add(n.right);
                
    //         }
    //     }
    //  }


System.out.println();
    if(head == null){
        return;
    }
    Queue <Node> q = new LinkedList<>();
    q.add(head);
    q.add(null);
    while(!q.isEmpty()){
        Node currNode = q.poll();
        if(currNode==null){
            System.out.println();
            if (q.isEmpty()) {
                break;
            }else{
             q.add(null);
            }
        }else{
            System.out.print(currNode.data+" ");
            if (currNode.left!=null) {
                q.add(currNode.left);
            }
            if (currNode.right!=null) {
                q.add(currNode.right);
                
            }
        }
    }
 }
 public int heightOfTree(Node head){
    if(head==null) return 0;
    int leftHeight=0;
    int rightHeight=0;
     if(head.left!=null){
         leftHeight = 1+heightOfTree(head.left);

     }

     if (head.right!=null) {
        rightHeight= 1+heightOfTree(head.right);

     }
     return Math.max(leftHeight, rightHeight);


 }


 public  int countNodes(Node head) {
        
    if(head==null) return 0;
    return 1+ countNodes(head.left)+countNodes(head.right);
}


}


public static void main(String[] args) {
    System.out.println("hiii i am building a inary treee");
    int[] nodes = {5, 2, 1, -1, -1, 3, -1, -1, 8, 7, -1, -1, 9, -1, -1};

    BinaryTree tree = new BinaryTree();
    Node head = tree.buildTree(nodes);
    System.out.println(head.data);
    tree.InOrder(head);
    System.out.println();
    tree.levelOrderInSameLine(head);
    tree.levelOrderInDiffLine(head);
    System.out.println("height of tree is "+tree.heightOfTree(head));
   
}
}