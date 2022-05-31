package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.ServiceTravel;
import com.example.service.RoomService;
import com.example.service.ServiceTravelService;

@Controller
@RequestMapping("/rooms")
public class RoomController {
	private RoomService roomService;
	private ServiceTravelService serviceTravelService;

	private ServiceTravel serviceTravel = new ServiceTravel();

	public RoomController(RoomService roomService, ServiceTravelService serviceTravelService) {
		this.roomService = roomService;
		this.serviceTravelService = serviceTravelService;
	}

	@GetMapping("/list/{id}")
	public String home(@PathVariable Long id, Model model) {

		serviceTravel = serviceTravelService.getServiceTravelById(id);
		model.addAttribute("serviceTravel", serviceTravelService.getServiceTravelById(id));
		model.addAttribute("rooms", roomService.getAllRoomByServices(id));

		return "rooms/rooms";
	}

}
