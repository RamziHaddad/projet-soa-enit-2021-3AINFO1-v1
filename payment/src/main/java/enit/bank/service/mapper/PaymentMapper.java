package enit.bank.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import enit.bank.domain.Payment;
import enit.bank.service.dto.PaymentDTO;
import enit.bank.service.dto.PaymentForAddDTO;

@Mapper(componentModel = "cdi")
public interface PaymentMapper {
    PaymentMapper instance = Mappers.getMapper(PaymentMapper.class);
    PaymentDTO PaymentToPaymentDTO (Payment payment);
    Payment PaymentForAddDTOToPayment (PaymentForAddDTO paymentDTO);
}
