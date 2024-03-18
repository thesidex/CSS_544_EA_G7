package edu.miu.cs.cs544.service;


import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.repository.AccountRepository;
import edu.miu.cs.cs544.service.AccountService;
import edu.miu.cs.cs544.service.contract.AccountPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl extends BaseReadWriteServiceImpl<AccountPayload, Account, Long> implements AccountService {

 @Autowired
        private AccountRepository accountRepository;

        public Account createAccount(Account account) {
            return accountRepository.save(account);
        }

        public List<Account> getAllAccounts() {
            return accountRepository.findAll();
        }

        public Account getAccountById(Long id) {
            return accountRepository.findById(id).orElse(null);

        }

        public Account updateAccount(Long id, Account accountDetails) {
            Account account = accountRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Account not found with id " + id));

            account.setName(accountDetails.getName());
            account.setDescription(accountDetails.getDescription());
            account.setAccountType(accountDetails.getAccountType());
            account.setBalance(accountDetails.getBalance());
            account.setMembers(accountDetails.getMembers());

            return accountRepository.save(account);
        }

        public void deleteAccount(Long id) {
            accountRepository.deleteById(id);



}

}

