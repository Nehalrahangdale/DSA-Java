class Solution {
    private int n;
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0){
            return false;
        }
        n=grid.length;
        return help(grid,0,0,1);
    }
    private int dir[][]={{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

    private boolean help(int grid[][],int i,int j,int cell){

        for(int[] d:dir){
            int newI=i+d[0];
            int newJ=j+d[1];
            if(newI>=0 && newI<n && newJ>=0&& newJ<n && grid[newI][newJ]==cell){
                return help(grid,newI,newJ,cell+1);
            }

        }
        return cell==n*n;
    }
}
