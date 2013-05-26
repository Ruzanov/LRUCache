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
		super();
		this.sizeCache = 10;
	}

	public LRUCacheImpl(Integer sizeCache) {
		super();
		this.sizeCache = sizeCache;
	}

	public LRUCacheImpl(Integer sizeCache, boolean isLoadItems) {
		super();
		this.sizeCache = sizeCache;
		if (isLoadItems)
			loadItems();
	}

	protected void Log(String log) {
		System.out.println(log);
	}

	protected void loadItems() {
		Item itemAdd;
		for (Integer i = 0; i < sizeCache
				&& i < getItemsStorage().getItemsStorage().size(); i++) {
			itemAdd = getItemsStorage().getItemsStorage().get(i);
			getCache().put(itemAdd.getId(), itemAdd);
			Log("load " + itemAdd.toString());
		}
	}

	protected void removeItem() {
		if (getCache().size() > sizeCache)
			if (ItemFirst != null) {
				getCache().remove(ItemFirst.hashCode());
				Log("remove " + ItemFirst.toString());
				ItemFirst = (Item) getCache().remove(getCache().firstKey());
			}
	}

	@Override
	public Item getItem(Integer id) {
		if (id == null)
			return null;
		if (isExistsItem(id))
			return getCache().get(id);
		// Добавим в кеш
		Item itemAdd = getItemById(id);
		getCache().put(itemAdd.getId(), itemAdd);
		removeItem();
		if (ItemFirst == null)
			ItemFirst = itemAdd;
		return itemAdd;
	}

	private Item getItemById(Integer id) {
		for (Item key : itemsStorage.getItemsStorage())
			if (key.getId() == id)
				return key;
		return null;
	}

	private boolean isExistsItem(Integer id) {
		for (Integer key : getCache().keySet())
			if (getCache().get(key).equals(getCache().get(id)))
				return true;
		return false;
	}

	@Override
	public void reloadCache() {
		Item reload;
		for (Integer key : getCache().keySet()) {
			reload = getItemById(getCache().get(key).getId());
			getCache().put(reload.getId(), reload);
		}
	}

	public TreeMap<Integer, Item> getCache() {
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
		for (Integer key : getCache().keySet())
			Log(getCache().get(key).toString());
		Log("size cache=" + getCache().size());
	}

}
