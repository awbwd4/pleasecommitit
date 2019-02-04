package com.zerock.domain;


import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {

	//SampleDTO객체를 여러개 전달받아서 처리하기 위한 클래스
	
	private List<SampleDTO> list;
	
	public SampleDTOList() {
		list = new ArrayList<>();
	}
	
	
	

}
