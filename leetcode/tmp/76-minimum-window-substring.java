class Solution76 {
    public String minWindow(String s, String t) {
         if(s==null || s=="") return "";
         int[] target=new int[256];
         int left=0,right=0,start=0;
         int len=Integer.MAX_VALUE;
         int cnt=t.length();
         //存储目标字符出现的次数
         for(int i=0;i<cnt;i++){
             target[t.charAt(i)]++;
         }
         for(;right<s.length();right++){
             char r=s.charAt(right);
             //找到某个字符，cnt减一
             if(target[r]>0) cnt--;
             //查找了一次
             target[r]--;
             //所有字符都找到了
             while(cnt==0){
                 int ll=right-left+1;
                 if(ll <len){
                     len=ll;
                     start=left;
                 }
                 //？？
                 char l=s.charAt(left);
                 target[l]++;
                 if(target[l]>0)cnt++;
                 left++;
             }
         }
         return len==Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}