package tacos.web;


import java.security.Principal;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;
import tacos.Order;
import tacos.User;
import tacos.data.OrderRepository;
import tacos.data.UserRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
	
	private OrderRepository orderRepo;
	private UserRepository userRepo;
	
	public OrderController(OrderRepository orderRepo, UserRepository userRepo) {
		this.orderRepo = orderRepo;
		this.userRepo = userRepo;
	}
	
	@GetMapping("/current")
	public String orderForm() {
		
		return "orderForm";
		
	}
	
	@PostMapping
	public String processOrder(@Valid Order order, 
			Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
		
		if(errors.hasErrors()) {
			return "orderForm";
		}
		
		log.info("Order Submitted: " + order);
		
		order.setUser(user);
		
		orderRepo.save(order);
		sessionStatus.setComplete();
		
		return "redirect:/";
		
	}

}
