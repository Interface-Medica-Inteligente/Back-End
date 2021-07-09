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
	public Long authenticate(MedicoAtenticarDTO medicoAutenticarDto) {
		Optional<Medico> medico = medicoRepository.findByEmail(medicoAutenticarDto.getEmail());

		if (!medico.isPresent()) {
			throw new RegraNegocioException("Médico não encontrado para o email informado");
		}

		if (!medico.get().getSenha().equals(medicoAutenticarDto.getSenha())) {
			throw new RegraNegocioException("Senha inválida");
		}

		return medico.get().getId();
	}

	@Override
	public Long editar(long id, MedicoDTO medicoDto) {
		Medico medico = medicoRepository.findById(id).map(med -> {
			if(org.springframework.util.StringUtils.hasLength(medicoDto.getCpf())) {
				med.setCpf(medicoDto.getCpf());
			}

			if(org.springframework.util.StringUtils.hasLength(medicoDto.getCrm())) {
				med.setCrm(medicoDto.getCrm());
			}

			if(org.springframework.util.StringUtils.hasLength(medicoDto.getEmail())) {
				med.setEmail(medicoDto.getEmail());
			}

			if(org.springframework.util.StringUtils.hasLength(medicoDto.getNome())) {
				med.setNome(medicoDto.getNome());
			}

			if(medicoDto.getSexo() != '\u0000') {
				med.setSexo(medicoDto.getSexo());
			}

			return medicoRepository.save(med);
		}
		).orElseThrow(() -> new RegraNegocioException("Médico não encontrado"));

		return medico.getId();
	}

	@Override
	public MedicoDTO consultar(String cpf) {
		Optional<Medico> medico = medicoRepository.findByCpf(cpf);

		if(medico.isPresent()) {
			return new MedicoDTO(medico.get());
		}

		throw new RegraNegocioException("Não existe medico cadastrado para este cpf");
	}

}
