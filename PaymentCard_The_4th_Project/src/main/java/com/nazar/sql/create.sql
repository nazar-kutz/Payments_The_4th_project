CREATE TABLE `payment`.`user` (
  `u_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `login` VARCHAR(25) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `rdate` DATE NOT NULL,
  `ldate` DATE NOT NULL,
  PRIMARY KEY (`u_id`));

CREATE TABLE `payment`.`card` (
  `c_id` BIGINT(16) NOT NULL AUTO_INCREMENT,
  `u_id` INT NOT NULL,
  `a_id` BIGINT(16) NOT NULL,
  `expiration_date` DATE NOT NULL,
  PRIMARY KEY (`c_id`));

CREATE TABLE `payment`.`account` (
  `a_id` BIGINT(16) NOT NULL AUTO_INCREMENT,
  `balance` BIGINT(20) NOT NULL,
  `is_blocked` TINYINT(1) NOT NULL,
  `rep_date` DATE NOT NULL,
  PRIMARY KEY (`a_id`));
