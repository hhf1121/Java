package test;

public class test implements  Runnable{
    static volatile String i="123";

//    Object o=new Object();

    public static void main(String[] args) throws InterruptedException {
       Thread t=new Thread(new test());
       t.start();
//       Thread.sleep(100);
       getI(i);
    }

    public   void setI(String i){
        this.i=i;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.i);
    }


   public  static void getI(String i){

        System.out.println(i);
    }


    @Override
    public void run() {
        setI("321");
    }
}
