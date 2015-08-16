package netgloo.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by gordon on 2015/8/15.
 */
@Transactional
public interface PersonDAO extends CrudRepository<Person,Long> {
}
