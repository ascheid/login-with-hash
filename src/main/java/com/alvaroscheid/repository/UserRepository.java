/**
 * 
 */
package com.alvaroscheid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alvaroscheid.model.User;

/**
 * @author alvaro-scheid
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
}
