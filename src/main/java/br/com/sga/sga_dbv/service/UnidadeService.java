package br.com.sga.sga_dbv.service;

import br.com.sga.sga_dbv.dto.UnidadeRequestDTO;
import br.com.sga.sga_dbv.dto.UnidadeResponseDTO;
import br.com.sga.sga_dbv.model.Unidade;
import br.com.sga.sga_dbv.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public UnidadeResponseDTO cadastrar(UnidadeRequestDTO dto) {

        Unidade unidade = new Unidade();

        unidade.setNome(dto.getNome());
        unidade.setGritoDeGuerra(dto.getGritoDeGuerra());
        unidade.setCorPadrao(dto.getCorPadrao());

        Unidade salva = unidadeRepository.save(unidade);
        return new UnidadeResponseDTO(salva);
    }

    public List<UnidadeResponseDTO> listarTodos() {
        List<Unidade> listaBanco = unidadeRepository.findAll();
        List<UnidadeResponseDTO> listaResposta = new ArrayList<>();

        for (Unidade u : listaBanco) {

            listaResposta.add(new UnidadeResponseDTO(u));
        }

        return listaResposta;
    }

    public UnidadeResponseDTO buscarPorId(Long id) {
        Unidade unidade = unidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unidade não encontrada com ID: " + id));
        return new UnidadeResponseDTO(unidade);
    }

    public UnidadeResponseDTO atualizar(Long id, UnidadeRequestDTO dto) {
        Unidade unidade = unidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unidade não encontrada com ID: " + id));

        unidade.setNome(dto.getNome());
        unidade.setGritoDeGuerra(dto.getGritoDeGuerra());
        unidade.setCorPadrao(dto.getCorPadrao());

        Unidade atualizada = unidadeRepository.save(unidade);
        return new UnidadeResponseDTO(atualizada);
    }

    public void deletar(Long id) {
        if (!unidadeRepository.existsById(id)) {
            throw new RuntimeException("Unidade não encontrada com ID: " + id);
        }
        unidadeRepository.deleteById(id);
    }
}
