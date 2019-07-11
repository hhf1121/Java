package Util;

import Pojo.HeroLOL;


/**
 * 启用多线程模式、执行攻击
 * @author hhf
 *
 */
public class killThread extends Thread{
    
    private HeroLOL h1;
    private HeroLOL h2;
 
    //构造方法，初始化对象参数
    public killThread(HeroLOL h1, HeroLOL h2){
        this.h1 = h1;
        this.h2 = h2;
    }
 
    //调用run、异步攻击
    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}