/*-------*/

INSERT INTO Role (role_Name)
VALUES ('Staff');

INSERT INTO Role (role_Name)
VALUES ('Member');

INSERT INTO Role (role_Name)
VALUES ('Faculty');

SELECT * FROM Role;

/*-------*/
INSERT INTO Member (barcode, email, first_name, last_name)
VALUES ('BC7822', 'tomsmith@gmail.com', 'Tom', 'Smith');

INSERT INTO Member (barcode, email, first_name, last_name)
VALUES ('BC7823', 'jellydon@gmail.com', 'Jelly', 'Don');

INSERT INTO Member (barcode, email, first_name, last_name)
VALUES ('BC7824', 'GallonDell@gmail.com', 'Gallon', 'Dell');

SELECT * FROM Member;



/*-------*/

INSERT INTO Event (endDateTime, id, startDateTime, description, name)
VALUES ('2023-04-01', 1, '2023-02-01', 'Description', 'Library');

INSERT INTO Event (endDateTime, id, startDateTime, description, name)
VALUES ('2023-02-10', 2, '2023-02-10', 'Concert Taylor', 'Music Concert');

INSERT INTO Event (endDateTime, id, startDateTime, description, name)
VALUES ('2023-02-23', 3, '2023-02-23', 'Description', 'Fire Event');

SELECT * FROM Event;

/*-------*/

INSERT INTO Location (description, name, locationType)
VALUES ('Location Des', 'Gym', 'GYM');

INSERT INTO Location (description, name, locationType)
VALUES ('Agiro Dinning Hall', 'Argiro', 'DINING');

SELECT * FROM Location;

/*-------*/
INSERT INTO Schedule(endTime, scheduleName, startTime, event_id)
VALUES  ('14:30:20', 'Taylor Swift', '14:00:20', 1);

INSERT INTO Schedule(endTime, scheduleName, startTime, event_id)
VALUES  ('10:30:20', 'Suziki Swift', '09:00:20', 2);

SELECT * FROM Schedule;

/*-------*/
INSERT INTO Session(date, schedule_id)
VALUES  ('2023-02-01', 1);
INSERT INTO Session(date, schedule_id)
VALUES  ('2023-03-01', 1);

INSERT INTO Session(date, schedule_id)
VALUES  ('2022-03-22', 2);
INSERT INTO Session(date, schedule_id)
VALUES  ('2022-03-12', 2);

SELECT * FROM Session;

/*-------*/
INSERT INTO Scanner (event_id, location_id)
VALUES ('1', '1');

INSERT INTO Scanner (event_id, location_id)
VALUES ('2', '1');

SELECT * FROM Scanner;

/*-------*/

SELECT * FROM Record;

SELECT * FROM Registration;

/*-------*/
