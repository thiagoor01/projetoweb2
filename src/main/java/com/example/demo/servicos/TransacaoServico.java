package com.example.demo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.TransacaoDTO;
import com.example.demo.modelos.Transacao;
import com.example.demo.repositorios.TransacaoRepositorio;

@Service
public class TransacaoServico {

    @Autowired
    private TransacaoRepositorio repositorio;

    public void salvar(TransacaoDTO dto) {
        Transacao transacao = new Transacao();
        transacao.setValor(dto.valor());
        transacao.setDataHora(dto.dataHora());

        repositorio.save(transacao);
    }

    public void limpar() {
        repositorio.deleteAll();
    }

}
