class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean word = false;
    public TrieNode() {};
}

class WordDictionary {
    /*
        TrieTree.
        Build O(m).
        Search O(m) for well defined strings; O(26 ^ m) for undefined strings
    */
    
    TrieNode trie;

    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = trie;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) node.children.put(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.word = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word, trie);
    }
    
    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                if (ch == '.') {
                    for (char c : node.children.keySet()) {
                        TrieNode next = node.children.get(c);
                        if (searchInNode(word.substring(i + 1), next)) return true;
                    }
                }
                return false;
            } else node = node.children.get(ch);
        }
        
    
        return node.word;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */