package java_base.lesson01_BasicDataStructure;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;

public class AA {

    public static void main(String[] args) {
        byte a = 127;
        int i = 127 << 1;
        System.out.println(i); // 254
        byte b = -64;
        System.out.println(b); // -128

        byte c = 127;
        int i1 = 127 >> 1;
        System.out.println(i1); // 63
        int i2 = b >> 1;
        System.out.println(i2); // -64
        int i3 =  (b >>> 1);
        System.out.println(i3); //

        int d = -64;
        int i4 = d >>> 1;
        System.out.println(i4);

        int e = 1;
        int i5 = 1 << 33;
        System.out.println(i5);

        int f = 0xff;
        System.out.println(f);

        byte aa = (byte) 0xf0;
        System.out.println(aa);
        int bb = 0xff & aa;
        System.out.println(bb);

        int flg = 0b01101000;
        byte bbb = (byte)((flg & 0b00110000) >> 4);
        System.out.println(bbb+" : "+flg);

        byte cc =  (byte) 206;
        System.out.println(cc);

//        int x = (int)1023.999999999999999; // 1024（14个9）
        int x = (int)1023.9999999999999; // 1023(13个9)
        System.out.println(x);
        double y = 0.1;
        System.out.println(y);

        BigDecimal z = new BigDecimal(0.1);
        System.out.println(z.toString());

        ArrayList array = new ArrayList<>();
        array.add(1);
        array.add(5);
        array.add(7);
        array.parallelStream();
//        Arrays.parallelSort();

        try {
            OutputStream os = new DataOutputStream(new FileOutputStream("aa.txt"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

    }

}
