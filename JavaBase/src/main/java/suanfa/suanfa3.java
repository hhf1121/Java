package suanfa;

import java.util.Arrays;

/**
 * 插入排序
 * 选择排序
 * 冒泡排序
 * 归并排序
 * 快速排序
 *
 */
public class suanfa3 {

    public static  int array [] = {1,2,8,9,12,3,-1,5,11,0,6};
//    public static  int array [] = {1,2,3,4,5,6};

    /**
     * 冒泡，相邻两位互换位置，每次选出一个最值
     * 交换次数过多的优化思路：
     * 当没有任何交换的时候，证明每个数值都在自己应该在的位置，break掉。
     */
    public static void maopaoSort(){
        int n=0;
        for (int i = 0; i < array.length - 1; i++) {//排序次数
            boolean flag=false;
            for (int j = 0; j < array.length - 1 - i; j++) {//开始排序,每次选出一个最值，下一轮排序就少比较一次
                if(array[j]>array[j+1]){//如果前面的一位大于后面的，进行冒泡操作。（交换位置或加法四则运算）
                    //1.开辟一个新变量，交换值
//                    int temp= array[j];
//                    array[j]=array[j+1];//j+1小于j，把j+1往前移。
//                    array[j+1]=temp;
                    //2.加法四则运算，避免开辟新变量
                    array[j]=array[j]+array[j+1];  // A=A+B
                    array[j+1]=array[j]-array[j+1];// B=A-B;
                    array[j]=array[j]-array[j+1];  // A=A-B
                    flag=true;//有交换
                }
            }
            System.out.println("第次"+(++n)+"排序："+Arrays.toString(array));
            if(!flag)break;
        }
    }


    /**
     *  快速排序(右小,左大)然后交换位置（目的是要讲数组换成，左小右大）
     *  定一个基准值（进行比较），类似二分
     * @param data  排序数值
     * @param left   最左边的位置
     * @param right  最右边的位置
     */
    public static void quickSort(int data[],int left,int right){
        //取第一个值为基准值
        int base=data[left];
        System.out.println("基准值："+base);
        int L=left;//左位置
        int R=right;//右位置
        //正常情况下：左小于右。
        while (L<R){
            //从右边开始找：右边不比基准值小的时候，一直找下去。
            while (L<R && data[R]>=base){
                R--;//右边倒着找.
            }
            if(L<R){//在右边找到了比基准值小的值，进行交换。
                System.out.println("右："+Arrays.toString(data));
                int temp=data[R];
                data[R]=data[L];
                data[L]=temp;
                L++;//交换之后，从左边接着找，左边的下标需要++
            }
            //正常情况下：左小于右。从左边开始找：左边不比基准值大的时候，一直找下去。
            while (L<R && data[L]<=base){
                L++;//左边正着找.
            }
            if(L<R){//在左边找到了比基准值大的值，进行交换。
                System.out.println("左："+Arrays.toString(data));
                int temp=data[R];
                data[R]=data[L];
                data[L]=temp;
                R--;//交换之后，从右边接着找，右边的下标需要--
            }
        }
        //找完之后，分成了三部分：[{left},base,{right}]，左右需求继续快排
        //这个时候L=R,是base的位置。
        // 递归，重复下去。
        if(left<L) quickSort(data,left,L-1);//递归{left}
        if(L<right)quickSort(data,L+1,right);//递归{right}
    }


    /**
     * 插入排序（例如：打扑克的时候，发牌的过程）
     *  1.将数组分成已排序段和未排序段。初始化时已排序端只有一个元素
     * 	 2.到未排序段取元素插入到已排序段，并保证插入后仍然有序
     * 	 3.重复执行上述操作，直到未排序段元素全部加完。
     */
    public static void insterSort(){
        int n = array.length;
        //这里面会有几层循环 2
        //时间复杂度：n^2
        //最好的情况：什么情况下：O(n); O(1)
        //for(){		//分段
        for(int i = 1 ; i < n;i++){		//为什么i要从1开始？ 第一个不用排序，我们就把数组从i分开，0~I的认为已经排好序
            int data = array[i];
            int j = i -1;
            for(;j>=0;j--){//从尾到头 1+2+3+4+5+...+n=>
                if(array[j] > data){
                    array[j+1] = array[j];		// 数据往后移动
                }else{	//因为前面已经是排好序的 那么找到一个比他小的就不用找了，因为前面的肯定更小
                    break; //O(1)		如果这个break执行的越多 那么我是不是效率就越高?
                }
            }
            array[j+1] = data;
            System.out.print("第" +i +"次的排序结果为：");
            for(j = 0 ; j < n;j++){
                System.out.print(array[j]+" ");
            }
            System.out.println();
        }
    }


    /**
     * 归并排序
     * @param data
     * @param left
     * @param right
     */
    public static void megerSort(int data[], int left, int right) { // 数组的两端
        if (left < right) { // 相等了就表示只有一个数了 不用再拆了
            int mid = (left + right) / 2;
            megerSort(data, left, mid);
            megerSort(data, mid + 1, right);
            // 分完了 接下来就要进行合并，也就是我们递归里面归的过程
            meger(data, left, mid, right);
            System.out.println(Arrays.toString(data));
        }
    }

    /**
     * 归并排序，归的过程。
     * @param data
     * @param left
     * @param mid
     * @param right
     */
    public static void meger(int data[], int left, int mid, int right) {
        int temp[] = new int[data.length];		//借助一个临时数组用来保存合并的数据

        int point1 = left;		//表示的是左边的第一个数的位置
        int point2 = mid + 1;	//表示的是右边的第一个数的位置

        int loc = left;		//表示的是我们当前已经到了哪个位置了
        while(point1 <= mid && point2 <= right){
            if(data[point1] < data[point2]){
                temp[loc] = data[point1];
                point1 ++ ;
                loc ++ ;
            }else{
                temp[loc] = data[point2];
                point2 ++;
                loc ++ ;
            }
        }
        //接下来要干嘛呢？合并排序完成 了吗？
        while(point1 <= mid){
            temp[loc ++] = data[point1 ++];
        }
        while(point2 <= right){
            temp[loc ++] = data[point2 ++];
        }
        for(int i = left ; i <= right ; i++){
            data[i] = temp[i];
        }
    }

    /**
     * 选择排序
     * 比较值，每一次选出一个最大的值。
     * @param a
     */
    public static void chooseSort(int[] a) {
        int max = 0;
        int index = 0;
        //外层循环，控制选择的次数，数组长度为n，一共需要选择n-1次
        for(int i=0;i<a.length-1;i++) {
            for(int j=0;j<a.length-i;j++) {
                if(max < a[j]) {
                    max = a[j];
                    index = j;//记录当前的下标位置
                }
            }
            //每次选择完成后，max中存放的是该轮选出的最大值
            //将max指向位置的元素和数组最后一个元素位置互换
            int temp = a[a.length-i-1];
            a[a.length-i-1] = max;
            a[index] = temp;
            //清空max和index，便于下次
            max=0;
            index =0;
            System.out.println("经过第"+(i+1)+"轮选择后，数组为"+Arrays.toString(a));
        }
    }


    public static void main(String[] args) {
//        megerSort(array,0,array.length-1);
        chooseSort(array);
    }

}
