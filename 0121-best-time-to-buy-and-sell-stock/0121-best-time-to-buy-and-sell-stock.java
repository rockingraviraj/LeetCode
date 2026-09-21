class Solution {
    public int maxProfit(int[] prices) {
        int index = 0;
        int pr = 0;
        int sell = Integer.MAX_VALUE;
        return Solve(pr,sell,prices,index);
        
    }
    private int Solve(int pr,int buy,int[] arr,int index){
        if(index >= arr.length){
            return pr;
        }
        int value = arr[index];
        buy = Math.min(buy,value);
        if(buy < value){
            pr = Math.max(value - buy,pr);
        }
       return Solve (pr,buy,arr,index+1);
       

        
    }
}