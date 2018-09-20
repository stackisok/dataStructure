package list;

public class MyArrayList<T> {
    Object[] list;
    int size;
    public void add(int index, T o){
        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = o;
        size++;
    }
    public void add(T o){
        list[size++] = o;
    }
    public void remove(int index) {


        System.arraycopy(list, index + 1, list, index,size - index - 1);
        size --;
    }
    public T get(int index){

        return (T) list[index];
    }

    public MyArrayList() {
        this.list = new Object[10];
        size = 0;
    }

    public static void main(String[] args) {

        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(2, 9);
        myArrayList.remove(1);
       for (int i = 0; i < myArrayList.size; i++) {
           System.out.println(myArrayList.get(i));
       }
    }
}
