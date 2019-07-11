package test;

import Pojo.HeroLOL;
import Pojo.ThreadPool;
import Util.killThread;

public class HeroLOLtest {
	
	/**
	 * 非多线程(同步)方式
	 */
	static void NoThread(){
		 HeroLOL gareen = new HeroLOL();
	      gareen.name = "盖伦";
	      gareen.hp = 616;
	      gareen.damage = 50;

	      HeroLOL teemo = new HeroLOL();
	      teemo.name = "提莫";
	      teemo.hp = 300;
	      teemo.damage = 30;
	       
	      HeroLOL bh = new HeroLOL();
	      bh.name = "赏金猎人";
	      bh.hp = 500;
	      bh.damage = 65;
	       
	      HeroLOL leesin = new HeroLOL();
	      leesin.name = "盲僧";
	      leesin.hp = 455;
	      leesin.damage = 80;
	       
	      //盖伦攻击提莫
	      while(!teemo.isDead()){
	          gareen.attackHero(teemo);
	      }

	      //赏金猎人攻击盲僧
	      while(!leesin.isDead()){
	          bh.attackHero(leesin);
	      }
	}
	
	//异步、多线程方式
	static void IsThread(){
		 HeroLOL gareen = new HeroLOL();
	      gareen.name = "盖伦";
	      gareen.hp = 616;
	      gareen.damage = 50;

	      HeroLOL teemo = new HeroLOL();
	      teemo.name = "提莫";
	      teemo.hp = 300;
	      teemo.damage = 30;
	       
	      HeroLOL bh = new HeroLOL();
	      bh.name = "赏金猎人";
	      bh.hp = 500;
	      bh.damage = 65;
	       
	      HeroLOL leesin = new HeroLOL();
	      leesin.name = "盲僧";
	      leesin.hp = 455;
	      leesin.damage = 80;
	      
	      killThread kt=new killThread(gareen, leesin);//盖伦攻击盲僧
	      kt.start();
	      killThread kt2=new killThread(teemo, bh);//提莫攻击赏金猎人
	      kt2.start();
	}
	
	//匿名
	static void NoNameThread(){
		 HeroLOL gareen = new HeroLOL();
	      gareen.name = "盖伦";
	      gareen.hp = 616;
	      gareen.damage = 50;

	      HeroLOL teemo = new HeroLOL();
	      teemo.name = "提莫";
	      teemo.hp = 300;
	      teemo.damage = 30;
	       
	      HeroLOL bh = new HeroLOL();
	      bh.name = "赏金猎人";
	      bh.hp = 500;
	      bh.damage = 65;
	       
	      HeroLOL leesin = new HeroLOL();
	      leesin.name = "盲僧";
	      leesin.hp = 455;
	      leesin.damage = 80;
	      
	      Thread t1=new Thread(){
	    	@Override
	    	public void run() {
	    		while(!gareen.isDead()){
	    			teemo.attackHero(gareen);
	    		}
	    	}  
	      };
	      t1.start();
	      
	      Thread t2=new Thread(){
	    	@Override
	    	public void run() {
	    		while(!bh.isDead()){
	    			leesin.attackHero(bh);
	    		}
	    	}  
	      };
	      t2.start();
	}
	
	//加锁的异步
	static void method1() throws Exception{
		   HeroLOL gareen = new HeroLOL();
		   gareen.name = "盖伦";
		   gareen.hp = 10000;
	        System.out.printf("盖伦的初始血量是 %.0f%n", gareen.hp);
	        //多线程同步问题指的是多个线程同时修改一个数据的时候，导致的问题
	        //假设盖伦有10000滴血，并且在基地里，同时又被对方多个英雄攻击
	        //用JAVA代码来表示，就是有多个线程在减少盖伦的hp
	        //同时又有多个线程在恢复盖伦的hp
	        //n个线程增加盖伦的hp
	           
	        int n = 10000;
	        Thread[] addThreads = new Thread[n];
	        Thread[] reduceThreads = new Thread[n];
	           
	        for (int i = 0; i < n; i++) {
	            Thread t = new Thread(){
	                public void run(){
	                    gareen.recover();
	                }
	            };
	            t.start();
	            addThreads[i] = t;
	        }
	           
	        //n个线程减少盖伦的hp
	        for (int i = 0; i < n; i++) {
	            Thread t = new Thread(){
	                public void run(){
	                	gareen.hurt();
	                }
	            };
	            t.start();
	            reduceThreads[i] = t;
	        }
	           
	        //等待所有增加线程结束
	        for (Thread t : addThreads) {
	                t.join();
	        }
	        //等待所有减少线程结束
	        for (Thread t : reduceThreads) {
	                t.join();
	        }
	        //代码执行到这里，所有增加和减少线程都结束了
	        //增加和减少线程的数量是一样的，每次都增加，减少1.
	        //那么所有线程都结束后，盖伦的hp应该还是初始值
	        //但是事实上观察到的是：
	        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n", n,n,gareen.hp);
	    }
	
	//死锁      互相等待
	static void method2(){
		final HeroLOL ahri = new HeroLOL();
        ahri.name = "九尾妖狐";
        final HeroLOL annie = new HeroLOL();
        annie.name = "安妮";
        
        Thread t1 = new Thread(){
            public void run(){
                //占有九尾妖狐
                synchronized (ahri) {
                    System.out.println("t1 已占有九尾妖狐");
                    try {
                        //停顿1000毫秒，另一个线程有足够的时间占有安妮
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                     
                    System.out.println("t1 试图占有安妮");
                    System.out.println("t1 等待中 。。。。");
                    synchronized (annie) {
                        System.out.println("do something");
                    }
                }  
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run(){
                //占有安妮
                synchronized (annie) {
                    System.out.println("t2 已占有安妮");
                    try {
                        //停顿1000秒，另一个线程有足够的时间占有暂用九尾妖狐
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2 试图占有九尾妖狐");
                    System.out.println("t2 等待中 。。。。");
                    synchronized (ahri) {
                        System.out.println("do something");
                    }
                }  
            }
        };
        t2.start();
	}
	
	
	//交互
	static void method3(){
		    HeroLOL gareen = new HeroLOL();
	        gareen.name = "盖伦";
	        gareen.hp = 116;
	           
	        Thread t1 = new Thread(){
	            public void run(){
	                while(true){
//	                	System.out.println("----"+gareen.hp);
	                    //因为减血更快，所以盖伦的血量迟早会到达1
	                	gareen.hurt();
	                    System.out.printf("t1 为%s 减血1点,减少血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
	                    try {
	                        Thread.sleep(10);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                
	                }
	            }
	        };
	        t1.start();
	        Thread t2 = new Thread(){
	            public void run(){
	                while(true){
	                	//System.out.println("--============--"+gareen.hp);
	                    gareen.recover();
	                    System.out.printf("t2 为%s 回血1点,增加血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
	                    try {
	                        Thread.sleep(50);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	 
	            }
	        };
	        t2.start();
	}	
	
	//线程池
	static void methodThreadPool(){
		 ThreadPool pool = new ThreadPool();
	        for (int i = 0; i < 5; i++) {
	            Runnable task = new Runnable() {
	                @Override
	                public void run() {
	                    System.out.println("执行任务");
	                    //任务可能是打印一句话
	                    //可能是访问文件
	                    //可能是做排序
	                }
	            };
	            pool.add(task);
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
	
	public static void main(String[] args) throws Exception {
//		NoThread();//同步
//		IsThread();//异步
//		NoNameThread();//匿名线程
		method3();
//		methodThreadPool();
	}
	 
  }

