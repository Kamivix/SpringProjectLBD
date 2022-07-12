package com.example.springprojectlbd.repository;

import com.example.springprojectlbd.entity.Sprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface
SprintRepository extends CrudRepository<Sprint,Long> {

    @Query
            ("SELECT s FROM Sprint s WHERE s.startTime>=?1 AND s.endTime<=?2")
    Optional<List<Sprint>> findBetweenData(Timestamp data1,Timestamp data2);


    @Query
            ("SELECT sum (c.countOfStoryPoint) FROM Sprint s join s.userStories c where s.id=?1 AND c.status LIKE 'DONE'")

    Optional<Integer> returnCountOfStoryPoint(long id);
    }

