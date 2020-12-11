CREATE SCHEMA club;
USE club;



CREATE TABLE club.member (
      member_number int AUTO_INCREMENT NOT NULL,
      first_name varchar(255),
      second_name varchar(255),
      surname varchar(255),
PRIMARY KEY(member_number),
INDEX member_member_number_INDEX (member_number));

INSERT INTO `club`.`member` (`first_name`, `second_name`) VALUES ('Albert', 'Einstien');
INSERT INTO `club`.`member` (`first_name`, `second_name`) VALUES ('Isaac', 'Newton');
INSERT INTO `club`.`member` (`first_name`, `second_name`) VALUES ('Galiloe', 'Galiliei');
INSERT INTO `club`.`member` (`first_name`, `second_name`) VALUES ('Charles', 'Darwin');
INSERT INTO `club`.`member` (`first_name`, `second_name`, `surname`) VALUES ('Thomas', 'Alva', 'Edision');
INSERT INTO `club`.`member` (`first_name`, `second_name`, `surname`) VALUES ('Alexandar', 'Graham', 'Bell');
INSERT INTO `club`.`member` (`first_name`, `second_name`, `surname`) VALUES ('Ludwig', 'Van', 'Beethoven');
INSERT INTO `club`.`member` (`first_name`, `second_name`) VALUES ('John', 'Lennon');
INSERT INTO `club`.`member` (`first_name`, `second_name`, `surname`) VALUES ('Leonardo', 'Da', 'Vinci');
INSERT INTO `club`.`member` (`first_name`) VALUES ('Michelangelo');
INSERT INTO `club`.`member` (`first_name`, `second_name`, `surname`) VALUES ('Vincent', 'Van', 'Gogh');
INSERT INTO `club`.`member` (`first_name`, `second_name`) VALUES ('Pablo', 'Picasso');

CREATE TABLE club.facility (
      name varchar(255) NOT NULL,
      description varchar(255),
PRIMARY KEY(name),
INDEX facility_name_INDEX (name));

INSERT INTO `club`.`facility` (`name`, `description`) VALUES ('Room1', 'Meeting Room in 2-1');
INSERT INTO `club`.`facility` (`name`, `description`) VALUES ('Room2', 'Meeting Room in 3-2');
INSERT INTO `club`.`facility` (`name`, `description`) VALUES ('Room3', 'Meeting Room 4-3');
INSERT INTO `club`.`facility` (`name`, `description`) VALUES ('Room4', 'Meeting Room 4-5');
INSERT INTO `club`.`facility` (`name`, `description`) VALUES ('Room5', 'Board Room in 4-3');



