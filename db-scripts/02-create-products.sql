-- -----------------------------------------------------
-- Schema full-stack-ecommerce
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `retail-ecommerce`;

CREATE SCHEMA `retail-ecommerce`;
USE `retail-ecommerce` ;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `retail-ecommerce`.`product_category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `retail-ecommerce`.`product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `sku` VARCHAR(255) DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `unit_price` DECIMAL(13,2) DEFAULT NULL,
  `image_url` VARCHAR(255) DEFAULT NULL,
  `active` BIT DEFAULT 1,
  `units_in_stock` INT(11) DEFAULT NULL,
   `date_created` DATETIME(6) DEFAULT NULL,
  `last_updated` DATETIME(6) DEFAULT NULL,
  `category_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category` (`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;


INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created,last_updated)
VALUES ('PROD-001', 'incence', 'incence for good smell',
'assets/images/products/placeholder.png'
,1,100,19.99,1, NOW(),NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('PROD-002', 'campour', 'campour for prayer',
'assets/images/products/placeholder.png'
,1,200,5,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('PROD-003', 'soap', 'nonchemical soap',
'assets/images/products/placeholder.png'
,1,10,30,1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created)
VALUES ('PROD-004', 'scented candles', 'jasmine falvoured candles',
'assets/images/products/placeholder.png'
,1,100,30,1, NOW());

INSERT INTO `retail-ecommerce`.product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created,last_updated)
VALUES ('PROD-005', 'snacks', 'masala snacks sweet and sour',
'assets/images/products/snacks.png'
,1,100,10.00,2, NOW(),NOW());


INSERT INTO product_category(category_name) VALUES ('Household products');

INSERT INTO product_category(category_name) VALUES ('Snacks');