
package com.banco.banco_digital;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.HashMap;

@RestController
public class InformacoesController {

    @GetMapping("/")
    public Map<String, Object> infoProjeto() {
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("projeto", "Banco Digital JohnArt");
        resposta.put("integrantes", new String[] {"Seu Nome", "Parceiro (se tiver)"});
        return resposta;
    }

    @GetMapping("/api/status")
    public Map<String, String> statusSistema() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "online");
        status.put("mensagem", "API rodando com sucesso e conectável pelo front-end.");
        return status;
    }
}