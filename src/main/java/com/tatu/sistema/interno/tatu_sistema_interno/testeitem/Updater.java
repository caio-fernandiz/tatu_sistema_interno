package com.tatu.sistema.interno.tatu_sistema_interno.testeitem;

import org.springframework.stereotype.Component;

@Component
public class Updater {

    public void atualizar (Mode mode, DTO form){
        if (form.nomeDaCoisa() != null) mode.setNomeDaCoisa(form.nomeDaCoisa());
        if (form.quantidade() != null) mode.setQuantidade(form.quantidade()); 
        if(form.identificador() != null && !form.identificador().equals(mode.getIdentificador())) mode.setIdentificador(form.identificador());
    }
}
