package com.infobip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infobip.bean.Account;

public interface AccountRepository extends JpaRepository<Account,String>
{

}
