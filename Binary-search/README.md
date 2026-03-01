# 🔍 Binary Search Pattern

## 🧠 Overview
Binary Search is a **divide and conquer** algorithm used on **sorted arrays**.
Instead of checking every element (O(n)),  
it eliminates half of the search space at each step.
Time Complexity → **O(log n)**  
Space Complexity → **O(1)**

 🎯 When to Use Binary Search?
Use Binary Search when:
- The array is **sorted**
- The problem involves:
  - Searching a target
  - Finding first/last occurrence
  - Finding minimum/maximum in sorted data
  - Optimization problems (Binary Search on Answer)

Keywords to watch:
- "Sorted"
- "Minimum possible"
- "Maximum possible"
- "Search in rotated array"
- "Find peak"

 🔁 Standard Binary Search Template

java
int left = 0;
int right = nums.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) {
        return mid;
    }
    else if (nums[mid] < target) {
        left = mid + 1;
    }
    else {
        right = mid - 1;
    }
}

return -1;


omplexity Analysis
Operation	Complexity
Time	O(log n)
Space	O(1)
🔥 Important Variations
Binary Search is not just searching.
It is used in:
           First & Last Position of Element
            Search in Rotated Sorted Array
           Find Peak Element
           Find Minimum in Rotated Array
           Square Root of a Number
           Binary Search on Answer (Optimization Problems)


Binary Search on Answer (Advanced Idea)

Sometimes we don’t search an index.
We search the answer space.
Example:
Minimum eating speed
Minimum capacity
Maximum possible value
Pattern:

while (low < high) {
    int mid = (low + high) / 2;
    if (isPossible(mid)) {
        high = mid;
    } else {
        low = mid + 1;
    }
}
⚠️ Common Mistakes
❌ Using (left + right) / 2 → may overflow
✔ Always use:
left + (right - left) / 2
❌ Forgetting <= vs <
❌ Infinite loops due to wrong pointer movement
Summary

Binary Search is:
✔ Efficient
✔ Logarithmic time
✔ Used in searching and optimization
           
