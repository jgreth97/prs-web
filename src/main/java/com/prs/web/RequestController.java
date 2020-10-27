package com.prs.web;

import java.time.LocalDateTime;
import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.prs.business.Request;
import com.prs.db.RequestRepo;



@CrossOrigin
@RestController
@RequestMapping("/api/requests")
public class RequestController {
	
	@Autowired
	private RequestRepo requestRepo;

	
	// list all Requests
			@GetMapping("/")
			public List<Request> getallRequests() {
				return requestRepo.findAll();
		}			
	
	// get request by id 
		@GetMapping("/{id}")
			public Optional<Request> getRequest(@PathVariable int id) {
				Optional<Request> rr = requestRepo.findById(id);
					if (rr.isPresent()) {
						return rr;
				}
					else {
						throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Request Not Found");
				}
			}
	//review by id
		 @GetMapping("/review/{id}")
		 	public List<Request> getAllRequestsByIdAndStatus(@PathVariable int id ) {
			 	return requestRepo.findByUserIdNotAndStatus(id, "Review");
		 }
	// add Requests
		@PostMapping("/")
			public Request addRequest(@RequestBody Request rr) { //in the incoming request there is a body(Request)
				rr.setSubmittedDate(LocalDateTime.now());
				rr.setStatus("New");
				return requestRepo.save(rr);

			}	 	
	//update a Request
		@PutMapping("/{id}")
			public Request updateRequest(@RequestBody Request rr, @PathVariable int id) { //in the incoming request there is a body(Request)
				if (id==rr.getId()) {
					return requestRepo.save(rr);
			}
				else {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Request id does not match");
				}
			}
		@PutMapping("/review")
		 	public Request updateRequestToReview(@RequestBody Request rev) { //in the incoming request there is a body(User)
				//set request status to Review
			 	rev.setStatus("Review");
			 		return requestRepo.save(rev);
		 }
		 @PutMapping("/approve")
		 	public Request updateRequestToApprove(@RequestBody Request aprv) { //in the incoming request there is a body(User)
				//set request status to Approve
			 	aprv.setStatus("Approve");
			 		return requestRepo.save(aprv);
		 }	
		 
		@PutMapping("/reject")
			public Request updateRequestToReject(@RequestBody Request rjct) { //in the incoming request there is a body(User)
				//set request status to Reject
				rjct.setStatus("Reject");
					return requestRepo.save(rjct); 	
		}
	//delete a Request
		@DeleteMapping("/{id}")
			public Optional<Request> deleteRequest(@PathVariable int id) { //in the incoming request there is a body(Request)
				Optional<Request> rr = requestRepo.findById(id);
					if (rr.isPresent()) {
						requestRepo.deleteById(id);;
					}
					else {
						throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Request not found");	
					}
					return rr;
			}
		 }

//recalculating the lineitem total: price * quantity add to sum (add lineitem page/purchase request id)
//copy lineitem and put it in request


