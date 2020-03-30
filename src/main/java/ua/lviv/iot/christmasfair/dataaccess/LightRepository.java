package ua.lviv.iot.christmasfair.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.christmasfair.model.Light;

@Repository
public interface LightRepository extends JpaRepository<Integer, Light> {

}
