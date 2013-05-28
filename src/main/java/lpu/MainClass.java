package lpu;

/**
 * Created with IntelliJ IDEA. User: inver Date: 26.05.13 Time: 15:44 To change
 * this template use File | Settings | File Templates.
 */
public class MainClass {
	public static void main(String[] args) {
		LRUCacheImpl cache = new LRUCacheImpl(Integer.parseInt(args[0]), true, Integer.parseInt(args[1]));
		cache.printCache();
		cache.getItem(588888885);
		cache.getItem(3);
		cache.getItem(11);
		cache.getItem(12);
		cache.getItem(588888885);
		cache.printCache();
		cache.getItemsStorage().setValItem(2, "TWO");
		cache.getItemsStorage().remove(5);

		cache.reloadCache();
		cache.getItem(22);
		cache.printCache();
	}
}
