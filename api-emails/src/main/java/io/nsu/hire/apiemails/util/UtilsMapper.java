package io.nsu.hire.apiemails.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbogado on 7/18/17.
 */
public class UtilsMapper {

	public static InternetAddress[] stringToAddress(List<String> direcciones) throws AddressException {
		ArrayList<InternetAddress> addresses = new ArrayList<>();
		for (String emailAddress : direcciones) {
			addresses.add(new InternetAddress(emailAddress));
		}

		InternetAddress[] ia = new InternetAddress[addresses.size()];
		ia = addresses.toArray(ia);
		return ia;
	}

}

