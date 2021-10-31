package enit.bank.shipping.service.impl;

import enit.bank.common.beans.Event;
import enit.bank.common.enums.ShippingStatus;
import enit.bank.shipping.domain.Shipping;
import enit.bank.shipping.repository.ShippingRepository;
import enit.bank.shipping.service.ShippingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ShippingServiceImpl implements ShippingService {

    @Resource
    private ShippingRepository shippingRepository;



    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void createShippingRequest(Long orderId) {
        Shipping shipping = new Shipping();
        shipping.setOrderId(orderId);
        shipping.setStatus(ShippingStatus.SHIPPED);
        shipping = shippingRepository.save(shipping);
        broadcastOrderShippedEvent(shipping);
    }

    @Override
    public void acknowledgeDelivery(Long shippingId) {
        Shipping shipping = shippingRepository.findOne(shippingId);
        shipping.setStatus(ShippingStatus.DELIVERED);
        shippingRepository.save(shipping);



    }
}
