import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            String S = br.readLine();
            String E = br.readLine();

            answer.append("#").append(test_case).append(" ").append(canTransform(S, new StringBuilder(E)));
        }

        System.out.print(answer);
    }

    private static String canTransform(String S, StringBuilder E){
        while(S.length() < E.length()){
            char ch = E.charAt(E.length() - 1);
            
            E.deleteCharAt(E.length() - 1);
            if(ch == 'Y')
                E.reverse();
        }
        
        if(S.equals(E.toString()))
            return "Yes\n";
        
        return "No\n";
    }
}
