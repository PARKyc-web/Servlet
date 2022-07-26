package com.tst.common;

import lombok.Getter;
import lombok.Setter;

// 정수, 문자형 데이터를 보관할 객체 : 공유해서 사용한다
@Getter
@Setter
public class SharedObject {

	private int count;
	private String str;
	
}
