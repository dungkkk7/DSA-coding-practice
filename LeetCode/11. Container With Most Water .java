class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i  = 0; 
        int j = height.length - 1; 

        
        while(i < j ){
          int newArea = (j - i) * (height[i] < height[j] ? height[i] : height[j]);
          maxArea = newArea > maxArea ? newArea : maxArea ; 
          if(height[i] > height[j]){
            j--; 
          }else{
            i++; 
          }

        }
        
  return maxArea;   }
}
