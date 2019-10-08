public class PriorityQueue {
    Heap max_heap;

    PriorityQueue(Heap heap){
        this.max_heap = heap;
    }

    void insert(Pair pair){
        max_heap.insert(pair);
    }

    Pair max(){
        return max_heap.get_max();
    }

    Pair extract_max(){
        return max_heap.extract_max();
    }

    void increase_key(int key, int k){
        max_heap.increase_key(key,k);
    }

    boolean delete(int key){
        return max_heap.delete(key);
    }

    @Override
    public String toString() {
        return max_heap.toString();
    }
}
