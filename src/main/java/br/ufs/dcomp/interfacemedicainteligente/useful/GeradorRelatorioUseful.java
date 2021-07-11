package br.ufs.dcomp.interfacemedicainteligente.useful;

import java.io.FileNotFoundException;
import java.util.Arrays;

import br.ufs.dcomp.interfacemedicainteligente.rest.dto.RelatorioLaudoDTO;
import br.ufs.dcomp.interfacemedicainteligente.rest.dto.RelatorioProntuarioDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class GeradorRelatorioUseful {

	public byte[] gerarRelatorioProntuario(RelatorioProntuarioDTO relatorioProntuarioDto)
			throws JRException, FileNotFoundException {

		JasperDesign design = JRXmlLoader.load("src/main/resources/jasper/Prontuario.jrxml");

		JasperReport report = JasperCompileManager.compileReport(design);

		JasperPrint print = JasperFillManager.fillReport(report, null,
				new JRBeanCollectionDataSource(Arrays.asList(relatorioProntuarioDto)));
		return JasperExportManager.exportReportToPdf(print);
	}
	
	public byte[] gerarRelatorioLaudo(RelatorioLaudoDTO relatorioProntuarioDto)
			throws JRException, FileNotFoundException {

		JasperDesign design = JRXmlLoader.load("src/main/resources/relatorio/laudo.jrxml");

		JasperReport report = JasperCompileManager.compileReport(design);

		JasperPrint print = JasperFillManager.fillReport(report, null,
				new JRBeanCollectionDataSource(Arrays.asList(relatorioProntuarioDto)));
		return JasperExportManager.exportReportToPdf(print);
	}
}
