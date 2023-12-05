package senior.com.br.InvestWise.domain.earning;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record GetEarningDTO(long id, BigDecimal value, LocalDate date, UUID user) {

    public GetEarningDTO(Earning earning) {
        this(earning.getId(), earning.getValue(), earning.getDate(), earning.getUser().getId());
    }

}
