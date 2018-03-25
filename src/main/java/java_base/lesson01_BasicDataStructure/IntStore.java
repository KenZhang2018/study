package java_base.lesson01_BasicDataStructure;

import java.io.Serializable;

public class IntStore implements Serializable {
    private int[] storeIntArray;
    public IntStore(int count) {
        this.storeIntArray = new int[count];
    }
    public int[] getStoreIntArray() {
        return storeIntArray;
    }
    public void setStoreIntArray(int[] storeIntArray) {
        this.storeIntArray = storeIntArray;
    }
    public void putMyItem(int index, MyItem item) {
        int i = (item.getColor() & 0xff) << 8;
        int i1 = (item.getType() & 0xff) << 16;
        int result =  (item.getPrice() & 0xff) + i + i1;
        storeIntArray[index] = result;
    }
    public MyItem getMyItem(int index) {
        int result = storeIntArray[index];
        byte price = (byte) result;
        byte color = (byte) (result >> 8);
        byte type = (byte) (result >> 16);
        MyItem item = new MyItem();
        item.setType(type);
        item.setColor(color);
        item.setPrice(price);
        return item;
    }

}
