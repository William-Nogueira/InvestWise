package senior.com.br.InvestWise.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import senior.com.br.InvestWise.domain.expense.*;
import senior.com.br.InvestWise.domain.user.User;
import senior.com.br.InvestWise.domain.user.UserRepository;


@RestController
@RequestMapping("expense")
@SecurityRequirement(name = "bearer-key")
public class ExpenseController {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Page<GetExpenseDTO>> getAllExpenses(@PageableDefault(size = 10, sort = {"date"}) Pageable page) {
        return ResponseEntity.ok(expenseRepository.findAll(page).map(GetExpenseDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetExpenseDTO> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(new GetExpenseDTO(expenseRepository.getReferenceById(id)));
    }

    @PostMapping
    public ResponseEntity<GetExpenseDTO> createExpense(@RequestBody PostExpenseDTO data, UriComponentsBuilder uriBuilder) {
        User user = userRepository.findById(data.userId()).orElseThrow(() -> new IllegalArgumentException("User not found"));

        var expense = new Expense(data.description(), data.value(), data.date(), user);
        expenseRepository.save(expense);
        var uri = uriBuilder.path("/expense/{id}").buildAndExpand(expense.getId()).toUri();

        return ResponseEntity.created(uri).body(new GetExpenseDTO(expense));
    }

}
