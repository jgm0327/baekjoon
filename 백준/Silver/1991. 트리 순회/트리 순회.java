import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        tree = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            char parent = tokenizer.nextToken().charAt(0);
            char left = tokenizer.nextToken().charAt(0);
            char right = tokenizer.nextToken().charAt(0);

            tree[parent - 'A'][0] = left == '.' ? -1 : left - 'A';
            tree[parent - 'A'][1] = right == '.' ? -1 : right - 'A';
        }

        StringBuilder answer = new StringBuilder();
        preOrder(answer, 0);
        answer.append("\n");
        inOrder(answer, 0);
        answer.append("\n");
        postOrder(answer, 0);

        System.out.println(answer);
        br.close();
    }

    static void preOrder(StringBuilder path, int parent) {
        path.append((char) (parent + 'A'));
        if (tree[parent][0] != -1)
            preOrder(path, tree[parent][0]);

        if (tree[parent][1] != -1)
            preOrder(path, tree[parent][1]);
    }

    static void inOrder(StringBuilder path, int parent) {
        if (tree[parent][0] != -1)
            inOrder(path, tree[parent][0]);
        path.append((char) (parent + 'A'));
        if (tree[parent][1] != -1)
            inOrder(path, tree[parent][1]);
    }

    static void postOrder(StringBuilder path, int parent) {
        if (tree[parent][0] != -1)
            postOrder(path, tree[parent][0]);

        if (tree[parent][1] != -1)
            postOrder(path, tree[parent][1]);

        path.append((char) (parent + 'A'));
    }
}