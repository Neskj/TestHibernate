package neskj.TestHibernate.Service;

import neskj.TestHibernate.Model.Account;
import neskj.TestHibernate.Repository.AccountRepository;
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
public class AccountServiceTest {

    @Mock
    private AccountRepository repository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void createServiceNotNull() {

        assertNotNull(accountService);
    }

    @Test
    public void putToRepositoryHappyFlow() {

        Account expectAccount = new Account();
        expectAccount.setId(1);
        expectAccount.setMessage("Forever young forever drunk");

        accountService.putToRepository(expectAccount);
        verify(repository).save(expectAccount);
    }

    @Test
    public void getFromRepositoryHappyFlow() {

        Iterable<Account> expectedAccounts = Arrays.asList(new Account(), new Account(), new Account());

        when(repository.findAll()).thenReturn(expectedAccounts);

        assertEquals(expectedAccounts, accountService.getFromRepository());
    }
}
