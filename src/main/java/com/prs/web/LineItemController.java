package com.prs.web;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.prs.business.LineItem;
import com.prs.business.Request;

import com.prs.db.LineItemRepo;
import com.prs.db.RequestRepo;



@CrossOrigin
@RestController
@RequestMapping("/api/lines")
public class LineItemController {
	
	@Autowired
	private LineItemRepo lineItemRepo;
	@Autowired
	private RequestRepo requestRepo;
	// list all LineItems
			@GetMapping("/")
			public List<LineItem> getallLineItems() {
				return lineItemRepo.findAll();
		}
	// get LineItems by id	
			@GetMapping("/{id}")
			public Optional<LineItem> getLineItem(@PathVariable int id) {
			Optional<LineItem> li = lineItemRepo.findById(id);
				if (li.isPresent()) {
				return li;
				}
				else {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Not Found");
				}
			}
			@GetMapping("/{reqId}")
			public Optional<Request> getRequestsById(@PathVariable int id){
				Optional <Request> r = requestRepo.findById(id);
				if (r.isPresent()) {
					return r;
				}
				else {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Request Not Found");

				}
			}
// add all LineItems
			@PostMapping("/{reqId}")
			public LineItem addRequestIdLineItem(@RequestBody LineItem li) { //in the incoming request there is a body(Request)
				
				try {
					
				li = lineItemRepo.save(li);
				recalculateLineItemTotal(li.getRequest());
			}
				catch(DataIntegrityViolationException dive) {
					System.out.println(dive.getRootCause().getMessage());
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return li;
			}
	 
			
//update a LineItem @putmapping(reqid)
			
			@PutMapping("/{id}")
			public LineItem InsertLineItem(@RequestBody LineItem li) { //in the incoming request there is a body(LineItem)
				try {
					if (lineItemRepo.existsById(li.getId())) {
						
					}
					else {
						System.out.println("Error updating LineItem. id: "+li.getId()+"doesn't exist");
						throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Request id not found");
				}
			}
				catch (Exception e) {
					e.printStackTrace();
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Request id not found");
				}
				return li;
			}
//delete a LineItem

			@DeleteMapping("/{id}")
			public LineItem deleteItem(@PathVariable int id) {
				LineItem li = null;
				
				try {
					if(lineItemRepo.existsById(id)) {
						li = lineItemRepo.findById(id).get();
						Request r = li.getRequest();
						lineItemRepo.deleteById(id);
						recalculateLineItemTotal(r);
					}
					else {
						throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
					}
				}
				catch(DataIntegrityViolationException dive) {
					System.out.println(dive.getRootCause().getMessage());
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return li;
				
			}
				
			private void recalculateLineItemTotal(Request r) {
				List<LineItem> liList = lineItemRepo.findAllByRequestId(r.getId());
					double total = 0.0;
					for(LineItem li: liList) {
						total += li.getQuantity();
					}
					r.setTotal(total);
				try {
					requestRepo.save(r);
				}catch(Exception e) {
					
				}
			}
}
