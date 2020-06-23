package genericity;

import Pojo.User;

public class ModelA extends ModelGenericity<ModelA> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ModelA{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String toSay(ModelA modelA) {
        ModelA a=new ModelA();
        return a.getName();
    }

    public static void main(String[] args) {
        ModelGenericity modelA =new  ModelGenericity<ModelA>();
        ModelA a=new ModelA();
        a.setName("我是ModelA");
        String s = modelA.toSay(a);
        System.out.println(s);
    }
}
