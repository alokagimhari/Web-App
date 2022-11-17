package com.company.transfer;

import com.company.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired private PaymentRepository repo;

    public List<Payment> listAll()
    {
        return (List<Payment>) repo.findAll();
    }

    public void save(Payment payment){
        repo.save(payment);
    }

    public Payment get(Integer id) throws UserNotFoundException {
        Optional<Payment> result=repo.findById(id);
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

