import java.io.*;
import java.util.*;;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        int l = Integer.parseInt(tokenizer.nextToken());
        
        int[] hunters = new int[m];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<m ; i++)
            hunters[i] = Integer.parseInt(tokenizer.nextToken());
        Arrays.sort(hunters);

        int answer = 0;
        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            if(!binarySearch(l, y, x, hunters))
                continue;

            answer++;
        }
            
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static boolean binarySearch(int l, int y, int x, int[] hunters){
        int left = 0, right = hunters.length - 1;

        while(left <= right){
            int mid = (left+ right) / 2;

            int dist = Math.abs(hunters[mid] - x) + y;

            if(dist <= l)
                return true;
            if(x == hunters[mid])
                return dist <= l;
            else if(x > hunters[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        int retL = Integer.MAX_VALUE, retR = Integer.MAX_VALUE;

        if(right >= 0)
            retR = Math.abs(x - hunters[right]) + y;
            
        if(left < hunters.length)
            retL = Math.abs(x - hunters[left]) + y;

        return Math.min(retR, retL) <= l;
    }
}