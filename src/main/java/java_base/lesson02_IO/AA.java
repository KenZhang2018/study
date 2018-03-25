package java_base.lesson02_IO;

import java.io.InputStream;
import java.util.*;

public class AA {

    public static void main(String[] args) {
//        byte[] b = new byte[4];
//        b[0] = -128;
//        b[1] = -128;
//        b[2] = -128;
//        b[3] = -128;
//        int off = 0;
//        int a = ((b[off + 3] & 0xFF)      ) +
//                ((b[off + 2] & 0xFF) <<  8) +
//                ((b[off + 1] & 0xFF) << 16) +
//                ((b[off    ]       ) << 24);
//        System.out.println(a);
        InputStream is = null;

        int a = -1;
        byte[] b = new byte[4];
//        b[0] = (byte)a;
//        b[1] = (byte)(a >> 8);
//        b[2] = (byte)(a >> 16);
//        b[3] = (byte)(a >> 24);
        putInt(b, 0, a);
        int count = 1000_0000;
        System.out.println(count);
        for (byte bb: b
             ) {
            long x = bb & 0xFFL;
            System.out.println(x);
        }
        int anInt = getInt(b, 0);

        System.out.println(anInt);
        Hashtable<String, String> hashtable = null;
        Queue<String> qq = null;
        Collection<String> c = null;
        LinkedList<String> linkedList = null;
        System.out.println("=================");
        IdentityHashMap map = new IdentityHashMap();
        Integer aa=5;
        Integer bb=5;
        map.put(aa,"100");
        map.put(bb,"100");
        System.out.println(map.size());
        map.clear();
        aa=Integer.MAX_VALUE-1;
        bb=Integer.MAX_VALUE-1;
        map.put(aa,"100");
        map.put(bb,"100");
        System.out.println(map.size());
//        Arrays.asList();
//        linkedList.toArray();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for(int i = 0; i < 1000000; i++) {
            linkedHashMap.put(i+1,i+1);
        }
        long starttime = System.currentTimeMillis();
        for (int i = 55555; i < 70000; i++) {
            linkedHashMap.remove(i);
        }
        long endtime = System.currentTimeMillis();
        System.out.println(endtime-starttime);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < 1000000; i++) {
            hashMap.put(i+1,i+1);
        }
        starttime = System.currentTimeMillis();
        for (int i = 55555; i < 70000; i++) {
            hashMap.remove(i);
        }
        endtime = System.currentTimeMillis();
        System.out.println(endtime-starttime);
    }

    static int getInt(byte[] b, int off) {
        return ((b[off + 3] & 0xFF)      ) +
                ((b[off + 2] & 0xFF) <<  8) +
                ((b[off + 1] & 0xFF) << 16) +
                ((b[off    ]       ) << 24);
    }

    static void putInt(byte[] b, int off, int val) {
        b[off + 3] = (byte) (val       );
        b[off + 2] = (byte) (val >>>  8);
        b[off + 1] = (byte) (val >>> 16);
        b[off    ] = (byte) (val >>> 24);
    }

}
