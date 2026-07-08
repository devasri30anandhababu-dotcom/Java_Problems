class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int size = prices.length;
        int hold=-prices[0],sold=0,rest=0;
        int pHold=0,pSold=0,pRest=0;
        for(int index=1;index<size;index++){
            pHold=hold;pSold=sold;pRest=rest;
            hold=Math.max(pHold,pRest-prices[index]);
            sold=pHold+prices[index];
            rest=Math.max(pRest,pSold);
        }
        return  Math.max(sold,rest);
    }
}
