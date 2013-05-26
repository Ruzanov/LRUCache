import data.Item;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 26.05.13
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public interface LRUCache<E extends Item> {
    E getItem(Integer id);

    void reloadCache();

}
