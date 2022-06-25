import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) { // access-order mode
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return map.size() > capacity; // can't use this.map since `this` is not the `this` of LRUCache
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */