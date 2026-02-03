package br.com.sga.sga_dbv.controller;

import br.com.sga.sga_dbv.dto.EspecialidadeRequestDTO;
import br.com.sga.sga_dbv.dto.EspecialidadeResponseDTO;
import br.com.sga.sga_dbv.service.EspecialidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @PostMapping
    public ResponseEntity<EspecialidadeResponseDTO> cadastrar(@RequestBody @Valid EspecialidadeRequestDTO dto) {
        EspecialidadeResponseDTO novaEspecialidade = especialidadeService.cadastrar(dto);
        return new ResponseEntity<>(novaEspecialidade, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EspecialidadeResponseDTO>> listarTodos() {
        List<EspecialidadeResponseDTO> especialidades = especialidadeService.listarTodos();
        return ResponseEntity.ok(especialidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDTO> buscarPorId(@PathVariable Long id) {
        EspecialidadeResponseDTO especialidade = especialidadeService.buscarPorId(id);
        return ResponseEntity.ok(especialidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDTO> atualizar(@PathVariable Long id,
            @RequestBody @Valid EspecialidadeRequestDTO dto) {
        EspecialidadeResponseDTO atualizada = especialidadeService.atualizar(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        especialidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
