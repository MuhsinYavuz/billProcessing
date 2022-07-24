package com.graduationProjectEvam.billProcessing.services;

import com.graduationProjectEvam.billProcessing.entity.Invoice;
import com.graduationProjectEvam.billProcessing.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository ;


    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
    // invoice leri tümünü göstermek için kullanılacak  service.
    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }
    // invoice leri olusuturmak için kullanılacak  service.
    public void createInvoice(Invoice invoiceToAdd){
        invoiceRepository.save(invoiceToAdd) ;
        System.out.println(invoiceToAdd.getClient().getId() +  "' id li müşteriye " + invoiceToAdd.getId() +" ' id li fatura eklendi");
    }
    // invoice leri olusuturmak için silinecek  service.
    public void deleteInvoice(Long id){
        invoiceRepository.deleteById(id);
        System.out.println("id si " +  id +  " olan fatura silindi");
    }
    // invoice leri id ye göre gösterecek service.
    public Invoice findById(Long id){
        return this.invoiceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Invoice Not Found")) ;
    }
    // invoice leri güncellemek için kullanılacak  service.
    @Transactional
    public void updateInvoice(Invoice invoice, Long id){
        // eğer id li invoice yoksa bildirecek
        Invoice invoiceToUpdate = this.invoiceRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Invoiced Not Found")) ;
        invoiceToUpdate.setClient(invoice.getClient() == null ? invoiceToUpdate.getClient() : invoice.getClient());
        // eğer ilgili yerler boşssa bir önceki değer tekrar edecek .
        invoiceToUpdate.setDate(invoice.getDate() == null ? invoiceToUpdate.getDate() : invoice.getDate());
    }
}
