package com.nicoz.NZWanderlust.Services;

import com.nicoz.NZWanderlust.NewDataPaymentRequest;
import com.nicoz.NZWanderlust.Entities.DataPayment;
import com.nicoz.NZWanderlust.Repositories.DataPaymentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataPaymentService {
    private final DataPaymentRepository dataPaymentRepository;

    public DataPaymentService(DataPaymentRepository dataPaymentRepository) {
        this.dataPaymentRepository = dataPaymentRepository;
    }

    public List<DataPayment> getDataPayments(){ return dataPaymentRepository.findAll(); }

    public DataPayment get(Long id){ return dataPaymentRepository.findById(id).get(); }

    public DataPayment addDataPayment(NewDataPaymentRequest dataPaymentRequest){
        DataPayment dataPayment = new DataPayment();
        dataPayment.setName(dataPaymentRequest.getName());
        dataPayment.setNumber(dataPaymentRequest.getNumber());
        dataPayment.setExpDate(dataPaymentRequest.getExpDate());
        dataPayment.setSecurityCode(dataPaymentRequest.getSecurityCode());
        dataPayment.setUserFullName(dataPaymentRequest.getUserFullName());
        return dataPaymentRepository.save(dataPayment);
    }

    public ResponseEntity<DataPayment> updateDataPayment(Long id, DataPayment dataPaymentDetails){
        Optional<DataPayment> optionalDataPayment = dataPaymentRepository.findById(id);
        if(!optionalDataPayment.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DataPayment dataPayment = optionalDataPayment.get();
        dataPayment.setName(dataPaymentDetails.getName());
        dataPayment.setNumber(dataPaymentDetails.getNumber());
        dataPayment.setExpDate(dataPaymentDetails.getExpDate());
        dataPayment.setSecurityCode(dataPaymentDetails.getSecurityCode());
        dataPayment.setUserFullName(dataPaymentDetails.getUserFullName());
        DataPayment updateDataPayment = dataPaymentRepository.save(dataPayment);
        return new ResponseEntity<>(updateDataPayment, HttpStatus.OK);
    }


    public void delete(Long id){dataPaymentRepository.deleteById(id);}
}
