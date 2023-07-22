package com.example.demo.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.service.AddressService;

/**
 * Controller class for managing CRUD operations on Address entities.
 */
@RestController
@RequestMapping("/address")
public class AddressController {
	
	
	private AddressService addressService;
	
	//Constructor to inject AddressService dependency
	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}
	
	/**
	 * Create a new address.
	 * 
	 * @param address The Address object containing address details to be saved.
	 * @return The saved Address object.
	 */
	@PostMapping()
	public Address saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	/**
	 * Get all addresses.
	 * 
	 * @return A list of all addresses in the database.
	 */
	@GetMapping()
	public List<Address> getAddresses(){
		return addressService.getAddress();
	}
	
	/**
	 * Get an address by its ID.
	 * 
	 * @param id The ID of the address to retrieve.
	 * @return The Address object with the specified ID, or null if not found.
	 */
	@GetMapping("/{id}")
	public Address getAddressById(@PathVariable("id") long id) {
		return addressService.getAddressById(id);
	}
	
	/**
	 * Update an existing address by its ID.
	 * 
	 * @param address The Address object containing updated address details.
	 * @param id The ID of the address to be updated.
	 * @return The updated Address object.
	 */
	@PutMapping("/{id}")
	public Address updateAddress(@RequestBody Address address, @PathVariable("id") long id) {
		return addressService.updateAddress(address, id);
	}
	
	/**
	 * Delete an address by its ID.
	 * 
	 * @param id The ID of the address to be deleted.
	 * @return ResponseEntity with a success message or an error message if the address is not found.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable("id") long id) {
		addressService.deleteAddress(id);
		
		return new ResponseEntity<String>("Address deleted Successfully", HttpStatus.OK);
	}
	

}
