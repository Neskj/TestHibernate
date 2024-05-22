package neskj.TestHibernate.Service;

import neskj.TestHibernate.Model.Account;
import neskj.TestHibernate.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository){

        this.repository=repository;
    }


    public void putToRepository(Account account){

        repository.save(account);
    }

    public Iterable<Account> getFromRepository(){

        Iterable<Account> list=repository.findAll();

        return list;
    }
}
