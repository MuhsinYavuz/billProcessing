package com.graduationProjectEvam.billProcessing.repo;


import com.graduationProjectEvam.billProcessing.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//anotacion belirtildi.
@Repository
public interface PaymentRepository  extends JpaRepository<Payment,Long> {

}
