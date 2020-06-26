package lab4.demo.entity;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "se.users")
public class User {
    @Id
    private String username;
    private String password;

}