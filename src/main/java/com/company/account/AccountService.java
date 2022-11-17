package com.company.account;

import com.company.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired private AccountRepository repo;

    public List<Account> listAll(){
        return (List<Account>) repo.findAll();
    }

    public void save(Account account) {
    repo.save(account);
    }

    public Account get(Integer id) throws UserNotFoundException {
        Optional<Account> result = repo.findById(id);
        if(result.isPresent())
        {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID"+id);
    }

    public void delete(Integer id)
    {
        repo.deleteById(id);
    }
}
