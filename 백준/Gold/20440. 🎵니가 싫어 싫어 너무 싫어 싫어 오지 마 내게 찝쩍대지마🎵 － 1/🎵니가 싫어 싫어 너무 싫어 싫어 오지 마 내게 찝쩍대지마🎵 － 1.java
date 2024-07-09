import java.io.*;
import java.util.*;

class Main {

    static class TimeRange implements Comparable<TimeRange>{
        int start, end;

        public TimeRange(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(TimeRange o){
            if(o.start != this.start)return this.start - o.start;
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        TimeRange[] timeRange = new TimeRange[n];

        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            timeRange[i] = new TimeRange(start, end);
        }

        Arrays.sort(timeRange);

        Map<Integer, Integer> count = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            TimeRange cur = timeRange[i];

            count.put(cur.start, count.getOrDefault(cur.start, 0) + 1);
            count.put(cur.end, count.getOrDefault(cur.end, 0) - 1);
        }

        int[] answer = new int[2];
        TreeSet<Integer> time = new TreeSet<>(count.keySet());
        int maxValue = 0, total = 0;
        boolean flag = true;

        while (!time.isEmpty()) {    
            int nextTotal = total + count.get(time.first());
            
            if(maxValue < nextTotal){
                flag = false;
                maxValue = nextTotal;
                answer[0] = time.first();
            }

            if(!flag && nextTotal < maxValue){
                answer[1] = time.first();
                flag = true;
            }

            total = nextTotal;
            time.pollFirst();
        }

        bw.write(maxValue + "\n");
        bw.write(answer[0] +" ");
        bw.write(answer[1] + "");

        bw.close();
    }
}