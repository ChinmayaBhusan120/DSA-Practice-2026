
Core Idea (Two Pointer Optimized)
We maintain:
left
right
leftMax
rightMax
Logic:
If left height < right height
→ Water depends on leftMax
Else
→ Water depends on rightMax

Time → O(n)
Space → O(1)




class TrappingRainWater {

    public static int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println("Trapped Water: " + trap(height));
    }
}
