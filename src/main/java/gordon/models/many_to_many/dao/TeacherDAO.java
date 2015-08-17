package gordon.models.many_to_many.dao;

import gordon.models.many_to_many.Teacher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gordon on 8/17/15.
 */
public interface TeacherDAO extends CrudRepository<Teacher,Long>{
}
