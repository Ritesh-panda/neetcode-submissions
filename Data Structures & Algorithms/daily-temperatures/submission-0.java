class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] list= new int[temperatures.length];
        
        for(int i=0;i<list.length;i++){
           
            
          
            
            
            for(int j=i+1;j<list.length;j++){
            if(temperatures[j]>temperatures[i]){
                list[i]=j-i;
                break;}
           
            

            }
                
                 
              

                
                
                


   
        }
        return list;
    }
}
