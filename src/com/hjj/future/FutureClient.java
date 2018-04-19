package com.hjj.future;

public class FutureClient {
	public Data request(final String query) {
		/**
		 *  要一个代理对象  先把请求 返回给客户端  ，告诉他请求已经收到了  
		 */
		final FutureData futureData = new FutureData();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				/**
				 * 这里就是在做真正要做的业务 查询操作了  做完以后set回去 就ok了
				 */
				RealData realData = new RealData(query);
				futureData.setRealData(realData);
			}
			
		}).start();
		/**
		 * 先返回回去  然而线程仍在执行 若执行完毕了  就会将数据填充到这个 感觉像是 暂存区的一个 容器之中的柑橘
		 */
		return futureData;
	}
}
