package restapi.todo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restapi.todo.model.User;
import restapi.todo.repositories.UserRepository;

@RestController
//@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:8082")
    @PostMapping("/signup")
    public String signUp(@RequestBody User user)
    {
        System.out.println("inside catch");
        try{
            userRepository.insert(user);
            return "User Created Successfully";
        }catch (Exception error){

            return error.toString();
        }


    }

}
