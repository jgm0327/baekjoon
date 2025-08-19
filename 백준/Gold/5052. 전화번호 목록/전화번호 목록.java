import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static class Trie {
        char ch;
        boolean isLeaf;
        Trie[] child;

        public Trie() {
            isLeaf = false;
            child = new Trie[10];
        }

        public Trie(char ch) {
            this.ch = ch;
            isLeaf = false;
            child = new Trie[10];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String[] phoneNumbers = new String[n];

            for (int i = 0; i < n; i++) {
                phoneNumbers[i] = br.readLine();
            }

            Arrays.sort(phoneNumbers, (o1, o2) -> o1.length() - o2.length());
            answer.append(solution(phoneNumbers));
        }

        System.out.print(answer);

        br.close();
    }

    static String solution(String[] phoneNumbers) {
        Trie root = new Trie();
        for (String phoneNumber : phoneNumbers) {
            if (trie(root, 0, phoneNumber))
                return "NO\n";
        }
        return "YES\n";
    }

    static boolean trie(Trie parent, int idx, String phoneNumber) {
        if (idx == phoneNumber.length()) {
            parent.isLeaf = true;
            return false;
        }

        if (parent.isLeaf)
            return true;

        char ch = phoneNumber.charAt(idx);

        if(parent.child[ch - '0'] == null){
            parent.child[ch - '0'] = new Trie(ch);
        }

        return trie(parent.child[ch - '0'], idx + 1, phoneNumber);
    }
}