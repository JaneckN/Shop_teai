package pl.janeck.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
@Profile("start")
public class ShopStart {

    private Basket basket;


    @Autowired
    public ShopStart(Basket basket) {
        this.basket = basket;
    }

    public void showBasket(){
        basket.getBasket().forEach(System.out::println);
    }

    @EventListener(ApplicationReadyEvent.class)
    public Double getTotalPrice(){
        Double totalPrice = basket
                .getBasket()
                .stream()
                .mapToDouble(value -> value.getPrice())
                .sum();
        System.out.format("Total Price=" + "%.2f", totalPrice);
        System.out.println();
        return totalPrice;



    }

    public Double getVatAmount(double vatRate, double netto){
        return netto * (vatRate/100);
    }
}
