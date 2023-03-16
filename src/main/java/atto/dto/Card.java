package atto.dto;

import atto.enums.CardStatus;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number")
    private String number;

    @Column(name = "balance")
    private Double balance = 50.00;

    @Column(name = "status")
    private CardStatus status;

    @Column(name = "phone")
    private String phone;

    @Column(name = "create_date")
    private LocalDate create_date;

    @Column(name = "exp_date")
    private String exp_date;


    public Card() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDate create_date) {
        this.create_date = create_date;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }


    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                ", status='" + status + '\'' +
                ", phone='" + phone + '\'' +
                ", create_date=" + create_date +
                ", exp_date='" + exp_date + '\'' +
                '}';
    }
}
