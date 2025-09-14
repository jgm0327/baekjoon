import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int x, n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringBuilder answer = new StringBuilder();
        while ((str = br.readLine()) != null) {

            x = Integer.parseInt(str) * 10_000_000;
            n = Integer.parseInt(br.readLine());

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);
            int maxValue = Integer.MIN_VALUE;
            int l1 = -1, l2 = -1;
            for (int i = 0; i < n; i++) {
                int left = binarySearch(x - arr[i], 0, i - 1);
                int right = binarySearch(x - arr[i], i + 1, n - 1);

                if(left != -1 && maxValue < arr[i] - arr[left]){
                    maxValue = arr[i] - arr[left];
                    l1 = arr[left];
                    l2 = arr[i];
                }
                else if(right != -1 && maxValue < arr[right] - arr[i]){
                    maxValue = arr[right] - arr[i];
                    l1 = arr[i];
                    l2 = arr[right];
                }
            }

            if(l1 == -1 && l2 == -1)
                answer.append("danger\n");
            else
                answer.append("yes ").append(l1).append(" ").append(l2).append("\n");
        }

        System.out.println(answer);
        br.close();
    }

    static int binarySearch(int target, int start, int end) {
        int left = start, right = end;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == arr[mid])
                return mid;
            else if (target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }
}
