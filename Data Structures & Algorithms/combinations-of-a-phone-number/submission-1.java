class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String>map=new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String>list=new ArrayList<>();
        StringBuilder s=new StringBuilder();
        if (digits.length() == 0)
        return list;
        char[] arr=digits.toCharArray();
        combo(map,0,list,s,arr);
        return list;
    }
    private void combo(HashMap<Character,String>map,int idx,List<String>list,StringBuilder s,char[] arr){
        
        if(idx>=arr.length){
            list.add(s.toString());
            return;
        }
        String letters=map.get(arr[idx]);
        for(int i=0;i<letters.length();i++){
        s.append(letters.charAt(i));
        combo(map,idx+1,list,s,arr);
        s.deleteCharAt(s.length()-1);
        
        

    }
}
}
