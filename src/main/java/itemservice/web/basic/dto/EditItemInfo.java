package itemservice.web.basic.dto;

import itemservice.domain.item.dto.ItemUpdateParameter;

public record EditItemInfo(String itemName, int price, Integer quantity) {
    public ItemUpdateParameter toItemUpdateParameter() {
        return new ItemUpdateParameter(itemName, price, quantity);
    }
}
