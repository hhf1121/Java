package Pojo;

public class HeroLOL {
	
	    public String name;
	    public  float hp;
	     
	    public int damage;
	     
	    
	  //回血
	    public synchronized void recover(){
	    	 hp = hp + 1;
	         // 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
	         this.notify();
	    }
	     
	    //掉血
	    public synchronized void hurt(){
	    	 if (hp == 1) {
	             try {
	                 // 让占有this的减血线程，暂时释放对this的占有，并等待
	                 this.wait();
	             } catch (InterruptedException e) {
	                 e.printStackTrace();
	             }
	         }
	         hp = hp - 1;
	    }
	    
	    
	    
	    public void attackHero(HeroLOL h) {
	        try {
	            //为了表示攻击需要时间，每次攻击暂停1000毫秒
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        h.hp-=damage;
	        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
	         
	        if(h.isDead())
	            System.out.println(h.name +"死了！");
	    }
	 
	    public boolean isDead() {
	        return 0>=hp?true:false;
	    }
}

