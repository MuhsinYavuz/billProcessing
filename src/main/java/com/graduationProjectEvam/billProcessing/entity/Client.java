package com.graduationProjectEvam.billProcessing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
//hubernate jpa bilgileri anotacionları belirttik .
@Entity
@Table(name = "clients") //tablo oluşrturuldu
public class Client {
    //özel alanı ayırdık  .
// Client öznitelikleri tanımlandı .
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id ;

    @JsonIgnoreProperties({"client"})
    @OneToMany(mappedBy = "client")
    private List<Invoice> invoices;

    @JsonIgnoreProperties({"client"})
    @OneToMany(mappedBy = "client")
    private List<Payment> payments ;
    private String firstName ;
    private String lastName ;

    //getter - setter - hashCode - equals - const oluşturuldu .
    public Client(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Client(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
