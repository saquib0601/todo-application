package restapi.todo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import restapi.todo.model.todo;

import java.util.List;

//Repository Annotation to declare and create a MongoDB repository
@Repository
public interface TodoRepository extends MongoRepository<todo, String> {
//    Method to find todos by using id of type ObjectId
//
}
