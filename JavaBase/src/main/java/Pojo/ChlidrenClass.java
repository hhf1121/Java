package Pojo;

public class ChlidrenClass extends SupperClass {

	
	//重写     参数必须一致     返回值一致   不能抛出比父类函数更大的异常    修饰符不小于父类函数的修饰符
	@Override
	public double a(int a) throws RuntimeException {
		return a;
	}

	
	
}
