package com.graduationProjectEvam.billProcessing.controller;

import com.graduationProjectEvam.billProcessing.entity.Client;
import com.graduationProjectEvam.billProcessing.entity.Invoice;
import com.graduationProjectEvam.billProcessing.entity.Payment;
import com.graduationProjectEvam.billProcessing.services.InvoiceService;
import com.graduationProjectEvam.billProcessing.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping(value = "/payments")
@RequestScope
public class PaymentController {
    // peyment Servicein içine yazılan metotlar ile işlemler yapılcak .
    private final PaymentService paymentService ;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    // tümünü sorgulamak için kullanılacak .
    @GetMapping(value = "/getAllPayment")
    public List<Payment> getAll(){
        return this.paymentService.getPayments() ;
    }

    // eklemek için kulllanılacak
    @PostMapping(value = "/addPayment")
    public ResponseEntity<?> add(@RequestBody Payment payment){
        try {
            this.paymentService.createPayment(payment);
            // Responce entity döndürecek . ve ilgili mesajı yazacak .
            return ResponseEntity.ok("Payment added");
        }catch (Exception exception){
            System.out.println(exception.getLocalizedMessage() + " hatasııı");
            return ResponseEntity.badRequest().build() ;

        }

    }
    // silmek için kullanılacak
    @DeleteMapping(value = "/deletePayment/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")  Long id){
        try {
            // Responce entity döndürecek . ve ilgili mesajı yazacak .
            this.paymentService.deletePayment(id);
            return ResponseEntity.ok("payment deleted");
        }catch (Exception exception){
            System.out.println(exception.getLocalizedMessage() + " hatasııı2");
            return ResponseEntity.badRequest().build() ;
        }


    }
    // id ye göre aramak için kullanılacak.
    @GetMapping(value = "/getPaymentId/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.paymentService.findById(id)) ;
    }

}
