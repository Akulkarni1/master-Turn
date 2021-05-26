package AllTime;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class ShortestPrefix {
/*
if the query string is "cat" and the {"dog", "be", "cut", "car"), the
bins are {"be"), {"car", "cut"), and {"dog"). We focus on the set {"car", "cur"), and
look for the longest prefix of "at" not in {"ar", "ur").
*/

    public String findShortestPrefix(String s, Set<String> set) {
        Trie trie = new Trie();
        for (String word : set) {
            trie.insert(word);
        }
        return trie.getShortestPrefix(s);
    }

    @Getter
    @Setter
    class Trie {
        @Getter
        @Setter
        private class TrieNode {
            boolean isString = false;
            Map<Character, TrieNode> leaves = new HashMap<>();
        }

        private TrieNode root = new TrieNode();

        public boolean insert(String s) {
            TrieNode tnode = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!tnode.getLeaves().containsKey(c)) {
                    tnode.getLeaves().put(c, new TrieNode());
                }
                tnode = tnode.getLeaves().get(c);
            }
            if (tnode.isString()) {
                return false;
            } else {
                tnode.setString(true);
                return true;
            }
        }

        public String getShortestPrefix(String s) {
            TrieNode trieNode = root;
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                prefix.append(c);
                if (!trieNode.getLeaves().containsKey(c)) {
                    return prefix.toString();
                }
                trieNode = trieNode.getLeaves().get(c);
            }
            return "";
        }
    }
}