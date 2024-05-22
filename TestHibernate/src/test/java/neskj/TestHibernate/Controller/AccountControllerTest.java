package neskj.TestHibernate.Controller;

import neskj.TestHibernate.Model.Account;
import neskj.TestHibernate.Service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @Mock
    private AccountService service;

    @InjectMocks
    private AccountController accountController;

    @Test
    public void createControllerNotNull() {

        assertNotNull(accountController);
    }

    @Test
    public void updateDataHappyFlow() {

        Account expectAccount = new Account();
        expectAccount.setId(1);
        expectAccount.setMessage("Hello");

        accountController.updateData(expectAccount);

        verify(service).putToRepository(expectAccount);
    }

    @Test
    public void showAllDataHappyFlow() {

        Iterable<Account> expectList = Arrays.asList(new Account(), new Account(), new Account());

        when(service.getFromRepository()).thenReturn(expectList);
        assertEquals(expectList, accountController.showAllData());
    }
}
