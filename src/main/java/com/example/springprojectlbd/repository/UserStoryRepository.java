package com.example.springprojectlbd.repository;

import com.example.springprojectlbd.entity.UserStory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStoryRepository extends PagingAndSortingRepository<UserStory,Long> {
}
