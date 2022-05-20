package br.ufs.dcomp.interfacemedicainteligente.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Validator;

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
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.MedicamentoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.ReceitaCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.FiltroReceitaDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.InformacaoReceitaDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicamentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.PrescricaoCmd;
import br.ufs.dcomp.interfacemedicainteligente.service.ReceitaService;
import br.ufs.dcomp.interfacemedicainteligente.useful.ValidacaoUtil;

@Service
public class ReceitaServiceImpl implements ReceitaService {

	@Autowired
	private Validator validator;

	@Autowired
	private ReceitaRepository receitaRepository;

	@Autowired
	private PrescricaoRepository prescricaoRepository;

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	@Override
	public List<InformacaoReceitaDTO> consultarReceitas(Long idPaciente) {
		if (idPaciente < 1) {
			throw new RegraNegocioException("Identificador de paciente inválido.");
		}

		Optional<Receita> receitas = receitaRepository.findByIdPaciente(idPaciente);

		if (receitas.isPresent()) {
			return converterReceitas(receitas);
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public Long cadastrarPrescricao(PrescricaoCmd prescricaoCmd) {
		ValidacaoUtil.validarCmd(prescricaoCmd, validator);

		Prescricao prescricao = new Prescricao();

		prescricao.setMedicamento(cadastrarMedicamento(prescricaoCmd.getMedicamento()));
		prescricao.setQuantidadeDeUso(prescricaoCmd.getQuantidadeUso());
		prescricao.setQuantidadeDiaria(prescricaoCmd.getQuantidadeDiaria());
		prescricao.setReceita(cadastrarReceita(prescricaoCmd.getReceita()));

		return prescricaoRepository.save(prescricao).getId();
	}

	@Override
	public List<InformacaoReceitaDTO> consultarReceitaPorFiltro(FiltroReceitaDTO filtroReceitaDto) {
		Optional<Receita> receitas = null;

		if (!StringUtils.hasLength(filtroReceitaDto.getMedicamento())) {
			throw new RegraNegocioException("Preencha o campo da consulta");
		}

		receitas = receitaRepository.findByFiltro(filtroReceitaDto.getMedicamento(), filtroReceitaDto.getAtendimento());

		if (receitas.isPresent()) {
			return converterReceitas(receitas);
		}

		throw new RegraNegocioException("Receita não encontrada");
	}

	public List<PrescricaoCmd> consultarPrescricao() {
		return null;
	}

	private List<InformacaoReceitaDTO> converterReceitas(Optional<Receita> receitas) {
		return receitas.stream().map(receita -> {
			List<MedicamentoDTO> medicamentos = new ArrayList<>();
			MedicamentoDTO medicamento = null;

			receita.getAtendimento().getDataAtendimento();

			for (Prescricao prescricao : receita.getPrescricoes()) {
				medicamento = new MedicamentoDTO(prescricao.getMedicamento().getNome());
				medicamentos.add(medicamento);
			}

			InformacaoReceitaDTO receitaDto = new InformacaoReceitaDTO(receita.getId(),
					receita.getAtendimento().getDataAtendimento(), medicamentos);

			return receitaDto;
		}).collect(Collectors.toList());
	}

	private Medicamento cadastrarMedicamento(MedicamentoCmd medicamentoCmd) {
		Optional<Medicamento> medicamento = medicamentoRepository.findByNome(medicamentoCmd.getNome());

		if (medicamento.isPresent()) {
			return medicamento.get();
		} else {
			Medicamento med = new Medicamento();

			med.setNome(medicamentoCmd.getNome());

			return medicamentoRepository.save(med);

		}
	}

	private Receita cadastrarReceita(ReceitaCmd receitaDto) {
		Optional<Receita> receita = receitaRepository.findByIdAtendimento(receitaDto.getAtendimento());

		if (receita.isPresent()) {
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

}
