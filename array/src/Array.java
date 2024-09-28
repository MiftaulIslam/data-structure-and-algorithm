public class Array {
    private int[] items;
    private int count;
    public Array(int length){
        items = new int[length];
    }

//    Insert Item
    //worst case:O(n)
    //best case:O(1)
    public void insert(int item){
        // if full, increase the array size dynamically?
        if(items.length == count){
            int[] newArr = new int[count * 2];
            for(int i=0; i<count; i++){
                newArr[i] = items[i];
            }
            items = newArr;
        }
        //insert at the end and increment count
        items[count++] = item;

    }

//    Insert Item at index
    //worst case: O(n)
    //best case: O(n)
    public void insert(int item, int index){
        //if array full increase the size
        if(items.length == count){
            int[] newarr = new int[count * 2];
            for(int i = 0; i <count; i++){
                newarr[i] = items[i];
            }
            items = newarr;
        }
        //If index greater than count
        if(index<0||index > count - 1){
            throw new IllegalArgumentException("Index out of bounds");
        }
        //increment the indexes of items from index to last
        for(int i = count-1; i>=index; i--){
            items[i + 1] = items[i];
        }

        //store the item to that index

        items[index] = item;
        count++;
    }



    // indexOf
    //O(n)
    public int indexOf(int item){
        for(int i = 0; i<count; i++){
            if(items[i] == item){
                return i;
            }
        }
        return -1;
    }

    //Remove - Remove the last item
    //O(1)
    public int remove(){
        if(count == 0 ){
            return -1;
        }
        int temp = items[count - 1];
        count--;
        return temp;
    }


    //Remove - Remove item by input
    // O(n)
    public int remove(int item){

        for(int i = 0; i<count ; i++){
            if(items[i] == item){
                for(int j = i; j < count - 1 ; j++){
                    items[j] = items[j+1];
                }
                count--;
                return i;
            }
        }

        return -1;
    }


    //RemoveAt - remove the item specified by index
    //O(n)
    public int removeAt(int index){
        if(index > count - 1) return  -1;
        for(int i = index; i<count - 1; i++){
            items[i] = items[i+1];
        }
        int temp = items[index];
        count--;
        return temp;
    }

    //O(n)
    public void print(){
        for(int i=0; i<count;i++){
            System.out.println(items[i]);
        }
    }
}
