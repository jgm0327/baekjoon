import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        int h = Integer.parseInt(tokenizer.nextToken());
        int w = Integer.parseInt(tokenizer.nextToken());
        
        int[] height = new int[w];

        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<w ; i++){
            height[i] = Integer.parseInt(tokenizer.nextToken());
        }
        
        int answer = 0;
        for(int i=1 ; i<w-1 ; i++){
            int left = 0, right = 0;
            
            for(int j=0 ; j<i ; j++){
                left = Math.max(left, height[j]);
            }
            
            for(int j=i+1 ; j<w ; j++){
                right = Math.max(right, height[j]);
            }
            
            if(height[i] < left && height[i] < right)
                answer += Math.min(left, right) - height[i];
        }
        
        System.out.println(answer);
        
        br.close();
    }
}