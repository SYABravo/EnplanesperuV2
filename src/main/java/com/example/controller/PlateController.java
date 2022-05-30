package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Menu;
import com.example.service.MenuService;
import com.example.service.PlateService;

@Controller
@RequestMapping("/plates")
public class PlateController {
	private PlateService plateService;
	private MenuService menuService;
	
	private Menu menu;
	
	public PlateController(PlateService plateService, MenuService menuService) {
		this.plateService = plateService;
		this.menuService = menuService;
	}
	
	@GetMapping("/list/{id}")
	public String home(@PathVariable Long id, Model model) {
		
		menu = menuService.getMenuById(id);
		
		model.addAttribute("menu", menu);
		model.addAttribute("plates",plateService.getAllPlatesByMenu(menu.getId()));
		
		return "plates/plates";
	}
	
}
