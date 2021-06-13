package br.ufs.dcomp.interfacemedicainteligente.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Medico;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.MedicoRepository;
import br.ufs.dcomp.interfacemedicainteligente.exception.RegraNegocioException;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoAtenticarDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.MedicoDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.MedicoService;
import br.ufs.dcomp.interfacemedicainteligente.useful.ValidatorDocumentUseful;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<MedicoDTO> findAll() {
		List<Medico> list = medicoRepository.findAll();
		return list.stream().map(medico -> new MedicoDTO(medico)).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public MedicoDTO findById(long idMedico) {
		Optional<Medico> medico = medicoRepository.findById(idMedico);

		if (medico.isPresent()) {
			return new MedicoDTO(medico.get());
		}

		throw new RegraNegocioException("Não existe medico cadastrado para este identificador");
	}

	@Override
	@Transactional
	public Long cadastrar(MedicoDTO medicoDto) {

		if (!ValidatorDocumentUseful.validarCpf(medicoDto.getCpf()))
			throw new RegraNegocioException("CPF Inválido.");

		Medico medico = new Medico();

		medico.setNome(medicoDto.getNome());
		medico.setCpf(medicoDto.getCpf());
		medico.setEmail(medicoDto.getEmail());
		medico.setSexo(medicoDto.getSexo());
		medico.setCrm(medicoDto.getCrm());
		medico.setSenha(medicoDto.getSenha());

		medicoRepository.save(medico);

		return medico.getId();
	}

	@Override
	public Long authenticate(MedicoAtenticarDTO medicoAutenticar) {
		Optional<Medico> medico = medicoRepository.findByEmail(medicoAutenticar.getEmail());

		if (!medico.isPresent()) {
			throw new RegraNegocioException("Médico não encontrado para o email informado");
		}

		if (!medico.get().getSenha().equals(medicoAutenticar.getSenha())) {
			throw new RegraNegocioException("Senha inválida");
		}

		return medico.get().getId();
	}

}
