class Solution {
    public List<List<String>> partition(String s) {
        StringBuilder sb=new StringBuilder();
        List<List<String>> ans=new ArrayList<>();
        List<String> combo=new ArrayList<>();
        backtrack(s,sb,ans,combo,0);
        return ans;
    }
    private void backtrack(String s,StringBuilder sb,List<List<String>> ans,List<String> combo,int idx){
        if(idx==s.length()){
         
                ans.add(new ArrayList<>(combo));
                return;
        }

       for(int i=idx;i<s.length();i++){
        sb.append(s.charAt(i));
      
       
        if(isPalindrome(sb.toString())){
            combo.add(sb.toString());
            backtrack(s,new StringBuilder(),ans,combo,i+1);
            combo.remove(combo.size()-1);
        }

       }
    }
    private boolean isPalindrome(String s){
        if(s.length()==0) return false;
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}