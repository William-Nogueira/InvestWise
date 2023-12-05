package senior.com.br.InvestWise.domain.earning;

import senior.com.br.InvestWise.domain.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PostEarningDTO(BigDecimal value, LocalDate date, UUID userId) {
}
