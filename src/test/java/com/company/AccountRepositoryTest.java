package com.company;

import com.company.account.Account;
import com.company.account.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class AccountRepositoryTest {
    @Autowired private AccountRepository repo;

    @Test
    public void testAddAccount()
    {
        Account account = new Account();
        account.setId(1);
        account.setAccName("JUDITHA YAP");
        account.setAccType("Savings");
        account.setBankName("boc");
        account.setAmount(10000.0);


        Account savedAccount = repo.save(account);
    }
}