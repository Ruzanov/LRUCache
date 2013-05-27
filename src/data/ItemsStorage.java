package data;

import java.util.ArrayList;

public class ItemsStorage {
  ArrayList<Item> itemsStorage;

  public ArrayList<Item> getItemsStorage() {
    return itemsStorage;
  }

  public ItemsStorage() {
    super();
    itemsStorage = new ArrayList<Item>();
    for (Integer i = 0; i < 21; i++)
      itemsStorage.add(new Item(i, "One" + i));
  }

  public void setValItem(Integer inx, String val) {
    if (inx != null)
      if (itemsStorage.get(inx) != null)
        itemsStorage.get(inx).setSomeData("CHANGE" + inx);
  }

  public void remove(Integer inx) {
    if (inx != null)
      if (itemsStorage.get(inx) != null)
        System.out.println("remote item=" + itemsStorage.get(inx).toString());
    itemsStorage.remove(itemsStorage.get(inx));
  }
}
