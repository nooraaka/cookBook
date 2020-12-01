package fi.kauhanen.CookBook;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.kauhanen.CookBook.web.CookBookController;

@SpringBootTest
class CookBookApplicationTests {
	
	@Autowired
	CookBookController cookbookcontroller;

	@Test
	public void contextLoads() throws Exception{
		assertThat(cookbookcontroller).isNotNull();
	}

}
