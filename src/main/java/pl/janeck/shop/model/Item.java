package pl.janeck.shop.model;

import java.util.Random;

public class Item {

    private String name;
    private Double price;

    public Item(String name) {
        this.name = name;
        this.price = setRandomPrice();
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    private Double setRandomPrice() {
        double min = 50D;
        double max = 300D;
        double randomPrice = min + new Random().nextDouble() * (max - min);
        return randomPrice;
    }
}
