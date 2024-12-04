import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        StringBuilder answer = new StringBuilder();
        while((str = br.readLine()) != null){

            int n = Integer.parseInt(str);
            StringBuilder ret = init(n);
            recur(ret, 0, ret.length(), ret.length());
            answer.append(ret).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }

    private static StringBuilder init(int n){
        int end = (int)Math.pow(3, n);
        
        StringBuilder ret = new StringBuilder();
        while(end-- > 0)
            ret.append("-");

        return ret;
    }

    private static void recur(StringBuilder temp, int start, int end, int len){
        if(len <= 1)
            return;
        int nextLen = len / 3;
        recur(temp, start, start + nextLen, nextLen);
        recur(temp, end - nextLen, end, nextLen);

        for(int i=start + nextLen ; i<end - nextLen ; i++){
            temp.setCharAt(i, ' ');
        }
    }
}