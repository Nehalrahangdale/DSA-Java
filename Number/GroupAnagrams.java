import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Convert string to character array
            char[] chars = str.toCharArray();

            // Sort characters
            Arrays.sort(chars);

            // Convert back to String
            String key = new String(chars);

            // Create list if key doesn't exist
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add original string
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
