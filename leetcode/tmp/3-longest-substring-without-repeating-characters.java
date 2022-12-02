import java.util.HashMap;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        HashMap<Character,Integer> seen=new HashMap<>();
        int maxlen=0,start=0,len=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            //
            if(seen.containsKey(c) && seen.get(c) >=start ){
                start=seen.get(c)+1;
            } 
           seen.put(c,i);
           maxlen=Math.max(maxlen,len=i-start+1);
            
        }
        return maxlen;
   }
   public static void main(String[] args) {
        String s="abba";
        int res=new Solution3().lengthOfLongestSubstring(s);
        System.out.println(res);
   }
}
