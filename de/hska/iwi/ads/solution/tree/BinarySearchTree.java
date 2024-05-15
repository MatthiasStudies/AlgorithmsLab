package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinaryTree<K, V> {

    protected Node getNode(K key) {
        Node x = this.root;

        while(x != null && !x.entry.getKey().equals(key)) {
            if (key.compareTo(x.entry.getKey()) < 0 ){
                x = x.left;
            } else {
                x = x.right;
            }
        }

        return x;
    }

    @SuppressWarnings("unchecked")
    public V get(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        var node = getNode((K) o);

        if (node != null) {
            return node.entry.getValue();
        }

        return null;
    }

    public V put(K key, V value) {
        if (key == null){
            throw new NullPointerException();
        }

        var existing = getNode(key);

        if (existing != null) {
            return existing.entry.setValue(value);
        }

        var z = new Node(key, value);

        Node y = null;
        Node x = this.root;

        while (x != null) {
            K xKey = x.entry.getKey();
            K zKey = z.entry.getKey();
            if (zKey.equals(xKey)) { // this should never happen
                throw new IllegalArgumentException("Double key");
            }

            y = x;
            if(zKey.compareTo(xKey) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        if (y == null) {
            this.root = z;
        } else if (z.entry.getKey().compareTo(y.entry.getKey()) < 0) {
            y.left = z;
        } else {
            y.right = z;
        }

        this.size++;

        return value;
    }

}
