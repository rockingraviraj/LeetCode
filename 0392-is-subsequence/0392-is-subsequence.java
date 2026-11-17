class Solution {
    public boolean isSubsequence(String s, String t) {
        int k =0;
        //int m = 0;
        if(s.length()==0){
            return true;
        }
        // StringBuilder sb = new StringBuilder();
        for(int m = 0;m<t.length();m++){
            if(k<s.length()){
            char c = s.charAt(k);
            char p = t.charAt(m);
            if(c==p){
                k++;
                // sb.append(c);               
            }
        }
        }
        if(k == s.length()){
            return true;
        }
return false;
     
}    
}