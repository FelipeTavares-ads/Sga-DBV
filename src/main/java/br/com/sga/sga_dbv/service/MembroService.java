package br.com.sga.sga_dbv.service;

import br.com.sga.sga_dbv.dto.MembroRequestDTO;
import br.com.sga.sga_dbv.dto.MembroResponseDTO;
import br.com.sga.sga_dbv.model.Membro;
import br.com.sga.sga_dbv.model.Unidade;
import br.com.sga.sga_dbv.model.Especialidade;
import br.com.sga.sga_dbv.repository.MembroRepository;
import br.com.sga.sga_dbv.repository.UnidadeRepository;
import br.com.sga.sga_dbv.repository.EspecialidadeRepository;
import br.com.sga.sga_dbv.model.Desbravador;
import br.com.sga.sga_dbv.model.Diretoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public MembroResponseDTO cadastrar(MembroRequestDTO dto) {
        if (dto.getNome() == null || dto.getNome().isEmpty()) {
            throw new RuntimeException("O nome do membro é obrigatório!");
        }

        Membro membro;

        if ("DESBRAVADOR".equalsIgnoreCase(dto.getTipo())) {
            Desbravador desbravador = new Desbravador();

            if (dto.getUnidadeId() != null) {
                Unidade unidadeEncontrada = unidadeRepository.findById(dto.getUnidadeId())
                        .orElseThrow(
                                () -> new RuntimeException("Unidade não encontrada com ID: " + dto.getUnidadeId()));
                desbravador.setUnidade(unidadeEncontrada);
            }
            membro = desbravador;

        } else if ("DIRETORIA".equalsIgnoreCase(dto.getTipo())) {
            Diretoria diretoria = new Diretoria();
            diretoria.setCargo(dto.getCargo());
            membro = diretoria;
        } else {
            throw new RuntimeException("Tipo de membro inválido ou não informado. Use 'DESBRAVADOR' ou 'DIRETORIA'.");
        }

        membro.setNome(dto.getNome());
        membro.setIdade(dto.getIdade());

        if (dto.getAtivo() != null) {
            membro.setAtivo(dto.getAtivo());
        } else {
            membro.setAtivo(true);
        }
        if (dto.getEspecialidadesIds() != null && !dto.getEspecialidadesIds().isEmpty()) {
            List<Especialidade> listaEspecialidades = especialidadeRepository
                    .findAllById(dto.getEspecialidadesIds());
            membro.setEspecialidades(listaEspecialidades);
        }

        Membro salvo = membroRepository.save(membro);
        return new MembroResponseDTO(salvo);
    }

    public List<MembroResponseDTO> listarTodos() {
        List<Membro> listaNoBanco = membroRepository.findAll();
        List<MembroResponseDTO> listaResposta = new ArrayList<>();

        for (Membro m : listaNoBanco) {
            listaResposta.add(new MembroResponseDTO(m));
        }

        return listaResposta;
    }

    public MembroResponseDTO buscarPorId(Long id) {
        Membro membro = membroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membro não encontrado com ID: " + id));
        return new MembroResponseDTO(membro);
    }

    public MembroResponseDTO atualizar(Long id, MembroRequestDTO dto) {
        Membro membro = membroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membro não encontrado com ID: " + id));

        membro.setNome(dto.getNome());
        membro.setIdade(dto.getIdade());

        if (membro instanceof Diretoria) {
            Diretoria diretoria = (Diretoria) membro;
            if (dto.getCargo() != null) {
                diretoria.setCargo(dto.getCargo());
            }
        }

        if (membro instanceof Desbravador) {
            Desbravador desbravador = (Desbravador) membro;
            if (dto.getUnidadeId() != null) {
                Unidade unidade = unidadeRepository.findById(dto.getUnidadeId())
                        .orElseThrow(() -> new RuntimeException("Unidade não encontrada"));
                desbravador.setUnidade(unidade);
            }
        }

        if (dto.getAtivo() != null) {
            membro.setAtivo(dto.getAtivo());
        }

        if (dto.getEspecialidadesIds() != null) {
            List<Especialidade> novasEspecialidades = especialidadeRepository.findAllById(dto.getEspecialidadesIds());
            membro.setEspecialidades(novasEspecialidades);
        }

        Membro atualizado = membroRepository.save(membro);
        return new MembroResponseDTO(atualizado);
    }

    public void deletar(Long id) {
        if (!membroRepository.existsById(id)) {
            throw new RuntimeException("Membro não encontrado com ID: " + id);
        }
        membroRepository.deleteById(id);
    }
}
