package senior.com.br.InvestWise.domain.salary;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record GetSalaryDTO(long id, BigDecimal value, LocalDate date, UUID userId) {}
