package com.bwardweb.security.security_service.bootstrap;

import com.bwardweb.security.security_service.entities.Client;
import com.bwardweb.security.security_service.entities.User;
import com.bwardweb.security.security_service.repository.ClientRepository;
import com.bwardweb.security.security_service.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final ClientRepository clientRepository;

    private final UserRepository userRepository;

    public BootStrapData(ClientRepository clientRepository, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadClients();
        loadUsers();
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

    private void loadUsers(){
        if(userRepository.count() == 0){
            User user1 = User.builder()
                    .username("test1")
                    .password("password")
                    .build();

            userRepository.save(user1);
        }
    }
}
