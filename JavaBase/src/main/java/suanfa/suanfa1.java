package suanfa;

import java.util.Scanner;

public class suanfa1 {

    private static int length;

    public static void main(String[] args) {
        //N个数，在length之内
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入数值范围");
        length=scanner.nextInt();
        int a[]=new int[length];
        System.out.println("输入数字个数");
        int num=scanner.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println("输入具体数字");
            int n = scanner.nextInt();
            a[n]=1;
        }
        System.out.println("输入某个数字，判断在不在"+num+"个数里面");
        if(a[scanner.nextInt()]==1){
            System.out.println("在");
        }else {
            System.out.println("不在");
        }
        //用空间换时间、时间复杂度O(1)

    }

}
