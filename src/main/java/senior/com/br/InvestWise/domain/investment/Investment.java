package senior.com.br.InvestWise.domain.investment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import senior.com.br.InvestWise.domain.taxes.TaxesAndInflation;

import java.math.BigDecimal;

@Table(name = "investment")
@Entity(name = "Investment")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private InvestmentCategory category;
    private String description;
    private BigDecimal value;
    @ManyToOne
    @JoinColumn(name = "tax_inflation_id")
    private TaxesAndInflation taxInflation;

}
