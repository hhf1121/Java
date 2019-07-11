package designModel.ListenerModel;

import java.util.List;

import com.google.common.collect.Lists;

public class XiaoMei {

	List<Person> list = Lists.newArrayList();

	public XiaoMei() {}

	public void addPerson(Person person) {
		list.add(person);
	}

	// 遍历list，把自己的通知发送给所有暗恋自己的人
	public void notifyPerson() {
		for (Person person : list) {
			person.getMessage("你们过来吧，谁先过来谁就能陪我一起玩儿游戏!");
		}
	}

	public static void main(String[] args) {
		XiaoMei xiao_mei = new XiaoMei();
		XiaoWang lao_wang = new XiaoWang();
		XiaoLi lao_li = new XiaoLi();
		// 小王和小李在小美那里都注册了一下
		xiao_mei.addPerson(lao_wang);
		xiao_mei.addPerson(lao_li);
		// 小美向小王和小李发送通知
		xiao_mei.notifyPerson();
	}
	
	
}
