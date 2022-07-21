package com.example.springprojectlbd.repository;

import com.example.springprojectlbd.entity.BinaryFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BinaryFileRepository extends CrudRepository<BinaryFile,Long> {
}
