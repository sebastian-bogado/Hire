package io.nsu.hire.apiemails.service.impl;

import io.nsu.hire.apiemails.service.KeyGeneratorService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by sbogado on 7/18/17.
 */
@Service
public class KeyGeneratorServiceImplDateEncode implements KeyGeneratorService {
	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";// "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final long BASE = 36;
	private static final String DIGIT = "0123456789";

	private String encode(long num) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			sb.append(ALPHABET.charAt((int) (num % BASE)));
			num /= BASE;
		}
		return sb.reverse().toString();
	}

	@Override
	public String getId() {
		Date date = new Date();
		String id = encode(date.getTime());
		return id;
	}

}

