package com.banco.banco_digital.repositories.config;

import com.banco.banco_digital.entities.Usuario;
import com.banco.banco_digital.repositories.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseSeeder {

    @Bean
    public CommandLineRunner seedBanco(UsuarioRepository usuarioRepository) {
        return args -> {
            if (usuarioRepository.count() == 0) {
                Usuario u1 = new Usuario(null, "João", "joao@email.com", "1234");
                Usuario u2 = new Usuario(null, "Maria", "maria@email.com", "5678");

                usuarioRepository.save(u1);
                usuarioRepository.save(u2);

                System.out.println("✅ Usuários de teste adicionados ao banco!");
            }
        };
    }
}