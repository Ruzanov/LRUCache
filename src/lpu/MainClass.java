package lpu;

/**
 * Created with IntelliJ IDEA. User: inver Date: 26.05.13 Time: 15:44 To change
 * this template use File | Settings | File Templates.
 */
public class MainClass {
  public static void main(String[] args) {
    LRUCacheImpl cache = new LRUCacheImpl(5, true,1000);
    cache.printCache();
    cache.getItem(588888885);
    cache.getItem(3);
    cache.getItem(11);
    cache.getItem(12);
    cache.getItem(588888885);  
    cache.printCache();
    cache.getItemsStorage().setValItem(2, "TWO");
    cache.getItemsStorage().remove(1);    
    cache.reloadCache();
    cache.printCache();
  }
}
