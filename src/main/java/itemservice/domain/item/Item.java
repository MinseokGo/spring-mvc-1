package itemservice.domain.item;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    private Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public static Item valueOf(String itemName, Integer price, Integer quantity) {
        return new Item(itemName, price, quantity);
    }
}
