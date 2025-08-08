import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        int[] point = new int[n];

        for (int i = 0; i < n; i++)
            point[i] = Integer.parseInt(br.readLine());

        int left = 1, right = 1000_000_000;
        Arrays.sort(point);

        while (left <= right) {
            int mid = (left + right) / 2;

            int prev = point[0], count = 1;
            for (int i = 1; i < n; i++) {
                if (point[i] - prev <= mid) 
                    continue;

                prev = point[i];
                count++;
            }

            if (count < c)
                right = mid - 1;
            else
                left = mid + 1;
        }

        System.out.println(left);

        br.close();
    }
}