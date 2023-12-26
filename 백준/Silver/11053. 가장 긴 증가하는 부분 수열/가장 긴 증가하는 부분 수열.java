import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main{

    private static int n;
    private static int[] numbers;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        numbers = new int[n];

        for(int i=0 ; i<n ; i++){
            numbers[i] = Integer.parseInt(stk.nextToken());
        }

        List<Integer> dp = new ArrayList<>();
        dp.add(numbers[0]);

        for(int i=1 ; i<n ; i++){
            if(dp.get(dp.size() - 1) < numbers[i]){
                dp.add(numbers[i]);
                continue;
            }
            binarySearch(dp, numbers[i]);
        }

        System.out.println(dp.size());
    }

    private static void binarySearch(List<Integer> dp, int target){
        int start = 0, end = dp.size() - 1;
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(dp.get(mid) < target)start = mid + 1;
            else end = mid - 1;
        }
        dp.set(start, target);
    }
}