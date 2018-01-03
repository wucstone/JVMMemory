package com.wucstone.jvmmemory;

import org.junit.Test;

/**
 * 跟踪查看GC日志查看垃圾收集过程
 * @author Administrator
 *
 */
public class GCTracingTest {
	
	
	private final int _1M=1024*1024;
	
	/**
	 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 * java堆大小为20M 新生代10M 新生代中Eden与Survivor的空间比例8:1
	 *  
	 */
	@Test
	public void testAllocation(){
		
		
		byte[] allocation1,allocation2,allocation3,allocation4;
		
		
		allocation1=new byte[2*_1M];
		allocation2=new byte[2*_1M];
		allocation3=new byte[2*_1M];
		allocation4=new byte[4*_1M];//会出现minor GC
		
		
		
	}

}
