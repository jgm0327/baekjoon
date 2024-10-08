import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException 
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        for(int i=0 ; i<n ; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            if(list.isEmpty() || numbers[i] > list.get(list.size() - 1)){
                list.add(numbers[i]);
                continue;
            }

            int idx = bisectLeft(numbers[i], list);
            
            list.set(idx, numbers[i]);
        }
        
        System.out.println(n - list.size());
        br.close();
	}

    private static int bisectLeft(int target, List<Integer> list){
        int left = 0, right = list.size() - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(target >= list.get(mid)) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }
}