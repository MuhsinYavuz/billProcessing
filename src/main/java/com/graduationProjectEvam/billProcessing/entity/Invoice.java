package com.graduationProjectEvam.billProcessing.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

//hubernate jpa bilgileri anotacionları belirttik .
@Entity
@Table(name = "invoices")//tablo oluşrturuldu
//özel alanı ayırdık  .
// Invoices öznitelikleri tanımlandı
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id  ;
    @ManyToOne()
    @JsonIgnoreProperties({"invoices","payments"})
    @JoinColumn(name = "clientId")
    private Client client  ;

    private double debt ;

    private LocalDate date ;

    private int status = 0 ;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Invoice(long id, Client client, double debt, LocalDate date, int status) {
        this.id = id;
        this.client = client;
        this.debt = debt;
        this.date = date;
        this.status = status;
    }

    public Invoice(){

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id;
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

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
