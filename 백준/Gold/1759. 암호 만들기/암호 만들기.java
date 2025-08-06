import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    
    static int n, m;
    static char[] arr, vowel = {'a', 'e', 'i', 'u', 'o'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        arr = new char[m];
        for(int i=0 ; i<m ; i++)
            arr[i] = tokenizer.nextToken().charAt(0);

        Arrays.sort(arr);
        
        StringBuilder answer = new StringBuilder();
        dfs(0, 0, 0, answer, new StringBuilder());
        System.out.print(answer);
        br.close();
    }

    static void dfs(int start, int vowelCount, int exist, StringBuilder answer, StringBuilder path){
        if(n == path.length()){
            if(vowelCount >= 1 && n - vowelCount >= 2)
                answer.append(path).append("\n");
            return;
        }

        for(int i=start ; i<m ; i++){
            if((exist & (1 << (arr[i] - 'a'))) != 0)
                continue;

            int nextVowel = isVowel(arr[i]) ? vowelCount + 1 : vowelCount;

            path.append(arr[i]);
            dfs(i + 1, nextVowel, exist | (1 << arr[i] - 'a'), answer, path);
            path.deleteCharAt(path.length() - 1);
        };
    }
    
    static boolean isVowel(char ch){
        for(int i=0 ; i<5 ; i++)
            if(vowel[i] == ch)
                return true;
        return false;
    }
}