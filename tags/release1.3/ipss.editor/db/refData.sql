DROP TABLE LoadSchedule;

CREATE TABLE LoadSchedule ( 
  ID	      INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  NAME        VARCHAR(24) NOT NULL,
  PERIOD_UNIT VARCHAR(10) DEFAULT 'Hour' NOT NULL,
  POINTS      INTEGER DEFAULT 24,
  CONSTRAINT LoadSchedule_UNIQUE UNIQUE (NAME),
  PRIMARY KEY (ID)
); 

INSERT INTO LoadSchedule (name) VALUES('SampleLoadSchedule-1');
INSERT INTO LoadSchedule (name) VALUES('SampleLoadSchedule-2');

CREATE TABLE LoadScheduleItem ( 
  SCHEDULE_ID	integer not null,
  POINT integer not null,
  P_PERCENT DOUBLE not null,
  Q_PERCENT DOUBLE not null,
  CONSTRAINT LoadScheduleItem_FK FOREIGN KEY (SCHEDULE_ID) REFERENCES LoadSchedule (ID) 
); 

INSERT INTO LoadScheduleItem VALUES(1, 1,  10,  10);
INSERT INTO LoadScheduleItem VALUES(1, 2,  10,  10);
INSERT INTO LoadScheduleItem VALUES(1, 3,  10,  10);
INSERT INTO LoadScheduleItem VALUES(1, 4,  10,  10);
INSERT INTO LoadScheduleItem VALUES(1, 5,  20,  20);
INSERT INTO LoadScheduleItem VALUES(1, 6,  50,  40);
INSERT INTO LoadScheduleItem VALUES(1, 7,  80,  90);
INSERT INTO LoadScheduleItem VALUES(1, 8,  100, 100);
INSERT INTO LoadScheduleItem VALUES(1, 9,  100, 100);
INSERT INTO LoadScheduleItem VALUES(1, 10, 100, 100);
INSERT INTO LoadScheduleItem VALUES(1, 11, 100, 100);
INSERT INTO LoadScheduleItem VALUES(1, 12, 50,  50);

INSERT INTO LoadScheduleItem VALUES(1, 13, 100, 100);

INSERT INTO LoadScheduleItem VALUES(1, 14, 100, 100);

INSERT INTO LoadScheduleItem VALUES(1, 15, 100, 100);

INSERT INTO LoadScheduleItem VALUES(1, 16, 100, 100);

INSERT INTO LoadScheduleItem VALUES(1, 17, 100, 100);

INSERT INTO LoadScheduleItem VALUES(1, 18, 100, 100);

INSERT INTO LoadScheduleItem VALUES(1, 19, 50,  50);

INSERT INTO LoadScheduleItem VALUES(1, 20, 50,  50);

INSERT INTO LoadScheduleItem VALUES(1, 21, 50,  50);

INSERT INTO LoadScheduleItem VALUES(1, 22, 20,  30);

INSERT INTO LoadScheduleItem VALUES(1, 23, 20, 30);

INSERT INTO LoadScheduleItem VALUES(1, 24, 10,  10);



INSERT INTO LoadScheduleItem VALUES(2, 1,  50,  50);

INSERT INTO LoadScheduleItem VALUES(2, 2,  50,  40);

INSERT INTO LoadScheduleItem VALUES(2, 3,  50,  40);

INSERT INTO LoadScheduleItem VALUES(2, 4,  60,  50);

INSERT INTO LoadScheduleItem VALUES(2, 5,  70,  70);

INSERT INTO LoadScheduleItem VALUES(2, 6,  100, 100);

INSERT INTO LoadScheduleItem VALUES(2, 7,  100, 100);

INSERT INTO LoadScheduleItem VALUES(2, 8,  100, 100);

INSERT INTO LoadScheduleItem VALUES(2, 9,  100, 100);

INSERT INTO LoadScheduleItem VALUES(2, 10, 80,  70);

INSERT INTO LoadScheduleItem VALUES(2, 11, 80,  70);

INSERT INTO LoadScheduleItem VALUES(2, 12, 80,  70);

INSERT INTO LoadScheduleItem VALUES(2, 13, 100, 100);

INSERT INTO LoadScheduleItem VALUES(2, 14, 100, 100);

INSERT INTO LoadScheduleItem VALUES(2, 15, 100, 100);

INSERT INTO LoadScheduleItem VALUES(2, 16, 100, 100);

INSERT INTO LoadScheduleItem VALUES(2, 17, 100, 100);

INSERT INTO LoadScheduleItem VALUES(2, 18, 100, 100);

INSERT INTO LoadScheduleItem VALUES(2, 19, 120, 110);

INSERT INTO LoadScheduleItem VALUES(2, 20, 120, 100);

INSERT INTO LoadScheduleItem VALUES(2, 21, 130, 120);

INSERT INTO LoadScheduleItem VALUES(2, 22, 100, 100);

INSERT INTO LoadScheduleItem VALUES(2, 23, 100, 100);

INSERT INTO LoadScheduleItem VALUES(2, 24, 50,  40);
