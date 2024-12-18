import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(tokenizer.nextToken());
        final int m = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        int[] marbles = new int[n];
        int start = 0, end = 0;
        for(int i=0 ; i<n ; i++){
            marbles[i] = Integer.parseInt(tokenizer.nextToken());
            start = Math.max(start, marbles[i]);
            end += marbles[i];
        }

        int left = start, right = end;
        ArrayDeque<Integer> groupCounts = new ArrayDeque<>();
        while (left <= right) {
            int mid = (left + right) / 2;

            ArrayDeque<Integer> counts = new ArrayDeque<>();
            int total = 0, count = 0;
            for(int i=0 ; i<n ; i++){

                if(total + marbles[i] > mid){
                    counts.add(count);
                    count = 1;
                    total = marbles[i];
                }
                else{
                    count++;
                    total += marbles[i];
                }

                if(n - 1 == i)
                    counts.add(count);
            }

            ArrayDeque<Integer> deque = new ArrayDeque<>();
            while(!counts.isEmpty()){
                count = counts.poll();

                while(count > 1 && counts.size() + deque.size() < m - 1){
                    deque.add(1);
                    count--;
                }
                deque.add(count);

                if(counts.size() + deque.size() == m)
                    break;

            }

            deque.addAll(counts);

            int size = deque.size();
            if(m == size && (groupCounts.isEmpty() || mid < groupCounts.peek())){
                groupCounts = deque;
                groupCounts.addFirst(mid);
            }

            if(size > m){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(groupCounts.poll()).append('\n');
        while(!groupCounts.isEmpty()){
            answer.append(groupCounts.poll()).append(' ');
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}