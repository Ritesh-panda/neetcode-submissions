class Solution {

    public String encode(List<String> strs) {
        String encoded="";
        for(int i=0;i<strs.size();i++){
            String word=strs.get(i);
            encoded+=word.length();
            encoded+="#";

            encoded+=word;
            

        }

        return encoded;

    }

    public List<String> decode(String encoded) {
        List<String> result=new ArrayList<>();
        int i=0;
        while(i<encoded.length()){
            int j=i;
            while(encoded.charAt(j)!='#'){
                j++;
            }
            int len=Integer.parseInt(encoded.substring(i,j));
            String word=encoded.substring(j+1,j+1+len);
            result.add(word);
            i=j+len+1;
        }
        return result;







            }
}
        



