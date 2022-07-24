package com.graduationProjectEvam.billProcessing.controller;

import com.graduationProjectEvam.billProcessing.entity.Client;
import com.graduationProjectEvam.billProcessing.entity.Invoice;
import com.graduationProjectEvam.billProcessing.services.ClientService;
import com.graduationProjectEvam.billProcessing.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping(value = "/invoices") // tablo kullanılacak .
@RequestScope
public class InvoiceController {

    // invoice serviste yazılan metotlar kullanılacak .
    private final InvoiceService invoiceService ;
    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    // tümünü görüntülemek için kullanıclacak
    @GetMapping(value = "/getAllInvoice")
    public List<Invoice> getAll(){
        return this.invoiceService.getInvoices();
    }

    @PostMapping(value = "/addInvoices")
    public ResponseEntity<?> add(@RequestBody Invoice invoice){
        try {
            this.invoiceService.createInvoice(invoice);
            return ResponseEntity.ok("Invoice added");
        }catch (Exception exception){
            System.out.println(exception.getLocalizedMessage() + " hatasııı");
            return ResponseEntity.badRequest().build() ;

        }

    }
    // silmek için kullanılacak .
    @DeleteMapping(value = "/deleteInvoice/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")  Long id){
        try {
            this.invoiceService.deleteInvoice(id);
            return ResponseEntity.ok("Invoice deleted");
        }catch (Exception exception){
            System.out.println(exception.getLocalizedMessage() + " hatasııı2");
            return ResponseEntity.badRequest().build() ;
        }


    }
// id si verilen invoice görmek için kullanılacak .
    @GetMapping(value = "/getInvoiceId/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.invoiceService.findById(id)) ;
    }
    // güncelleme yapmak için kullanılacak .
    @PutMapping(value = "/updateInvoice/{id}")
    public ResponseEntity<?> update(@RequestBody Invoice invoice, @PathVariable("id") Long id){
        try {
            this.invoiceService.updateInvoice(invoice,id);
            return ResponseEntity.ok("Invoiced is updated") ;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return ResponseEntity.badRequest().build() ;
        }
    }
}
