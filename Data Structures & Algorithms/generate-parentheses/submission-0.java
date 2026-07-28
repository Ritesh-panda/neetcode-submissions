class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder tmp=new StringBuilder();
        List<String> list=new ArrayList<>();
        check(n,0,0,tmp,list);
        return list;
    
    }
    private void check(int n,int open,int close,StringBuilder tmp,List<String>list){
        //base case
        if(open==n && close==n){
            list.add(tmp.toString());
            return;
        }
        if(open<=n){
            tmp.append('(');
            check(n,open+1,close,tmp,list);
            tmp.deleteCharAt(tmp.length()-1);
        }
        if(close<open){
            tmp.append(')');
            check(n,open,close+1,tmp,list);
            tmp.deleteCharAt(tmp.length()-1);
        }

    }
}
