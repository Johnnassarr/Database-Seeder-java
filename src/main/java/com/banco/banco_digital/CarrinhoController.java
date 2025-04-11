package com.banco.banco_digital;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/carrinho")
@CrossOrigin(origins = "http://localhost:3000")
public class CarrinhoController {

    private List<CarrinhoItem> itens = new ArrayList<>();

    @GetMapping
    public List<CarrinhoItem> listarItens() {
        return itens;
    }

    @PostMapping
    public CarrinhoItem adicionarItem(@RequestBody CarrinhoItem item) {
        itens.add(item);
        return item;
    }

    @DeleteMapping
    public void limparCarrinho() {
        itens.clear();
    }
}