package com.hjj.future;
/**
 * 这个类是一个真正获取数据库内容的类
 * @author huangjiangjun
 *
 */
public class RealData implements Data{
	/**
	 * 最后的结果
	 */
	private String result;
	/**
	 * 初始化 实际data 可能会花费很长的时间来初始化这个对象
	 * @param query
	 */
	public RealData(String query) {
		System.out.println("query with" + query + " it is a long time operation");
		try {
			/**
			 * 做大量的查询
			 */
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("finished the operation ,get the result");
		result = "suprise";
	}
	
	
	@Override
	public String getRequest() {
		// TODO Auto-generated method stub
		return result;
	}

}
