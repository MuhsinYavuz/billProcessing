package com.graduationProjectEvam.billProcessing.services;

import com.graduationProjectEvam.billProcessing.entity.Client;
import com.graduationProjectEvam.billProcessing.entity.Invoice;
import com.graduationProjectEvam.billProcessing.entity.Payment;
import com.graduationProjectEvam.billProcessing.repo.InvoiceRepository;
import com.graduationProjectEvam.billProcessing.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository ;
    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository= paymentRepository;
    }
    // Payment leri görüntülemek için kullanılacak  service.
    public List<Payment> getPayments(){
        return paymentRepository.findAll();
    }
    // Payment leri olusuturmak için kullanılacak  service.
    public void createPayment(Payment paymentToAdd){
        paymentRepository.save(paymentToAdd) ;
        System.out.println(paymentToAdd.getClient().getId() +  "' id li kişi " + paymentToAdd.getId() +" ' id li  ödemeyi yaptı");
    }
    // Payment leri silmek için kullanılacak  service.

    public void deletePayment(Long id){
        paymentRepository.deleteById(id);
        System.out.println("id si " +  id +  " olan ödeme silindi");
    }
    // Payment leri güncellemek için kullanılacak  service.
    public Payment findById(Long id){
        return this.paymentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Payment Not Found")) ;
    }



}
