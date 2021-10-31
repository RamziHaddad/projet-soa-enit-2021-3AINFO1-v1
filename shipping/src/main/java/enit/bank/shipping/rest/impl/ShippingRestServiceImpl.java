package enit.bank.shipping.rest.impl;

import enit.bank.shipping.rest.ShippingRestService;
import enit.bank.shipping.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/services/shipping")
public class ShippingRestServiceImpl implements ShippingRestService {

    @Autowired
    private ShippingService shippingService;

    @Override

    public void createShipping(@PathVariable Long id) {
        shippingService.createShippingRequest(id);
    }

    @Override
    @RequestMapping(value= "/{id}", method = RequestMethod.POST)

    public void acknowledgeDelivery(@PathVariable Long shippingId) {
        shippingService.acknowledgeDelivery(shippingId);
    }
}
