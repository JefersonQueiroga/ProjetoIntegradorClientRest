package br.edu.ifrn.projeto.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrn.projeto.cliente.dto.Professor;
import br.edu.ifrn.projeto.cliente.dto.ProjetoIntegrador;
import br.edu.ifrn.projeto.cliente.service.ProjetoIntegradorRestService;

@Controller
public class IndexController {
	
	@Autowired
	ProjetoIntegradorRestService projetoIntegradorRestService;
	
	@RequestMapping("/teste")
	public ModelAndView listaProjetos() {
		
		ModelAndView mv = new ModelAndView("lista_projeto");
		
		List<ProjetoIntegrador> projetos = projetoIntegradorRestService.getAll();
		
		for(ProjetoIntegrador projeto : projetos ) {
			System.out.println("Nome Projeto: " + projeto.getNome());
			System.out.println("Professores: ");
			for( Professor p : projeto.getProfessores() ) {
				System.out.println("Nome do Professor: " + p.getNome());
			}
		}
		
		mv.addObject("projetos", projetos);
		
		return mv;
	}
	
}
