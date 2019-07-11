package designModel.ProxyModel;
/**
 * 整个流程大概是这样的：家里人催婚->男女双方家庭商定结婚的黄道即日->找一家靠谱的婚庆公司->在约定的时间举行结婚仪式->结婚完毕
 * @author hhf
 *
 */

 
//代理接口
public interface ProxyInterface {
	// 需要代理的是结婚这件事，如果还有其他事情需要代理，比如吃饭睡觉上厕所，也可以写
	void marry();
	// void eat();
	// void shit();
}
