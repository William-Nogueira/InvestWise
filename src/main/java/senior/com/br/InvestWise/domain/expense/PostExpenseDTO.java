package senior.com.br.InvestWise.domain.expense;

import senior.com.br.InvestWise.domain.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PostExpenseDTO(String description, BigDecimal value, LocalDate date, UUID userId){}
