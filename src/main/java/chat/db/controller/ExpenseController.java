package chat.db.controller;

import chat.db.model.Expense;
import chat.db.repository.ExpenseRepository;
import chat.db.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cost")
public class ExpenseController {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense){
        return expenseRepository.save(expense);
    }

    @GetMapping("/averages")
    public ResponseEntity<Map<String, Double>> getCategoryAverages() {
        Map<String, Double> averages = expenseService.calculateCategoryAverages();
        return ResponseEntity.ok()
                .body(averages);
    }
    @GetMapping("/totalAverage")
    public ResponseEntity<Map<String, Double>> getTotalAverage() {
        Map<String, Double> totalAverage = expenseService.calculateTotalAverage();
        return ResponseEntity.ok(totalAverage);
    }
}


