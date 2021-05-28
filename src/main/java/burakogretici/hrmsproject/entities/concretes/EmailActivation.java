package burakogretici.hrmsproject.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "email_activations")
public class EmailActivation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "user_id")
    private int userId;

    @NotBlank
    @Column(name = "auth_token")
    private String authToken;

    @NotBlank
    @Column(name = "email")
    private String email;

    @Column(name = "is_approved")
    private boolean isApproved;
}
