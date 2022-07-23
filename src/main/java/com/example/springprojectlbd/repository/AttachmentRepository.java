package com.example.springprojectlbd.repository;

import com.example.springprojectlbd.entity.Attachment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends CrudRepository<Attachment,Long> {
}
