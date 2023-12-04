package senior.com.br.InvestWise.domain.expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record GetExpenseDTO(long id, String description, BigDecimal value, LocalDate date, UUID userId) {}

