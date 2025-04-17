package expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import expensetracker.exception.ResourceNotFoundException;
import expensetracker.model.Expense;
import expensetracker.repository.ExpenseRepository;


@RestController

@RequestMapping("/api/expense")
@CrossOrigin("*")
public class ExpenseController {
	
		@Autowired
		ExpenseRepository eRepository;

		@PostMapping
		public ResponseEntity<Expense> createExpense(@RequestBody  Expense e){
			eRepository.save(e);
			return new ResponseEntity<Expense>(e,HttpStatus.OK);
		}
		@GetMapping
		
		public ResponseEntity <List<Expense>> getAllExpense(){
			List<Expense> list= eRepository.findAll();
			return new ResponseEntity<List<Expense>>(list,HttpStatus.ACCEPTED);
		

		}

		@GetMapping("/{id}")
		
		public ResponseEntity<Expense> getProductById(@PathVariable ("id")int id )
						throws ResourceNotFoundException {
			Expense e = eRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense  not found for this id :: " + id));
			return ResponseEntity.ok().body(e);
		}
		@PutMapping("/{id}")
//		public ResponseEntity<Expense> update(@RequestBody Expense e, @PathVariable("id") Long id) {
//		   e.setEid(id);
//			service.updateProduct(e);
//		   return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
//		   
//		}
		@DeleteMapping("/{id}")
		public ResponseEntity<Expense> deleteExpenseById(@PathVariable("id") int id)
				throws ResourceNotFoundException{
			
			Expense e = eRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense  not found for this id :: " + id));
			 return new ResponseEntity<Expense>(HttpStatus.OK);
		}
		
		
	}
