import { Component } from '@angular/core';
import { ExpenseService } from '../../expense.service';
import { take } from 'rxjs';

@Component({
  selector: 'app-check-expense',
  templateUrl: './check-expense.component.html',
  styleUrl: './check-expense.component.css'
})
export class CheckExpenseComponent {
  expenseList: any[] = [];
  allExpenseList: any[] = [];
  date: any;
  budgetLimit: number = 2000;
  totalExpense: number = 0;
  constructor(private service: ExpenseService) {
    this.getExpenseList();
  }

  getExpenseList(): void {
      const uid = localStorage.getItem('uId');
      this.service.listExpense(uid).pipe(take(1)).subscribe((res) => {
        this.allExpenseList = res;
      }, (err: any) => {
        console.log('Error while getting expense list');
      })
    }

  dateChange(ev: any) {
    console.log(new Date(this.date), '###', ev);
    this.totalExpense = 0;
    this.expenseList = this.allExpenseList?.filter((item: any) => {
      const selectedDate = new Date(this.date);
      const recordDate = new Date(item?.date)
      if (selectedDate.getMonth() + 1 === recordDate.getMonth() + 1 && selectedDate.getFullYear() === recordDate?.getFullYear()) {
        this.totalExpense+=item?.expAmount;
        return item;
      }
    });
  }
}
