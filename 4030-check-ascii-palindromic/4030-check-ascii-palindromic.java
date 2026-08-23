class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder binStr = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            for(int j = 7;j>=0;j--){
                binStr.append((c>>j) & 1);
            }
        }
        int left = 0;
        int right = binStr.length()-1;
        while(right>left){
            if((binStr.charAt(right)) != (binStr.charAt(left))){
                return false;
            }
            right--;
            left ++ ;
        }
        return true;
    }
}