import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int[][] colorBalls = new int[n][2];

        PriorityQueue<int[]> sortColorBalls = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);

        for(int i=0 ; i<n ; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int color = Integer.parseInt(tokenizer.nextToken());
            int value = Integer.parseInt(tokenizer.nextToken());

            colorBalls[i] = new int[]{color, value};
            sortColorBalls.add(new int[]{color, value});
        }

        List<int[]>[] eachPrefix = new ArrayList[n + 1];
        for(int i=1 ; i<=n ; i++){
            eachPrefix[i] = new ArrayList<>();
            eachPrefix[i].add(new int[]{0,0});
        }

        List<int[]> prefix = new ArrayList<>();
        prefix.add(new int[]{0,0});

        while(!sortColorBalls.isEmpty()){
            int[] colorBall = sortColorBalls.poll();
            int color = colorBall[0], value = colorBall[1];

            eachPrefix[color].add(new int[]{value, eachPrefix[color].get(eachPrefix[color].size() - 1)[1] + value});
            prefix.add(new int[]{value, prefix.get(prefix.size() - 1)[1] + value});
        }

        StringBuilder answer = new StringBuilder();

        for(int[] colorBall : colorBalls){
            int color = colorBall[0], value = colorBall[1];

            int prefixIndex = bisectRight(value, prefix);
            int eachPrefixIndex = bisectRight(value, eachPrefix[color]);

            int total = prefix.get(prefixIndex)[1] - eachPrefix[color].get(eachPrefixIndex)[1];

            answer.append(total).append("\n");
        }
        
        
        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bisectRight(int target, List<int[]> eachPrefix){
        int left = 0, right = eachPrefix.size() - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(target > eachPrefix.get(mid)[0])left = mid + 1;
            else right = mid - 1;
        }

        return right;
    }

}