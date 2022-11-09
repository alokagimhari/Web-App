package com.company.transfer;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class payment {

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


}
