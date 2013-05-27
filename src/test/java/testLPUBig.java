package test;

import junit.framework.Assert;
import lpu.LRUCacheImpl;

import org.junit.Test;

import data.Item;

public class testLPUBig {
	LRUCacheImpl lpuImpl;
	Item data;

	@Test
	public void testLoad() {
		lpuImpl = new LRUCacheImpl(60009999, true, 30000);
		 System.out.println("lpuImpl = new LRUCacheImpl(60009999, true, 30000)");
		data = lpuImpl.getItem(300);
		System.out.println("data = lpuImpl.getItem(300);");
		Assert.assertTrue(data.getId() == 300);
		lpuImpl.getItemsStorage().remove(666);
		System.out.println("lpuImpl.getItemsStorage().remove(666);");
		lpuImpl.reloadCache();
		System.out.println("lpuImpl.reloadCache();");
		data = lpuImpl.getItem(333333333);
		Assert.assertTrue(data == null);
		lpuImpl.printCache();
		System.out.println("lpuImpl.printCache();");
		data = lpuImpl.getItem(300);
		lpuImpl.getItemsStorage().setValItem(30000-10, "TWO");
		System.out.println("lpuImpl.getItemsStorage().setValItem(30000-1, TWO);");
		lpuImpl.printCache();
		
	}

}
