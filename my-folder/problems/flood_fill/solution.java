class Solution {
    // 0 0 0
    // 0 0 0
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // start at image[sr][sc]
        // change cell to new color
        int m = image.length;
        int n = image[0].length;
        // Match new cells with older color to prevent
        // revisiting an already filled cell.
        int oldColor = image[sr][sc];
        // Nothing to change if color is the same.
        if (image[sr][sc] == color) return image;
        // Set new color for cell.
        image[sr][sc] = color;
        // Recursively flood 4-directional neighbors.
        if (sr + 1 < m && image[sr + 1][sc] == oldColor) // down cell
            image = floodFill(image, sr + 1, sc, color);
        if (sr - 1 >= 0 && image[sr - 1][sc] == oldColor) // up cell 
            image = floodFill(image, sr - 1, sc, color);
        if (sc + 1 < n && image[sr][sc + 1] == oldColor) // right cell
            image = floodFill(image, sr, sc + 1, color);
        if (sc - 1 >= 0 && image[sr][sc - 1] == oldColor) // left cell
            image = floodFill(image, sr, sc - 1, color);
    
        return image;
    }
}