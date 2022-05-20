package br.ufs.dcomp.interfacemedicainteligente.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Validator;

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
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CID10Cmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CNESCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CadastroRegistroAtendimentoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CadastroRegistroCid10Cmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.ConsultaCID10Cmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CID10DTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.CNESDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.RegistroCID10DTO;
import br.ufs.dcomp.interfacemedicainteligente.service.RegistroAtendimentoService;
import br.ufs.dcomp.interfacemedicainteligente.useful.ValidacaoUtil;

@Service
public class RegistroAtendimentoServiceImpl implements RegistroAtendimentoService {

	@Autowired
	private Validator validator;

	@Autowired
	private CIDRepository cidRepositorio;

	@Autowired
	private RegistroAtendimentoRepository registroAtendimentoRepositorio;

	@Autowired
	private CNESRepository cnesRepositorio;

	@Autowired
	private RegistroCID10Repository registroCID10Repositorio;

	@Override
	public Long cadastrarCID10(CID10Cmd cid10Cmd) {
		ValidacaoUtil.validarCmd(cid10Cmd, validator);

		CID10 cid10 = new CID10();

		cid10.setCodigo(cid10Cmd.getCodigo());
		cid10.setDescricao(cid10Cmd.getDescricao());

		return cidRepositorio.save(cid10).getId();
	}

	@Override
	public CID10DTO consultarCID10(ConsultaCID10Cmd codigoCid10) {
		ValidacaoUtil.validarCmd(codigoCid10, validator);

		Optional<CID10> cid10 = cidRepositorio.findByCodigo(codigoCid10.getCodigoCid10());

		if (cid10.isPresent()) {
			return new CID10DTO(cid10.get());
		}

		throw new RegraNegocioException("Não foi encontrado um cid10 para o código passado.");
	}

	@Override
	public Long cadastrarCnes(CNESCmd cnesCmd) {
		ValidacaoUtil.validarCmd(cnesCmd, validator);

		CNES cnes = new CNES();

		cnes.setCodigo(cnesCmd.getCodigo());
		cnes.setNomeEstabelecimento(cnesCmd.getNomeEstabelecimento());

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
	public Long cadastrarRegistroAtendimento(CadastroRegistroAtendimentoCmd cadastroRegistroAtendimentoCmd) {
		ValidacaoUtil.validarCmd(cadastroRegistroAtendimentoCmd, validator);

		Atendimento atendimento = new Atendimento();

		atendimento.setId(cadastroRegistroAtendimentoCmd.getAtendimento());

		CNES cnes = new CNES();

		cnes.setId(cadastroRegistroAtendimentoCmd.getCnes());

		RegistroAtendimento registroAtendimento = new RegistroAtendimento();

		registroAtendimento.setAnamnese(cadastroRegistroAtendimentoCmd.isAnamnese());
		registroAtendimento.setAnamneseProgressao(cadastroRegistroAtendimentoCmd.getAnamneseProgessao());
		registroAtendimento.setCnes(cnes);
		registroAtendimento.setAtendimento(atendimento);
		registroAtendimento.setEstadoTratamento(cadastroRegistroAtendimentoCmd.getEstadoTratamento());

		return registroAtendimentoRepositorio.save(registroAtendimento).getId();
	}

	@Override
	public Long cadastrarRegistroCid(CadastroRegistroCid10Cmd cadastroRegistroCid10Cmd) {
		ValidacaoUtil.validarCmd(cadastroRegistroCid10Cmd, validator);

		RegistroAtendimento registroAtendimento = new RegistroAtendimento();

		registroAtendimento.setId(cadastroRegistroCid10Cmd.getRegistroAtendimento());

		CID10 cid10 = new CID10();

		cid10.setId(cadastroRegistroCid10Cmd.getCid10());

		RegistroCID10 registroCID10 = new RegistroCID10();

		registroCID10.setRegistroAtendimento(registroAtendimento);
		registroCID10.setCid10(cid10);

		return registroCID10Repositorio.save(registroCID10).getId();
	}

	@Override
	public List<RegistroCID10DTO> consultarRegistroCid() {
		List<RegistroCID10> listaRegistroCID10 = registroCID10Repositorio.findAll();
		return listaRegistroCID10.stream().map(registroCID10 -> new RegistroCID10DTO(registroCID10))
				.collect(Collectors.toList());
	}

}
