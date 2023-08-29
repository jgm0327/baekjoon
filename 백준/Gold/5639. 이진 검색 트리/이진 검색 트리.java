import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    private static int[] nodes;

    static class Node{
        Node left;
        Node right;
        int num;

        Node(int num, Node left, Node right){
            this.num = num;
            this.right = right;
            this.left = left;
        }
    }

    private static StringBuilder answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        nodes = new int[10001];

        int num = 0;
        String number = "";
        while((number = br.readLine()) != null){
            num = Integer.parseInt(number);
            nodes[idx++] = num;
        }

        Node root = new Node(nodes[0], null, null);
        for(int i=1; i<idx ; i++){
            makeTree(root, nodes[i]);
        }

        answer = new StringBuilder();
        printPostOrder(root);

        System.out.println(answer);
        br.close();
    }

    private static void makeTree(Node parent, int child){
        if(parent.num < child){
            if(parent.right == null){
                parent.right = new Node(child, null, null);
                return;
            }
            makeTree(parent.right, child);
        }else{
            if(parent.left == null){
                parent.left = new Node(child, null, null);
                return;
            }
            makeTree(parent.left, child);
        }
    }

    private static void printPostOrder(Node parent){
        if(parent.left != null)printPostOrder(parent.left);
        if(parent.right != null) printPostOrder(parent.right);
        answer.append(parent.num).append("\n");
    }
}