import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]), m = Integer.parseInt(size[1]);
        int j = Integer.parseInt(br.readLine());

        int[] pos = new int[j];
        for(int i=0 ; i<j ; i++){
            pos[i] = Integer.parseInt(br.readLine());
        }

        int start = 1, end = m, answer = 0;
        for(int i=0 ; i<j ; i++){
            if(start >= pos[i]){
                answer += (start - pos[i]);
                start = pos[i];
                end = start + m - 1;
            }else if(end <= pos[i]){
                answer += (pos[i] - end);
                end = pos[i];
                start = end - m + 1;
            }
        }
        System.out.println(answer);
        br.close();
    }
}