package com.cms.financeservice.doa;

import com.cms.financeservice.domain.Account;
import com.cms.financeservice.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepositoryIfc extends JpaRepository<Invoice, Long> {

	List<Invoice> findAllByAccountId(String accountId);

	Invoice findByReferenceId(String referenceId);

	List<Invoice> findByAccount(Account account);

}
