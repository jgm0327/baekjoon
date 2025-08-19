import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {
    static class Trie {
        char ch;
        boolean isLeaf;
        Map<Character, Trie> child;

        public Trie() {
            child = new HashMap<>();
        }

        public Trie(char ch) {
            this.ch = ch;
            isLeaf = false;
            child = new HashMap<>();
        }
    }

    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringBuilder answer = new StringBuilder();
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            total = 0;

            Trie root = new Trie();

            for (int i = 0; i < n; i++) {
                str = br.readLine();
                makeTrie(str, 0, root);
            }

            for (Trie trie : root.child.values()) {
                dfs(trie, 1);
            }

            answer.append(String.format("%.2f\n", (double) total / n));
        }

        System.out.print(answer);
        br.close();
    }

    static void dfs(Trie parent, int depth) {
        if(parent.isLeaf){
            total += depth;
        }

        int add = (parent.isLeaf || parent.child.size() > 1) ? 1 : 0;

        for (Trie nxt : parent.child.values()) {
            dfs(nxt, depth + add);
        }
    }

    static void makeTrie(String str, int idx, Trie parent) {
        if (str.length() == idx) {
            parent.isLeaf = true;
            return;
        }

        char ch = str.charAt(idx);
        if (!parent.child.containsKey(ch)) {
            parent.child.put(ch, new Trie(ch));
        }

        makeTrie(str, idx + 1, parent.child.get(ch));
    }
}