package hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    @Query(value = "select pe.last_name as lastName, pe.description from person pe where pe.last_name = :lastName", nativeQuery = true)
    List<PersonProjection> findAllByLastName(@Param("lastName") String lastName);


}