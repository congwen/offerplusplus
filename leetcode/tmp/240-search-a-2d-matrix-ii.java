class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || matrix.length==0) return false;
        int row=matrix.length;
        int col=matrix[0].length;
        int i=0;
        int j=col-1;
        while(i<row && j>=0){ //从右上角开始找
                if(matrix[i][j]==target){
                    return true;
                }else if(matrix[i][j]>target){//向左找
                    j--;//向左找
                }else{
                    i++;//向下找
                }
        }
      return false;
    }
}