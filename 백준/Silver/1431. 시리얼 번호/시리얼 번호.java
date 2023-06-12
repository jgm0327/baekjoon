import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main{

  private static class Serial implements Comparable<Serial>{
    int total = 0;
    String number;

    public Serial(String number){
      this.number = number;
      convertToNumber(number);
    }

    private void convertToNumber(String str){
      int sum = 0;
      for(int i=0 ; i<str.length() ; i++){
        if('0' <= str.charAt(i) && str.charAt(i) <= '9'){
          sum += (str.charAt(i) - '0');
        }
      }
      this.total = sum;
    }

    @Override
    public int compareTo(Serial o){
      if(o.number.length() > this.number.length())return -1;
      else if(o.number.length() < this.number.length())return 1;
      if(o.total > this.total)return -1;
      else if(o.total < this.total)return 1;
      if(o.number.compareTo(number) < 0)return 1;
      else if(o.number.compareTo(number) > 0)return -1;
      return 0;
    }
  }

  private static int n;
  private static List<Serial> list;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    n = Integer.parseInt(br.readLine());
    list = new ArrayList<>();
    for(int i=0 ; i<n ; i++){
      list.add(new Serial(br.readLine()));
    }

    Collections.sort(list);
    for(Serial serial : list){
      System.out.println(serial.number);
    }
    br.close();
  }
}