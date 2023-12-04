package senior.com.br.InvestWise.domain.expense;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import senior.com.br.InvestWise.domain.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "expense")
@Entity(name = "Expense")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private BigDecimal value;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}