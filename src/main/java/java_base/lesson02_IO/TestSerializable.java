package java_base.lesson02_IO;

import java_base.lesson01_BasicDataStructure.ByteStore;
import java_base.lesson01_BasicDataStructure.IntStore;
import java_base.lesson01_BasicDataStructure.MyItem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.channels.FileChannel;

public class TestSerializable implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyItem[] items = new MyItem[1000];
        IntStore intStore = new IntStore(1000);
        ByteStore byteStore = new ByteStore(1000);
//        for(int i = 0; i < 1000; i++) {
//            byteStore.putMyItem(i, TestByteStore.randomItem());
//            intStore.putMyItem(i, TestByteStore.randomItem());
//            items[i] = TestByteStore.randomItem();
//        }
//
//        FileOutputStream fos = new FileOutputStream("D://serializable/itemByByteArray");
//        ObjectOutputStream os = new ObjectOutputStream(fos);
//        os.writeObject(items);
//        os.writeObject(intStore);
//        os.writeObject(byteStore);
//        os.close();

        FileInputStream fis = new FileInputStream("D://serializable/item");
        FileInputStream fisByByte = new FileInputStream("D://serializable/itemByByteArray");
        FileInputStream fisByInt = new FileInputStream("D://serializable/itemByIntArray");
        FileChannel channe = fis.getChannel();
        FileChannel channeByByte = fisByByte.getChannel();
        FileChannel channeByInt = fisByInt.getChannel();
        long size = channe.size();
        long sizeByByte = channeByByte.size();
        long sizeByInt = channeByInt.size();
        System.err.println("MyItem[]存储 读取："+size+"字节   每个对象占"+ (size/1000)+"字节");
        System.err.println("byte[]存储   读取："+sizeByByte+"字节   每个对象占"+ (sizeByByte/1000)+"字节");
        System.err.println("int[]存储    读取："+sizeByInt+"字节   每个对象占"+ (sizeByInt/1000)+"字节");
        ObjectInputStream is = new ObjectInputStream(fis);

//        items = (MyItem[]) is.readObject();
//        intStore = (IntStore) is.readObject();
//        byteStore = (ByteStore) is.readObject();
        is.close();
        for(int i = 0; i < 10; i++) {
//            System.out.println(intStore.getMyItem(i));
//            System.out.println(byteStore.getMyItem(i));
        }
        System.out.println("结束");
    }


}
