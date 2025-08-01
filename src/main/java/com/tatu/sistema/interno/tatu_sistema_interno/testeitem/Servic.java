package com.tatu.sistema.interno.tatu_sistema_interno.testeitem;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Servic {

    private final Repository repository;
    private final Updater updater;

    public Servic(Repository repository, Updater updater) {
        this.repository = repository;
        this.updater = updater;
    }

    public DTO salvar(Mode mode) {
        if (repository.existsByIdentificador(mode.getIdentificador())) {
            throw new IllegalArgumentException("já tem");
        } else {
            return new DTO(repository.save(mode));
        }
    }

    public DTO atualizar(String identificador, DTO form) {
    Mode mode = repository.findByIdentificador(identificador).orElseThrow(() -> new RuntimeException("Não tem"));
    
    // Verifica se está tentando alterar para um identificador que já existe
    if(form.identificador() != null && !form.identificador().equals(identificador) && repository.existsByIdentificador(form.identificador())) {
        throw new IllegalArgumentException("Já existe outro registro com este identificador");
    }
    
    updater.atualizar(mode, form);
    repository.save(mode);
    return new DTO(mode);
}

    public DTO achardModePeloIdentificador(String identificador){
        return repository.findByIdentificador(identificador).map(DTO::new).orElseThrow(() -> new RuntimeException("não achado" + identificador));
    }

    public List<DTO> mostraTudo(){
        return repository.findAll().stream().map(DTO::new).toList();
    }

    public void deletar(String identificador){
        repository.deleteByIdentificador(identificador);
    }
}
