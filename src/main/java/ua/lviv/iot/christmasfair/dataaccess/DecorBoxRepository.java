package ua.lviv.iot.christmasfair.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.christmasfair.model.DecorBox;

@Repository
public interface DecorBoxRepository extends JpaRepository<DecorBox, Integer> {

}
