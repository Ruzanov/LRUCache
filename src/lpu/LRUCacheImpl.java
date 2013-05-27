package lpu;

import java.util.TreeMap;

import data.Item;
import data.ItemsStorage;

/**
 * Created with IntelliJ IDEA. User: inver Date: 26.05.13 Time: 15:43 To change
 * this template use File | Settings | File Templates.
 */
public class LRUCacheImpl implements LRUCache<Item> {
  TreeMap<Integer, Item> cache;
  Integer sizeCache;
  Item ItemFirst;
  ItemsStorage itemsStorage;

  public LRUCacheImpl() {
    this(10, false);
  }

  public LRUCacheImpl(Integer sizeCache) {
    this(sizeCache, false);
  }

  public LRUCacheImpl(Integer sizeCache, boolean isLoadItems) {
    this.sizeCache = sizeCache;
    if (isLoadItems)
      loadItems();
  }

  protected void Log(String log) {
    System.out.println(log);
  }

  protected void loadItems() {
    Item itemAdd;
    for (Integer i = 0; i < sizeCache && i < getItemsStorage().getItemsStorage().size(); i++){
      itemAdd = getItemsStorage().getItemsStorage().get(i);
      getCache().put(itemAdd.getId(), itemAdd);
      Log("load " + itemAdd.toString());
    }
  }

  protected void removeItem() {
    if (getCache().size() > sizeCache)
      if (ItemFirst != null){
        getCache().remove(ItemFirst.getId());
        Log("remove " + ItemFirst.toString());
        ItemFirst = null;
      }
  }

  @Override
  public Item getItem(Integer id) {
    if (id == null)
      return null;
    if (isExistsItem(id))
      return getCache().get(id);
    Item itemAdd = getItemById(id);
    if (itemAdd != null)
      getCache().put(itemAdd.getId(), itemAdd);
    if (ItemFirst == null)
      ItemFirst = getCache().get(getCache().firstKey());
    removeItem();
    return itemAdd;
  }

  private Item getItemById(Integer id) {
    if (itemsStorage != null){
      for (Item key: itemsStorage.getItemsStorage())
        if (key.getId() == id)
          return key;
    }
    return null;
  }

  private boolean isExistsItem(Integer id) {
    for (Integer key: getCache().keySet())
      if (getCache().get(key).equals(getCache().get(id)))
        return true;
    return false;
  }

  @Override
  public void reloadCache() {
    Item reload;
    @SuppressWarnings("unchecked")
    TreeMap<Integer, Item> keySet = (TreeMap<Integer, Item>) getCache().clone();
    getCache().clear();
    for (Integer key: keySet.keySet()){
      reload = getItemById(key);
      if (reload != null)
        getCache().put(reload.getId(), reload);
    }
    keySet.clear();
    ItemFirst = null;
  }

  protected TreeMap<Integer, Item> getCache() {
    if (cache == null)
      cache = new TreeMap<Integer, Item>();
    return cache;
  }

  public ItemsStorage getItemsStorage() {
    if (itemsStorage == null)
      itemsStorage = new ItemsStorage();
    return itemsStorage;
  }

  public void printCache() {
    for (Integer key: getCache().keySet())
      Log(getCache().get(key).toString());
    Log("size cache=" + getCache().size());
    Log("-------------------------------");
  }
}
