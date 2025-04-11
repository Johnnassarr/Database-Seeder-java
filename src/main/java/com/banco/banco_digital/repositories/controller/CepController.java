package com.banco.banco_digital.repositories.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/cep")
@CrossOrigin(origins = "*")
public class CepController {

    @GetMapping("/{cep}")
    @Cacheable("cepCache") // ← aqui ativa o cache com base no CEP
    public Map buscarCep(@PathVariable String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        Map response = restTemplate.getForObject(url, Map.class);
        if (response.containsKey("erro")) {
            throw new RuntimeException("CEP não encontrado");
        }
        return response;
    }
}
