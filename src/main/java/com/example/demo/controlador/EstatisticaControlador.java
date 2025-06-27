package com.example.demo.controlador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.servicos.EstatisticaServico;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class EstatisticaControlador {
    
    @Autowired
    private EstatisticaServico servico;

    @GetMapping("/estatistica")
    public Map<String, Object> estatisticas() {
        return servico.estatisticaUltimoMinuto();
    }
    
}
