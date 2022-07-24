package com.graduationProjectEvam.billProcessing.controller;

import com.graduationProjectEvam.billProcessing.entity.Client;
import com.graduationProjectEvam.billProcessing.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping(value = "/clients") // ilgili tablo kullanılacak
@RequestScope
public class ClientController {
    // client servisteki metotlar kullanılacak
    private final ClientService clientService ;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    // tüm clientler görüntülenecek
    @GetMapping(value = "/getAllClient")
    public List<Client> getAll(){
        return this.clientService.getClients() ;
    }
    // client eklenecek
    @PostMapping(value = "/addClient")
    public ResponseEntity<?> add(@RequestBody Client client){
        try {
            this.clientService.createClient(client);
            return ResponseEntity.ok("Client added");
        }catch (Exception exception){
            System.out.println(exception.getLocalizedMessage() + " hatasııı");
            return ResponseEntity.badRequest().build() ;

        }

    }
        // silmek için kullanılacak
    @DeleteMapping(value = "/deleteClient/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")  Long id){
        try {
            this.clientService.deleteClient(id);
            return ResponseEntity.ok("Client deleted");
        }catch (Exception exception){
            System.out.println(exception.getLocalizedMessage() + " hatasııı2");
            return ResponseEntity.badRequest().build() ;
        }


    }
    // id si verilen client görüntülenecek .
    @GetMapping(value = "/getClientId/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.clientService.findById(id)) ;
    }
    // güncelleme yapılacak .
    @PutMapping(value = "/updateClient/{id}")
    public ResponseEntity<?> update(@RequestBody Client client, @PathVariable("id") Long id){
        try {
            this.clientService.updateClient(client,id);
            return ResponseEntity.ok("Client is updated") ;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return ResponseEntity.badRequest().build() ;
        }


    }


}
