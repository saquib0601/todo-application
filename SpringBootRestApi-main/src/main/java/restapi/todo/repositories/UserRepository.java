package restapi.todo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import restapi.todo.model.User;

public interface UserRepository extends MongoRepository<User, String> {
//    User findByid(ObjectId id);
}
