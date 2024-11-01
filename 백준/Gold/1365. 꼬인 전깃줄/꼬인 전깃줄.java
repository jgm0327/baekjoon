import java.io.*;
import java.util.*;;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] wires = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            wires[i] = Integer.parseInt(tokenizer.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        for(int wire : wires){
            if(list.isEmpty() || list.get(list.size() - 1) < wire)
                list.add(wire);

            int idx = bisectLeft(wire, list);
            list.set(idx, wire);
        }

        bw.write(String.valueOf(n - list.size()));

        bw.close();
        br.close();
    }

    private static int bisectLeft(int target, List<Integer> list){
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
