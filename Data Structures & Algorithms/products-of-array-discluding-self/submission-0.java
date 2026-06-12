class Solution {
    public int[] productExceptSelf(int[] nums) {
        int a=nums.length;
        int[] product=new int[a];
        for(int i=0;i<a;i++){
           product[i]=1;
           
            for(int j=0;j<a;j++){
                if(i==j)continue;
                product[i]*=nums[j];
               
            }
            
           

            }
            return product;
        }
    }

