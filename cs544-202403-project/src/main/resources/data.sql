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