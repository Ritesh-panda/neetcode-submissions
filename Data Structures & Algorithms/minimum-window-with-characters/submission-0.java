class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        if(s.equals(t)) return s;
        HashMap<Character,Integer>map1=new LinkedHashMap<>();
        HashMap<Character,Integer>map2=new LinkedHashMap<>();
        for(int i=0;i<t.length();i++){
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }
        int l=0;
        int have=0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int need=map2.size();
        for(int i=0;i<s.length();i++){
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
            if(map2.containsKey(s.charAt(i)) && map1.get(s.charAt(i)).equals(map2.get(s.charAt(i)))){
                have++;
            }
            while(need==have){
                if (i - l + 1 < minLen) {
                    minLen = i - l + 1;
                    start = l;
                }
                map1.put(s.charAt(l),map1.getOrDefault(s.charAt(l),0)-1);
                if (map2.containsKey(s.charAt(l)) &&
                    map1.get(s.charAt(l)) < map2.get(s.charAt(l))) {
                    have--;
                }

                l++;

            }
        }
        
        
    
     return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
