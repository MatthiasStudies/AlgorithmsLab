package de.hska.iwi.ads.solution.list;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

public class DoubleLinkedList<K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K, V> {
    private Entry<K, V> getEntry(K key) {
        if (head == null) return null;

        ListElement currentLeft = head;

        while(currentLeft != null) {
            if (currentLeft.entry.getKey().equals(key)) {
                return currentLeft.entry;
            }

            currentLeft = currentLeft.next;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public V get(Object key) {
        if (key == null) {
            throw new NullPointerException("Cannot read key `null` from list");
        }

        Entry<K, V> e = getEntry((K) key);

        if (e != null) return e.getValue();

        return null;
    }


    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("Cannot put key `null` into list");
        }

        Entry<K, V> existing = getEntry(key);

        if (existing != null) {
            return existing.setValue(value);
        }

        SimpleEntry<K, V> entry = new SimpleEntry<>(key, value);

        ListElement new_ = new ListElement(entry, null, head);

        if (head != null) {
            head.previous = new_;
        }

        head = new_;
        this.size++;

        return new_.entry.getValue();
    }
}
