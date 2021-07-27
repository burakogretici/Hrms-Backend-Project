package burakogretici.hrmsproject.entities.concretes;

import burakogretici.hrmsproject.core.entities.concretes.User;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name="employee_verifications")
public class EmployeeVerification {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @JoinColumn(name = "user_id")
    @OneToOne()
    private User user;

    @NotNull
    @Column(name = "is_approved", columnDefinition = "boolean default false")
    private boolean isApproved = false;

    @NotNull
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
    private Date createdAt ;

    @NotNull
    @PastOrPresent
    @Column(name = "approval_date")
    private Date approvalDate;


}
