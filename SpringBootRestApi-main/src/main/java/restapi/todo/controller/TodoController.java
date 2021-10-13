package restapi.todo.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restapi.todo.model.todo;
import restapi.todo.repositories.TodoRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    public TodoRepository todoRepository;


//Get Method at endpoint "/todo" to retrieve all todos
    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping(value = "/todo")
    public List<todo> getAllTodo(){
        try {
            return todoRepository.findAll();
        }catch (Exception error){
            System.out.println(error);
        }
        return null;
    }

//    Post Method at endpoint "/todo" to add a todo to the database
    @CrossOrigin(origins = "http://localhost:8082")
    @PostMapping(value = "/todo")
    public ResponseEntity createTodo(@RequestBody todo t){
        try{
            if(t.getText().length() <= 0){
                return new ResponseEntity("Description is empty!!!\nPlease Provide Description",HttpStatus.BAD_REQUEST);
            }
            if(t.getStart_date().length() <= 0){
                return new ResponseEntity("Start date is empty!!!\nPleases Provide Start date",HttpStatus.BAD_REQUEST);
            }
            if(t.getEnd_date().length() <= 0){
                return new ResponseEntity("End date is empty!!!\nPleases Provide End date", HttpStatus.BAD_REQUEST);
            }
            todo newTodo = todoRepository.insert(t);
            return new ResponseEntity("Todo: \""+ newTodo.getText() + "\" created", HttpStatus.OK);
        }catch (Exception error){
            System.out.println(error);
        }
        return null;
    }

//    Delete Method at endpoint "/todo/{id}" to delete a particular todo
    @CrossOrigin(origins = "http://localhost:8082")
    @DeleteMapping(value = "/todo/{eventID}")
    public ResponseEntity deleteTodoById(@PathVariable("eventID") String id){
        try{
            todoRepository.deleteById(id);
            return new ResponseEntity("Todo deleted",HttpStatus.OK);
        }catch (Exception error){
            System.out.println(error);
        }
        return  null;
    }

//    Put Method at endpoint "/todo/{id}" to edit a particular todo if exists or else create a new todo
    @CrossOrigin(origins = "http://localhost:8082")
    @PutMapping(value = "/todo/{id}")
    public ResponseEntity<Object> editTodoById(@RequestBody todo t, @PathVariable("id") String id){
        try{
            todoRepository.findById(id).map(editedTodo -> {
                if(t.getText().length() > 0){
                    editedTodo.setText(t.getText());
                }else{
                    return new ResponseEntity("Description is empty!!!\nPlease Provide Description", HttpStatus.BAD_REQUEST);
                }
                if(t.getStart_date().length() > 0){
                    editedTodo.setStart_date(t.getStart_date());
                }else{
                    return new ResponseEntity("Start date is empty!!!\nPleases Provide Start date", HttpStatus.BAD_REQUEST);
                }
                if(t.getEnd_date().length() > 0){
                    editedTodo.setEnd_date(t.getEnd_date());
                }else{
                    return new ResponseEntity("End time is empty!!!\nPleases Provide End Time", HttpStatus.BAD_REQUEST);
                }

                todo response = todoRepository.save(editedTodo);
                return new ResponseEntity("Todo edited Successfully",HttpStatus.OK);
            });
            return new ResponseEntity("Id not found in database.",HttpStatus.NOT_FOUND);

        }catch (Exception error){
            System.out.println(error);
        }
        return null;
    }



//    @GetMapping(value = "/todo/event/{eventType}")
//    public Long getTodoByEventType(@PathVariable("eventType") String eventType){
//        try{
//            return todoRepository.countByeventType(eventType);
//        }catch (Exception error){
//            System.out.println(error);
//        }
//        return null;
//    }


}
