import java.util.*;

class Solution {
    class Node{
        Node[] child;
        int root;
        boolean isLeaf;
        
        public Node(){
            isLeaf = false;
            child = new Node[10];
        }
    }
    
    class Trie{
        Node node;
        
        public Trie(){
            this.node = new Node();
        }
        
        public boolean insert(String phoneNumber){
            Node node = this.node;
            if(node.isLeaf)
                return false;
            
            for(int i=0 ; i<phoneNumber.length() ; i++){
                int number = phoneNumber.charAt(i) - '0';
                
                node.root = number;
                if(node.child[number] == null)
                    node.child[number] = new Node();
                node = node.child[number];
                
                if(node.isLeaf)
                    return false;
            }
            
            node.isLeaf = true;
            return true;
        }
    }
    
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (o1, o2) -> o1.length() - o2.length());
        Trie trie = new Trie();
        
        for(String phone : phone_book){
            if(!trie.insert(phone))
                return false;
        }
        
        return true;
    }
}