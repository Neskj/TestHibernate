package neskj.TestHibernate.Controller;

import neskj.TestHibernate.Model.Account;
import neskj.TestHibernate.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class AccountController {

    private final AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/data")
    public void updateData(@RequestBody Account account){

        service.putToRepository(account);
    }

    @GetMapping("/alldata")
    public Iterable<Account>showAllData(){

     Iterable<Account> list=service.getFromRepository();

        return list;
    }
}
