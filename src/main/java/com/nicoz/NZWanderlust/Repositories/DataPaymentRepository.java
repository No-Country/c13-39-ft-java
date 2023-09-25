package com.nicoz.NZWanderlust.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicoz.NZWanderlust.Entities.DataPayment;
import org.springframework.stereotype.Repository;


@Repository
public interface DataPaymentRepository extends JpaRepository<DataPayment, Long>{

}