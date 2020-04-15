package ua.lviv.iot.christmasfair.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.christmasfair.model.Viewer;

public interface ViewerRepository extends JpaRepository<Viewer, Integer> {

}
