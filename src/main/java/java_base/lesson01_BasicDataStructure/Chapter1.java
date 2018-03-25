package java_base.lesson01_BasicDataStructure;


import oracle.jrockit.jfr.events.Bits;

import java.util.ArrayList;
import java.util.Random;

public class Chapter1 {

    public static void main(String[] arg) {
//        int a = -1024;
//        int i1 = a >> 1;
//        int i2 = a >>> 1;
//        System.out.println("a>>1:"+i1+"; a>>>1:"+i2);

//        int[][] arr = new int[10240][10240];
//        for( int i = 0; i < 10240; i++ ) {
//            for ( int j = 0; j < 10240; j++ ) {
//                arr[i][j] = 1;
//            }
//        }
//        long startTime = System.currentTimeMillis();
//        System.out.println("start-time:"+ startTime);
//        int total = 0;
//        for( int i = 0; i < 10240; i++ ) {
//            for ( int j = 0; j < 10240; j++ ) {
//                total = total + arr[i][j];
//            }
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("end-time:"+ endTime + "用时:"+(endTime-startTime));
//
//        System.out.println("// =======================================");
//        total = 0;
//        startTime = System.currentTimeMillis();
//        System.out.println("start-time:"+ startTime);
//        for ( int i = 0; i < 10240; i++ ) {
//            for ( int j = 0; j < 10240; j++ ) {
//                total = total + arr[j][i];
//            }
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("end-time:"+ endTime + "用时:"+(endTime-startTime));


//        int[] arrInt = new int[1000];
//        Arrays.parallelSort(arrInt);

        ArrayList<Salary> salaryList = new ArrayList<>();
        for ( int i = 0; i < 1000; i++ ) {
            Salary salary = getSalary();
            salaryList.add(salary);
        }
//        IncomeCompartor incomeCompartor = new IncomeCompartor();
//        Collections.sort(salaryList, incomeCompartor);
        Salary[] salaryArray = new Salary[1000];
        salaryArray = salaryList.toArray(salaryArray);
        quickSortSalary(salaryArray, 0, 999);
//        bubbleSortSalary(salaryArray);
        for (int i = 999; i > 899; i--) {
            System.out.println(salaryArray[i]);
        }
//        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        System.out.println(uuid);
    }

    public static Salary getSalary() {
        Random random = new Random();
        int max = 1000000;
        int min = 50000;
        random.nextInt(1000000);
        Salary salary = new Salary();
        salary.setName(getRandomChar(5));
        int baseSalary = random.nextInt(max) % (max-min+1) + min;
        salary.setBaseSalary(baseSalary);
        salary.setBonus(random.nextInt(100001));
        return salary;
    }

    private static void bubbleSortSalary(Salary[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for ( int j = i+1; j < arr.length; j++ ) {
                if ( getTotalSalary(arr[i]) > getTotalSalary(arr[j]) ) {
                    swap(arr, i, j);
                }
            }
        }

    }

    private static void quickSortSalary(Salary[] arr, int low, int high) {
        int lowIndex = low;
        int highIndex = high;
        int first = getTotalSalary(arr[low]);
        Integer a = null;
        Bits b = null;
        while (lowIndex < highIndex) {
            // 从右往左
            while (lowIndex < highIndex && getTotalSalary(arr[highIndex]) >= first) {  highIndex--; }
            if (lowIndex < highIndex) {
                swap(arr, lowIndex, highIndex);
                lowIndex++;
            }
            // 从左往右
            while (lowIndex < highIndex && getTotalSalary(arr[lowIndex]) <= first) { lowIndex++; }
            if (lowIndex < highIndex) {
                swap(arr, lowIndex, highIndex);
                highIndex--;
            }
        }
        // 递归处理数组的左右部分
        if (lowIndex > low) {quickSortSalary(arr, low, lowIndex - 1);}
        if (highIndex < high) {quickSortSalary(arr, lowIndex + 1, high);}
    }

    private static void swap(Salary[] arr, int low, int high) {
        Salary temp = arr[high];
        arr[high] = arr[low];
        arr[low] = temp;
    }

    private static int getTotalSalary(Salary salary) {
        return salary.getBaseSalary() * 13 + salary.getBonus();
    }

    /**
     * JAVA获得0-9,a-z,A-Z范围的随机数
     *
     * @param length
     *            随机数长度
     * @return String
     */
    public static String getRandomChar(int length) {
        char[] chr = {
//                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
//            buffer.append(chr[random.nextInt(62)]);
            buffer.append(chr[random.nextInt(52)]);
        }
        return buffer.toString();
    }

}
