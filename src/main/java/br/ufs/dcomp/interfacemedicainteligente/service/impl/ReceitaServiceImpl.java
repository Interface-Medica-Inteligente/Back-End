package br.ufs.dcomp.interfacemedicainteligente.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medicamento;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Prescricao;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Receita;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.MedicamentoRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.PrescricaoRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.ReceitaRepository;
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
        Receita receita = new Receita();

        receita.setDescricao(receitaDto.getDescricao());
        receita.setDataEmissao(LocalDate.now());
        receita.setSegundaVia(receitaDto.getSegundaVia());

        receitaRepository.save(receita);

        return receita;
    }

    @Override
    public List<ReceitaDTO> consultarReceita() {

        return null;
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
            medicamento.get().setNome(medicamentoDto.getNome());

            return medicamentoRepository.save(medicamento.get());
            
        }
    }
    
    public List<MedicamentoDTO> consultarMedicamento(MedicamentoDTO medicamentoDto) {
        List<Medicamento> medicamentos = medicamentoRepository.ConsultarPorNome(medicamentoDto.getNome());

        return medicamentos.stream().map(medicamento -> new MedicamentoDTO(medicamento)).collect(Collectors.toList());
    }

}
