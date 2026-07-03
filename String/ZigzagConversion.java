class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows)
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++)
            rows[i] = new StringBuilder();

        int currentRow = 0;
        boolean goingDown = true;

        for (char ch : s.toCharArray()) {

            rows[currentRow].append(ch);

            if (currentRow == 0)
                goingDown = true;

            if (currentRow == numRows - 1)
                goingDown = false;

            if (goingDown)
                currentRow++;
            else
                currentRow--;
        }

        StringBuilder ans = new StringBuilder();

        for (StringBuilder row : rows)
            ans.append(row);

        return ans.toString();
    }
}
