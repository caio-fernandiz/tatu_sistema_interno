package com.tatu.sistema.interno.tatu_sistema_interno.testeitem;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin("@")
@RequestMapping("/teste")
public class Controller {

    private final Servic servic;

    public Controller(Servic servic) {
        this.servic = servic;
    }

    @PostMapping("/post")
    public ResponseEntity<DTO> salvar(@Valid @RequestBody Mode mode) {
        DTO novaCoisaDTO = servic.salvar(mode);
        return new ResponseEntity<>(novaCoisaDTO, HttpStatus.CREATED);
    }

    @PutMapping("put/{identificador}")
    public ResponseEntity<DTO> atualizar(@PathVariable String identificador, @RequestBody DTO form) {
        return ResponseEntity.ok(servic.atualizar(identificador, form));
    }

    @GetMapping("/get/{identificador}")
    public ResponseEntity<DTO> achardModePeloIdentificador(@PathVariable String identificador) {
        DTO mode = servic.achardModePeloIdentificador(identificador);
        return new ResponseEntity<>(mode, HttpStatus.OK);
    }

    @GetMapping("/get/tudo")
    public ResponseEntity<List<DTO>> mostraTudo () {
        List<DTO> mode = servic.mostraTudo();
        return new ResponseEntity<>(mode, HttpStatus.OK);
    }

    @DeleteMapping("/deleta/{identificador}")
    public ResponseEntity<Void> deletar(@PathVariable String identificador){
        return ResponseEntity.noContent().build();
    }

}
