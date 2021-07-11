package br.ufs.dcomp.interfacemedicainteligente.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufs.dcomp.interfacemedicainteligente.domain.entity.Atendimento;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.CID10;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.CNES;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.RegistroAtendimento;
import br.ufs.dcomp.interfacemedicainteligente.domain.entity.RegistroCID10;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.CIDRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.CNESRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.RegistroAtendimentoRepository;
import br.ufs.dcomp.interfacemedicainteligente.domain.repository.RegistroCID10Repository;
import br.ufs.dcomp.interfacemedicainteligente.exception.RegraNegocioException;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CID10DTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CNESDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaCID10DTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.RegistroAtendimentoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.RegistroCID10DTO;
import br.ufs.dcomp.interfacemedicainteligente.service.RegistroAtendimentoService;

@Service
public class RegistroAtendimentoServiceImpl implements RegistroAtendimentoService {

	@Autowired
	private CIDRepository cidRepositorio;

	@Autowired
	private RegistroAtendimentoRepository registroAtendimentoRepositorio;

	@Autowired
	private CNESRepository cnesRepositorio;

	@Autowired
	private RegistroCID10Repository registroCID10Repositorio;

	@Override
	public Long cadastrarCID10(CID10DTO cid10dto) {
		CID10 cid10 = new CID10();

		cid10.setCodigo(cid10dto.getCodigo());
		cid10.setDescricao(cid10dto.getDescricao());

		return cidRepositorio.save(cid10).getId();
	}

	@Override
	public CID10DTO consultarCID10(ConsultaCID10DTO codigoCid10) {
		Optional<CID10> cid10 = cidRepositorio.findByCodigo(codigoCid10.getCodigoCid10());

		if (cid10.isPresent()) {
			return new CID10DTO(cid10.get());
		}

		throw new RegraNegocioException("Não foi encontrado um cid10 para o código passado.");
	}

	@Override
	public Long cadastrarCnes(CNESDTO cnesDto) {
		CNES cnes = new CNES();

		cnes.setCodigo(cnesDto.getCodigo());
		cnes.setNomeEstabelecimento(cnesDto.getNomeEstabelecimento());

		return cnesRepositorio.save(cnes).getId();
	}

	@Override
	public CNESDTO consultarCnes(Integer codigoCnes) {
		Optional<CNES> cnes = cnesRepositorio.findByCodigo(codigoCnes);

		if (cnes.isPresent()) {
			return new CNESDTO(cnes.get());
		}

		throw new RegraNegocioException("CNES não encontrado para o codigo passado.");
	}

	@Override
	public Long cadastrarRegistroAtendimento(RegistroAtendimentoDTO registroAtendimentoDto) {

		if (registroAtendimentoDto.getAtendimento() > 0L && registroAtendimentoDto.getCnes() > 0L) {
			Atendimento atendimento = new Atendimento();

			atendimento.setId(registroAtendimentoDto.getAtendimento());

			CNES cnes = new CNES();

			cnes.setId(registroAtendimentoDto.getCnes());

			RegistroAtendimento registroAtendimento = new RegistroAtendimento();

			registroAtendimento.setAnamnese(registroAtendimentoDto.isAnamnese());
			registroAtendimento.setAnamneseProgressao(registroAtendimentoDto.getAnamneseProgessao());
			registroAtendimento.setCnes(cnes);
			registroAtendimento.setAtendimento(atendimento);
			registroAtendimento.setEstadoTratamento(registroAtendimentoDto.getEstadoTratamento());

			return registroAtendimentoRepositorio.save(registroAtendimento).getId();
		}

		throw new RegraNegocioException("É necessário informar um identificador para o atendimento.");
	}

	@Override
	public List<RegistroAtendimentoDTO> consultarRegistroAtendimento() {

		return null;
	}

	@Override
	public Long cadastrarRegistroCid(RegistroCID10DTO registroCid10Dto) {
		if (registroCid10Dto.getRegistroAtendimento() > 0L && registroCid10Dto.getCid10() > 0L) {
			RegistroAtendimento registroAtendimento = new RegistroAtendimento();

			registroAtendimento.setId(registroCid10Dto.getRegistroAtendimento());

			CID10 cid10 = new CID10();

			cid10.setId(registroCid10Dto.getCid10());

			RegistroCID10 registroCID10 = new RegistroCID10();

			registroCID10.setRegistroAtendimento(registroAtendimento);
			registroCID10.setCid10(cid10);

			return registroCID10Repositorio.save(registroCID10).getId();
		}
		throw new RegraNegocioException(
				"É necessário informar o identificador do atendimento e idenditificador do CID10");
	}

	@Override
	public List<RegistroCID10DTO> consultarRegistroCid() {
		List<RegistroCID10> listaRegistroCID10 = registroCID10Repositorio.findAll();
		return listaRegistroCID10.stream().map(registroCID10 -> new RegistroCID10DTO(registroCID10))
				.collect(Collectors.toList());
	}

}
