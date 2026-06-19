class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] freq=new int [26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        int l=0;
        int k=s1.length();
        int[] wordFreq=new int[26];
        for(int r=0;r<k;r++){
         wordFreq[s2.charAt(r)-'a']++;
        }
        if(matches(freq,wordFreq)){
            return true;
        }
        
            for(int r=k;r<s2.length();r++){
                wordFreq[s2.charAt(r)-'a']++;
                wordFreq[s2.charAt(l)-'a']--;
                l++;
            
            if(matches(freq,wordFreq)){
                return true;
            }
            }
           
        
        return false;

        
    }
    public boolean matches(int[] a,int[] b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}
