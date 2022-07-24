package com.graduationProjectEvam.billProcessing.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
//hubernate jpa bilgileri anotacionları belirttik .
@Entity
@Table(name = "payments")//tablo oluşrturuldu
//özel alanı ayırdık  .
// Payment öznitelikleri tanımlandı
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id ;
    @ManyToOne()
    @JsonIgnoreProperties({"payments","invoices"})
    @JoinColumn(name = "clientId")
    private Client client  ;
    private double paidTotal ;
    private LocalDate date ;
    public Payment(){
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getPaidTotal() {
        return paidTotal;
    }

    public void setPaidTotal(double paidTotal) {
        this.paidTotal = paidTotal;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Payment(long id, Client client, double paidTotal, LocalDate date) {
        this.id = id;
        this.client = client;
        this.paidTotal = paidTotal;
        this.date = date;
    }
}
