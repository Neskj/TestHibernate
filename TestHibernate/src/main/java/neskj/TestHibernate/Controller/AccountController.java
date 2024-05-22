package neskj.TestHibernate.Controller;

import neskj.TestHibernate.Model.Account;
import neskj.TestHibernate.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class AccountController {

    private final static Logger logger = Logger.getLogger(AccountController.class.getName());

    private final AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/data")
    public void updateData(@RequestBody Account account) {

        logger.info("Metod -->> POST get a new object :" + account.toString());
        service.putToRepository(account);
    }

    @GetMapping("/alldata")
    public Iterable<Account>showAllData(){

     Iterable<Account> list=service.getFromRepository();
        logger.info("Metod -->> GET return data from DB :\n" + list.toString());

        return list;
    }
}
