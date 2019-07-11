package MyRPC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PollGetServerIP {
	Map<String, Integer> serverWeightMap=new HashMap<String, Integer>();
	
	public PollGetServerIP(){
		serverWeightMap.put("192.168.1.10",1);
		serverWeightMap.put("192.168.1.11",1);
		serverWeightMap.put("192.168.1.12",3);
		serverWeightMap.put("192.168.1.13",1);
		serverWeightMap.put("192.168.1.14",5);
		serverWeightMap.put("192.168.1.15",2);
		serverWeightMap.put("192.168.1.16",1);
	}
	
	/**
	 * 轮询法
	 * @return
	 */
	public String getServerIP() {
        //新建map，避免出现服务器上线、下线、宕机引发的并发问题、数组越界等
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(serverWeightMap);
        //取得服务器列表list
        List<String> serverList = new ArrayList<String>();
        serverList.addAll(serverMap.keySet());
        
        String server = null;
        Integer pos = 0;//当前服务器位置
        synchronized (pos) {
            if (pos >= serverList.size()) {
                pos = 0;
            }
            server = serverList.get(pos);
            pos++;
        }
        return server;
    }
	
	public static void main(String[] args) {
		
		for (int i=0;i<5;i++) {
			new Thread(()->{
				PollGetServerIP polLgetIP = new PollGetServerIP();
				System.out.println(polLgetIP.getServerIP());
			}).start();
		}
		
	}
}
