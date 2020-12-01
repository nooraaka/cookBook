package fi.kauhanen.CookBook;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.kauhanen.CookBook.domain.DishType;
import fi.kauhanen.CookBook.domain.DishTypeRepository;
import fi.kauhanen.CookBook.domain.Recipe;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DishTypeRepositoryTest {
	
		@Autowired 
		private DishTypeRepository dishTypeRepository;
		
		@Test
		public void createNewDishType() {
			DishType dishType = new DishType("Jälkiruoka");
			dishTypeRepository.save(dishType);
			assertThat(dishType.getDishTypeid()).isNotNull();
	}
		@Test
		public void findByDishTypeName() {
			List<DishType> dishTypes = dishTypeRepository.findByDishTypeName("Jälkiruoka");
			
			assertThat(dishTypes).hasSize(1);
			
		}
}
