import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int n, m, k;
    static int[] parents, cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        cards = new int[m];
        for (int i = 0; i < m; i++)
            cards[i] = Integer.parseInt(tokenizer.nextToken());
        Arrays.sort(cards);

        parents = new int[m + 1];
        for (int i = 0; i <= m; i++)
            parents[i] = i;

        tokenizer = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (k-- > 0) {
            int number = Integer.parseInt(tokenizer.nextToken());

            int idx = bisectLeft(number);

            // 2 3 4 5 7 8 9
            int nextCard = findParent(idx);
            if(cards[nextCard] == number)
                nextCard = findParent(nextCard + 1);

            if(nextCard >= m)
                continue;

            answer.append(cards[nextCard]).append("\n");
            union(nextCard, findParent(nextCard + 1));
        }

        System.out.print(answer);
        br.close();
    }

    static int bisectLeft(int target) {
        int left = 0, right = m - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target <= cards[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }

    static int findParent(int x) {
        if (x == parents[x])
            return x;
        return parents[x] = findParent(parents[x]);
    }

    static void union(int x, int y) {
        int px = findParent(x), py = findParent(y);

        if (px == py)
            return;

        parents[px] = py;
    }
}