package com.bwardweb.security.security_service.bootstrap;

import com.bwardweb.security.security_service.entities.Client;
import com.bwardweb.security.security_service.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final ClientRepository clientRepository;

    public BootStrapData(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadClients();
    }

    private void loadClients(){
        if(clientRepository.count() == 0){
            Client client1 = Client.builder()
                    .clientSecret("secret")
                    .redirectUrl("redirectUrl")
                    .build();

            clientRepository.save(client1);
        }
    }
}
