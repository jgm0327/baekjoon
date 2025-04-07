import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int[] cards;
    static int[] parents;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        cards = new int[m];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<m ; i++)
            cards[i] = Integer.parseInt(tokenizer.nextToken());

        Arrays.sort(cards);

        parents = new int[m];
        for(int i=0 ; i<m ; i++)
            parents[i] = i;

        tokenizer = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        while(tokenizer.hasMoreTokens()){
            int num = Integer.parseInt(tokenizer.nextToken());

            int idx = bisectLeft(num);
            int pIdx = findParent(idx);

            answer.append(cards[pIdx]).append("\n");
            if(pIdx + 1 < m) union(idx, pIdx + 1);
        }

        System.out.print(answer);

        br.close();
    }

    static int findParent(int x){
        if(x == parents[x])
            return x;

        return parents[x] = findParent(parents[x]);
    }

    static void union(int x, int y){
        int px = findParent(x), py = findParent(y);

        if(px == py)
            return;

        parents[px] = py;
    }

    static int bisectLeft(int target){
        int left = 0, right = cards.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(cards[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }
}