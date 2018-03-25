package java_base.lesson02_IO;

import java_base.lesson01_BasicDataStructure.Chapter1;
import java_base.lesson01_BasicDataStructure.Salary;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Chapter2_4 {
    private static String filePath = "D://serializable/salary";
    private static int dataLength = 1000;
    private static Salary salary = new Salary();

    public static void main(String[] args) throws IOException {
        writeSalaryDatasToFile();
        List<String> list = readSalaryDatasFromFile();
        HashMap<String, SalaryGroup> groupInfo = getGroupInfo(list);
        compare(new ArrayList<>(groupInfo.values()));
    }

    public static void writeSalaryDatasToFile() throws IOException {
        System.out.println("================= write data started ======================= ");
        File file = new File(filePath);
//        if(!file.exists()) {
//            create(filePath, "rwxr-x---");
//        }
        FileOutputStream fos = new FileOutputStream(filePath);
        FileChannel channel = fos.getChannel();

        boolean isOpen = channel.isOpen();
        System.out.println("isOpen:"+isOpen);

//        PrintWriter p = new PrintWriter(filePath, "UTF-8");
        long startTime = System.currentTimeMillis();
        IntStream.range(0, dataLength).forEach(i -> {
            byte[] bytes = new byte[0];
            try {
                bytes = (Chapter1.getSalary() + "\n").getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            ByteBuffer bbf = MappedByteBuffer.wrap(bytes);
            bbf.put(bytes);
            bbf.flip();
            try {
                channel.write(bbf);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            p.print(Chapter1.getSalary() + "\n");
            if (i == (dataLength - 1)) {
//                p.flush();
            System.out.println("=============== write data had flushed i is " + i + " ===========================");
            }
        });
//        p.close();
        channel.close();
        fos.flush();
        fos.close();
        long endTime = System.currentTimeMillis();
        System.out.println("============ write data end, use time is " + (endTime - startTime) + "ms =====================");

    }

    private static void create(String filePath, String s) {
    }

    public static List<String> readSalaryDatasFromFile() throws IOException {
        System.out.println("================= read data started ======================= ");
        long stime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(filePath);
        FileChannel channel = fis.getChannel();
        ByteBuffer fbb = ByteBuffer.allocate(1024 * 100);
        List<String> stringList = new ArrayList<>();
        byte[] lineByte = new byte[0];
        byte[] temp = new byte[0];
        while (-1 != channel.read(fbb)) {
            int readSize = fbb.position();
            byte[] bs = new byte[readSize];
            fbb.rewind();
            fbb.get(bs);
            fbb.clear();

            int startNum = 0;
            int LF = 10;
            int CR = 13;
            boolean hasLF = false;
            for (int i = 0; i < readSize; i++) {
                if (bs[i] == LF) {
                    hasLF = true;
                    int tempNum = temp.length;
                    int lineNum = i - startNum;
                    lineByte = new byte[tempNum + lineNum];
                    System.arraycopy(temp, 0, lineByte, 0, tempNum);
                    temp = new byte[0];
                    System.arraycopy(bs, startNum, lineByte, tempNum, lineNum);
                    String line = new String(lineByte, 0, lineByte.length, "UTF-8");
//                    System.out.println(line);
                    stringList.add(line);
                    //过滤回车符和换行符
                    if(i + 1 < readSize && bs[i + 1] == CR){
                        startNum = i + 2;
                    }else{
                        startNum = i + 1;
                    }
                }
            }
            if(hasLF){
                temp = new byte[bs.length - startNum];
                System.arraycopy(bs, startNum, temp, 0, temp.length);
            }else{
                //兼容单次读取的内容不足一行的情况
                byte[] toTemp = new byte[temp.length + bs.length];
                System.arraycopy(temp, 0, toTemp, 0, temp.length);
                System.arraycopy(bs, 0, toTemp, temp.length, bs.length);
                temp = toTemp;
            }
        }
        if(channel.isOpen()){
            channel.close();
        }
        fis.close();

//        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
//        LineNumberReader lr = new LineNumberReader(isr);
//        List<String> arr = new ArrayList<>();
//        IntStream.range(0, dataLength).forEach(i -> {
//            lr.setLineNumber(i);
//            try {
//                arr.add(lr.readLine());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        lr.close();
//        isr.close();
//        fis.close();
        long etime = System.currentTimeMillis();
        System.out.println("============ read data end  =====================");
        System.out.println("读取arr.size=" + stringList.size() + ", 读取耗时：" + (etime - stime) );
        return stringList;
    }

    public static HashMap<String, SalaryGroup> getGroupInfo(List<String> list) {
        long starttime = System.currentTimeMillis();
        HashMap<String, SalaryGroup> map = new HashMap<String, SalaryGroup>();
        list.stream().forEach(i -> {
            String[] strings = i.split(",");
//            Salary s1 = new Salary(strings);
            Salary s1 = salary.clone();
            s1.setName(strings[0]);
            s1.setBaseSalary(Integer.valueOf(strings[1]));
            s1.setBonus(Integer.valueOf(strings[2]));
            String preName = s1.getPreName();
            SalaryGroup salaryGroup = map.get(preName);
            if (salaryGroup == null) {
                salaryGroup = new SalaryGroup();
                salaryGroup.setGroupName(preName);
                map.put(preName, salaryGroup);
            }
            salaryGroup.increasePeopleCount();
            salaryGroup.plusSalaryTotalCount(s1.getYearlySalaryCount());
        });
        long endtime = System.currentTimeMillis();
        System.out.println("解析耗时："+(endtime - starttime));
        return map;
    }

    public static void compare(List<SalaryGroup> salaryGroups) {
        System.out.println("================= compare started ======================= ");
        long stime = System.currentTimeMillis();
        salaryGroups.stream().sorted(Comparator.comparingLong(SalaryGroup::getSalaryTotalCount).reversed())
                .limit(10).forEach(salaryGroup -> System.out.println(salaryGroup));

        long etime = System.currentTimeMillis();
        System.out.println("============ compare end, use time is " + (etime - stime) + " =====================");
    }

}
