class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        for(int len=s.length() - 1 ; len > 0 ; len--){
            for(int i=0 ; i<s.length() - len ; i++){
                if(check(s, i, len))
                    return len + 1;
            }
        }

        return 1;
    }
    
    boolean check(String s, int start, int mid){
        for(int i=0 ; i<mid ; i++){
            char left = s.charAt(start + i), right = s.charAt(start + mid - i);
            
            if(left != right)
                return false;
        }
        return true;
    }
}