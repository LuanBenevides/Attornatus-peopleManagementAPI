package br.com.attornatus.peopleManagement.utils;

import java.sql.Date;

public final class TestConstants {

	public static final Long DEFAULT_PEOPLE_ID = 1L;
	
	public static final String DEFAULT_PEOPLE_NAME = "Usuário teste 001";
	
	@SuppressWarnings("deprecation")
	public static final Date DEFAULT_PEOPLE_BIRTH_DATE = new Date(2023, 06, 04);
	
	public static final Long DEFAULT_PEOPLE_MAIN_ADDRESS_ID = 1L;
	
	private TestConstants() {}
}
