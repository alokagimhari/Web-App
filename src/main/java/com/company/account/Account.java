package com.company.account;


import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(nullable = false,length = 45,name = "acc_name")
    private String accName;

    @Column(nullable = false,length = 20,name = "acc_type")
    private String accType;

    @Column(nullable = false,length = 50,name = "bank_name")
    private String bankName;

    @Column(nullable = false,name = "amount")
    private double amount;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id){this.id = id;}

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accName='" + accName + '\'' +
                ", accType='" + accType + '\'' +
                ", bankName='" + bankName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
