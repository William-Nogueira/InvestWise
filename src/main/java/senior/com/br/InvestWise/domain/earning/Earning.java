package senior.com.br.InvestWise.domain.earning;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import senior.com.br.InvestWise.domain.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "earning")
@Entity(name = "Earnings")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Earning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal value;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Earning(BigDecimal value, LocalDate date, User user) {
        this.value = value;
        this.date = date;
        this.user = user;
    }
}