package java_base.lesson01_BasicDataStructure;

import java.util.Random;

public class TestByteStore {

    private static Random random = new Random();

    public static void main(String[] args) {
        ByteStore byteStore = new ByteStore(1000);
        IntStore intStore = new IntStore(1000);
        MyItem item1 = randomItem();
        MyItem item2 = randomItem();
        MyItem item3 = randomItem();
        intStore.putMyItem(0, item1);
        intStore.putMyItem(1, item2);
        intStore.putMyItem(2, item3);
        System.out.println(item1.equals(intStore.getMyItem(0))+" "+item1.toString());
        System.out.println(item2.equals(intStore.getMyItem(1))+" "+item2.toString());
        System.out.println(item3.equals(intStore.getMyItem(2))+" "+item3.toString());
//
//        byteStore.putMyItem(0, item1);
//        byteStore.putMyItem(1, item2);
//        byteStore.putMyItem(2, item3);

//        System.out.println(item1.equals(byteStore.getMyItem(0))+" "+item1.toString());
//        System.out.println(item2.equals(byteStore.getMyItem(1))+" "+item2.toString());
//        System.out.println(item3.equals(byteStore.getMyItem(2))+" "+item3.toString());

//        for(int i = 0; i < 1000; i++) {
//            byteStore.putMyItem(i, randomItem());
//        }
//        byteStore.sortByPrice();
//        for(int i = 0; i < 100; i++) {
//            MyItem myItem = byteStore.getMyItem(i);
//            System.out.println(myItem);
//        }
//        MyItem item = randomItem();
//        System.out.println(item);
//        int i = (item.getColor() & 0xff) << 8;
//        int i1 = (item.getType() & 0xff) << 16;
//        int result =  (item.getPrice() & 0xff) + i + i1;
//        byte price = (byte) result;
//        byte color = (byte) (result >> 8);
//        byte type = (byte) (result >> 16);
//        System.out.println("type:"+type+"; color:"+color+"; price:"+price);
//
//        byte type1 = 58;
//        byte color1 = -74;
//        byte price1 = -38;
//        System.out.println("type:"+type1+"; color:"+color1+"; price:"+price1);
//        int i2 = (type1 & 0xff) << 16;
//        int i3 = (color1 & 0xff) << 8;
//        int i4 = price1 & 0xff;
//        int res = i2+i3+i4;
//        byte type2 = (byte) (res >> 16);
//        byte color2 = (byte) (res >> 8);
//        byte price2 = (byte)res;
//        System.out.println("type:"+type2+"; color:"+color2+"; price:"+price2);

    }

    public static MyItem randomItem() {
        MyItem item = new MyItem();
        byte[] bytes = new byte[3];
        random.nextBytes(bytes);
        item.setType(bytes[0]);
        item.setColor(bytes[1]);
        item.setPrice(bytes[2]);
        return item;
    }


}
