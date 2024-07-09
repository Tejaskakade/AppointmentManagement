package com.ams;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import com.ams.entity.AppManage;

@SpringBootTest
class AppointManagementApplicationTests {
	
	static AppManage appManage;
	
	@BeforeAll
	public static void setUpBeforeClass() {
		appManage= new AppManage();
	}

	@Test
	public void checkError() {
		appManage.setId(101);
		assertThat(appManage.getId()).isEqualTo(101);
		
	}

}
