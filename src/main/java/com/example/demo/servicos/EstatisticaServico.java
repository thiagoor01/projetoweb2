package com.example.demo.servicos;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Transacao;
import com.example.demo.repositorios.TransacaoRepositorio;

@Service
public class EstatisticaServico {
    
    @Autowired
    private TransacaoRepositorio repositorio;

    public Map<String, Object> estatisticaUltimoMinuto() {
        OffsetDateTime agora = OffsetDateTime.now(ZoneOffset.UTC).minusSeconds(60);
        List<Transacao> transacaos = repositorio.findByDataHoraAfter(agora);

        DoubleSummaryStatistics stats = transacaos.stream().mapToDouble(Transacao::getValor).summaryStatistics();
        return Map.of("count", stats.getCount(),
                "sum", stats.getSum(),
                "avg", stats.getCount() > 0 ? stats.getAverage() : 0.0,
                "min", stats.getCount() > 0 ? stats.getMin() : 0.0,
                "max", stats.getCount() > 0 ? stats.getMax() : 0.0);
    }

}
