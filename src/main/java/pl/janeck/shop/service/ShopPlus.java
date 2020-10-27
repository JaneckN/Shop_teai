package pl.janeck.shop.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("plus")
public class ShopPlus extends ShopStart {

    @Value("${vat}")
    private double vat;


    public ShopPlus(Basket basket) {
        super(basket);
    }


    @Override
    @EventListener(ApplicationReadyEvent.class)
    public Double getTotalPrice() {
        double netto = super.getTotalPrice();
        double vatAmount = getVatAmount(vat, netto);
        double totalPriceVatInc = netto+vatAmount;
        System.out.format("Total Price (VAT inc.)= "+"%.2f", totalPriceVatInc);
        return totalPriceVatInc;


    }



}
