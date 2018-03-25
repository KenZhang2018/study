package java_base.lesson02_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;

public class Chapter2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        String s = "中国";
//        byte[] utf8Bytes = printStringByCharset(s, "UTF-8");
//        printStringByCharset(s, "GBK");
//        printStringByCharset(s, "ISO-8859-1");
//
//        String gbk = new String(utf8Bytes, "GBK");
//        System.err.println("UTF-8编码的字符串的byte[]用GBK编码还原为: " + gbk);
// 因为utf8是三个字节的编码集,gbk是两个字节的编码集,用utf8编码的byte[]用gbk解码时就会出现乱码,并且会多解析出一定长度的字符

        question2();

//        new PrintWriter("", "");
//        IntStream.range(0,1);

    }

    private static byte[] printStringByCharset(String originalStr, String charsetName) throws UnsupportedEncodingException {
        byte[] bytes = originalStr.getBytes(charsetName);
        String newStr = new String(bytes, charsetName);
        System.err.println(charsetName + "  length is " + bytes.length +", string is " + newStr);
        return newStr.getBytes();
    }

    private static void question2() throws IOException, ClassNotFoundException {
        int a = 10240;
        String pathLittle = "D://serializable/int10240ByLittleEnbian";
        String pathBig = "D://serializable/int10240ByBigEnbian";
        byte[] littleEnbian = getBytesByLittleEnbian(a);
        writeFile(pathLittle, littleEnbian);
        byte[] readLittleByte = readFile(pathLittle);
        a = readLittleByte[0] + (readLittleByte[1] << 8) + (readLittleByte[2] << 16) + (readLittleByte[3] << 24);
        for( int i = 0; i < 4; i++ ) {
            System.out.print(readLittleByte[i] + ", ");
        }
        System.out.println();
        System.out.println("a:"+a);

        byte[] bigEnbian = getBytesByBigEnbian(a);
        writeFile(pathBig, bigEnbian);
        byte[] readBigByte = readFile(pathBig);
        a = (readBigByte[0] << 24) + (readBigByte[1] << 16) + (readBigByte[2] << 8) + readBigByte[3];
        for( int i = 0; i < 4; i++ ) {
            System.out.print(readBigByte[i] + ", ");
        }
        System.out.println();
        System.out.println("a:"+a);

    }

    public static byte[] getBytesByLittleEnbian(int data) {
        byte[] result = new byte[4];
        result[0] = (byte) ( data & 0xFF);
        result[1] = (byte) ( data >> 8 & 0xFF);
        result[2] = (byte) ( data >> 16 & 0xFF);
        result[3] = (byte) ( data >> 24 & 0xFF);
        return result;
    }

    public static byte[] getBytesByBigEnbian(int data) {
        byte[] result = new byte[4];
        result[0] = (byte) ( data >> 24 & 0xFF);
        result[1] = (byte) ( data >> 16 & 0xFF);
        result[2] = (byte) ( data >> 8 & 0xFF);
        result[3] = (byte) ( data & 0xFF);
        return result;
    }

    public static byte[] readFile(String path) throws IOException, ClassNotFoundException {
        byte[] data = new byte[4];
        FileInputStream fis = new FileInputStream(path);
        fis.read(data);
        fis.close();
//        FileChannel channe = fis.getChannel();
//        ObjectInputStream is = new ObjectInputStream(fis);
//        data = (byte[]) is.readObject();
//        is.close();
        return data;
    }

    public static void writeFile(String path, byte[] data) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        FileChannel channel = fos.getChannel();
        fos.write(data);
        fos.close();
//        ObjectOutputStream os = new ObjectOutputStream(fos);
//        os.writeObject(data);
//        os.close();
    }

}
