package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.TransacaoDTO;
import com.example.demo.servicos.TransacaoServico;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TransacaoControlador {

    @Autowired
    private TransacaoServico servico;

    @PostMapping("/transacao")
    public ResponseEntity<Void> novaTransacao(@Valid @RequestBody TransacaoDTO dto) {
        servico.salvar(dto);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> limpar() {
        servico.limpar();
        return ResponseEntity.ok().build();
    }
}
