package senior.com.br.InvestWise.infra.security;

import senior.com.br.InvestWise.domain.user.Roles;

public record RegisterDTO(String name, String email, String login, String password, Roles role) {
}
