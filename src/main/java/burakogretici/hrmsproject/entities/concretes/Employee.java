package burakogretici.hrmsproject.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private  int userId;

    @Column(name="department_id")
    private int departmentId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

}