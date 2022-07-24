package com.graduationProjectEvam.billProcessing.repo;


import com.graduationProjectEvam.billProcessing.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//anotacion belirtildi.
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
