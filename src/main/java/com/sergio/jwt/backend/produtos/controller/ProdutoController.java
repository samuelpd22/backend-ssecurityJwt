package com.sergio.jwt.backend.produtos.controller;

import com.sergio.jwt.backend.produtos.dto.ProdutoDTO;
import com.sergio.jwt.backend.produtos.entity.ProdutoEntity;
import com.sergio.jwt.backend.produtos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<ProdutoEntity> cadastrarProduto(@RequestBody ProdutoDTO data){
        ProdutoEntity newProduto = new ProdutoEntity();
        BeanUtils.copyProperties(data, newProduto);
        return new ResponseEntity(produtoRepository.save(newProduto), HttpStatus.OK);

    }


    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> listarProdutos(){
        return new ResponseEntity(produtoRepository.findAll(), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            produtoRepository.deleteById(id);
            return new ResponseEntity<>("Deletado com sucesso",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }


}
