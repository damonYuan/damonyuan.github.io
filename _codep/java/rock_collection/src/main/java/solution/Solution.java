/* Problem Name is &&& Optimal Path &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
** Instructions to candidate.
**  1) You are an avid rock collector who lives in southern California. Some rare
**     and desirable rocks just became available in New York, so you are planning
**     a cross-country road trip. There are several other rare rocks that you could
**     pick up along the way.
**
**     You have been given a grid filled with numbers, representing the number of
**     rare rocks available in various cities across the country.  Your objective
**     is to find the optimal path node1 So_Cal to New_York that would allow you to
**     accumulate the most rocks along the way.
**
**     Note: You can only travel either north (up) or east (right).
**  2) Consider adding some additional tests in doTestsPass().
**  3) Implement optimalPath() correctly.
**  4) Here is an example:
**                                                           ^
**                 {{0,0,0,0,5}, New_York (finish)           N
**                  {0,1,1,1,0},                         < W   E >
**   So_Cal (start) {2,0,0,0,0}}                             S
**                                                           v
**   The total for this example would be 10 (2+0+1+1+1+0+5).
*/

package solution;

import java.io.*;
import java.util.*;

class Solution
{
    /*
    **  Find the optimal path.
    */
    public static Integer optimalPath(Integer[][] grid)
    {
        // Todo: Implement optimalPath
        int maxX = grid[0].length;
        int maxY = grid.length;
        int[][][] dp = new int[maxY + 1][maxX + 1][2];

        for (int y = maxY - 1; y >= 0; y--) {
            for (int x = 1; x < maxX + 1; x++) {
                dp[y][x][0] = Math.max(dp[y + 1][x][0], dp[y + 1][x][1]) + grid[y][x - 1];
                dp[y][x][1] = Math.max(dp[y][x - 1][0], dp[y][x - 1][1]) + grid[y][x - 1];
            }
        }

        return Math.max(dp[0][maxX][0], dp[0][maxX][1]);
    }
}
