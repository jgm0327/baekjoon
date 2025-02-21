import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int n, m, k, total;
    static long[] prefix;
    static long[] tree, numbers;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        int h = (int) Math.ceil(Math.log(n) / Math.log(2)); // log2(N)
        int treeSize = (int) Math.pow(2, h + 1);

        prefix = new long[n + 1];
        tree = new long[treeSize];
        numbers = new long[n + 1];

        for(int i=1 ; i<=n ; i++){
            numbers[i] = Long.parseLong(br.readLine());
            prefix[i] = prefix[i - 1] + numbers[i];
        }
        
        init(1, n, 1);

        StringBuilder answer = new StringBuilder();
        for(int i=0 ; i<m+k ; i++){
            total = 0;
            tokenizer = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(tokenizer.nextToken());
            int target = Integer.parseInt(tokenizer.nextToken());
            long value = Long.parseLong(tokenizer.nextToken());

            if(command == 1){
                modifyTree(1, 1, n, target, value);
            }
            else{
                answer.append(findValue(1, 1, n, target, value)).append("\n");
            }
        }

        System.out.print(answer);
        br.close();
    }

    static void init(int start, int end, int idx){
        tree[idx] = prefix[end] - prefix[start - 1];

        if(start == end){
            return;
        }

        int mid = (start + end) / 2;

        init(start, mid, 2 * idx);
        init(mid + 1, end, 2 * idx + 1);
    }

    static long findValue(int idx, int start, int end, int s, long e){
        int mid = (start + end) / 2;
    
        // 완전히 포함된 구간
        if (s <= start && e >= end) {
            return tree[idx];
        }
    
        // 범위가 겹치지 않는 경우
        if (e < start || s > end) {
            return 0;
        }
    
        // 그 외의 경우, 두 자식 구간으로 나누어 탐색
        long leftResult = findValue(2 * idx, start, mid, s, e);
        long rightResult = findValue(2 * idx + 1, mid + 1, end, s, e);
    
        return leftResult + rightResult;
    }
    

    static void modifyTree(int idx, int start, int end, int target, long value){
        if(start == end){
            // 리프 노드에 도달한 경우
            tree[idx] = value;
            numbers[target] = value;  // numbers 배열도 업데이트
            return;
        }
    
        int mid = (start + end) / 2;
    
        if(start <= target && target <= mid){
            modifyTree(2 * idx, start, mid, target, value);
        }
        else{
            modifyTree(2 * idx + 1, mid + 1, end, target, value);
        }
    
        // 트리의 부모 노드를 업데이트 (구간 합)
        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }
    
}