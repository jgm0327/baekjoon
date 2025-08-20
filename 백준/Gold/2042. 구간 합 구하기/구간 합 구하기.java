import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int n, m, k;
    static long[] tree, arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int size = (1 << (h + 1));

        tree = new long[size];
        arr = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        makeSegmentTree(1, n, 1);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            long c = Long.parseLong(tokenizer.nextToken());

            if (a == 1)
                updateTree(1, n, 1, b, c);

            else
                answer.append(getSum(1, n, 1, b, (int) c)).append("\n");

        }
        System.out.print(answer);

        br.close();
    }

    static void makeSegmentTree(int left, int right, int depth) {
        if (left == right) {
            tree[depth] = arr[left];
            return;
        }

        int mid = (left + right) / 2;

        makeSegmentTree(left, mid, depth * 2);
        makeSegmentTree(mid + 1, right, depth * 2 + 1);

        tree[depth] = tree[2 * depth] + tree[2 * depth + 1];
    }

    static void updateTree(int left, int right, int depth, int target, long value) {
        if(left == right){
            tree[depth] = value;
            arr[target] = value;
            return;
        }

        int mid = (left + right) / 2;

        if(target <= mid)updateTree(left, mid, depth * 2, target, value);
        else updateTree(mid + 1, right, depth * 2 + 1, target, value);

        tree[depth] = tree[2 * depth] + tree[2 * depth + 1];
    }

    static long getSum(int left, int right, int depth, int start, int end) {
        if(left > end || right < start) return 0;
        if(start <= left && right <= end) return tree[depth];

        int mid = (left + right) / 2;

        return getSum(left, mid, depth * 2, start, end) + getSum(mid + 1, right, depth * 2 + 1, start, end);
    }
}
