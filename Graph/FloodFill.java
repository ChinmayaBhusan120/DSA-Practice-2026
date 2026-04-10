Problem Statement

You are given a 2D image (matrix) where each cell has a color.

Starting from a pixel (sr, sc),
change the color of all connected pixels (same color) to a new color.

Example
Input:
image = [ [1,1,1],
          [1,1,0],
          [1,0,1]]
sr = 1, sc = 1, newColor = 2

Output:
[[2,2,2],
 [2,2,0],
 [2,0,1]
]
🧠 Key Idea

👉 This is just like Number of Islands

Start from given cell
Visit all connected cells with same color
Change their coloR
  
🧠 Approach

1️⃣ Store original color
2️⃣ DFS/BFS from (sr, sc)
3️⃣ Replace all connected same-color cells

⚠️ Important Edge Case
If original color == newColor → return immediately

Otherwise infinite recursion.


CODE----->>>>>


class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];

        if (original == color) {
            return image;
        }

        dfs(image, sr, sc, original, color);

        return image;
    }

    private void dfs(int[][] image, int i, int j, int original, int color) {

        if (i < 0 || j < 0 ||
            i >= image.length || j >= image[0].length ||
            image[i][j] != original) {
            return;
        }

        image[i][j] = color;

        dfs(image, i + 1, j, original, color);
        dfs(image, i - 1, j, original, color);
        dfs(image, i, j + 1, original, color);
        dfs(image, i, j - 1, original, color);
    }
}
