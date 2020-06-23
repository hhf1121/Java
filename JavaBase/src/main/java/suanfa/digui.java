package suanfa;


/**
 * 递归实现
 * 斐波那契  数组
 */
public class digui {

    static int data[];

    //1 1 2 3 5 8 13
    //从第三个数开始，值等于前两个数的和
    //f(n)=f(n-1)+f(n-2)
    public  static  int fab(int i){//时间复杂度和空间复杂度O（2^n）
        if(i<=2)return 1;
        return fab(i-1)+fab(i-2);
    }



    public  static  int fab2(int i){//使用数组缓存计算过的数据，优化时间复杂度和空间复杂度为O（n）
        if(i<=2)return 1;
        if(data[i]>0){
            return data[i];
        }
        int res = fab2(i-1)+fab2(i - 2);
        data[i]=res;
        return res;
    }

    //阶乘的递归
    public static int fabJc(int i){// 5=5*4*3*2*1   ->公式：  n*f(n-1)
        if(i<=1)return 1;
        return fabJc(i-1)*i;
    }

    //尾递归:返回的是函数本身，不再有计算。思路：将上一次(递)的值，传入下一次的调用函数中
    public static int tailFabJc(int n,int res){//res,指的是上一次的结果，上一次的结果就是n*f(n-1)
        System.out.println(n + ":" + res);
        if(n<=1)return res;
        return tailFabJc(n-1,n*res);//倒着算
    }

    //不用递归，用for
    public  static  int NoFab(int i){ //时间复杂度O（n）
        if(i<=2)return 1;
        int f1=1;
        int f2=1;
        int f3=0;
        for (int j = 3; j <= i; j++) {
            f3=f1+f2;
            //每次for、把后面的两个值对应给前面的两个
            f1=f2;
            f2=f3;
        }
        return f3;
    }

    public static void main(String[] args) {

//        for (int i = 0; i < 45; i++) {
//            long start=System.currentTimeMillis();
//            System.out.print(i+":"+NoFab(i)+"->");
//            System.out.println("花费时间："+(System.currentTimeMillis()-start)+"ms");
//        }

        //初始化数组
//        data=new int[46];
//        for (int i = 1; i <= 45; i++) {
//            long start=System.currentTimeMillis();
//            System.out.print(i+":"+fab2(i)+"->");
//            System.out.println("花费时间："+(System.currentTimeMillis()-start)+"ms");
//        }

        int i = tailFabJc(5, 1);//5*4*3*2*1
        System.out.println(i);

    }

}
