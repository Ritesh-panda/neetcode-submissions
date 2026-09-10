class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //convert the whole 2d into 1 d
        /*
        how?
        int rows=mid/cols; here quotient
        int cols=mid%cols; here remainder
        */
        int rows=matrix.length;
        int cols=matrix[0].length;
        int left=0;
        int right=(rows*cols)-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            int r=mid/cols;
            int c=mid%cols;

            if(target>matrix[r][c]){
                left=mid+1;

            }
            if(target<matrix[r][c]){
                right=mid-1;
            }
            if(target==matrix[r][c]) return true;
        }
        return false;
    }
}
