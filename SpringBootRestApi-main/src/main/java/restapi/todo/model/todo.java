package restapi.todo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Document Annotation to specify it belongs to MongoDB Document
@Document(collection ="todo")
public class todo {

// Declare the todo parameters
    @Id
    private String id;
    private String text;
    private String start_date;
    private String end_date;

//    Constructors

    public todo() {
        super();
    }

    public todo(String id,String text,String start_date, String end_date) {
        this.text = text;
        this.start_date = start_date;
        this.end_date = end_date;
        this.id = id;
    }

//    Setter and Getter methods

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
