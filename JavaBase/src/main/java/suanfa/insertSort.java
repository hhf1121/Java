package suanfa;

import java.util.Arrays;

/**
 * 插入排序
 * 类似打扑克，发牌
 */
public class insertSort {

    public static void main(String[] args) {
        //时间复杂度是O（n^2），最好的情况是O（n），内圈一直break=====>O(1)
//        int [] a={1,2,0,12,-1,3,4,9,5,6,8};
        int [] a={10,9,8,7,6,5,4,3,2,1};
        for (int i = 1; i < a.length; i++) {//外圈是新发的牌(第一个不用排序)
            int data=a[i];
            int j=i-1;
            for (; j >=0; j--) {//内圈是已经排好的序（从后移动数组）
                if(a[j]>data){//已排好的比新来的大，把排好的往后移
                    a[j+1]=a[j];
                }else {//前面已经是排好序的数组
                    break;
                }
            }
            //内圈结束，a[j+1](老a[i])的位置是当前值
            a[j+1]=data;
            System.out.println("排序第"+i+"圈："+Arrays.toString(a));
        }

    }
}
