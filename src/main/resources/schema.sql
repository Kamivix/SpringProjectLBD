DROP TABLE IF EXISTS Sprint_UserStory cascade ;
DROP Table IF EXISTS Sprint cascade ;
DROP Table IF EXISTS BinaryFile cascade ;
DROP Table IF EXISTS UserStory cascade  ;


CREATE  TABLE IF NOT EXISTS SPRINT (
                                       Id long PRIMARY KEY ,
                                       SprintName varchar(255),
                                       StartTime DATETIME ,
                                       EndTime DATETIME ,
                                       Description varchar(255),
                                       Status ENUM('PENDING', 'IN PROGRESS', 'FINISHED', 'CANCELED')


);


CREATE TABLE IF NOT EXISTS USER_STORY  (
                                           Id long PRIMARY KEY ,
                                           UserStoryName varchar(255),
                                           Description varchar(255),
                                           CountOfStoryPoint INT ,
                                           Status ENUM ('To do','In progress', 'Review', 'Done')


);
CREATE TABLE IF NOT EXISTS SPRINT_USER_STORY (
                                                 Sprint_id long NOT NULL references Sprint(Id),
                                                 UserStory_id long NOT NULL references USER_STORY(Id)
);

CREATE TABLE IF NOT EXISTS BINARY_FILE (
                                           UserStory_id long NOT NULL references USER_STORY(Id),
                                           binaryFile varbinary
)
