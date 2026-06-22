class Solution {
    public int maxArea(int[] height) {

        int left=0;
        int right=height.length-1;
        int maxwater=0;
        while(left<right){
            int width=right-left;
            int h= Math.min(height[left],height[right]);
            int area=width*h;
            maxwater=Math.max(maxwater,area);

            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxwater;
    }
}
