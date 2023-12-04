package senior.com.br.InvestWise.domain.user;

import java.util.UUID;

public record GetUserDTO(UUID id, String name, String email) {
}
