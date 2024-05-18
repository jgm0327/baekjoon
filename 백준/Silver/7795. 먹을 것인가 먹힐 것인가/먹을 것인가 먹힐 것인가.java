import java.io.*;
import java.util.*;
public class Main {
    static int arr[] = new int[20001], brr[] = new int[20001], n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        for(int t=0; t<testcase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            int ret = 0;

            st = new StringTokenizer(br.readLine());
            arr = new int[n + 1];
            for (int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            brr = new int[m + 1];
            for (int i=1; i<=m; i++) brr[i] = Integer.parseInt(st.nextToken());

            //=======================================================================

            Arrays.sort(brr);

            for(int num : arr) ret += check(num);

            bw.write(String.valueOf(ret)+"\n");
        }

        bw.close();
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