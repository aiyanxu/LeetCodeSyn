public class Solution {
    public int largestRectangleArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            if (i + 1 < height.length && height[i] <= height[i + 1])
                continue;
            int minHeight = height[i];
            for (int j = i; j >= 0; j--) {
                minHeight = Math.min(minHeight, height[j]);
                int area = minHeight * (i - j + 1);
                if (area > maxArea)
                    maxArea = area;
            }
        }
        return maxArea;
    }
}