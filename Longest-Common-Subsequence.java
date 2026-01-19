1class Solution {
2    public int longestCommonSubsequence(String text1, String text2) {
3        int dp[][] = new int[text1.length()+1][text2.length()+1];
4        for (int[] row : dp) Arrays.fill(row, -1);
5      return  helper(text1 , text2 , text1.length(), text2.length(), dp);
6    }
7    public static int helper( String text1, String text2 , int i , int j, int[][]dp){
8        if( i ==0 || j == 0) return 0;
9
10        if( dp[i][j] != -1)return dp[i][j];
11
12         if( text1.charAt(i-1) == text2.charAt(j-1)){
13                return  dp[i][j] =  1 + helper( text1 , text2 , i-1 , j-1 , dp);
14             }
15
16             else{
17                 dp[i][j] = Math.max( helper(text1 , text2 , i-1, j,dp), helper( text1 , text2 ,i , j-1 ,dp));
18             }
19
20             return dp[i][j];
21        }
22
23}