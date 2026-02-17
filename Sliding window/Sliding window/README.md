Sliding Window Pattern
🧠 What is Sliding Window?
Sliding Window is an optimization technique used on:
Arrays
Strings
Subarrays
Substrings
It redces nested loops (O(n²)) into a single loop (O(n)).
Instead of recalculating values repeatedly, we maintain a moving window over a portion of the data.

🎯 Why Use Sliding Window?
Use when problem involves:
Subarray / Substring
Contiguous elements
Maximum / Minimum length
Sum / Count conditions
Keywords in question:
“longest”, “shortest”, “maximum sum”, “minimum window”, “substring”, “subarray”

🔹 Types of Sliding Window
1️⃣ Fixed Size Window
Window size is given (k).
Example:
Maximum Sum Subarray of Size K
Structure:
// Calculate first window
// Then slide:
// add next element
// remove previous element

Time Complexity → O(n)
Space Complexity → O(1)

2️⃣ Variable Size Window

Window expands and shrinks based on condition.
Example:
Longest Substring Without Repeating Characters
Longest Subarray With Sum ≤ K
Structure:
while (right < n) {

    // expand window

    while (condition invalid) {
        // shrink window
    }

    // update answer
}


Time Complexity → O(n)
🧩 General Template (Variable Window)
int left = 0;

for (int right = 0; right < n; right++) {

    // expand window

    while (window is invalid) {
        left++;
    }

    // update result
}

📊 Complexity Advantage
Approach	Time Complexity
Brute Force	O(n²)
Sliding Window	O(n)

🚀 When NOT To Use Sliding Window
Non-contiguous elements
Random selection problems
Graph traversal
DP without contiguous relation
