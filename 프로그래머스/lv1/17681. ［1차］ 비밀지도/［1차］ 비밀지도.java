import java.util.*;



class Solution {
    public String toBinary(int arr, int n){
        String str = "";
        while(arr > 0){
            str = Integer.toString(arr  % 2) + str;
            arr = (int)(arr / 2);
        }
        int cnt = n - str.length();
        while(cnt > 0){
            cnt--;
            str = "0"+str;
        }
        return str;
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        Vector<String> arr1_list = new Vector<>();
        Vector<String> arr2_list = new Vector<>();
        String[] answer = new String[n];
        
        for(int i=0 ; i<n ; i++){
            arr1_list.add(toBinary(arr1[i], n));
            arr2_list.add(toBinary(arr2[i], n));
        }
        
        for(int i=0 ; i<n ; i++){
            String str = "";
            for(int j=0 ; j<n ; j++){
                if(arr1_list.get(i).charAt(j) == '1'
                   || arr2_list.get(i).charAt(j) == '1'){
                    str += "#";
                }
                else
                    str += " ";
            }
            answer[i] = str;
        }
        return answer;
    }
}