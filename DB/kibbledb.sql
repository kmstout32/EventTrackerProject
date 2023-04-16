-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema kibbledb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `kibbledb` ;

-- -----------------------------------------------------
-- Schema kibbledb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kibbledb` DEFAULT CHARACTER SET utf8 ;
USE `kibbledb` ;

-- -----------------------------------------------------
-- Table `kibble`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kibble` ;

CREATE TABLE IF NOT EXISTS `kibble` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price` INT NULL,
  `kibble_url` VARCHAR(2000) NULL,
  `date_created` DATE NULL,
  `result` TEXT NULL,
  `protein` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS kibble@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'kibble'@'localhost' IDENTIFIED BY 'kibble';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'kibble'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `kibble`
-- -----------------------------------------------------
START TRANSACTION;
USE `kibbledb`;
INSERT INTO `kibble` (`id`, `name`, `price`, `kibble_url`, `date_created`, `result`, `protein`) VALUES (1, 'Purina One', 45.00, 'https://www.purina.com/sites/default/files/2021-09/purina-one-cat-logo.png', '2023-01-04', 'His skin  cleared up and some hair grew back', 'Salmon');
INSERT INTO `kibble` (`id`, `name`, `price`, `kibble_url`, `date_created`, `result`, `protein`) VALUES (2, 'Zignature', 45.00, NULL, '2023-04-21', 'Skin broke out', 'Beef');
INSERT INTO `kibble` (`id`, `name`, `price`, `kibble_url`, `date_created`, `result`, `protein`) VALUES (3, 'Zignature', 55.00, NULL, '2022-03-12', 'He was extremely itchy', 'Chicken');
INSERT INTO `kibble` (`id`, `name`, `price`, `kibble_url`, `date_created`, `result`, `protein`) VALUES (4, 'Pro Plan', 44.00, NULL, '2023-02-28', 'Seemed good, no itching', 'Lamb');
INSERT INTO `kibble` (`id`, `name`, `price`, `kibble_url`, `date_created`, `result`, `protein`) VALUES (5, 'Zignature', 50.00, NULL, '2022-11-07', 'Coat did not improve', 'Chicken');
INSERT INTO `kibble` (`id`, `name`, `price`, `kibble_url`, `date_created`, `result`, `protein`) VALUES (6, 'Zignature Essentials', 65.00, NULL, '2022-12-21', 'Coat looks amazing!', 'Pork');

COMMIT;

