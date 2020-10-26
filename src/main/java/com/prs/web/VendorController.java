package com.prs.web;

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

import com.prs.business.Vendor;
import com.prs.db.VendorRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/vendors")
public class VendorController {
	
	@Autowired
	private VendorRepo vendorRepo;
	
	// list all Vendors
			@GetMapping("/")
			public List<Vendor> getallVendors() {
				return vendorRepo.findAll();
		}
	// add all Vendors
			@PostMapping("/")
			public Vendor addVendor(@RequestBody Vendor vv) { //in the incoming request there is a body(Vendor)
				return vendorRepo.save(vv);
			}
	// get pumpkin by id 
			@GetMapping("/{id}")
		
			public Optional<Vendor> getVendor(@PathVariable int id) {
			Optional<Vendor> vv = vendorRepo.findById(id);
				if (vv.isPresent()) {
				return vv;
				}
				else {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendor Not Found");
				}
			}
	//update a Vendor
			@PutMapping("/{id}")
			public Vendor updateVendor(@RequestBody Vendor vv, @PathVariable int id) { //in the incoming request there is a body(Vendor)
				if (id==vv.getId()) {
				return vendorRepo.save(vv);
			}
				else {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendor id does not match");
				}
			}
	//delete a Vendor
			@DeleteMapping("/{id}")
			public Optional<Vendor> deleteVendor(@PathVariable int id) { //in the incoming request there is a body(Vendor)
			Optional<Vendor> vv = vendorRepo.findById(id);
			if (vv.isPresent()) {
				vendorRepo.deleteById(id);;
			}
			else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendor not found");	
			}
			return vv;
			
		}
	
}
