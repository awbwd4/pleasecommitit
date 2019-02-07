package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.mapper.Sample1Mapper;
import org.zerock.mapper.Sample2Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SampleTxServiceImpl implements SampleTxService {

	
	@Setter(onMethod_ = {@Autowired})
	private Sample1Mapper mapper1;
	
	@Setter(onMethod_ = {@Autowired})
	private Sample2Mapper mapper2;
	
	
	@Override
	public void addData(String value) {
		//같은 데이터(value)를 tbl_sample1과 tbl_sample_2 테이블에 insert함
		
		log.info("mapper1........................................");
		mapper1.insertCol1(value);
		
		log.info("mapper2.........................................");
		mapper2.insertCol2(value);
		
		log.info("end................................................");
		
	}

}
