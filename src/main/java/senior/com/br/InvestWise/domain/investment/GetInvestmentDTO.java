package senior.com.br.InvestWise.domain.investment;

import java.math.BigDecimal;

public record GetInvestmentDTO(long id, InvestmentCategory category, String description, BigDecimal value) {}