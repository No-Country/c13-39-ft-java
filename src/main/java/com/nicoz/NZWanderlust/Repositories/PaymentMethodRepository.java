package com.nicoz.NZWanderlust.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicoz.NZWanderlust.Entities.PaymentMethod;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long>{

}