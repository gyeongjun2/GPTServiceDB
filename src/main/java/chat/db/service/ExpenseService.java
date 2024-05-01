package chat.db.service;


import chat.db.model.Expense;
import chat.db.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public double calculateTotalAvg(){
        List<Expense> expenses = expenseRepository.findAll();

        int count = expenses.size();
        double totalAccommodation=0, totalFood=0, totalOther=0,
                totalShopping=0, totalTransportation=0;

        for (Expense expense : expenses) {
            totalAccommodation += expense.getAccommodation();
            totalFood += expense.getFood();
            totalOther += expense.getOther();
            totalShopping += expense.getShopping();
            totalTransportation += expense.getTransportation();
        }

        double avgAccommodation = totalAccommodation/count;
        double avgFood = totalFood/count;
        double avgOther = totalOther/count;
        double avgShopping = totalShopping/count;
        double avgTransportation = totalTransportation/count;


        return (avgAccommodation+avgFood+avgOther+avgShopping+avgTransportation) / 5;
    }

    public Map<String, Double> calculateCategoryAverages() {
        List<Expense> expenses = expenseRepository.findAll();

        double totalAccommodation = 0, totalFood = 0, totalOther = 0,
                totalShopping = 0, totalTransportation = 0;
        int count = expenses.size();

        for (Expense expense : expenses) {
            totalAccommodation += expense.getAccommodation();
            totalFood += expense.getFood();
            totalOther += expense.getOther();
            totalShopping += expense.getShopping();
            totalTransportation += expense.getTransportation();
        }

        Map<String, Double> averages = new HashMap<>();
        averages.put("accommodation_average", totalAccommodation / count);
        averages.put("food_average", totalFood / count);
        averages.put("other_average", totalOther / count);
        averages.put("shopping_average", totalShopping / count);
        averages.put("transportation_average", totalTransportation / count);
        return averages;
    }


}
