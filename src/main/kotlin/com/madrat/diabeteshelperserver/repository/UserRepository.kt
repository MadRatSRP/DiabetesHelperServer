package com.madrat.diabeteshelperserver.repository

import com.madrat.diabeteshelperserver.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User, Int> {}