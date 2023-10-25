package com.io.DirectorMovie_API.s.Repository;


import com.io.DirectorMovie_API.s.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query(value = " select * from movie order by duration_in_minutes desc limit 3", nativeQuery = true)
    public List<Movie> getTop3MovieDuration();

}
