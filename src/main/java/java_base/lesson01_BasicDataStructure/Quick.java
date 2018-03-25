package java_base.lesson01_BasicDataStructure;

public class Quick {

    public static void main(String[] args) {
        int[] array = new int[] {6, 2,7,3,9,66,13, 1, 4,51,76,8,81,26,57,69,23};
//        quickSort2(array, 0, 14);
        sort(array, 0, 16);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void sort(int[] arr, int low, int high) {
        int low1 = low;
        int high1 = high;
        int povit = arr[low];

        while (low1 < high1) {
            // 从右往左
            while (low1 < high1 && arr[high1] >= povit) {  high1--; }
            if (low1 < high1) {
                int temp = arr[high1];
                arr[high1] = arr[low1];
                arr[low1] = temp;
                low1++;
            }

            while (low1 < high1 && arr[low1] <= povit) { low1++; }
            if (low1 < high1) {
                int temp = arr[high1];
                arr[high1] = arr[low1];
                arr[low1] = temp;
                high1--;
            }
        }

        if (low1 > low) {sort(arr, low, low1 - 1);}
        if (high1 < high) {sort(arr, low1 + 1, high);}
    }

    /*//////////////////////////方式二////////////////////////////////*/
//        更高效点的代码：
    public static int[] quickSort2(int[] targetArr, int start, int end) {
        int i = start + 1, j = end;
        int key = targetArr[start];
        if (start >= end) { return targetArr; }

        /*从i++和j--两个方向搜索不满足条件的值并交换
         *条件为：i++方向小于key，j--方向大于key
         */
        while (true) {
//            while (targetArr[j].compareTo(key) > 0) { j--; }
//            while (targetArr[i].compareTo(key) < 0 && i < j) { i++; }
            while (targetArr[j] > key ) { j--; }
            while (targetArr[i] < key && i < j) { i++; }
            if (i >= j) { break; }
            swap(targetArr, i, j);
            if (targetArr[i] == key) {
                j--;
            } else {
                i++;
            }
        }
        /*关键数据放到‘中间’*/
        swap(targetArr, start, j);
        if (start < i - 1) { quickSort2(targetArr, start, i - 1); }
        if (j + 1 < end) { quickSort2(targetArr, j + 1, end); }
        return targetArr;
    }

    public static void swap(int[] targetArr, int i, int j) {
        int temp = targetArr[i];
        targetArr[i] = targetArr[j];
        targetArr[j] = temp;

    }

    /*//////////////方式三：减少交换次数，提高效率/////////////////////*/
//<TextendsComparable<?superT>>
    private static void quickSort3(int[] targetArr, int start, int end) {
        int i = start, j = end;
        int key = targetArr[start];

        while (i < j) {
            /*按j--方向遍历目标数组，直到比key小的值为止*/
//            while (j > i && targetArr[j].compareTo(key) >= 0) {
            while ( j > i && targetArr[j] >= key ) {
                j--;
            }
            if (i < j) {
                /*targetArr[i]已经保存在key中，可将后面的数填入*/
                targetArr[i] = targetArr[j];
                i++;
            }
            /*按i++方向遍历目标数组，直到比key大的值为止*/
//            while (i < j && targetArr[i].compareTo(key) <= 0) {
            while (i < j && targetArr[i] <= key) {
                /*此处一定要小于等于零，假设数组之内有一亿个1，0交替出现的话，而key的值又恰巧是1的话，那么这个小于等于的作用就会使下面的if语句少执行一亿次。*/
                i++;
            }
            if (i < j) {
                /*targetArr[j]已保存在targetArr[i]中，可将前面的值填入*/
                targetArr[j] = targetArr[i];
                j--;
            }
        }
        /*此时i==j*/
        targetArr[i] = key;

        /*递归调用，把key前面的完成排序*/
        quickSort3(targetArr, start, i - 1);

        /*递归调用，把key后面的完成排序*/
        quickSort3(targetArr, j + 1, end);

        }
}