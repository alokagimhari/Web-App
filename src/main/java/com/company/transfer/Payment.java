package com.company.transfer;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false,length = 45,name = "acc_Holder")
    private String accHolderName;

    @Column(nullable = false,length = 45,name = "Beneficiary_name")
    private String BeneficiaryName;

    @Column(nullable = false,length = 45,name = "beneficiary_bank")
    private String BeneficiaryBank;

    @Column(nullable = false,name = "amount")
    private double amount;

    @Column(nullable = false,name = "date")
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public String getBeneficiaryName() {
        return BeneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        BeneficiaryName = beneficiaryName;
    }

    public String getBeneficiaryBank() {
        return BeneficiaryBank;
    }

    public void setBeneficiaryBank(String beneficiaryBank) {
        BeneficiaryBank = beneficiaryBank;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", accHolderName='" + accHolderName + '\'' +
                ", BeneficiaryName='" + BeneficiaryName + '\'' +
                ", BeneficiaryBank='" + BeneficiaryBank + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}
