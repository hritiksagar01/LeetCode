1class Solution {
2  public List<String> generateParenthesis(int n) {
3    List<String> res = new ArrayList<>();
4    helper(res, n, 0, "");
5    return res;
6}
7
8private void helper(List<String> res, int left, int right, String s) {
9    if (left == 0 && right == 0) {
10        res.add(s);
11        return;
12    }
13
14    if (left > 0)
15        helper(res, left - 1, right + 1, s + "(");
16
17    if (right > 0)
18        helper(res, left, right - 1, s + ")");
19}
20
21}