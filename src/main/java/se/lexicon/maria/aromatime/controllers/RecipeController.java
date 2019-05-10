package se.lexicon.maria.aromatime.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import se.lexicon.maria.aromatime.service.RecipeService;



@RestController
public class RecipeController {

	private RecipeService service;

	@Autowired
	public RecipeController(RecipeService service) {
		this.service = service;
	}
	
//	@GetMapping("/order")
//	public ResponseEntity<List<ProductOrder>> getAll(){
//		List<ProductOrder> orders = orderService.findAll();
//		
//		return orders.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(orders);		
//	}
//	
//	@PostMapping("/order")
//	public ResponseEntity<ProductOrder> create(
//			@RequestBody List<@Valid OrderItemForm> orderItemForms,
//			@RequestAttribute @Valid @ValidAppUser String userId)
//	{		
//		return ResponseEntity.status(HttpStatus.CREATED)
//				.body(orderService.createOrder(orderItemForms, userId));
//	}
}
