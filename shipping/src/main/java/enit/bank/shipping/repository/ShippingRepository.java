package enit.bank.shipping.repository;

import enit.bank.shipping.domain.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShippingRepository extends JpaRepository<Shipping, Long> {

}
