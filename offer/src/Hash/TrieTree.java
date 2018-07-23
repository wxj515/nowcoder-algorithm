/**
 * 前缀树
 */
package Hash;

public class TrieTree {
    public static class TrieNode {
        //这个节点被经过多少次，等于有多少字符串以这一小段字符串为前缀
        public int path;
        public int end; //以这一字符串结尾的有多少
        public TrieNode[] nexts;

        public TrieNode() {
            path =0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null)
                return;
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null)
                    node.nexts[index] = new TrieNode();
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }

        public void delet(String word) {
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    if (--node.nexts[index].path == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        public int search(String word) {
            if (word == null)
                return 0;
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null)
                    return 0;
                node = node.nexts[index];
            }
            return node.end;
        }

        public int prefixNumber(String pre) {
            if (pre == null)
                return 0;
            char[] chars = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null)
                    return 0;
                node = node.nexts[index];
            }
            return node.path;
        }
    }
}

