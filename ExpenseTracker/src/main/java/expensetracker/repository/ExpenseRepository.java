package expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import expensetracker.model.Expense;


public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
