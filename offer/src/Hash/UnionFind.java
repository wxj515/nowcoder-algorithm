/**
 * 并查集：两个功能：判断两个元素是否在同一集合(每个集合有一个代表元，其实也就是根节点)；假如不是就合并两个不同集合
 */
package Hash;

import java.util.HashMap;
import java.util.List;

public class UnionFind {
    public static class Node {

    }

    public static class UnionFindSet {
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;

        public UnionFindSet(List<Node> nodes) {

        }

        private void makeSets(List<Node> nodes) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node findHead(Node node) {
            Node father = fatherMap.get(node);
            if (father != node) {
                father = findHead(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null)
                return;
            Node af = fatherMap.get(a);
            Node bf = fatherMap.get(b);

            if (af != bf) {
                int as = sizeMap.get(a);
                int bs = sizeMap.get(b);
                if (as >= bs) {
                    fatherMap.put(bf, af);
                    sizeMap.put(af, as + bs);
                } else {
                    fatherMap.put(af, bf);
                    sizeMap.put(bf, as + bs);
                }
            }
        }
    }
}
