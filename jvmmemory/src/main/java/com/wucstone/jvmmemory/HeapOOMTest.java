package com.wucstone.jvmmemory;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * out of heap memory test
 * VM args -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * @author wuc
 *
 */
public class HeapOOMTest {
	
	@Test
	public void testHeapOOM(){
		List<HeapOOMTest> list=new ArrayList<HeapOOMTest>();
		while(true){
			list.add(new HeapOOMTest());
		}
	}

}
