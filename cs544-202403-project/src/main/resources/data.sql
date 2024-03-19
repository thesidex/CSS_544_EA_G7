INSERT INTO Member (barcode, email, first_name, last_name)
VALUES ('BC7822', 'tomsmith@gmail.com', 'Tom', 'Smith');

INSERT INTO Member (barcode, email, first_name, last_name)
VALUES ('BC7823', 'jellydon@gmail.com', 'Jelly', 'Don');

INSERT INTO Member (barcode, email, first_name, last_name)
VALUES ('BC7824', 'GallonDell@gmail.com', 'Gallon', 'Dell');

SELECT * FROM Member;

/*-------*/

INSERT INTO Role (role_Name)
VALUES ('Staff');

INSERT INTO Role (role_Name)
VALUES ('Member');

INSERT INTO Role (role_Name)
VALUES ('Faculty');

SELECT * FROM Role;

/*-------*/

INSERT INTO Event (endDateTime, id, startDateTime, description, name)
VALUES ('2023/02/01', 1, '2023/02/01', 'Description', 'Library');

INSERT INTO Event (endDateTime, id, startDateTime, description, name)
VALUES ('2023/02/10', 2, '2023/02/10', 'Concert Taylor', 'Music Concert');

INSERT INTO Event (endDateTime, id, startDateTime, description, name)
VALUES ('2023/02/23', 3, '2023/02/23', 'Description', 'Fire Event');

SELECT * FROM Event;

/*-------*/

INSERT INTO Location (description, name, locationType)
VALUES ('Location Des', 'Gym', 'GYM');

SELECT * FROM Location;

/*-------*/
INSERT INTO Scanner (event_id, location_id)
VALUES ('1', '1');

SELECT * FROM Scanner;

/*-------*/

SELECT * FROM Session;