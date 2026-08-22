class Solution {
    public boolean checkDivisibility(int n) {
        int r = n;
        int sum = 0;
        int pr = 1;
        while(n!=0){
            int temp = n%10;
            sum = sum + temp;
            pr = pr * temp;
            n = n/10;
        }
        int total = sum + pr;
        if(r % total == 0){
            return true;
        }
        return false;
    }
}