package java_base.lesson01_BasicDataStructure;

import java.io.Serializable;

public class ByteStore implements Serializable {

    private byte[] storeByteArray;

    public ByteStore(int myItemCount) {
        this.storeByteArray = new byte[myItemCount*3];
    }

    public byte[] getStoreByteArray() {
        return storeByteArray;
    }

    public void putMyItem(int index, MyItem item) {
        int i = index * 3;
        storeByteArray[i] = item.getType();
        storeByteArray[i+1] = item.getColor();
        storeByteArray[i+2] = item.getPrice();
    }

    public MyItem getMyItem(int index) {
        int i = index * 3;
        MyItem item = new MyItem();
        item.setType(storeByteArray[i]);
        item.setColor(storeByteArray[i+1]);
        item.setPrice(storeByteArray[i+2]);
        return item;
    }

    public void sortByPrice() {
        int length = storeByteArray.length;
        int count = length / 3;
//        System.out.println(count);
        for(int i = 0; i < count-1; i++) {
            for(int j = i+1; j < count; j++) {
                if (storeByteArray[i * 3 + 2] < storeByteArray[j*3+2]) {
                    byte type = storeByteArray[i*3];
                    byte color = storeByteArray[i * 3 + 1];
                    byte price = storeByteArray[i * 3 + 2];

                    storeByteArray[i*3] = storeByteArray[j*3];
                    storeByteArray[i*3+1] = storeByteArray[j*3+1];
                    storeByteArray[i*3+2] = storeByteArray[j*3+2];

                    storeByteArray[j*3] = type;
                    storeByteArray[j*3+1] = color;
                    storeByteArray[j*3+2] = price;
                }
            }
        }
    }

}
