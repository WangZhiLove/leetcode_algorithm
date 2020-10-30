package october.time1.a15;

public class IslandPerimeter {
    /**
     * 463. 岛屿的周长
     * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
     *
     * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
     *
     * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
     *
     * 示例 :
     *
     * 输入:
     * [[0,1,0,0],
     *  [1,1,1,0],
     *  [0,1,0,0],
     *  [1,1,0,0]]
     *
     * 输出: 16
     *
     * 解释: 它的周长是下面图片中的 16 个黄色的边：
     */

    /**
     * 这道题目纯粹是我想的难了，直接双层for循环
     */
    static int[] x = new int[]{0,1,0,-1};
    static int[] y = new int[]{1,0,-1,0};

    /**
     * 时间复杂度 O(m * n * 4) = O(m * n)
     * 空间复杂度 O(1)，没有额外的栈空间消耗
     */
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        if (grid.length == 0) {
            return result;
        }
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int num = 0;
                    for (int k = 0; k < 4; k++) {
                        int xInd = i + x[k];
                        int yInd = j + y[k];
                        if (xInd < 0 || xInd >= m || yInd < 0 || yInd >= n || grid[xInd][yInd] == 0) {
                            num ++;
                        }
                    }
                    result += num;
                }
            }
        }

        return result;
    }
}
