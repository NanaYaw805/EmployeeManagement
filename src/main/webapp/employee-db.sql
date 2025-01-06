create DATABASE IF NOT EXISTS employee_db;

use employee_db;

CREATE TABLE employee
(
id int NOT NULL AUTO_INCREMENT,
name VARCHAR(24) NOT NULL,
email VARCHAR(96),
phone VARCHAR(15),
address VARCHAR(100),
PRIMARY KEY (ID)
);

INSERT INTO `employee_db`.`employee` (`name`, `email`, `phone`, `address`) VALUES ('Karim Mahmoud', 'kmshawky20@gmail.com', '0097450413948', 'Egypt');
INSERT INTO `employee_db`.`employee` (`name`, `email`, `phone`, `address`) VALUES ('Fran Wilson', 'franwilson@mail.com', '(204) 619-5731', 'C/ Araquil, 67, Madrid, Spain');
INSERT INTO `employee_db`.`employee` (`name`, `email`, `phone`, `address`) VALUES ('Maria Anders', 'mariaanders@mail.com', '(503) 555-9931', '25, rue Lauriston, Paris, France');
INSERT INTO `employee_db`.`employee` (`name`, `email`, `phone`, `address`) VALUES ('Thomas Hardy', 'thomashardy@mail.com', '(171) 555-2222', '89 Chiaroscuro Rd, Portland, USA');
INSERT INTO `employee_db`.`employee` (`name`, `email`, `phone`, `address`) VALUES ('Ahmed Omar', 'amhedoomar@gmail.com', '0096650413948', 'KSA');
INSERT INTO `employee_db`.`employee` (`name`, `email`, `phone`, `address`) VALUES ('Idam Wilson', 'idamwilson@mail.com', '(204) 619-5331', 'C/ Araquil, 67, Madrid, Spain');
INSERT INTO `employee_db`.`employee` (`name`, `email`, `phone`, `address`) VALUES ('Maria Anders', 'mariaanders@mail.com', '(503) 552-9931', '25, rue Lauriston, Paris, France');
INSERT INTO `employee_db`.`employee` (`name`, `email`, `phone`, `address`) VALUES ('Peter Perrier', 'peterperrier@mail.com', '(313) 555-5735', 'Obere Str. 57, Berlin, Germany');
INSERT INTO `employee_db`.`employee` (`NAME`, `email`, `phone`, `address`) VALUES ('Mark Hardy', 'markshardy@mail.com', '(171) 555-2222', '89 Chiaroscuro Rd, Portland, USA');	
