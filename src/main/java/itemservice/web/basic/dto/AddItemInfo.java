package itemservice.web.basic.dto;

import itemservice.domain.item.Item;

public record AddItemInfo(String itemName, int price, Integer quantity) {
    public Item toEntity() {
        return Item.valueOf(itemName, price, quantity);
    }
}
