package neskj.TestHibernate.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    private long id;

    private String message;

    public void setId(long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

}
