package com.example.springprojectlbd.entity;

import javax.persistence.*;

@Entity
@Table(name = "BINARYFILE")
public class BinaryFile {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID") private Long id;

        @ManyToOne
        @JoinColumn(name = "USERSTORYID")
        private UserStory userStoryLinked;

        @Column(name = "BINARYFILE")
        private byte[] binaryFile;

        public void setId(Long id) { this.id = id; }
        public Long getId() { return id; }

        public void setUserStoryLinked(UserStory userStoryId) { this.userStoryLinked =userStoryId; }
        public UserStory getUserStoryLinked() { return userStoryLinked; }

        public void setBinaryFile(byte[] binaryFile) { this.binaryFile=binaryFile; }
        public byte[] getBinaryFile() { return binaryFile; }

    }

