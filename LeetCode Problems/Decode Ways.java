import java.util.*;
class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0) return 0;
        int size=s.length(),ind=0,pair=0;
        int[]dp = new int [size+1];
        dp[0]=1;dp[1]=(s.charAt(0)!='0')?1:0;
        for(int index=2;index<=size;index++){
            ind=s.charAt(index-1)-'0';
            if(ind>=1&&ind<=9) dp[index]+=dp[index-1];
            String sub=s.substring(index-2,index);
            pair=Integer.parseInt(sub);
            if(pair>=10&&pair<=26) dp[index]+=dp[index-2];
        }
        return dp[size];
    }
}
