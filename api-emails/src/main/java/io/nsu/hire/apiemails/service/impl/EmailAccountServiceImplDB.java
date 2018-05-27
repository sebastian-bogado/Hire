package io.nsu.hire.apiemails.service.impl;

import io.nsu.hire.apiemails.dao.EmailAccountDao;
import io.nsu.hire.apiemails.model.EmailAccount;
import io.nsu.hire.apiemails.model.EmailProperty;
import io.nsu.hire.apiemails.service.EmailAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sbogado on 7/18/17.
 */
@Service
public class EmailAccountServiceImplDB implements EmailAccountService {


	@Autowired
	private EmailAccountDao emailAccountDao;


	@Override
	public EmailAccount saveEmailAccout(EmailAccount emailAccount) {
		for (EmailProperty emailProperties : emailAccount.getProperties()) {
			emailProperties.setEmailAccount(emailAccount);
		}
		return emailAccountDao.save(emailAccount);
	}

}

