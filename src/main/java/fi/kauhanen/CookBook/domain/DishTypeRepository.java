package fi.kauhanen.CookBook.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DishTypeRepository extends CrudRepository<DishType, Long> {
	
	List<DishType> findBydishTypeName (String dishTypeName);
	
}
