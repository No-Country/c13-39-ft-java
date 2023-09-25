package com.nicoz.NZWanderlust.Services;

import com.nicoz.NZWanderlust.NewDataPaymentRequest;
import com.nicoz.NZWanderlust.Entities.DataPayment;
import com.nicoz.NZWanderlust.Entities.PaymentMethod;
import com.nicoz.NZWanderlust.Repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }
    
	@Autowired
	private DataPaymentService dataPaymentService;
	
	@Autowired
	private UserService userService;
    

    public List<PaymentMethod> getPaymentMethods(){ return paymentMethodRepository.findAll(); }

    public PaymentMethod get(Long id){ return paymentMethodRepository.findById(id).get(); }

    public void addPaymentMethod(NewDataPaymentRequest dataPaymentRequest){
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setUser(userService.getUser(dataPaymentRequest.getUserId()));
        
        DataPayment dataPayment = dataPaymentService.addDataPayment(dataPaymentRequest);
        
        paymentMethod.setDataPayment(dataPayment);
        paymentMethodRepository.save(paymentMethod);
    }

    public void delete(Long id){ 
    	PaymentMethod paymentMethod = paymentMethodRepository.findById(id).get();

    	
    	paymentMethodRepository.deleteById(id);
		dataPaymentService.delete(paymentMethod.getDataPayment().getId());
    }
    
}
