package com.example.demo.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.modelos.Transacao;
import java.time.OffsetDateTime;


public interface TransacaoRepositorio extends JpaRepository<Transacao, Integer> {
    
    List<Transacao> findByDataHoraAfter(OffsetDateTime dataHora);

}
