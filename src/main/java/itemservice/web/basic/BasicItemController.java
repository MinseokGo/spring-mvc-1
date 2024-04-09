package itemservice.web.basic;

import itemservice.domain.item.Item;
import itemservice.domain.item.ItemRepository;
import itemservice.domain.item.dto.ItemUpdateParameter;
import itemservice.web.basic.dto.AddItemInfo;
import itemservice.web.basic.dto.EditItemInfo;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basic/items")
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    @PostMapping("/add")
    public String addItemV1(AddItemInfo addItem, Model model) {
        Item item = addItem.toEntity();
        itemRepository.save(item);

        model.addAttribute("item", item);

        return "/basic/item";
    }

    @GetMapping("{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("{itemId}/edit")
    public String edit(@PathVariable Long itemId, EditItemInfo editItem) {
        ItemUpdateParameter update = editItem.toItemUpdateParameter();
        itemRepository.update(itemId, update);
        return "redirect:/basic/items/{itemId}";
    }

    @PostConstruct
    public void init() {
        itemRepository.save(Item.valueOf("itemA", 10000, 10));
        itemRepository.save(Item.valueOf("itemB", 20000, 20));
    }
}
