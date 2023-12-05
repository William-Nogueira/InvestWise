package senior.com.br.InvestWise.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import senior.com.br.InvestWise.domain.earning.Earning;
import senior.com.br.InvestWise.domain.earning.EarningRepository;
import senior.com.br.InvestWise.domain.earning.GetEarningDTO;
import senior.com.br.InvestWise.domain.earning.PostEarningDTO;
import senior.com.br.InvestWise.domain.user.User;
import senior.com.br.InvestWise.domain.user.UserRepository;

@RestController
@RequestMapping("earning")
@SecurityRequirement(name = "bearer-key")
public class EarningController {

    @Autowired
    private EarningRepository earningRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Page<GetEarningDTO>> getAllEarnings(@PageableDefault(size = 10, sort = {"date"}) Pageable page) {
        return ResponseEntity.ok(earningRepository.findAll(page).map(GetEarningDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetEarningDTO> getEarningById(@PathVariable Long id) {
        return ResponseEntity.ok(new GetEarningDTO(earningRepository.getReferenceById(id)));
    }

    @PostMapping
    public ResponseEntity<GetEarningDTO> createEarning(@RequestBody PostEarningDTO data, UriComponentsBuilder uriBuilder) {
        User user = userRepository.findById(data.userId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        var earning = new Earning(data.value(), data.date(), user);
        earningRepository.save(earning);
        var uri = uriBuilder.path("/earning/{id}").buildAndExpand(earning.getId()).toUri();

        return ResponseEntity.created(uri).body(new GetEarningDTO(earning));
    }



}
