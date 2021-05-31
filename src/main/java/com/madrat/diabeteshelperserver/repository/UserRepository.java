package com.madrat.diabeteshelperserver.repository;

import com.madrat.diabeteshelperserver.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
