package com.hjj.future;
/**
 * 这是一个包装类  实现了 Data接口  另一个真实数据类也要实现Data这个接口
 * 
 * @author huangjiangjun
 *
 */
public class FutureData implements Data{
	private RealData realData;
	
	private boolean isReady = false;
	
	public synchronized void setRealData(RealData realData) {
		if(isReady) {
			return ;
		}
		/**
		 * set the realData into FutureData like a stash
		 */
		this.realData = realData;
		isReady = true;
		notify();
	}
	
	
	@Override
	/**
	 * 这里不加入锁会有问题  IllegalMonitorStateException
	 * 在同步控制方法或同步控制块里调用wait()，notify()和notifyAll()。
	 * 如果在非同步控制方法里调用这些方法，程序能通过编译，但运行的时候，将得到IllegalMonitorStateException异常，
	 * 并伴随着一些含糊的消息，比如"当前线程不是拥有者"。
	 * 消息的意思是，调用wait()，notify()和notifyAll()的线程在调用这些方法前必须"拥有"对象的锁。
	 * 当前的线程不是此对象锁的所有者，却调用该对象的notify()，notify()，wait()方法时抛出该异常。
	 */
	public synchronized String getRequest() {
		// TODO Auto-generated method stub
		while(!isReady) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return this.realData.getRequest();
	}

}
