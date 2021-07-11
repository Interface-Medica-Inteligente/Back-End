package br.ufs.dcomp.interfacemedicainteligente.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Atendimento;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medicamento;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Prescricao;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Receita;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.MedicamentoRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.PrescricaoRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.ReceitaRepository;
import br.ufs.dcomp.interfacemedicainteligente.exception.RegraNegocioException;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.FiltroReceitaDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.InformacaoReceitaDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicamentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PrescricaoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ReceitaDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.ReceitaService;

@Service
public class ReceitaServiceImpl implements ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private PrescricaoRepository prescricaoRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    private Receita cadastrarReceita(ReceitaDTO receitaDto) {
        Optional<Receita> receita = receitaRepository.findByIdAtendimento(receitaDto.getAtendimento());

        if(receita.isPresent()) {
            return receita.get();
        } else {
            Receita rec = new Receita();
            Atendimento atendimento = new Atendimento();

            atendimento.setId(receitaDto.getAtendimento());

            rec.setDescricao(receitaDto.getDescricao());
            rec.setDataEmissao(LocalDate.now());
            rec.setSegundaVia(receitaDto.getSegundaVia());
            rec.setAtendimento(atendimento);
    
            return receitaRepository.save(rec);
        }
    }

    @Override
    public List<InformacaoReceitaDTO> consultarReceitas(Long idPaciente) {
        Optional<Receita> receitas = receitaRepository.findByIdPaciente(idPaciente);

        if(receitas.isPresent()) {
            return converterReceitas(receitas);
        } else {
            return new ArrayList<>();
        }
    }

    private List<InformacaoReceitaDTO> converterReceitas(Optional<Receita> receitas) {
        return receitas.stream().map(receita -> {
            List<MedicamentoDTO> medicamentos = new ArrayList<>();
            MedicamentoDTO medicamento = null;
            
            for(Prescricao prescricao : receita.getPrescricoes()) {
                medicamento = new MedicamentoDTO(prescricao.getMedicamento().getNome());
                medicamentos.add(medicamento);
            }

            InformacaoReceitaDTO receitaDto = new InformacaoReceitaDTO(receita.getId(), receita.getDataEmissao(), medicamentos);

            return receitaDto;
        }).collect(Collectors.toList());
    }

    @Override
    public Long cadastrarPrescricao(PrescricaoDTO prescricaoDto) {
        Prescricao prescricao = new Prescricao();
        
        prescricao.setMedicamento(cadastrarMedicamento(prescricaoDto.getMedicamento()));
        prescricao.setQuantidadeDeUso(prescricaoDto.getQuantidadeUso());
        prescricao.setQuantidadeDiaria(prescricaoDto.getQuantidadeDiaria());
        prescricao.setReceita(cadastrarReceita(prescricaoDto.getReceita()));

        return prescricaoRepository.save(prescricao).getId();
    }

    public List<PrescricaoDTO> consultarPrescricao() {
        return null;
    }

    private Medicamento cadastrarMedicamento(MedicamentoDTO medicamentoDto) {
        Optional<Medicamento> medicamento = medicamentoRepository.findByNome(medicamentoDto.getNome());

        if(medicamento.isPresent()) {
            return medicamento.get();
        } else {
            Medicamento med = new Medicamento();
            
            med.setNome(medicamentoDto.getNome());

            return medicamentoRepository.save(med);
            
        }
    }

    @Override
    public List<InformacaoReceitaDTO> consultarReceitaPorFiltro(FiltroReceitaDTO filtroReceitaDto) {
        Optional<Receita> receitas = null;

        if(StringUtils.hasLength(filtroReceitaDto.getMedicamento())) {
            receitas = receitaRepository.findByMedicamento(filtroReceitaDto.getMedicamento());
        } else if(filtroReceitaDto.getDataEmissao() != null) {
            receitas = receitaRepository.findByDataEmissao(filtroReceitaDto.getDataEmissao());
        } else if(filtroReceitaDto.getReceita() != null) {
            receitas = receitaRepository.findByFiltroId(filtroReceitaDto.getReceita());
        }

        if(receitas.isPresent()) {
            return converterReceitas(receitas);
        } 

        throw new RegraNegocioException("Receita não encontrada");
    }

}
