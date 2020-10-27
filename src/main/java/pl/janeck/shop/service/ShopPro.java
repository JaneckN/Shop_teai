package pl.janeck.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("pro")
public class ShopPro extends ShopStart{

    @Value("${discount}")
    private double discount;
    @Value("${vat}")
    private double vat;

    @Autowired
    public ShopPro(Basket basket) {
        super(basket);
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public Double getTotalPrice() {
        double netto = super.getTotalPrice();
        netto *= (100.00 - discount)/100;
        double vatAmount = getVatAmount(vat, netto);
        double totalPriceVatInc = netto+vatAmount;
        System.out.format("Total Price after discount (VAT inc)= "+"%.2f", totalPriceVatInc);
        return  totalPriceVatInc;

    }
}
