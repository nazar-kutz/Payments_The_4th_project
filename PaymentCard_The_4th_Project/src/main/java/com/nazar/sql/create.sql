#####################################################################
#                         SCHEMA 'PAYMENT'
#####################################################################
CREATE SCHEMA IF NOT EXISTS `payment`
  DEFAULT CHARACTER SET utf8;
USE `payment`;

#####################################################################
#                           TABLE 'USER'
#####################################################################
DROP TABLE IF EXISTS 'payment'.'user';

CREATE TABLE `payment`.`user` (
  `u_id`       INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45)  NOT NULL,
  `last_name`  VARCHAR(45)  NOT NULL,
  `patronymic` VARCHAR(45)  NOT NULL,
  `role`       VARCHAR(15)  NOT NULL,
  `login`      VARCHAR(25)  NOT NULL,
  `password`   VARCHAR(45)  NOT NULL,
  `rdate`      DATE         NOT NULL,
  `ldate`      DATE         NOT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE INDEX 'u_idx' ('u_id', ASC)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARACTER SET utf8;

#####################################################################
#                           TABLE 'CARD'
#####################################################################
DROP TABLE IF EXISTS 'payment'.'card';

CREATE TABLE `payment`.`card` (
  `c_id`            BIGINT(16) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `u_id`            INT        NOT NULL,
  `a_id`            BIGINT(16) NOT NULL,
  `expiration_date` DATE       NOT NULL,
  CONSTRAINT 'payment_card'
  FOREIGN KEY (u_id)
  REFERENCES 'payment'.'user' ('u_id')
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (u_id)
  REFERENCES 'payment'.'account' ('a_id')
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB AUTO_INCREMENT = 5
  DEFAULT CHARACTER SET utf8;

#####################################################################
#                          TABLE 'ACCOUNT'
#####################################################################
DROP TABLE IF EXISTS 'payment'.'account';

CREATE TABLE `payment`.`account` (
  `a_id`       BIGINT(16) NOT NULL AUTO_INCREMENT,
  `balance`    BIGINT(20) NOT NULL,
  `is_blocked` TINYINT(1) NOT NULL,
  `rep_date`   DATE       NOT NULL,
  PRIMARY KEY (`a_id`),
  UNIQUE INDEX 'a_idx' ('a_id', ASC)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARACTER SET utf8;
