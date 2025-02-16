import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] comb = {'A', 'C', 'G', 'T'};

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        String dna = br.readLine();
        str = br.readLine().split(" ");

        int[] minCount = new int[26];
        boolean[] accept = new boolean[26];
        int total = 0;
        for(int i=0 ; i<4 ; i++){
            int idx = comb[i] - 'A';
            minCount[idx] = Integer.parseInt(str[i]);
            if(minCount[idx] == 0){
                total++;
                accept[idx] = true;
            }
        }

        int[] count = new int[26];

        for(int i=0 ; i<m ; i++){
            int idx = dna.charAt(i) - 'A';
            count[idx]++;

            if(count[idx] >= minCount[idx])
            
            if(!accept[idx]){
                total++;
                accept[idx] = true;
            }
        }

        int left = 0, right = m;
        int answer = total == 4 ? 1 : 0;
        while(right < n){
            int r = dna.charAt(right) - 'A';
            int l = dna.charAt(left) - 'A';

            count[r]++;
            count[l]--;

            if(count[r] >= minCount[r] && !accept[r]){
                accept[r] = true;
                total++;
            }

            if(count[l] < minCount[l] && accept[l]){
                accept[l] = false;
                total--;
            }

            if(total == 4)
                answer++;

            right++;
            left++;
        }


        System.out.println(answer);
        br.close();
    }
}