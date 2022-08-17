
INSERT INTO Sprint(SprintName,StartTime,EndTime,Description,Status) values ('Sprint',NOW(),'2022-12-31','Nie dziala','CANCELED');
SET @sprintKey=(SELECT MAX(id) FROM Sprint);

INSERT INTO USER_STORY(UserStoryName,DESCRIPTION,COUNTOFSTORYPOINT,STATUS) values ('PierwszaHistoryjka','tez nie dziala',10,'Done');
SET @UserStoryKey=(SELECT MAX(id) FROM USER_STORY);
INSERT INTO SPRINT_USER_STORY(Sprint_id,UserStory_id) values (@sprintKey,@userStoryKey);

INSERT INTO USER_STORY(UserStoryName,DESCRIPTION,COUNTOFSTORYPOINT,STATUS) values ('DrugaHistoryjka','tez nie dziala',9,'Done');
SET @UserStoryKey=(SELECT MAX(id) FROM USER_STORY);
INSERT INTO SPRINT_USER_STORY(Sprint_id,UserStory_id) values (@sprintKey,@userStoryKey);

INSERT INTO USER_STORY(UserStoryName,DESCRIPTION,COUNTOFSTORYPOINT,STATUS) values ('TrzeciaHistoryjka','a to dziala',8,'Done');
SET @UserStoryKey=(SELECT MAX(id) FROM USER_STORY);
INSERT INTO SPRINT_USER_STORY(Sprint_id,UserStory_id) values (@sprintKey,@userStoryKey);

INSERT INTO USER_STORY(UserStoryName,DESCRIPTION,COUNTOFSTORYPOINT,STATUS) values ('czwartaHistoryjka','tez nie dziala',7,'Done');
SET @UserStoryKey=(SELECT MAX(id) FROM USER_STORY);
INSERT INTO SPRINT_USER_STORY(Sprint_id,UserStory_id) values (@sprintKey,@userStoryKey);


