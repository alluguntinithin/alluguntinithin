package com.example.demo;
// full form dao(data access object)

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Accountdao extends CrudRepository<Account ,Long> {


	Account findByAccountNumber(String accountNo);
		
	

}