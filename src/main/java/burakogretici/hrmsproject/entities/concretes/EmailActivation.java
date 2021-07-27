package burakogretici.hrmsproject.entities.concretes;

import burakogretici.hrmsproject.core.entities.concretes.User;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "email_activations")
public class EmailActivation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @JoinColumn(name = "user_id")
    @ManyToOne()
    private User user;


    @NotBlank
    @Column(name = "activation_code")
    private String activationCode;

    @NotBlank
    @Column(name = "email")
    private String email;

    @Column(name = "is_activated", columnDefinition ="boolean default false")
    private boolean isActivated = false;

    @NotNull
    @Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
    private final LocalDateTime createdAt = LocalDateTime.now();

    @NotNull
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "activation_date")
    private LocalDateTime activationDate;


    @Builder
    public EmailActivation(@NotNull  User user, @NotBlank  String activationCode,
                           @NotBlank String email, @NotNull boolean isActivated,
                           @NotNull LocalDateTime expirationDate,LocalDateTime activationDate) {
        this.user = user;
        this.activationCode = activationCode;
        this.email = email;
        this.isActivated = isActivated;
        this.expirationDate = expirationDate;
        this.activationDate = activationDate;
    }

    @Builder
    public EmailActivation(@NotNull User user,String activationCode,
                           @NotBlank String email, LocalDateTime expirationDate,
                           LocalDateTime activationDate) {
        this.user = user;
        this.activationCode = activationCode;
        this.email = email;
        this.expirationDate = expirationDate;
        this.activationDate = activationDate;
    }
}
