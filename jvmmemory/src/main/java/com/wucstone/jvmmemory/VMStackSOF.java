package com.wucstone.jvmmemory;

import org.junit.Test;

/**
 * stack over flow 
 * 对于HotSpot来说，虽然可以设置本地方法栈大小（-Xoss）
 * 但是本地方法栈和虚拟机栈是合在一起的，所以-Xoss无效
 * 栈容量只由-Xss来设置
 * 
 * VMargs:
 * 
 * @author wuc
 *
 */
public class VMStackSOF {
	
	private int stackLength=0;
	private int threadCount=0;
	
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	/**
	 * VM Args: -Xss128k
	 */
	@Test
	public void testStackOverFlow() throws Throwable{
		
		try{
			stackLeak();
		}catch(Throwable e){
			System.out.println("stack length:"+stackLength);
			e.printStackTrace();
			throw e;
		}
	}
	
	
	/**
	 * VM args: -Xss2M
	 */
	@Test
	public void testStackOOM(){
		try{
			while(true){
				stackLeakByThread();
			}
		}catch(Throwable e){
			e.printStackTrace();
		}
		
	}
	
	public void stackLeakByThread(){
		
		Thread thread=new Thread(new Runnable() {
			
			public void run() {
				System.out.println("第"+threadCount+"个线程");
				threadCount++;
				while(true){
				}
			}
		});
		thread.start();
		
	}
}
