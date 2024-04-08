package itemservice.domain.item;

import itemservice.domain.item.dto.ItemUpdateParameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return List.copyOf(store.values());
    }

    public void update(Long id, ItemUpdateParameter update) {
        Item findItem = findById(id);
        findItem.setItemName(update.itemName());
        findItem.setPrice(update.price());
        findItem.setQuantity(update.quantity());
    }

    public void clearStore() {
        store.clear();
    }
}
