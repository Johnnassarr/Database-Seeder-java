package com.banco.banco_digital;

import com.banco.banco_digital.entities.Usuario;
import com.banco.banco_digital.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isBlank())
            return ResponseEntity.badRequest().body("Nome é obrigatório.");
        if (usuario.getEmail() == null || usuario.getEmail().isBlank())
            return ResponseEntity.badRequest().body("Email é obrigatório.");
        if (usuario.getSenha() == null || usuario.getSenha().length() < 4)
            return ResponseEntity.badRequest().body("A senha deve ter pelo menos 4 caracteres.");
        if (usuarioRepository.existsByEmail(usuario.getEmail()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já cadastrado.");

        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!");
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        Optional<Usuario> encontrado = usuarioRepository.findAll().stream()
            .filter(u -> u.getEmail().equals(usuario.getEmail()) && u.getSenha().equals(usuario.getSenha()))
            .findFirst();

        return encontrado.isPresent() ? "Login bem-sucedido!" : "Email ou senha incorretos.";
    }
}
