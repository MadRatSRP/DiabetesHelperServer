package com.madrat.diabeteshelperserver

import com.madrat.diabeteshelperserver.model.User
import com.madrat.diabeteshelperserver.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
class MainController {
    @Autowired
    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private val userRepository: UserRepository

    // POST
    @PostMapping(path = ["/addUser"]) // Map ONLY POST Requests
    @ResponseBody
    fun addNewUser(
        @RequestParam name: String, @RequestParam email: String
    ): String? {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        val user = User(
            0,
            name,
            email
        )
        userRepository.save<User>(user)
        return "Saved"
    }

    // GET
    @GetMapping(path = ["/users"])
    @ResponseBody
    fun getAllUsers(): Iterable<User> {
        // This returns a JSON or XML with the users
        return userRepository.findAll()
    }
    @GetMapping(path = ["/hello"])
    @ResponseBody
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String?): String {
        return String.format("Hello %s!", name)
    }
}