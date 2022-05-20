package br.ufs.dcomp.interfacemedicainteligente.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.CadastroProntuarioCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.PessoaDocumentoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.RelatorioLaudoCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.cmd.RelatorioReceitaCmd;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.ConsultaProntuarioDTO;
import br.ufs.dcomp.interfacemedicainteligente.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;

	@PostMapping("/cadastrar-prontuario")
	@ResponseStatus(CREATED)
	public Long cadastrarProntuario(@RequestBody CadastroProntuarioCmd cadastroProntuarioCmd) {
		return consultaService.cadastrarProntuario(cadastroProntuarioCmd);
	}

	@PostMapping("/consultar-prontuario")
	@ResponseStatus(OK)
	public ConsultaProntuarioDTO consultarProntuario(@RequestBody PessoaDocumentoCmd cpf) {
		return consultaService.consultarProntuario(cpf);
	}

	@PostMapping("/gerar-documento-laudo")
	@ResponseBody
	public ResponseEntity<byte[]> gerarDocumentoLaudoPDF(@RequestBody RelatorioLaudoCmd relatorioLaudoCmd) {
		return ResponseEntity.ok().body(consultaService.gerarDocumentoLaudoPDF(relatorioLaudoCmd));
	}

	@PostMapping("/gerar-documento-receita")
	@ResponseBody
	public ResponseEntity<byte[]> gerarDocumentoReceitaPDF(@RequestBody RelatorioReceitaCmd relatorioReceitaCmd) {
		return ResponseEntity.ok().body(consultaService.gerarDocumentoReceitaPDF(relatorioReceitaCmd));
	}
}
