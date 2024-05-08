package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractHashMap;

public class Hashtable<K extends Comparable<K>, V> extends AbstractHashMap<K, V> {
    public Hashtable(int capacity) {
        super(capacity);
    }

    private int hash(K key, int i) {
        return Math.floorMod(key.hashCode() + i * i, hashtable.length);
    }

    private int find(K key) {
        int i = 0;
        int j;
        do {
            j = hash(key, i);
            if (hashtable[j] != null && hashtable[j].getKey().equals(key)) {
                return j;
            }
            i++;
        } while (hashtable[j] != null && i < hashtable.length);
        return -1;
    }

    public void delete(K key) {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    public V get(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        int j = find((K) o);

        if (j == -1) {
            return null;
        }

        return hashtable[j].getValue();
    }

    public V put(K key, V value) {
        int existing = find(key);

        if (existing != -1) {
            V oldValue = hashtable[existing].getValue();
            hashtable[existing] = new SimpleEntry<>(key, value);
            return oldValue;
        }

        int i = 0;
        int j;
        do {
            j = hash(key, i);
            if (hashtable[j] == null) {
                hashtable[j] = new SimpleEntry<>(key, value);
                size++;
                return value;
            }
            i++;
        } while (i < hashtable.length);

        throw new DictionaryFullException();
    }

}
