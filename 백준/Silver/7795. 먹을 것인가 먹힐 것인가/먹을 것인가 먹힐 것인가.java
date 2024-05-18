import java.io.*;
import java.util.*;
public class Main {
    static int arr[] = new int[20001], brr[] = new int[20001], n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();

        for(int t=0; t<testcase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            int ret = 0;

            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=m; i++) brr[i] = Integer.parseInt(st.nextToken());

            //=======================================================================

            Arrays.sort(brr, 1, m + 1);

            for(int i=1 ; i<=n ; i++) ret += check(arr[i]);
            answer.append(ret).append("\n");
        }

        System.out.print(answer);
    }

    static int check(int num) {

        int l = 1, r = m;

        while (l <= r) {
            int mid = (l + r) / 2;
            
            if(brr[mid] >= num) r = mid - 1;
            else l = mid + 1;
        }

        return r;
    }
}