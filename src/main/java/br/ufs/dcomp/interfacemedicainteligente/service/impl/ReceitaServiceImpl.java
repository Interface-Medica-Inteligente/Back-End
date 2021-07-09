package br.ufs.dcomp.interfacemedicainteligente.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medicamento;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Prescricao;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Receita;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.MedicamentoRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.PrescricaoRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.ReceitaRepository;
import br.ufs.dcomp.interfacemedicainteligente.exception.RegraNegocioException;
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

    @Override
    public Long cadastrarReceita(ReceitaDTO receitaDto) {
        Receita receita = new Receita();

        receita.setDescricao(receitaDto.getDescricao());
        receita.setDataEmissao(LocalDate.now());
        receita.setSegundaVia(receitaDto.getSegunda_via());

        receitaRepository.save(receita);

        return receita.getId();
    }

    @Override
    public List<ReceitaDTO> consultarReceita() {

        return null;
    }

    @Override
    public Long cadastrarPrescricao(PrescricaoDTO prescricaoDto) {
        Prescricao prescricao = new Prescricao();

        if(prescricaoDto.getMedicamento() > 0 && prescricaoDto.getReceita() > 0) {
            Medicamento medicamento = new Medicamento();
            Receita receita = new Receita();

            medicamento.setId(prescricaoDto.getMedicamento());
            receita.setId(prescricaoDto.getReceita());

            prescricao.setMedicamento(medicamento);
            prescricao.setQuantidadeDeUso(prescricaoDto.getQuantidadeUso());
            prescricao.setQuantidadeDiaria(prescricaoDto.getQuantidadeDiaria());
            prescricao.setReceita(receita);

            prescricaoRepository.save(prescricao);

            return prescricao.getId();
        }

        throw new RegraNegocioException("");
    }

    @Override
    public List<PrescricaoDTO> consultarPrescricao() {
        return null;
    }

    @Override
    public Long cadastrarMedicamento(MedicamentoDTO medicamentoDto) {
        Medicamento medicamento = new Medicamento();

        medicamento.setNome(medicamentoDto.getNome());

        medicamentoRepository.save(medicamento);

        return medicamento.getId();
    }

    @Override
    public List<MedicamentoDTO> consultarMedicamento(MedicamentoDTO medicamentoDto) {
        List<Medicamento> medicamentos = medicamentoRepository.ConsultarPorNome(medicamentoDto.getNome());

        return medicamentos.stream().map(medicamento -> new MedicamentoDTO(medicamento)).collect(Collectors.toList());
    }
    
    
}
