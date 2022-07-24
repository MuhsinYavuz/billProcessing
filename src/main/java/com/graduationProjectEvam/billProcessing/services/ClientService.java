package com.graduationProjectEvam.billProcessing.services;

import com.graduationProjectEvam.billProcessing.entity.Client;
import com.graduationProjectEvam.billProcessing.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository ;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    // client leri tümünü göstermek için kullanılacak  service.
    public List<Client> getClients(){
        return clientRepository.findAll();
    }
    // client oluşturmak için kullanılacak service.
    public void createClient(Client clientToAdd){
        clientRepository.save(clientToAdd) ;
        System.out.println(clientToAdd.getFirstName() +  " eklendi");
    }
    // client silmek için kullanıcılacak service
    public void deleteClient(Long id){
        clientRepository.deleteById(id);
        System.out.println(id +  "' li müşteri silindi");
    }
    // id ye göre client aramak için kullanılacak servis
    public Client findById(Long id){
        return this.clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client Not Found")) ;
    }
    // client güncellemesi yapmak için kullanılacak servis .
    @Transactional
    public void updateClient(Client client,Long id){
        Client clientToUpdate = this.clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client Not found")) ;
        // eğer ilgili yerler boşssa bir önceki değer tekrar edecek .
        clientToUpdate.setFirstName(client.getFirstName() == null ? clientToUpdate.getFirstName() : client.getFirstName());
        clientToUpdate.setLastName(client.getLastName() == null ?  clientToUpdate.getLastName() : client.getLastName());
    }

}
