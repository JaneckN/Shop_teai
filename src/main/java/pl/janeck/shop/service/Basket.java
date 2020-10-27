package pl.janeck.shop.service;

import org.springframework.stereotype.Component;
import pl.janeck.shop.model.Item;
import java.util.HashSet;
import java.util.Set;

@Component
public class Basket {

    private Set<Item> basket = initialize();

    private Set<Item> initialize() {
        Set<Item> initialSet = new HashSet<>();
        initialSet.add(new Item("Hammer"));
        initialSet.add(new Item("Jacket"));
        initialSet.add(new Item("Drill"));
        initialSet.add(new Item("Reciprocating Saw"));
        initialSet.add(new Item("Cutters"));
        return initialSet;

    }

    public Set<Item> getBasket() {
        return basket;
    }

    public void addItem(Item item){
        basket.add(item);
    }
}
