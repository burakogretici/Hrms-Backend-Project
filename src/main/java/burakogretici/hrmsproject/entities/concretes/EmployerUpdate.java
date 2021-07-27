package burakogretici.hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employer_updates")
public class EmployerUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Employer employer;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @CreationTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @NotNull
    @Column(name = "is_approved", columnDefinition = "boolean default false")
    private boolean isApproved = false;

    @NotNull
    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted = false;
}
