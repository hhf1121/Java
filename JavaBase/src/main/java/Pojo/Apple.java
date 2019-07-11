package Pojo;

import Pojo.FruitColor.Color;
import Util.FruitInfoUtil;


/*	自定义注解类编写的一些规则:
	  1. Annotation型定义为@interface, 所有的Annotation会自动继承java.lang.Annotation这一接口,并且不能再去继承别的类或是接口.
	  2. 参数成员只能用public或默认(default)这两个访问权修饰
	  3. 参数成员只能用基本类型byte,short,char,int,long,float,double,boolean八种基本数据类型和String、Enum、Class、annotations等数据类型,以及这一些类型的数组.
	  4. 要获取类方法和字段的注解信息，必须通过Java的反射技术来获取 Annotation对象,因为你除此之外没有别的获取注解对象的方法
	  5. 注解也可以没有定义成员, 不过这样注解就没啥用了
*/

/* 原理：
 * 注解本质是一个继承了Annotation的特殊接口，其具体实现类是Java运行时生成的动态代理类。
而我们通过反射获取注解时，返回的是Java运行时生成的动态代理对象$Proxy1。
通过代理对象调用自定义注解（接口）的方法，会最终调用AnnotationInvocationHandler的invoke方法。
该方法会从memberValues这个Map中索引出对应的值。而memberValues的来源是Java常量池。
*/

/**
 * 注解使用
 */
public class Apple{
    
    @FruitName("Apple")
    private String appleName;
    
    @FruitColor(fruitColor=Color.RED)
    private String appleColor;
    
    @FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    private String appleProvider;
    
    public Apple(){}
    public Apple(String appleName,String appleColor,String appleProvider){
    	this.appleName=appleName;
    	this.appleColor=appleColor;
    	this.appleProvider=appleProvider;
    }
    
    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }
    public String getAppleColor() {
        return appleColor;
    }
    
    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }
    public String getAppleName() {
        return appleName;
    }
    
    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
    public String getAppleProvider() {
        return appleProvider;
    }
    
    public void displayName(){
        System.out.println("水果的名字是：苹果");
    }

	@Override
	public String toString() {
		return "appleName=" + appleName + ", appleColor=" + appleColor + ", appleProvider=" + appleProvider;
	}
	
    
    
   
}