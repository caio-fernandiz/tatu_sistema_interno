package com.tatu.sistema.interno.tatu_sistema_interno.testeitem;

public record DTO(String id, String nomeDaCoisa, String identificador, Integer quantidade) {
    public DTO(Mode mode){
        this(mode.getId(), mode.getNomeDaCoisa(), mode.getIdentificador(), mode.getQuantidade());
    }

}
