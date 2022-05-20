package br.ufs.dcomp.interfacemedicainteligente.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medico;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.MedicoRepository;
import br.ufs.dcomp.interfacemedicainteligente.exception.RegraNegocioException;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.MedicoAutenticarCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.MedicoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.PessoaDocumentoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.MedicoService;
import br.ufs.dcomp.interfacemedicainteligente.useful.ValidacaoUtil;
import br.ufs.dcomp.interfacemedicainteligente.useful.ValidatorDocumentUseful;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private Validator validator;

	@Override
	@Transactional(readOnly = true)
	public List<MedicoDTO> findAll() {
		List<Medico> list = medicoRepository.findAll();
		return list.stream().map(medico -> new MedicoDTO(medico)).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public MedicoDTO findById(long idMedico) {
		if (idMedico < 1L) {
			throw new RegraNegocioException("Identificador inválido");
		}

		Optional<Medico> medico = medicoRepository.findById(idMedico);

		if (medico.isPresent()) {
			return new MedicoDTO(medico.get());
		}

		throw new RegraNegocioException("Não existe medico cadastrado para este identificador");
	}

	/**
	 * Metodo responsavel pelo cadastro do medico
	 * 
	 * @param medicoCmd
	 * @return um {@link Long} contendo o id do medico cadastrado.
	 */
	@Override
	@Transactional
	public Long cadastrar(MedicoCmd medicoCmd) {
		ValidacaoUtil.validarCmd(medicoCmd, validator);
		if (!ValidatorDocumentUseful.validarCpf(medicoCmd.getCpf()))
			throw new RegraNegocioException("CPF Inválido.");

		try {
			Medico medico = new Medico();

			medico.setNome(medicoCmd.getNome());
			medico.setCpf(medicoCmd.getCpf());
			medico.setEmail(medicoCmd.getEmail());
			medico.setSexo(medicoCmd.getSexo());
			medico.setCrm(medicoCmd.getCrm());
			medico.setSenha(medicoCmd.getSenha());

			medicoRepository.save(medico);

			return medico.getId();
		} catch (DataIntegrityViolationException ex) {
			throw new RegraNegocioException("CPF já cadastrado no sistema");
		}
	}

	@Override
	public Long autenticar(MedicoAutenticarCmd medicoAutenticarCmd) {
		ValidacaoUtil.validarCmd(medicoAutenticarCmd, validator);

		Optional<Medico> medico = medicoRepository.findByEmail(medicoAutenticarCmd.getEmail());

		if (!medico.isPresent()) {
			throw new RegraNegocioException("Médico não encontrado para o email informado");
		}

		if (!medico.get().getSenha().equals(medicoAutenticarCmd.getSenha())) {
			throw new RegraNegocioException("Senha inválida");
		}

		return medico.get().getId();
	}

	@Override
	public MedicoDTO consultar(PessoaDocumentoCmd pessoaDocumentoCmd) {
		ValidacaoUtil.validarCmd(pessoaDocumentoCmd, validator);

		Optional<Medico> medico = medicoRepository.findByCpf(pessoaDocumentoCmd.getCpf());

		if (medico.isEmpty()) {
			throw new RegraNegocioException("Não existe medico cadastrado para este cpf");
		}

		return new MedicoDTO(medico.get());
	}

}
