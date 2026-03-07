import java.util.*;

import org.w3c.dom.Node;

import java.io.*;

class Main {
    static class Node {
        Node[] child;
        boolean isEnd;

        public Node() {
            isEnd = false;
            child = new Node[26];
        }
    }

    static class Trie {
        Node node;

        public Trie() {
            node = new Node();
        }

        public void insert(String str) {
            Node root = this.node;

            for (int i = 0; i < str.length(); i++) {
                int ch = str.charAt(i);

                if (root.child[ch - 'a'] == null) {
                    root.child[ch - 'a'] = new Node();
                }

                root = root.child[ch - 'a'];
            }

            root.isEnd = true;
        }

        public boolean search(String str) {
            Node root = this.node;

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if(root.child[ch - 'a'] == null)
                    return false;

                root = root.child[ch - 'a'];
            }

            return true;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        Trie trie = new Trie();
        while(n-- > 0){
            String str = br.readLine();
            trie.insert(str);
        }

        int answer = 0;
        while(m-- > 0){
            String str = br.readLine();
            if(trie.search(str))
                answer++;
        }

        System.out.println(answer);
        br.close();
    }
}