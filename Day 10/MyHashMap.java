// Design HashMap
// https://leetcode.com/problems/design-hashmap/description/?envType=daily-question&envId=2023-10-04
class MyHashMap {
    private static final int SIZE = 10000;
    private Entry[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new Entry[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new Entry(key, value);
        } else {
            Entry current = buckets[index];
            while (current.next != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key == key) {
                current.value = value;
            } else {
                current.next = new Entry(key, value);
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % SIZE;
        Entry current = buckets[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % SIZE;
        Entry current = buckets[index];
        Entry prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    private class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
