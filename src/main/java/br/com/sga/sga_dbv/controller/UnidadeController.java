package br.com.sga.sga_dbv.controller;

import br.com.sga.sga_dbv.dto.UnidadeRequestDTO;
import br.com.sga.sga_dbv.dto.UnidadeResponseDTO;
import br.com.sga.sga_dbv.service.UnidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @PostMapping
    public ResponseEntity<UnidadeResponseDTO> cadastrar(@RequestBody @Valid UnidadeRequestDTO dto) {
        UnidadeResponseDTO novaUnidade = unidadeService.cadastrar(dto);
        return new ResponseEntity<>(novaUnidade, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UnidadeResponseDTO>> listarTodos() {
        List<UnidadeResponseDTO> unidades = unidadeService.listarTodos();
        return ResponseEntity.ok(unidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeResponseDTO> buscarPorId(@PathVariable Long id) {
        UnidadeResponseDTO unidade = unidadeService.buscarPorId(id);
        return ResponseEntity.ok(unidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeResponseDTO> atualizar(@PathVariable Long id,
            @RequestBody @Valid UnidadeRequestDTO dto) {
        UnidadeResponseDTO atualizada = unidadeService.atualizar(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        unidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
