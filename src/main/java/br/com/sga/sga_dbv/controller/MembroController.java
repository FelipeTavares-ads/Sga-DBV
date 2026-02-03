package br.com.sga.sga_dbv.controller;

import br.com.sga.sga_dbv.dto.MembroRequestDTO;
import br.com.sga.sga_dbv.dto.MembroResponseDTO;
import br.com.sga.sga_dbv.service.MembroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/membros")
public class MembroController {

    @Autowired
    private MembroService membroService;

    @PostMapping
    public ResponseEntity<MembroResponseDTO> cadastrar(@RequestBody MembroRequestDTO dto) {
        MembroResponseDTO novoMembro = membroService.cadastrar(dto);
        return new ResponseEntity<>(novoMembro, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MembroResponseDTO>> listarTodos() {
        List<MembroResponseDTO> membros = membroService.listarTodos();
        return ResponseEntity.ok(membros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembroResponseDTO> buscarPorId(@PathVariable Long id) {
        MembroResponseDTO membro = membroService.buscarPorId(id);
        return ResponseEntity.ok(membro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembroResponseDTO> atualizar(@PathVariable Long id,
            @RequestBody @Valid MembroRequestDTO dto) {
        MembroResponseDTO atualizado = membroService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        membroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
