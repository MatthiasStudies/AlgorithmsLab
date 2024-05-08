package de.hska.iwi.ads.solution.list;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

public class DoubleLinkedList<K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K, V> {
    private ListElement tail;

    private Entry<K, V> getEntry(K key) {
        if (head == null) return null;

        ListElement currentLeft = head;
        ListElement currentRight = tail;


        do {
            if (currentLeft.entry.getKey().equals(key)) {
                return currentLeft.entry;
            }
            if (currentRight.entry.getKey().equals(key)) {
                return currentRight.entry;
            }

            currentLeft = currentLeft.next;
            currentRight = currentRight.previous;
        } while (currentLeft != currentRight && currentLeft.previous != currentRight);

        // Required: If the element is the middle of the list
        if (currentLeft != null && currentLeft.entry.getKey().equals(key)) {
            return currentLeft.entry;
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

    public void delete(K key) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("Cannot put key `null` into list");
        }

        Entry<K, V> existing = getEntry(key);

        if (existing != null) {
            V oldValue = existing.getValue();
            existing.setValue(value);
            return oldValue;
        }

        SimpleEntry<K, V> entry = new SimpleEntry<>(key, value);

        ListElement new_ = new ListElement(entry, null, head);

        if (head != null) {
            head.previous = new_;
        } else {
            tail = new_;
        }
        head = new_;
        this.size++;

        return new_.entry.getValue();
    }
}
