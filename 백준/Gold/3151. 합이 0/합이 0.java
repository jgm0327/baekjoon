import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main{
    private static int n;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);
        HashMap<Integer, Integer> end = new HashMap<>();

        for(int i=0 ; i<n ; i++){
            end.put(arr[i], i);
        }

        long answer = 0;
        for(int i = 0 ; i < n - 2 ; i++){
            for(int j = i + 1 ; j < n - 1; j++){
                int sum = arr[i] + arr[j];
                int idx = binarySearch(j + 1, -sum);
                if(idx == -1)continue;
                answer += (end.get(-sum) - idx + 1);
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static int binarySearch(int s, int target){
        int start = s, end = n - 1, ret = -1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == target)ret = mid;
            if(target > arr[mid])start = mid + 1;
            else end = mid - 1;
        }
        return ret;
    }
}