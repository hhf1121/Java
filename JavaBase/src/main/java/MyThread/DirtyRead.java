package MyThread;

/**
 * 多线程-脏读
 *
 * @author hhf
 */

public class DirtyRead {

    private String password = "123";
    private String username = "my";

    public synchronized void setValue(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
        System.out.println("账号密码设置成功：" + this.username + "-" + this.password);
    }

    //set的同时，get的时候，会产生脏读。解决：把get方法加锁。
    public void getValue() {
        System.out.println("获取账号密码：" + this.username + "-" + this.password);
    }

    public static void main(String[] args) throws InterruptedException {
        final DirtyRead dir = new DirtyRead();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                dir.setValue("hhf", "456");
            }
        });


        t1.start();

        Thread.sleep(1000);//在线程没有set完之前，就get。产生脏读

        dir.getValue();
    }


}
