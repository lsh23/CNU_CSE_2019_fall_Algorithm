import java.util.HashMap;

public class Heap {
    Pair[] array_tree;
    int heap_size;
    Heap(Pair[] array,int size){
        this.heap_size = size;
        this.array_tree = array;
    }

    void bulid_max_heap(){
        for (int i = heap_size/2 ; i>=1 ;i--){
            max_heapity(i);
        }
    }

    void max_heapity(int i){
        int l = get_left_child_index(i);
        int r = get_rigth_child_index(i);
        if(l>heap_size) return;
        int max = 0;
        if(l<=heap_size && array_tree[l].get_key()>array_tree[i].get_key()){
            max = l;
        }
        else max = i;

        if(r<=heap_size && array_tree[r].get_key()>array_tree[max].get_key()){
            max = r;
        }
        if (max!=i){
            Pair tmp = array_tree[i];
            array_tree[i] = array_tree[max];
            array_tree[max] = tmp;
            max_heapity(max);
        }
    }

    
    int get_parent_index(int i){
        return i/2;
    }

    int get_left_child_index(int i){
        return 2*i;
    }

    int get_rigth_child_index(int i){
        return 2*i+1;
    }
}
