package suanfa;


import java.util.Scanner;

/**
 * 某个数，是不是2的n次方
 * 使用&运算
 * &运算：01&10=0（只要对应位置上有一个不一样，就是0、否则就是1）
 */
public class suanfa2 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in) ;
        while (true){
            System.out.println("输入数字：");
            int i = scanner.nextInt();
            if(i<1){
                System.out.println("输入的数字必须大于1，请输入数字：");
                i = scanner.nextInt();
            }
            if(i==-1){
                System.out.println("退出程序");
                break;
            }
            if( (i & (i-1)) ==0 ){
                System.out.println("是2的n次方");
            }else {
                System.out.println("不是2的n次方");
            }
        }
    }
}
