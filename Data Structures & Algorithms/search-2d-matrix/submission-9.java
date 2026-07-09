class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int r=matrix.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(matrix[mid][0]<=target && matrix[mid][matrix[0].length-1]>=target){
                int left=0;
                int right=matrix[0].length-1;
                while(left<=right){
                int mid1=(left+right)/2;
                if(matrix[mid][mid1]==target) return true;
                else if(matrix[mid][mid1]<target) left=mid1+1;
                else{
                    right=mid1-1;
                }
                

            }
            return false;
            
            }
            else if(matrix[mid][0]>target) r=mid-1;
            else{ l=mid+1;}
        }
        return false;

        
    }
}
