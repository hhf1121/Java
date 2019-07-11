package Pojo;

public class Child extends Father {

	//static方法，不能重写
	 public static void battleWin(){
		 
	        System.out.println("Child battle win");
	    }
	 
	 //父类方法被重写的时候、子类可以扩大访问权限： protected(父)->public(子)
	 public void method1(){
		 
	 }
	 
	 //父类异常方法被重写的时候、子类不能抛出比父类更大的异常
	 public void method2() throws RuntimeException{
		 
	 }
	 
	 //父类fanl方法不能被重写
//	 public void method3(){
//		 
//	 }
	
}
