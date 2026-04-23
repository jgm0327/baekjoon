import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] parents, cheolsu;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        parents = new int[n];
        for(int i=0 ; i<n ; i++)
            parents[i] = i;

        cheolsu = new int[m];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<m ; i++)
            cheolsu[i] = Integer.parseInt(tokenizer.nextToken());
        Arrays.sort(cheolsu);

        tokenizer = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        while(k-- > 0){
            int num = Integer.parseInt(tokenizer.nextToken());

            int idx = bisectLeft(num);
            int pIdx = findParent(idx);

            answer.append(cheolsu[pIdx]).append('\n');
            union(pIdx, pIdx + 1);
        }
        System.out.print(answer);

        br.close();
    }

    static int bisectLeft(int target){
        int left = 0, right = m - 1;
        while(left <= right){
            int mid = (left + right) / 2;

            if(target < cheolsu[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
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
}