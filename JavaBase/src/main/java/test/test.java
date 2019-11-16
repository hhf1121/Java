package test;

public class test  {


    public static void main(String[] args) throws InterruptedException {
        String str=null;
        for (int i = 0; i < 3; i++) {
            if(null==str){
                str +=i;// null0
            }else{
                str +=","+i;// null0,1,2
            }
        }
        System.out.println(str);
        String a=null;
        System.out.println(a+23);
    }



}
