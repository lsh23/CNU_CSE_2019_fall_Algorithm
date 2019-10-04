import java.util.HashMap;

public class Heap {
    Pair[] array_tree;
    int heap_size;
    Heap(Pair[] array,int size){
        this.heap_size = size;
        this.array_tree = array;
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
