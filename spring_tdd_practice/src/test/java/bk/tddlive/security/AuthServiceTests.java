package bk.tddlive.security;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import bk.tddlive.domain.UserRepository;


public class AuthServiceTests {


	private static final String WRONG_PASSWORD = "wrongPassword";
	private static final String USER_ID = "userId";
	private static final String NO_USER_ID = "noUserId";
	AuthService authService;
	private static final String USER_PASSWORD = "userPassword";

	
	UserRepository mockUserRepository;
	
	
	
	@Test
	public void nothing() {
		/*
		 * 우선 아무것도 안하는 메소드를 만들어서 junit을 돌림
		 * 테스트를 돌릴 수 있는 환경 조성
		 * */
	}

	@Before
	public void setUp() {
		//객체 만드는 테스트
		
		mockUserRepository = mock(UserRepository.class);
		authService = new AuthService();
		authService.setUserRepository(mockUserRepository);
	}
	
	
	@Test
	public void givenInvalidId_throwIllegalArgEx() {
		//유효하지 않은 아이디가 들어오면 illegalargumentsexcepion이 나오도록 하는 테스트
		
		assertIllegalArgExThrown(null, USER_PASSWORD);
		assertIllegalArgExThrown("", "userPassword");
		
		assertIllegalArgExThrown(USER_ID, null);
		assertIllegalArgExThrown(USER_ID, "");
		
		/* 동일한 코드들 발생 -> 메소드를 이용해 동일 코드 중복 제거*/
	}
	
	
	@Test
	public void whenUserNotFound_throwNonExistingUserEx() {
		String id = NO_USER_ID;
		String userPassword = USER_PASSWORD;
		Class<? extends Exception> type = NonExistingUserException.class;

		assertExceptionThrown(NO_USER_ID, USER_PASSWORD, type);
		
		for(int i=1; i<=100; i++)
			assertExceptionThrown(NO_USER_ID+i, USER_PASSWORD, type);
		
	}
	
	
	@Test
	public void whenUserFoundButWrongPw_throwWrongPasswordEx() {
		givenUserExists(USER_ID, USER_PASSWORD);
		assertExceptionThrown(USER_ID, WRONG_PASSWORD, WrongPasswordException.class);
		verifyUserFound(USER_ID);
	}
	
	
	//유저를 찾고, 패스워드가 올바른 경우 : 인증 정보 리턴
	//인증정보에 해당하는 객체 필요
	//이 인증정보 객체가 맞는지 테스트를 수행해야 함.
	@Test
	public void whenUserFoundAndRightPw_returnAuth() {
		givenUserExists(USER_ID, USER_PASSWORD);
		Authentication auth = authService.authenticate(USER_ID, USER_PASSWORD);;
		assertThat(auth.getId(), equalTo(USER_ID));
	}
	
	
	
	
	
	
	
	
	
	
	private void givenUserExists(String id, String password) {
		
		when(mockUserRepository.findById(id)).thenReturn(new User(id, password));
	
	} 
	
	private void verifyUserFound(String id) {
		verify(mockUserRepository).findById(id);
		
	}


	private Object thenReturn(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	public void assertIllegalArgExThrown(String id, String password) {
		 
		Class<? extends Exception> type = IllegalArgumentException.class;
	
		assertExceptionThrown(id, password, type);
	}

	
	
	
	
	public void assertExceptionThrown(String id, String password, Class<? extends Exception> type) {
	
		Exception thrownEx = null;
		
		try {
			authService.authenticate(id, password);
			
		} catch (Exception e) {
			thrownEx = e;
		}
		assertThat(thrownEx, instanceOf(type));
	}
	
	
	
}
