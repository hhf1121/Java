package test;

import java.io.Serializable;

public class Hero implements Serializable{
    
	private static final long serialVersionUID = 1L;

	String name; //姓名
    
    static int i;
    
    float hp; //血量
        
    float armor; //护甲
        
    int moveSpeed; //移动速度
     
    public Hero(){
         
    }
     
    public Hero(String name,float hp){
        this.name = name;
        this.hp = hp;
    }
 
    //复活
    public void revive(Hero h){
        h = new Hero("提莫",383);
    }
 
    public void finalize(){
    	i++;
        System.out.println("这个对象正在被回收===="+i);
    }
    

	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + ", armor=" + armor + ", moveSpeed=" + moveSpeed + "]";
	}
	
	public static void main(String[] args) {
		Hero teemo =  new Hero("提莫",383);
		
		//受到400伤害，挂了
		teemo.hp = teemo.hp - 400;
		
		teemo.revive(teemo);
		//问题： 输出多少？ 怎么理解？
		System.out.println(teemo.hp); 
		
	}
      
}