package br.com.sga.sga_dbv.service;

import br.com.sga.sga_dbv.dto.EspecialidadeRequestDTO;
import br.com.sga.sga_dbv.dto.EspecialidadeResponseDTO;
import br.com.sga.sga_dbv.model.Especialidade;
import br.com.sga.sga_dbv.repository.EspecialidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public EspecialidadeResponseDTO cadastrar(EspecialidadeRequestDTO dto) {
        if (dto.getNome() == null || dto.getNome().isEmpty()) {
            throw new RuntimeException("Erro: O nome é obrigatório!");
        }
        if (dto.getArea() == null || dto.getArea().isEmpty()) {
            throw new RuntimeException("Erro: A área é obrigatória!");
        }

        Especialidade especialidade = new Especialidade();
        especialidade.setNome(dto.getNome());
        especialidade.setArea(dto.getArea());
        especialidade.setNivel(dto.getNivel());
        Especialidade salva = especialidadeRepository.save(especialidade);
        return new EspecialidadeResponseDTO(salva);
    }

    public List<EspecialidadeResponseDTO> listarTodos() {
        List<Especialidade> especialidades = especialidadeRepository.findAll();
        List<EspecialidadeResponseDTO> resposta = new java.util.ArrayList<>();

        for (Especialidade especialidade : especialidades) {
            resposta.add(new EspecialidadeResponseDTO(especialidade));
        }

        return resposta;
    }

    public EspecialidadeResponseDTO buscarPorId(Long id) {
        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidade não encontrada com ID: " + id));
        return new EspecialidadeResponseDTO(especialidade);
    }

    public EspecialidadeResponseDTO atualizar(Long id, EspecialidadeRequestDTO dto) {
        Especialidade especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidade não encontrada com ID: " + id));

        especialidade.setNome(dto.getNome());
        especialidade.setArea(dto.getArea());
        especialidade.setNivel(dto.getNivel());
        Especialidade atualizada = especialidadeRepository.save(especialidade);
        return new EspecialidadeResponseDTO(atualizada);
    }

    public void deletar(Long id) {
        if (!especialidadeRepository.existsById(id)) {
            throw new RuntimeException("Especialidade não encontrada com ID: " + id);
        }
        especialidadeRepository.deleteById(id);
    }
}
