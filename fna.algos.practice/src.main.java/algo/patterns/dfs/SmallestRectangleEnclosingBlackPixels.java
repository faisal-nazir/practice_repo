package algo.patterns.dfs;

public class SmallestRectangleEnclosingBlackPixels {

    // this has a binary search solution as well.
    public int minAreaDFS(int[][] image, int x, int y) {
    if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
        return 0;
    }
    // array record minimum x, minimum y, maximum x, maximum y
    int[] res = {x, y, x, y};
    dfs(x, y, image, res);
    return (res[2] - res[0] + 1) * (res[3] - res[1] + 1);
}

private void dfs(int x, int y, int[][] image, int[] res) {
    int maxR = image.length;
    int maxC = image[0].length;
             // If the current pixel point exists and, before continuing, otherwise
    if (x >= 0 && x < maxR && y >= 0 && y < maxC && image[x][y] == 1) {
        image[x][y] = 0;
        res[0] = Math.min(x, res[0]);
        res[1] = Math.min(y, res[1]);
        res[2] = Math.max(x, res[2]);
        res[3] = Math.max(y, res[3]);
        dfs(x - 1, y, image, res);
        dfs(x + 1, y, image, res);
        dfs(x, y - 1, image, res);
        dfs(x, y + 1, image, res);
    }
}    
}

