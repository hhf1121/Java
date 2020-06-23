package genericity;

import Pojo.User;

public class test {

    public static void main(String[] args) {
        MyGenericity myGenericity=new genericity1();
        User u=new User();
        u.setSex("nan");
        u.setName("name");
        User t = (User) myGenericity.getT(u);
        System.out.println(t);
    }
}
