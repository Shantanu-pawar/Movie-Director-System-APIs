package com.io.DirectorMovie_API.s.Repository;

import com.io.DirectorMovie_API.s.Models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {

    List<Director> findByLocation(String Name);


}
