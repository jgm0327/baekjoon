import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] ports = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            int port = Integer.parseInt(tokenizer.nextToken());

            if(list.isEmpty() || list.get(list.size() - 1) < port){
                list.add(port);
                continue;
            }

            int idx = bisectLeft(list, port);
            list.set(idx, port);
        }

        bw.write(String.valueOf(list.size()));
        bw.close();
        br.close();
    }

    private static int bisectLeft(List<Integer> list, int target){
        int left = 0, right = list.size() - 1;
        while(left <= right){
            int mid = (left + right) / 2;

            if(target <= list.get(mid))
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }
}
