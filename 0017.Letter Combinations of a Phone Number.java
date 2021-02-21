class Solution {
    /*
        dfs and backtrack.
    */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        List<String> ans = new ArrayList<>();
        
        dfs(map, ans, digits, 0, new StringBuffer());
        
        return ans;
    }
    
    private void dfs(Map<Character, List<Character>> map, List<String> ans, String digits, int head, StringBuffer sb) {
        if (head >= digits.length()) return;
        
        List<Character> list = map.get(digits.charAt(head));
        for (Character ch : list) {
            sb.append(ch);
            
            if (head == digits.length() - 1) ans.add(sb.toString());
            
            dfs(map, ans, digits, head + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    } 
}