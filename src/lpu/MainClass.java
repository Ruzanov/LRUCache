package lpu;

import data.Item;

/**
 * Created with IntelliJ IDEA. User: inver Date: 26.05.13 Time: 15:44 To change
 * this template use File | Settings | File Templates.
 */
public class MainClass {

	public static void main(String[] args) {
		System.out.println("-------------------------------");
		LRUCacheImpl cache = new LRUCacheImpl(5, true);
		cache.printCache();
		cache.getItem(8);
		cache.getItem(9);
		cache.getItem(11);
		cache.getItem(12);
		cache.getItem(13);
		System.out.println("-------------------------------");
		cache.printCache();
		cache.getItemsStorage().setValItem(2, "TWO");
		//cache.reloadCache();
		System.out.println("-------------------------------");
	//	cache.printCache();
	}
}
