public class Pair {
    private int key;
    private String value;
    Pair(int key, String value){
        this.key = key;
        this.value = value;
    }
    public int get_key(){
        return this.key;
    }
    public String get_value(){
        return this.value;
    }

    public void set_key(int key){
        this.key = key;
    }
    @Override
    public java.lang.String toString() {
        return "("+key+")";
    }
}
