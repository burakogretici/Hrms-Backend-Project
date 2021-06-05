package burakogretici.hrmsproject.core.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @NotEmpty(message = "Email cannot be empyt")
    @Email
    @Column(name="email")
    private  String email;


    @NotEmpty(message = "Password cannot be empyt !!!")
    @Column(name="password")
    private String password;

    @NotEmpty(message = "Password cannot be empyt !!!")
    @Column(name="confirm_password")
    private String confirmPassword;


}
