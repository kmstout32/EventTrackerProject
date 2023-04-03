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
-- Table `brand`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `brand` ;

CREATE TABLE IF NOT EXISTS `brand` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `logo_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kibble`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kibble` ;

CREATE TABLE IF NOT EXISTS `kibble` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price` INT NULL,
  `brand_id` INT NULL,
  `kibble_url` VARCHAR(2000) NULL,
  `date_created` DATE NULL,
  `result` TEXT NULL,
  `protein` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_kibble_brand_idx` (`brand_id` ASC),
  CONSTRAINT `fk_kibble_brand`
    FOREIGN KEY (`brand_id`)
    REFERENCES `brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Data for table `brand`
-- -----------------------------------------------------
START TRANSACTION;
USE `kibbledb`;
INSERT INTO `brand` (`id`, `name`, `logo_url`) VALUES (1, 'Purina', 'https://1000logos.net/wp-content/uploads/2020/07/Purina-Logo.png');
INSERT INTO `brand` (`id`, `name`, `logo_url`) VALUES (2, 'Zignature', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjyDgKHLGYNnKra5qV82oparjbbP90JnKxaw&usqp=CAU');
INSERT INTO `brand` (`id`, `name`, `logo_url`) VALUES (3, 'Iams', 'https://upload.wikimedia.org/wikipedia/commons/5/50/IAMS-Logo.svg');
INSERT INTO `brand` (`id`, `name`, `logo_url`) VALUES (4, 'Blue Buffalo', 'https://cdn.shopify.com/s/files/1/0620/9393/products/Blue_Buffalo_1024x1024.jpg?v=1417920473');
INSERT INTO `brand` (`id`, `name`, `logo_url`) VALUES (5, 'Stella and Chewys', 'https://www.petage.com/wp-content/uploads/2022/11/SC-Logo.jpg');
INSERT INTO `brand` (`id`, `name`, `logo_url`) VALUES (6, 'Nulo', 'https://tailsofthecitystores.com/product_images/uploaded_images/nulo-logo-healthier-reverse.png');
INSERT INTO `brand` (`id`, `name`, `logo_url`) VALUES (7, 'Instinct', 'https://instinctpetfood.com/wp-content/uploads/2021/08/instinct-logo.jpg');
INSERT INTO `brand` (`id`, `name`, `logo_url`) VALUES (8, 'Diamond Naturals', 'https://www.diamondpet.com/wp-content/uploads/2019/01/Diamond-Logo_rev-1.png');
INSERT INTO `brand` (`id`, `name`, `logo_url`) VALUES (9, 'Victor', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfAkC_4Tj5MHD0V8HFgHtl7okmjTFTn2qp4WV3jY7q3XiGmOe52eLWBF8aTFiQRw0qLOA&usqp=CAU');
INSERT INTO `brand` (`id`, `name`, `logo_url`) VALUES (10, 'American Journey', 'https://petfoodsherpa.com/wp-content/uploads/2020/08/american-journey-500x200.png');

COMMIT;


-- -----------------------------------------------------
-- Data for table `kibble`
-- -----------------------------------------------------
START TRANSACTION;
USE `kibbledb`;
INSERT INTO `kibble` (`id`, `name`, `price`, `brand_id`, `kibble_url`, `date_created`, `result`, `protein`) VALUES (1, 'Purina One', 45.00, 1, 'https://www.purina.com/sites/default/files/2021-09/purina-one-cat-logo.png', '2023-01-04', 'His skin  cleared up and some hair grew back', 'Salmon');
INSERT INTO `kibble` (`id`, `name`, `price`, `brand_id`, `kibble_url`, `date_created`, `result`, `protein`) VALUES (2, 'Zignature', 45.00, 2, NULL, '2023-04-21', 'Skin broke out', 'Beef');
INSERT INTO `kibble` (`id`, `name`, `price`, `brand_id`, `kibble_url`, `date_created`, `result`, `protein`) VALUES (3, 'Zignature', 55.00, 2, NULL, '2022-03-12', 'He was extremely itchy', 'Chicken');
INSERT INTO `kibble` (`id`, `name`, `price`, `brand_id`, `kibble_url`, `date_created`, `result`, `protein`) VALUES (4, 'Pro Plan', 44.00, 1, NULL, '2023-02-28', 'Seemed good, no itching', 'Lamb');
INSERT INTO `kibble` (`id`, `name`, `price`, `brand_id`, `kibble_url`, `date_created`, `result`, `protein`) VALUES (5, 'Zignature', 50.00, 2, NULL, '2022-11-07', 'Coat did not improve', 'Chicken');
INSERT INTO `kibble` (`id`, `name`, `price`, `brand_id`, `kibble_url`, `date_created`, `result`, `protein`) VALUES (6, 'Zignature Essentials', 65.00, 2, NULL, '2022-12-21', 'Coat looks amazing!', 'Pork');

COMMIT;

