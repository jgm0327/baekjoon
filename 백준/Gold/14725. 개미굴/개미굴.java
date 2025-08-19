import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    static class Trie {
        String str;
        TreeMap<String, Trie> child;

        public Trie() {
            child = new TreeMap<>();
        }

        public Trie(String str) {
            this.str = str;
            child = new TreeMap<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Trie root = new Trie();
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(tokenizer.nextToken());
            String[] arr = new String[m];
            for (int j = 0; j < m; j++) {
                arr[j] = tokenizer.nextToken();
            }

            makeTrie(root, 0, arr);
        }

        StringBuilder answer = new StringBuilder();
        for (String key : root.child.keySet()) {
            dfs(root.child.get(key), 0, answer);
        }

        System.out.print(answer);

        br.close();
    }

    static void dfs(Trie parent, int depth, StringBuilder answer) {
        answer.append(makeBar(depth)).append(parent.str).append("\n");
        if (parent.child.size() == 0) {
            return;
        }

        for (String str : parent.child.keySet()) {
            dfs(parent.child.get(str), depth + 1, answer);
        }
    }

    static String makeBar(int depth) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            ret.append("--");
        }
        return ret.toString();
    }

    static void makeTrie(Trie trie, int idx, String[] arr) {
        if(idx == arr.length){
            return;
        }

        if (!trie.child.containsKey(arr[idx])) {
            trie.child.put(arr[idx], new Trie(arr[idx]));
        }

        makeTrie(trie.child.get(arr[idx]), idx + 1, arr);
    }
}