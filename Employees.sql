use pruebas;
create table Employees
    (
    id int primary key auto_increment,
    age int not null,
    first varchar (255),
    last varchar (255)
    );
	
INSERT INTO Employees(AGE, FIRST, LAST) VALUES (18, 'Zara', 'Ali');
INSERT INTO Employees(AGE, FIRST, LAST) VALUES (25, 'Mahnaz', 'Fatma');
INSERT INTO Employees(AGE, FIRST, LAST) VALUES (30, 'Zaid', 'Khan');
INSERT INTO Employees(AGE, FIRST, LAST) VALUES (28, 'Sumit', 'Mittal');
