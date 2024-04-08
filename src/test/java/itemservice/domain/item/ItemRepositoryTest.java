package itemservice.domain.item;

import static org.assertj.core.api.Assertions.assertThat;

import itemservice.domain.item.dto.ItemUpdateParameter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    @DisplayName("아이템 저장 테스트")
    void saveItemTest() {
        // given
        Item item = Item.valueOf("itemA", 10000, 10);

        // when
        Item savedItem = itemRepository.save(item);
        Item findItem = itemRepository.findById(item.getId());

        // then
        assertThat(savedItem).isSameAs(findItem);
    }

    @Test
    @DisplayName("아이템 리스트 조회 테스트")
    void findAllItemsTest() {
        // given
        Item item1 = Item.valueOf("itemA", 10000, 10);
        Item item2 = Item.valueOf("itemB", 10000, 10);

        // when
        itemRepository.save(item1);
        itemRepository.save(item2);
        List<Item> items = itemRepository.findAll();

        // then
        assertThat(items.size()).isEqualTo(2);
        assertThat(items).contains(item1, item2);
    }

    @Test
    @DisplayName("아이템 수정 테스트")
    void updateItemTest() {
        // given
        Item savedItem = Item.valueOf("itemA", 10000, 10);

        // when
        itemRepository.save(savedItem);
        ItemUpdateParameter update = new ItemUpdateParameter("itemB", 15000, 5);
        itemRepository.update(savedItem.getId(), update);

        // then
        assertThat(savedItem.getItemName()).isSameAs(update.itemName());
        assertThat(savedItem.getPrice()).isSameAs(update.price());
        assertThat(savedItem.getQuantity()).isSameAs(update.quantity());
    }
}
