class Solution {
    public boolean isMonotonic(int[] nums) {
     return  isincreasing(nums) || isdecreasing(nums); 
    }

    public boolean isincreasing(int nums[]){

        int len=nums.length-1;
        for(int i=0;i<len;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }

     public boolean isdecreasing(int nums[]){

        int len=nums.length-1;
        for(int i=0;i<len;i++){
            if(nums[i]<nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
