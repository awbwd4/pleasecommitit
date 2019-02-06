package org.zerock.service;

import org.springframework.stereotype.Service;

@Service //반드시 이 어노테이션을 추가해서 스프링에서 빈으로 사용될 수 있도록 설정해야 함.
public class SampleServiceImpl implements SampleService{

	@Override
	public Integer doAdd(String str1, String str2) throws Exception {

		return Integer.parseInt(str1)+Integer.parseInt(str2);
	}

}
