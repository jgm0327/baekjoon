import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    String[] paragraphs = new String[n];
    Map<Character, Boolean> visit = new HashMap<>();

    for(int i=0 ; i<n ; i++){
      paragraphs[i] = br.readLine();
    }

    for(String paragraph : paragraphs){
      StringBuilder sb = new StringBuilder();
      boolean flag = false;

      for(int i=0 ; i<paragraph.length() ; i++){
        char ch = paragraph.charAt(i);
        if((i == 0 || paragraph.charAt(i - 1) == ' ') && !visit.containsKey(toLower(ch))){
          flag = true;
          sb.append('[');
          sb.append(ch);
          sb.append(']');
          sb.append(paragraph.substring(i + 1));
          visit.put(toLower(ch), true);
          bw.write(sb.toString());
          break;
        }
        sb.append(ch);
      }

      if(flag){
        bw.write('\n');
        continue;
      }
      sb = new StringBuilder();
      for(int i=0 ; i<paragraph.length() ; i++){
        char ch = paragraph.charAt(i);
        if(ch != ' ' && !visit.containsKey(toLower(ch))){
          flag = true;
          sb.append('[');
          sb.append(ch);
          sb.append(']');
          sb.append(paragraph.substring(i + 1));
          visit.put(toLower(ch), true);
          bw.write(sb.toString());
          break;
        }
        sb.append(ch);
      }
      if(!flag)bw.write(sb.toString());
      bw.write('\n');
    }

    bw.flush();
    bw.close();
    br.close();
  }
  
  private static Character toLower(Character ch){
    return 'A' <= ch && ch <= 'Z' ? (char)(ch + 32) : ch;
  }
}