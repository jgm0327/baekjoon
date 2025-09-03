import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int n, m, k;
    static long[] arr, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        arr = new long[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = Long.parseLong(br.readLine());

        int h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        tree = new long[(1 << h)];

        makeSegmentTree(1, n, 1);

        StringBuilder ansewr = new StringBuilder();
        while (m-- > 0 || k-- > 0) {
            tokenizer = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            long c = Long.parseLong(tokenizer.nextToken());

            if (a == 1) {
                updateSegmentTree(1, n, 1, b, c);
            }
            else
                ansewr.append(getSum(1, n, 1, b, (int)c)).append("\n");
        }

        System.out.print(ansewr);

        br.close();
    }

    static void makeSegmentTree(int left, int right, int idx) {
        if (left == right) {
            tree[idx] = arr[left];
            return;
        }

        int mid = (left + right) / 2;

        makeSegmentTree(left, mid, idx * 2);
        makeSegmentTree(mid + 1, right, idx * 2 + 1);

        tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
    }

    static void updateSegmentTree(int left, int right, int idx, int target, long value) {
        if (left == right && target == left) {
            tree[idx] = value;
            arr[target] = value;
            return;
        }

        int mid = (left + right) / 2;

        if(target <= mid) updateSegmentTree(left, mid, idx * 2, target, value);
        else updateSegmentTree(mid + 1, right, idx * 2 + 1, target, value);

        tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
    }

    static long getSum(int left, int right, int idx, int start, int end){
        if(left > end || right < start){
            return 0;
        }

        if(start <= left && right <= end)
            return tree[idx];

        int mid = (left + right) / 2;

        return getSum(left, mid, idx * 2, start, end) + getSum(mid + 1, right, idx * 2 + 1, start, end);
    }
}
