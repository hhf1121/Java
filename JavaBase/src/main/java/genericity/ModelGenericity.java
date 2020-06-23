package genericity;

public class ModelGenericity<T extends ModelGenericity> {

    public String toSay(T t){
     return t.toString();
    }

}
