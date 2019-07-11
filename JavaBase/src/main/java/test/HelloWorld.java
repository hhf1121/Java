package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.jdbc.AtomikosDataSourceBean;

import Impl.BookFacadeImpl;
import Pojo.Apple;
import Pojo.BookFacade;
import Pojo.Child;
import Pojo.Child2;
import Pojo.ConnectionPool;
import Pojo.Father;
import Pojo.HeroChecker;
import Pojo.JDBCConfig;
import Pojo.Season;
import Util.BookFacadeProxy;
import Util.FruitInfoUtil;
import designModel.Adapter;
import designModel.Adapter2;
import designModel.Builder;
import designModel.Decorator;
import designModel.DecoratorSource;
import designModel.Provider;
import designModel.SendFactory;
import designModel.SendMailFactory;
import designModel.Sender;
import designModel.Singleton;
import designModel.Source;
import designModel.Sourceable;
import designModel.Targetable;

public class JavaMain {
	
	/**
	 * 成员属性和内部类
	 */
	 private String name; // 姓名
	 
	 private static String sname; //静态名字
	 
	 private  static  List<Integer> list= new ArrayList<Integer>();
	 
	 float hp; // 血量
	 
	    float armor; // 护甲
	 
	    int moveSpeed; // 移动速度
	 
	    // 非静态内部类，只有一个外部类对象存在的时候，才有意义
	    class BattleScore {
	        int kill;
	        int die;
	        int assit;
	 
	        public void legendary() {
	            if (kill >= 8)
	                System.out.println(name + "超神！");
	            else
	                System.out.println(name + "尚未超神！");
	        }
	    }

	    /**
	     * 静态内部类
	     * @author hhf
	     *
	     *		因为没有一个外部类的实例，所以在静态内部类里面不可以访问外部类的实例属性和方法
		 *	  	除了可以访问外部类的私有静态成员外，静态内部类和普通类没什么大的区别
	     */
	    static class EnemyCrystal{
	        int hp=5000;
	        public void checkIfVictory(){
	            if(hp==5000){
					JavaMain.method1();
	                //静态内部类不能直接访问外部类的对象属性，但能访问类属性
	                System.out.println(sname + " win this game");
	            }
	        }
	    }
	    
	    
	//内部静态类、记录窗口位置
	static class lol03 {
		static int x;
		static int y;
		static JFrame f = new JFrame("lol");
		static File f1 = new File("f:/窗口坐标.txt");

		public lol03() {
			f.setSize(400, 300);
			if (f1.length() == 0) { // txt中没有值，窗口出现位置600,600
				f.setLocation(600, 600);
			} else { // 否则就读取txt，并取其中的值作为出现位置。
				try (FileReader fe = new FileReader(f1);) {
					char[] all = new char[(int) f1.length()];
					fe.read(all);
					String st = String.valueOf(all);
					String ss[] = st.split("@"); // ss-0是上次保存的坐标x，ss-1是上次保存的坐标y
					f.setLocation(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
					fe.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			f.setLayout(null);
			JButton b = new JButton("一键秒对方基地挂");
			b.setBounds(50, 50, 280, 30);
			f.add(b);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
		}
	}
	
	    //======================================================
	    
	/**
	 * 重载函数a   ：返回值无关、参数有关
	 * @param a
	 * @return
	 */
	public double a(int a){
		return a;
	}
	
	public int a(int a,int b){
		return a;
	}
	
	public void a(int a,double b){
	}
	//==========================================
	/**
	 * 枚举
	 */
	static void method1(){
		 Season season = Season.WINTER;
	     switch (season) {
	     case SPRING:
	         System.out.println("春天");
	         break;
	     case SUMMER:
	         System.out.println("夏天");
	         break;
	     case AUTUMN:
	         System.out.println("秋天");
	         break;
	     case WINTER:
	         System.out.println("冬天");
	         break;
	     }
	     //遍历枚举的values
	     for (Season s: Season.values()) {
				System.out.println("枚举类的value："+s+"\n");
			}
	 }
	
	//通过反射改变String类(final)的初始值
	static void method2() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		String oldStr="abc";
		System.out.println("oldStr初始值："+oldStr);
		//通过反射，获取String类的value字段
		Field declaredField = String.class.getDeclaredField("value");
		//改变访问权限
		declaredField.setAccessible(true);
		//获取oldStr对应的char[]的值
		char [] str = (char [])declaredField.get(oldStr);
		//改变value中下标为1的值。
		str[1]='B';
		System.out.println("进过反射之后，改变了oldStr(String类型)的值："+oldStr);
	}
	
	
	
	//字符串连接
	static void method3(){
		System.out.println("1"+(1+2));
		System.out.println("1"+1+2);
		System.out.println(1+1+"2");
	}
	
	//验证静态方法不能被覆盖
	static void method4(){
		Father.battleWin();
		Child.battleWin();
		Father ch=new Child();
		ch.battleWin();//执行Father的类方法：静态方法不会被覆盖
	}
	
	//验证虚拟机垃圾回收
	static void method5(){
		Hero h=new Hero();
		for (int i = 0; i < 10000; i++) {
			h=new Hero();
		}
	}
	
	//BigDecimal取整测试
	static void method6() {
		BigDecimal b = new BigDecimal("2.229991");
		BigDecimal setScale = b.setScale(3, BigDecimal.ROUND_DOWN);
		System.out.println(setScale);
	}
	//运算符    异或：^   断路且&&  断路或||
	static void method7() {
		int i = 1;
		boolean b = !(i++ == 3) ^ (i++ == 2) && (i++ == 3);
		System.out.println(b);
		System.out.println(i);
	}
	
	//验证内部类
	static void method8(){
		JavaMain garen = new JavaMain();
	        garen.name = "盖伦";
	        // 实例化内部类
	        // BattleScore对象只有在一个英雄对象存在的时候才有意义
	        // 所以其实例化必须建立在一个外部类对象的基础之上
	        BattleScore score = garen.new BattleScore();
	        score.kill = 9;
	        score.legendary();
	}
	
	//验证静态内部类
	static void method9(){
		//实例化静态内部类
		JavaMain.EnemyCrystal crystal = new JavaMain.EnemyCrystal();
        crystal.checkIfVictory();
	}
	
	// break标记
	static void method10() {
		a: // break 的标记
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 5) {
					break a;
				}
				System.out.println("i:" + i + "=========j:" + j);
			}
		}
	}
	
	//   printf/format格式化
	static void method11() {
		String name = "盖伦";
		int kill = 8;
		String title = "超神";
		String sentenceFormat = "%s 在进行了连续 %d 次击杀后，获得了 %s 的称号%n";
		// 使用printf格式化输出
		System.out.printf(sentenceFormat, name, kill, title);
		// 使用format格式化输出
		System.out.format(sentenceFormat, name, kill, title);
	}
	
	// String类
	static void method12() {
		// 创建了一个新的字符串"the light"
		// 编译器发现已经存在现成的"the light"，那么就直接拿来使用，而没有进行重复创建
		String str1 = "the light";
		String str2 = "the light";
		String str3 = new String("the light");
		System.out.println(str1 == str3);// 比较对象
		System.out.println(str1 == str2);// 比较对象
		System.out.println(str1.equals(str3));// 比较内容
		System.out.println("----------分割线-----------");
		String A = "123";
		String C = A;
		System.out.println(A == C);
		A = "456";
		System.out.println(A == C);
		// String srt=new String("hello");
		// 上面的语句中变量 str 放在栈上，用 new 创建出来的字符串对象放在堆上，而"hello"这个字面量是放在方法区
		
		System.out.println("--------------------------------------------");
		String a = "ab";// 创建了一个对象，并加入字符串池中
		System.out.println("String a = \"ab\";");
		String b = "cd";// 创建了一个对象，并加入字符串池中
		System.out.println("String b = \"cd\";");
		String c = "abcd";// 创建了一个对象，并加入字符串池中

		String d = "ab" + "cd";
		
		if (d == c) {// 如果d和c指向了同一个对象，则说明d也被加入了字符串池
			System.out.println("\"ab\"+\"cd\" 创建的对象 加入了 字符串池中");
		}else {// 如果d和c没有指向了同一个对象，则说明d没有被加入字符串池
			System.out.println("\"ab\"+\"cd\" 创建的对象 没加入 字符串池中");
		}

		String e = a + "cd";
		
		if (e == c) {// 如果e和c指向了同一个对象，则说明e也被加入了字符串池
			System.out.println("a +\"cd\" 创建的对象 加入了 字符串池中");
		}
		else {// 如果e和c没有指向了同一个对象，则说明e没有被加入字符串池
			System.out.println("a +\"cd\" 创建的对象 没加入 字符串池中");
		}

		String f = "ab" + b;
		
		if (f == c) {// 如果f和c指向了同一个对象，则说明f也被加入了字符串池
			System.out.println("\"ab\"+ b 创建的对象 加入了 字符串池中");
		}else {// 如果f和c没有指向了同一个对象，则说明f没有被加入字符串池
			System.out.println("\"ab\"+ b 创建的对象没加入 字符串池中");
		}

		String g = a + b;
		if (g == c) {// 如果g和c指向了同一个对象，则说明g也被加入了字符串池
			System.out.println("a + b 创建的对象 加入了 字符串池中");
		}else {// 如果g和c没有指向了同一个对象，则说明g没有被加入字符串池
			System.out.println("a + b 创建的对象 没加入 字符串池中");
		}
	}
	
	//Calendar类
	static void method13(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
        Date now = c.getTime();
        // 当前日期
        System.out.println("当前日期：\t" + sdf.format(c.getTime()));
        // 下个月的今天
        c.setTime(now);
        c.add(Calendar.MONTH, 1);
        System.out.println("下个月的今天:\t" +sdf.format(c.getTime()));
        // 去年的今天
        c.setTime(now);
        c.add(Calendar.YEAR, -1);
        System.out.println("去年的今天:\t" +sdf.format(c.getTime()));
        // 上个月的第三天
        c.setTime(now);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DATE, 3);
        System.out.println("上个月的第三天:\t" +sdf.format(c.getTime()));
	}
	
	// 输入流
	static void method14() throws IOException{
		File f=new File("F:/环境变量.txt");
		FileInputStream fs=new FileInputStream(f);
		byte[] b=new byte[(int)f.length()];
		fs.read(b);
		for (byte c : b) {
			System.out.print((char)c);
		}
		fs.close();
	}
	
	// 输出流
	static void method15() throws IOException {
		File f = new File("F:/test/环境变量1.txt");
		File ft=new File("F:/test/环境变量1.txt".substring(0, "F:/test/环境变量1.txt".indexOf("环")));
		if(!ft.exists()){
			ft.mkdirs();
		}
		FileOutputStream fs = new FileOutputStream(f,true);
		byte[] b = "新建的文件，输入文字：test".getBytes();
		fs.write(b);
		fs.close();
		System.out.println("写入成功...");
	}
	
	//对象流写
	static void method16(){
		//创建一个Hero garen
        //要把Hero对象直接保存在文件上，务必让Hero类实现Serializable接口
        Hero h = new Hero();
        h.name = "garen";
        h.hp = 616;
        //准备一个文件用于保存该对象
        File f =new File("f:\\testObject.lol");
        try(
            //创建对象输出流
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            //创建对象输入流              
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois =new ObjectInputStream(fis);
        ) {
            oos.writeObject(h);
            Hero h2 = (Hero) ois.readObject();
            System.out.println(h2.name);
            System.out.println(h2.hp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	//对象流 读
	static void method17() throws Exception{
		FileInputStream f =new FileInputStream("f:\\testObject.lol");
		ObjectInputStream os=new ObjectInputStream(f);
		Hero readObject = (Hero)os.readObject();
		System.out.println(readObject.name+"==="+readObject.hp);
		os.close();
		f.close();
	}
	
	//打印输入流
	static void method18(){
		 // 控制台输入
        try (InputStream is = System.in;) {
            while (true) {
                // 敲入a,然后敲回车可以看到
                // 97 13 10
                // 97是a的ASCII码
                // 13 10分别对应回车换行
                int i = is.read();
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * 	如果希望只取出，不插入，就使用? extends Hero
	 *  如果希望只插入，不取出，就使用? super Hero
	 *  如果希望，又能插入，又能取出，就不要用通配符？
	 *  
	 */
	//泛型1<? extends Father> 如果希望只取出，不插入，就使用
	static void method19(){
		ArrayList<Child> apHeroList = new ArrayList<Child>();
        apHeroList.add(new Child());
        //? extends Father 表示这是一个Father泛型的子类泛型,包括Father
        ArrayList<? extends Father> heroList = apHeroList;
        //heroList 的泛型可以是Father
        //heroList 的泛型可以是Child
        //heroList 的泛型可以是Child2
          
        //可以确凿的是，从heroList取出来的对象，一定是可以转型成Father的
        Father h= heroList.get(0);
          
        //但是，不能往里面放东西
        //heroList.add(new Child()); //编译错误，因为heroList的泛型 有可能是Child2
	}
	
	//泛型2<? super Father>  如果希望只插入，不取出，就使用
	static void method20(){
		//? super Father 表示 heroList的泛型是Father或者其父类泛型或Object
		ArrayList<? super Father> heroList = new ArrayList<Father>();
        //heroList 的泛型可以是Father
        //heroList 的泛型可以是Object
        //所以就可以插入Father
        heroList.add(new Father());
        //也可以插入Father的子类
        heroList.add(new Child());
        heroList.add(new Child2());
          
        //但是，不能从里面取数据出来,因为其泛型可能是Object,而Object是强转Father会失败
        //Father h= heroList.get(0); //编译错误
	}
	
	//泛型3  通配符<?>
	static void method21(){
		 ArrayList<Child> apHeroList = new ArrayList<Child>();
	        //?泛型通配符，表示任意泛型
	        ArrayList<?> generalList = apHeroList;
	        //generalList.add(apHeroList);//编译错误  不能插入
	 
	        //?的缺陷1： 既然?代表任意泛型，那么换句话说，你就不知道这个容器里面是什么类型
	        //所以只能以Object的形式取出来
	        Object o = generalList.get(0);
	 
	        //?的缺陷2： 既然?代表任意泛型，那么既有可能是Hero,也有可能是Item
	        //所以，放哪种对象进去，都有风险，结果就什么什么类型的对象，都不能放进去
	        //generalList.add(new Hero()); //编译错误 因为?代表任意泛型，很有可能不是Hero
	        //generalList.add(new Father()); //编译错误 因为?代表任意泛型，很有可能不是Father
	        //generalList.add(new Child()); //编译错误  因为?代表任意泛型，很有可能不是Child
	}
	
	//泛型容器转换
	static void method22(){
		   ArrayList<Father> hs =new ArrayList<>();
	        ArrayList<Child> adhs =new ArrayList<>();
	        //假设能转换成功
	        //hs = adhs;  //编辑错误
	        //作为Hero泛型的hs,是可以向其中加入APHero的
	        //但是hs这个引用，实际上是指向的一个ADHero泛型的容器
	        //如果能加进去，就变成了ADHero泛型的容器里放进了APHero，这就矛盾了
	        hs.add(new Child2());
	}
	
	//Lambda方式
	static void method23(){
		 Random r = new Random();
	        List<Hero> heros = new ArrayList<Hero>();
	        for (int i = 0; i < 5; i++) {
	            heros.add(new Hero("hero " + i, r.nextFloat()*100));
	        }
	        System.out.println("初始化后的集合：");
	        System.out.println(heros);
	        System.out.println("使用Lamdba的方式，筛选出 hp>100 && damange<50的英雄");
	        filter(heros,h-> h.hp>50);
	}
	
	//Lambda表达式的演变
	static void method24(){
		List<Hero> heros = new ArrayList<Hero>();
		   // 匿名类的正常写法c1
        HeroChecker c1 = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp > 100 && h.hp < 50);
            }
        };
        // 把new HeroChcekcer，方法名，方法返回类型信息去掉  c2
        // 只保留方法参数和方法体
        // 参数和方法体之间加上符号 ->
        HeroChecker c2 = (Hero h) -> {
            return h.hp > 100 && h.hp < 50;
        }; 
        // 把return和{}去掉  c3
        HeroChecker c3 = (Hero h) -> h.hp > 100 && h.hp < 50;
        // 把 参数类型和圆括号去掉  c4
        HeroChecker c4 = h -> h.hp > 100 && h.hp < 50;
        // 把c4作为参数传递进去
        filter(heros, c4);
        // 直接把表达式传递进去
        filter(heros, h -> h.hp > 100 && h.hp < 50);
	}
	
	//java1.8 新特性：流式处理  lamda
	static void method25(){
		List<String> list=new ArrayList<>();
		for (int i=0;i<5;i++) {
			list.add("String"+i);
		}
		//流式处理、过滤、遍历
		list.stream().filter(a->!a.endsWith("1")).forEach(b->System.out.println(b));
		System.out.println("================分割线=================");
		List<Hero> heros=new ArrayList<>();
		Random r=new Random();
		for (int i = 0; i < 5; i++) {
			float nextFloat = r.nextFloat();
			heros.add(new Hero("name"+i,nextFloat*100));
		}
		heros.add(heros.get(0));//添加一个重复的对象
		heros.stream().filter(a->a.hp>60||a.name.endsWith("2")).forEach(a->System.out.println(a));//遍历符合条件
		System.out.println("--------------分割线：去重----------------");
		System.out.println("list的size："+heros.size());
		heros.stream().distinct().forEach(a->System.out.println(a));//去重
		System.out.println("--------------分割线：去重之后排序----------------");
		heros.stream().distinct().sorted((a,b)->a.hp>b.hp?1:-1).forEach(c->System.out.println(c));//排序
		System.out.println("--------------分割线：不去重但忽略前3个----------------");
		heros.stream().skip(3).forEach(a->System.out.println(a));//忽略
		System.out.println("--------------分割线：不去重保留3个----------------");
		heros.stream().limit(3).forEach(a->System.out.println(a));//保留
	}
	
	//jdbc数据库连接
	static void method26(int i,int j) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");//加载驱动
		//创建数据库连接
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/books?characterEncoding=UTF-8","root","feixiang");
		//功能1：查看数据库元数据
		DatabaseMetaData metaData = con.getMetaData();
		 // 获取数据库服务器产品名称
        System.out.println("数据库产品名称:\t"+metaData.getDatabaseProductName());
        // 获取数据库服务器产品版本号
        System.out.println("数据库产品版本:\t"+metaData.getDatabaseProductVersion());
        // 获取数据库服务器用作类别和表名之间的分隔符 如test.user
        System.out.println("数据库和表分隔符:\t"+metaData.getCatalogSeparator());
        // 获取驱动版本
        System.out.println("驱动版本:\t"+metaData.getDriverVersion());

        System.out.println("可用的数据库列表：");
        // 获取数据库名称
        ResultSet rs = metaData.getCatalogs();

        while (rs.next()) {
            System.out.println("数据库名称:\t"+rs.getString(1));
        }
        
        //功能2：操作数据库
		//获取操作对象1.Statement  
		Statement statement = con.createStatement();
		con.setAutoCommit(false);//关闭自动提交(开启事务)
		//操作sql
		ResultSet executeQuery = statement.executeQuery("select programme_name from product_sal_service_fee where is_delete=0 and comp_code='sss' limit "+i+","+j);
		//处理结果
		while(executeQuery.next()){
			String string = executeQuery.getString("programme_name");
			System.out.println(string);
		}
		con.commit();//手动提交  493-501之间对于数据的操作、要么全部成功，要么全部失败
		//关闭连接
		executeQuery.close();
		System.out.println("==============================================================");
		/**
		 * ----------------------------------------------------------------------------------
		 */
		//获取操作对象2.PreparedStatement  支持预编译,用？代替
		PreparedStatement prepareStatement = con.prepareStatement("select programme_name from product_sal_service_fee where is_delete=0 and comp_code=? limit ?,?");
		prepareStatement.setString(1, "yimidida");
		prepareStatement.setInt(2, 0);
		prepareStatement.setInt(3, 1);
		ResultSet executeQuery2 = prepareStatement.executeQuery();
		while (executeQuery2.next()) {
			String string = executeQuery2.getString("programme_name");
			System.out.println(string);
		}
		executeQuery2.close();
	}
	
	
	//模拟数据库连接池
	static void method27(){
		ConnectionPool cp = new ConnectionPool(3);
        for (int i = 0; i < 100; i++) {
            new WorkingThread("working thread" + i, cp).start();
        }
	}
	
	
	//图形界面：监听器
	static void method28() {
		// 主窗体
		JFrame f = new JFrame("LoL");
		// 主窗体设置大小
		f.setSize(400, 300);
		// 主窗体设置位置
		f.setLocation(200, 200);
		// 主窗体中的组件设置为绝对定位
		f.setLayout(null);
		// 按钮组件
		JButton b = new JButton("一键秒对方基地挂");
		// 同时设置组件的大小和位置
		b.setBounds(50, 50, 280, 30);
		//增加监听
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("当按钮被点击时，就会触发 ActionEvent事件");
			}
		});
		//增加键盘监听
		b.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("键盘监听-一个按下弹起的组合动作");				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("键盘监听-键被弹起");				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("键盘监听-键被按下");
				
			}
		});
		//增加鼠标监听
		b.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("鼠标监听器-释放鼠标");				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("鼠标监听器-按下鼠标");
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("鼠标监听器-鼠标退出");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("鼠标监听器-鼠标进入");				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("鼠标监听器-按下释放组合动作为点击鼠标");
			}
		});
		//增加鼠标监听适配器
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("鼠标监听适配器，鼠标进入");
				super.mouseEntered(e);
			}
		});
		// 把按钮加入到主窗体中
		f.add(b);
		// 关闭窗体的时候，退出程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 让窗体变得可见
		f.setVisible(true);
	}
	
	//打开图形界面的时候，窗口自动显示在上次关掉的位置
	static void method29() {
		new lol03();//打开窗口
		//启用线程、每50毫秒记录一次窗口位置，保存到file文件中(也可用监听器)
		Thread s1 = new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(50); // 隔50毫秒读取一次窗口坐标
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					int x = lol03.f.getX();
					int y = lol03.f.getY();
					String str = x + "@" + y; // 坐标保存到txt,格式【***@***】
					try (FileWriter fr = new FileWriter(lol03.f1);) {
						char[] cs = str.toCharArray();
						fr.write(cs);
						fr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		s1.start();
	}
	
	//图形界面：窗口
	static void method30(){
		 JFrame f = new JFrame("外部窗体");
	        f.setSize(800, 600);
	        f.setLocation(100, 100);
	        // 根据外部窗体实例化JDialog
	        JDialog d = new JDialog(f);
	        // 窗体大小不可变化
	        d.setResizable(false);
	        // 设置为模态,父窗口不能操作
	        d.setModal(true);
	        d.setTitle("模态的对话框");
	        d.setSize(400, 300);
	        d.setLocation(200, 200);
	        d.setLayout(null);
	        JButton b = new JButton("一键秒对方基地挂");
	        b.setBounds(50, 50, 280, 30);
	        d.add(b);
	        f.setVisible(true);
	        d.setVisible(true);
	}
	
	//图像界面：菜单
	static void method31(){
		JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // 菜单栏
        JMenuBar mb = new JMenuBar();
        // 菜单
        JMenu mHero = new JMenu("英雄");
        JMenu mItem = new JMenu("道具");
        JMenu mWord = new JMenu("符文");
        JMenu mSummon = new JMenu("召唤师");
        JMenu mTalent = new JMenu("天赋树");
        // 菜单项
        mHero.add(new JMenuItem("近战-Warriar"));
        mHero.add(new JMenuItem("远程-Range"));
        mHero.add(new JMenuItem("物理-physical"));
        mHero.add(new JMenuItem("坦克-Tank"));
        mHero.add(new JMenuItem("法系-Mage"));
        mHero.add(new JMenuItem("辅助-Support"));
        mHero.add(new JMenuItem("打野-Jungle"));
        mHero.add(new JMenuItem("突进-Charge"));
        mHero.add(new JMenuItem("男性-Boy"));
        mHero.add(new JMenuItem("女性-Girl"));
        // 把菜单加入到菜单栏
        mb.add(mHero);
        mb.add(mItem);
        mb.add(mWord);
        mb.add(mSummon);
        mb.add(mTalent);
        // 把菜单栏加入到frame，这里用的是set而非add
        f.setJMenuBar(mb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
	
	//用java程序ping IP
	static void method32() throws IOException {
		Process p = Runtime.getRuntime().exec("ping " + "127.0.0.1");
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "GB18030"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			if (line.length() != 0)
				sb.append(line + "\r\n");
		}
		System.out.println("本次指令返回的消息是：");
		System.out.println(sb.toString());
	}
	
	
	/**
	 * socket网络编程
	 * 直接使用字节流收发字符串比较麻烦，使用数据流对字节流进行封装，这样收发字符串就容易了 
		1. 把输出流封装在DataOutputStream中 ,使用writeUTF发送字符串 "Legendary!" 
		2. 把输入流封装在DataInputStream ,使用readUTF读取字符串,并打印
	 *  用多线程的方式实现通讯链接。
	 */
	static void method33(){
		serverSocketByThread();//服务端
		clientSocketByThread();//客户端
	}
	
	
	//自定义注解，连接mysql数据库
	//jdbc:mysql://127.0.0.1:3306/books?characterEncoding=UTF-8","root","feixiang"
	@JDBCConfig(ip = "127.0.0.1", database = "books", encoding = "UTF-8", loginName = "root", password = "feixiang")
	static void method34() throws ClassNotFoundException, SQLException {
		// 获取HelloWorld类下的所有方法,并找到某个特定方法
		Method[] methods = JavaMain.class.getDeclaredMethods();
		Method method = null;
		for (Method f : methods) {
			if (f.getName().equals("method34")) {
				method = f;
				break;
			}
		}
		// 获取method注解方法，并解析注解信息
		JDBCConfig config = method.getAnnotation(JDBCConfig.class);
		String ip = config.ip();
		int port = config.port();
		String database = config.database();
		String encoding = config.encoding();
		String user = config.loginName();
		String password = config.password();
		System.out.println(ip);
		System.out.println(port);
		System.out.println(database);
		System.out.println(encoding);
		System.out.println(user);
		System.out.println(password);
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
		Connection c = DriverManager.getConnection(url, user, password);
		Statement createStatement = c.createStatement();
		ResultSet executeQuery = createStatement.executeQuery("select * from product_sal_service_fee limit 0,2");
		while (executeQuery.next()) {
			System.out.println(executeQuery.getString(2));
		}
	}
	
	
	//aop原理，proxy机制
	static void method35(){
		BookFacade b =new BookFacadeImpl();
//		b.addBook();
		BookFacade p=(BookFacade) new BookFacadeProxy().bind(b);
		p.addBook();
	}
	
	
	//如果catch里面有return、就先执行finally块，再返回catch里面的。如果finally里面也是return，就返回后停止。
	static int method36(){
		try {
			int i=1/2;
			return 1;
		}catch(Exception e){
			return 2;
		}finally {
			System.out.println("final");
			return 3;
		}
	}
	
	
	//自定义注解
	static void method37() {
	  Apple apple = new Apple("name", "red", "product");
   	  FruitInfoUtil.getFruitInfo(apple.getClass());
   	  System.out.println(apple);
	}
	
	
	//日期类
	static void method38(){
		//jdk1.8之前---线程不安全
		SimpleDateFormat s=new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		Calendar c=Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		String format = s.format(c.getTime());
		System.out.println(format);
		System.out.println("----------------------------------");
		//JDK1.8---线程安全
		LocalDateTime l=LocalDateTime.now();
		LocalDateTime y=l.minusDays(1);
		System.out.println(y);
		LocalDateTime ll=LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println(ll);
		LocalTime lt=LocalTime.of(12,20,25);
		System.out.println(lt);
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		System.out.println(ll.format(ofPattern));
	}
	
	//测试forEach
	static void method39(){
		List<String> list=new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		System.out.println(list.get(0));
		for (String string : list) {
			System.out.println(string);
		}
		//forEach在遍历的时候，不能进行增删操作、否则报错  java.util.ConcurrentModificationException
//		for (String string : list) {
//			if(string.equals("1")){
//				list.remove(string);
//			}
//		}
		//可用流式处理:过滤不是1的，重新生成一个List
		List<String> collect = list.stream().filter(num->!num.equals("1")).collect(Collectors.toList());
		System.out.println("流式处理..");
		System.out.println(collect);
	}
	
	
	//多线程       	  实现：子线程运行10次，主线程运行5次。交替执行
	static void method40() {
		final JavaMain h=new JavaMain();
		//子线程
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					h.subMethod();
				}
				
			}
		}).start();
		//主线程
		for (int i = 0; i < 3; i++) {
			h.mainMethod();
		}
	}
	
	//ArrayList的动态代理类
	@SuppressWarnings("unchecked")
	static void method41(){
		//jdk代理的类，必须实现接口
		List<Apple> list=new ArrayList<Apple>();
		List<Apple> proxy=(List<Apple>) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return method.invoke(list, args);
			}
		});
		proxy.add(new Apple("苹果", "青", "a"));
		proxy.add(new Apple("苹果", "红", "b"));
		System.out.println(list);
	}
	
	//设计模式
	static void method42(){
		/**
		 * 单例模式：	一是单例模式的类只提供私有的构造函数，
		 * 			二是类定义中含有一个该类的静态私有对象，
		 * 			三是该类提供了一个静态的公有的函数用于创建或获取它本身的静态私有对象。
		 */
		//饿汉模式
		Singleton instanceByEH = Singleton.getInstanceByEH();
		//懒汉模式
		Singleton instanceByLH = Singleton.getInstanceByLH();
		/**
		 * 工厂模式：
		 */
		//一般模式=================================
		SendFactory s=new SendFactory();
		Sender produce = s.produce("mail");
		produce.Send();
		//多工厂模式=================================
		Sender produceMail = s.produceMail();
		produceMail.Send();
		//静态工厂模式==================================
		Sender staticProduceMail = SendFactory.staticProduceMail();
		staticProduceMail.Send();
		//抽象工厂模式
		Provider p= new  SendMailFactory();
		Sender produce2 = p.produce();
		produce2.Send();
		/**
		 * 建造者模式
		 */
		Builder b=new Builder();
		b.produceMailSender(10);
		System.out.println(b.getList());
		/**
		 * 适配器模式
		 */
		//类的适配模式
		Targetable adapter = new Adapter();
		adapter.method1();
		adapter.method2();
		//对象的适配模式
		Targetable adapter2 = new Adapter2(new Source());
		adapter2.method1();
		adapter2.method2();
		/**
		 * 装饰模式
		 */
		Sourceable ds=new DecoratorSource();
		Decorator d=new Decorator(ds);
		d.method();
	}
	
	//用线程排序
	static void method43() throws InterruptedException{
		 int [] nums={1,2,44,112,5,334,199,96,999};
		for (int i = 0; i < nums.length;i++) {
			new Thread(new ArraySort(nums[i])).start();
		}
		Thread.sleep(1000);
		System.out.println(list);
	}
	
	//冒泡排序
	static void method44() {
		int[] A = { 10, 3, 8, 2, 9, 1 };
		System.out.println("排序前数组为：");
		for (int num : A) {
			System.out.print(num + " ");
		}
		System.out.println("");
		for (int i = 0; i < A.length - 1; i++) {// 外层循环控制排序趟数
			for (int j = 0; j < A.length - 1 - i; j++) {// 内层循环控制每一趟排序多少次：每一次循环确定一个最高值
				if (A[j] > A[j + 1]) {
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
				System.out.println(Arrays.toString(A));
			}
			System.out.print("------外层循环控制次数------");
		}
		System.out.println();
		System.out.println("排序后的数组为：");
		for (int num : A) {
			System.out.print(num + " ");
		}
	}

	//遍历map、转换成set，用迭代器遍历
	static void method45() {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		map.put(1, "一");
		map.put(2, "二");
		map.put(3, "三");
		map.put(4, "四");
		map.put(5, "五");
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			String value = (String) map.get(next);
			System.out.println(next + "-" + value);
		}
	}
	
	static void method46(){
		String dateStr= "2016年10月25日";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		LocalDate date= LocalDate.parse(dateStr, formatter);
		System.out.println(date);
		//日期转换为字符串
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm a");
		String nowStr = now .format(format);
		System.out.println(nowStr);
	}
	
	//两阶段提交框架：Atomikos(多数据源)
	static void method47() throws NotSupportedException, SystemException, SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		//两个库，两个数据链接
		Properties p1=new Properties();
		p1.setProperty("url", "jdbc:mysql://127.0.0.1:3306/product_pro");
		p1.setProperty("user", "root");
		p1.setProperty("password", "feixiang");
		
		AtomikosDataSourceBean ds1=new AtomikosDataSourceBean();
		ds1.setUniqueResourceName("product_pro");
		ds1.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
		ds1.setXaProperties(p1);
		
		Properties p2=new Properties();
		p2.setProperty("url", "jdbc:mysql://127.0.0.1:3306/books");
		p2.setProperty("user", "root");
		p2.setProperty("password", "feixiang");
		
		AtomikosDataSourceBean ds2=new AtomikosDataSourceBean();
		ds2.setUniqueResourceName("books");
		ds2.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
		ds2.setXaProperties(p2);
		
		Connection conn1=null;
		Connection conn2=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		
		//事务实现...（全程操作加锁，所以可用性不高 ）
		UserTransaction user=new UserTransactionImp();
		
		//开启
		user.begin();
		conn1=ds1.getConnection();
		ps1=conn1.prepareStatement("INSERT INTO ts_hhf(id,name) VALUES(102,'product')",Statement.RETURN_GENERATED_KEYS);
		ps1.executeUpdate();
		
		//制造错误，回滚。
		int i=1/0;
		
		conn2=ds2.getConnection();
		ps2=conn2.prepareStatement("INSERT INTO user(id,userName,passWord,name,address,createDate) VALUES(3,'hhf','123456','book','上海',NOW())",Statement.RETURN_GENERATED_KEYS);
		ps2.executeUpdate();
		
		//提交
		user.commit();
	}
	
	
	/*
	 * **********************************************************************************
	 */


	final static int a=1;
	//main方法
	public static void main(String[] args) throws Exception {
//		method26(1,2);
//		System.out.println(method36());
//		method39();
		method47();
    }
	
	
	
	
	
	
	/*
	 * **********************************************************************************
	 */
	
	//====================方法函数=========================
	//过滤符合条件的对象
	static void filter(List<Hero> heros, HeroChecker checker) {
		for (Hero hero : heros) {
			if (checker.test(hero))
				System.out.print(hero);
		}
	}
	
	
	//子线程运行10次，主线程运行5次。交替执行
	private boolean subFlag=true;
	
	protected synchronized void subMethod() {
		while(!subFlag){
			try {
				wait();//此(子)线程等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"运行"+(i+1)+"次");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		subFlag=false;
		notify();//唤醒沉睡的(主)线程
	}
	
	protected synchronized void mainMethod() {
		while(subFlag){
			try {
				wait();//此(主)线程等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+"运行"+(i+1)+"次");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		subFlag=true;
		notify();//唤醒沉睡的(子)线程
	}
	
	//socket服务端
	static void serverSocketByThread(){
		System.out.println("-------------服务端启动---------------");
		Thread server=new Thread(){
			@Override
			public void run() {
				try {
		            ServerSocket ss = new ServerSocket(8888);
		            Socket s = ss.accept();
		            InputStream is = s.getInputStream();
		            //把输入流封装在DataInputStream
		            DataInputStream dis = new DataInputStream(is);
		            //使用readUTF读取字符串
		            String msg = dis.readUTF();
		            System.out.println("服务端收到客户端的信息："+msg);
		            dis.close();
		            s.close();
		            ss.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}
		};
		server.start();
	}
	
	//socket客户端
	static void clientSocketByThread() {
		System.out.println("-------------客户端启动---------------");
		Thread client=new Thread(){
			@Override
			public void run() {
				Scanner input=new Scanner(System.in);
				System.out.print("请输入要发出的信息：");
				String info=input.next();
				input.close();
				try {
					Socket s = new Socket("127.0.0.1", 8888);
					OutputStream os = s.getOutputStream();
					// 把输出流封装在DataOutputStream中
					DataOutputStream dos = new DataOutputStream(os);
					// 使用writeUTF发送字符串
					dos.writeUTF(info);
					dos.close();
					s.close();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		client.start();
	}
	
	
	
 static class ArraySort implements Runnable{

	 private Integer num;
	 
	 public  ArraySort() {}
	 
	 public  ArraySort(int num) {
		 this.num=num;
	}
	 
	@Override
	public void run() {
		try {
			Thread.sleep(num);
			list.add(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		 
	 }
}

	 //=====================非公共线程类=========================
	 class WorkingThread extends Thread {
		    private ConnectionPool cp;
		   
		    public WorkingThread(String name, ConnectionPool cp) {
		        super(name);
		        this.cp = cp;
		    }
		   
		    public void run() {
		        Connection c = cp.getConnection();
		        System.out.println(this.getName()+ ":\t 获取了一根连接，并开始工作"  );
		        try (Statement st = c.createStatement()){
		            //模拟时耗１秒的数据库ＳＱＬ语句
		            Thread.sleep(1000);
		            //建立的连接操作数据库
		            st.execute("select * from product_sal_service_fee limit 0,1");
		        } catch (SQLException | InterruptedException e) {
		            e.printStackTrace();
		        }
		        cp.returnConnection(c);
		        System.out.println(this.getName()+"归还连接==============");
		    }
	 }
	 
//	 class calculatorTest{
//		 
//	    	Calculator calculator = new Calculator();
//	    	@Before
//	    	public void setUp() throws Exception {
//	    		calculator.clear();
//	    	}
//	    	
//	    	@Test
//	    	public void testAdd() {
//	    		calculator.add(2);
//	    		calculator.add(3);
//	    		assertEquals(5, calculator.getResult());
//	    	}
//	    	
//	    	@Test
//	    	public void testSubstract() {
//	    		calculator.add(10);
//	    		calculator.substract(2);
//	    		assertEquals(8, calculator.getResult());
//	    	}
//	    	
//	    	@Ignore("Multiply() Not yet implemented")
//	    	@Test
//	    	public void testMultiply() {
//	    	}
//	    	
//	    	@Test
//	    	public void testDivide() {
//	    		calculator.add(8);
//	    		calculator.divide(2);
//	    		assertEquals(4, calculator.getResult());
//	    	}
//	    	
//	    }
	 