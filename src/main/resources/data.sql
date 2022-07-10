
INSERT INTO Sprint(Id,SprintName,StartTime,EndTime,Description,Status) values (1,'Sprint',NOW(),'2022-12-31','Nie dziala','Canceled');
SET @sprintKey=(SELECT MAX(id) FROM Sprint);

INSERT INTO USER_STORY(Id,UserStoryName,DESCRIPTION,COUNTOFSTORYPOINT,STATUS) values (1,'PierwszaHistoryjka','tez nie dziala',10,'Done');
SET @UserStoryKey=(SELECT MAX(id) FROM USER_STORY);
INSERT INTO SPRINT_USER_STORY(Sprint_id,UserStory_id) values (@sprintKey,@userStoryKey);

INSERT INTO USER_STORY(Id,UserStoryName,DESCRIPTION,COUNTOFSTORYPOINT,STATUS) values (2,'DrugaHistoryjka','tez nie dziala',9,'Done');
SET @UserStoryKey=(SELECT MAX(id) FROM USER_STORY);
INSERT INTO SPRINT_USER_STORY(Sprint_id,UserStory_id) values (@sprintKey,@userStoryKey);

INSERT INTO USER_STORY(Id,UserStoryName,DESCRIPTION,COUNTOFSTORYPOINT,STATUS) values (3,'TrzeciaHistoryjka','a to dziala',8,'Done');
SET @UserStoryKey=(SELECT MAX(id) FROM USER_STORY);
INSERT INTO SPRINT_USER_STORY(Sprint_id,UserStory_id) values (@sprintKey,@userStoryKey);

INSERT INTO USER_STORY(Id,UserStoryName,DESCRIPTION,COUNTOFSTORYPOINT,STATUS) values (4,'CzwartaHistoryjka','tez nie dziala',7,'Done');
SET @UserStoryKey=(SELECT MAX(id) FROM USER_STORY);
INSERT INTO SPRINT_USER_STORY(Sprint_id,UserStory_id) values (@sprintKey,@userStoryKey);


