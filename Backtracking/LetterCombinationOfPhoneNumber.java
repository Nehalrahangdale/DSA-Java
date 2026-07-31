class Solution {

    String arr[] = {
        "0", "1", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();

        if (digits.isEmpty())
            return list;

        solve(digits, new StringBuilder(), list);

        return list;
    }

    void solve(String digits, StringBuilder res, List<String> list) {

        // Base case
        if (digits.length() == 0) {
            list.add(res.toString());
            return;
        }

        char cc = digits.charAt(0);
        String ros = digits.substring(1);

        String phoneString = arr[cc - '0'];

        for (char c : phoneString.toCharArray()) {
            res.append(c);
            solve(ros, res, list);
            res.deleteCharAt(res.length() - 1);
        }
    }
}
