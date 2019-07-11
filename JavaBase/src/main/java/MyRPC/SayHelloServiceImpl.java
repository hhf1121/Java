package MyRPC;

public class SayHelloServiceImpl implements SayHelloService{

    public String sayHello(String[] arg1) {
    	for (int i = 0; i < arg1.length; i++) {
    		if("hello".equals(arg1[i])&&"hhf".equals(arg1[i+1])){
    			return "hello,hhf!";
    		}
		}
        return "bye bye,you are not hhf";
    }
}