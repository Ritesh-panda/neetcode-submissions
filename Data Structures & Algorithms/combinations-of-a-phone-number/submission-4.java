class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        ArrayList<String> list= new ArrayList<>();
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder sb = new StringBuilder();
        int n=digits.length();
        backtrack(list,map,digits,n,0,sb);

        return list;

    }
    private void backtrack(ArrayList<String>list,
    HashMap<Character,String>map,
    String digits,
    int n,int idx,StringBuilder sb){
        if(idx==n){
            list.add(sb.toString());
            return;
        }
        char ch=digits.charAt(idx);
        String letter=map.get(ch);
    /*
    for (each letter) {
    choose letter;
    recurse to next digit;if you are on 2 go to 3 and do the recurssion;
    undo choice;
    }
    */
        for(int i=0;i<letter.length();i++){
        char c=letter.charAt(i);
        sb.append(c);
        backtrack(list,map,digits,n,idx+1,sb);
        sb.deleteCharAt(sb.length() - 1);

        }
        return;
    }
}