public class MinStack {
    int[] array;
    int top;
    public int size;

    public MinStack(int size) {
        this.size = size;
        top = -1;
        array = new int[size];
    }
}
