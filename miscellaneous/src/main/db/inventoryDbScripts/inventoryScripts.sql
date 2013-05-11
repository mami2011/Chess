SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `stool` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `stool` ;

-- -----------------------------------------------------
-- Table `stool`.`MERCHANT_PRODUCT`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `stool`.`MERCHANT_PRODUCT` (
  `PRODUCT_ID` INT NOT NULL ,
  `PRODUCT_TITLE` VARCHAR(45) NULL ,
  `PRODUCT_DESCRIPTION_ID` INT NULL ,
  `PRODUCT_NAME` VARCHAR(45) NULL ,
  `PRODUCT_SKU` VARCHAR(45) NULL ,
  `PRODUCT_TYPE` VARCHAR(45) NULL ,
  `PRODUCT_CODE` VARCHAR(45) NULL ,
  `PRODUCT_URL` VARCHAR(45) NULL ,
  `AVAILABLE_QUANTITY` INT NULL ,
  `PRODUCT_COST` DECIMAL(8,2) NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `MODIFIED_DATE` DATETIME NULL ,
  `CHANGE_WHO` VARCHAR(45) NULL ,
  PRIMARY KEY (`PRODUCT_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stool`.`PRODUCT_VARIATION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `stool`.`PRODUCT_VARIATION` (
  `VARIATIONS_ID` INT NOT NULL ,
  `VARIATIONS_NAME` VARCHAR(45) NULL ,
  `PRODUCT_ID` INT NULL ,
  `SPEC_ID` INT NULL ,
  `PRODUCT_TYPE` VARCHAR(45) NULL ,
  `PRODUCT_CODE` VARCHAR(45) NULL ,
  `SKU` VARCHAR(45) NULL ,
  `AVAILBLE_QUANTITY` VARCHAR(45) NULL ,
  `TITLE` VARCHAR(45) NULL ,
  `PRICE` DECIMAL(19,4) NULL ,
  `MODIFIED_DATE` DATETIME NULL ,
  `CHANGE_WHO` VARCHAR(45) NULL ,
  `CREATE_DATE` DATETIME NULL ,
  PRIMARY KEY (`VARIATIONS_ID`) ,
  INDEX `fk_PRODUCT_VARIATION_MERCHANT_PRODUCT1_idx` (`PRODUCT_ID` ASC) ,
  CONSTRAINT `fk_PRODUCT_VARIATION_MERCHANT_PRODUCT1`
    FOREIGN KEY (`PRODUCT_ID` )
    REFERENCES `stool`.`MERCHANT_PRODUCT` (`PRODUCT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stool`.`MERCHANT_PRODUCT_DESCRIPTION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `stool`.`MERCHANT_PRODUCT_DESCRIPTION` (
  `PRODUCT_DESCRIPTION_ID` INT NOT NULL ,
  `DESCRIPTION_NAME` VARCHAR(45) NULL ,
  `PRODUCT_TYPE` VARCHAR(45) NULL ,
  `PRODUCT_ID` INT NOT NULL ,
  `DESCRIPTION_TEXT` VARCHAR(4000) NOT NULL ,
  `CREATE_DATE` DATETIME NOT NULL ,
  `LAST_MODIFIED_DATE` DATETIME NOT NULL ,
  `CHANGE_WHO` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`PRODUCT_DESCRIPTION_ID`) ,
  INDEX `fk_MERCHANT_PRODUCT_DESCRIPTION_MERCHANT_PRODUCT1_idx` (`PRODUCT_ID` ASC) ,
  CONSTRAINT `fk_MERCHANT_PRODUCT_DESCRIPTION_MERCHANT_PRODUCT1`
    FOREIGN KEY (`PRODUCT_ID` )
    REFERENCES `stool`.`MERCHANT_PRODUCT` (`PRODUCT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MERCHANT_PRODUCT_DESCRIPTION_PRODUCT_VARIATION1`
    FOREIGN KEY (`PRODUCT_ID` )
    REFERENCES `stool`.`PRODUCT_VARIATION` (`VARIATIONS_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stool`.`MERCHANT_PRODUCT_GROUP`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `stool`.`MERCHANT_PRODUCT_GROUP` (
  `PRODUCT_GROUP_ID` INT NULL ,
  `SELLER_ID` INT NULL ,
  `PRODUCT_GROUP_NAME` VARCHAR(45) NULL ,
  `PRODUCT_GROUP_TITLE` VARCHAR(45) NULL ,
  `DESCRIPTION_ID` INT NULL ,
  `PRODUCT_GROUP_URL` VARCHAR(45) NULL ,
  `IMAG_GROUP_ID` INT NULL ,
  `PRODUCT_VARIATIONS_ID` INT NOT NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `MODIFIED_DATE` DATETIME NULL ,
  `CHANGE_WHO` VARCHAR(45) NULL )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stool`.`ADDRESS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `stool`.`ADDRESS` (
  `ADDRESS_ID` INT NOT NULL ,
  `ADDR_TYPE` TINYINT NULL ,
  `USE_CASE` TINYINT NULL ,
  `CONTACT_NAME` VARCHAR(45) NULL ,
  `COMPANY_NAME` VARCHAR(45) NULL ,
  `ADDR_LN1` VARCHAR(45) NULL ,
  `ADDR_LN2` VARCHAR(45) NULL ,
  `ADDR_LN3` VARCHAR(45) NULL ,
  `CITY` VARCHAR(45) NULL ,
  `STATE` VARCHAR(45) NULL ,
  `COUNTRY` VARCHAR(45) NULL ,
  `ZIP` VARCHAR(45) NULL ,
  `SELLER_ID` INT NULL ,
  `STATUS` TINYINT NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `MODIFY_DATE` DATETIME NULL ,
  `CHANGE_WHO` VARCHAR(45) NULL ,
  PRIMARY KEY (`ADDRESS_ID`) )
ENGINE = InnoDB;




-- -----------------------------------------------------
-- Table `stool`.`VARIATIONS_VALUE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `stool`.`VARIATIONS_VALUE` (
  `VARIATIONS_VALUE_ID` INT NOT NULL ,
  `DESCRIPTION` VARCHAR(45) NULL ,
  `VARIATIONS_ID` INT NULL ,
  PRIMARY KEY (`VARIATIONS_VALUE_ID`) ,
  INDEX `fk_VARIATIONS_VALUE_VARIATIONS1_idx` (`VARIATIONS_ID` ASC) ,
  CONSTRAINT `fk_VARIATIONS_VALUE_VARIATIONS1`
    FOREIGN KEY (`VARIATIONS_ID` )
    REFERENCES `stool`.`PRODUCT_VARIATION` (`VARIATIONS_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stool`.`IMAGE_GROUP`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `stool`.`IMAGE_GROUP` (
  `IMAGE_GROUP_ID` INT NOT NULL ,
  `IMAGE_GROUP_NAME` VARCHAR(45) NULL ,
  `SELLER_ID` INT NULL ,
  PRIMARY KEY (`IMAGE_GROUP_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stool`.`IMAGE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `stool`.`IMAGE` (
  `IMAGE_ID` INT NOT NULL ,
  `IMAGE_NAME` VARCHAR(45) NULL ,
  `IS_DEFAULT` TINYINT NULL ,
  `IMAGE_REF_TYPE` VARCHAR(45) NULL ,
  `IMAGE_REF_ID` INT NULL ,
  `IMAGE_FORMAT` TINYINT NULL ,
  `EXT_REF_IMAGE_ID` VARCHAR(45) NULL ,
  `IMAGE_REF_URL` VARCHAR(45) NULL ,
  `MD5HASH` VARCHAR(45) NULL ,
  `SIZE` VARCHAR(45) NULL ,
  `CHANGE_WHO` VARCHAR(45) NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  `CREATE_DATE` DATETIME NULL ,
  PRIMARY KEY (`IMAGE_ID`) ,
  INDEX `fk_IMAGE_PRODUCT_VARIATION1_idx` (`IMAGE_REF_ID` ASC) ,
  CONSTRAINT `fk_IMAGE_PRODUCT_VARIATION1`
    FOREIGN KEY (`IMAGE_REF_ID` )
    REFERENCES `stool`.`PRODUCT_VARIATION` (`VARIATIONS_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_IMAGE_MERCHANT_PRODUCT1`
    FOREIGN KEY (`IMAGE_REF_ID` )
    REFERENCES `stool`.`MERCHANT_PRODUCT` (`PRODUCT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stool`.`PRODUCT_ATTRIBUTE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `stool`.`PRODUCT_ATTRIBUTE` (
  `ATTR_ID` INT NOT NULL ,
  `ATTR_NAME` VARCHAR(45) NULL ,
  `ATTR_CHAR_VALUE` VARCHAR(45) NULL ,
  `ATTR_NUM_VALUE` DOUBLE NULL ,
  `ATTR_DATE_VALUE` DATETIME NULL ,
  `ATTR_DATA_TYPE` TINYINT NULL ,
  `REF_TYPE` VARCHAR(45) NULL ,
  `REF_ID` VARCHAR(45) NULL ,
  `MODIFIED_DATE` DATETIME NULL ,
  `CHANGE_WHO` VARCHAR(45) NULL ,
  `CREATE_DATE` DATETIME NULL ,
  PRIMARY KEY (`ATTR_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stool`.`PRODUCT_CLASSIFICATION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `stool`.`PRODUCT_CLASSIFICATION` (
  `CLASSIFICATION_ID` INT NOT NULL ,
  `CLASSIFICATION_NAME` VARCHAR(45) NULL ,
  `MARKET_ID` INT NULL ,
  `MARKET_REF_ID` VARCHAR(45) NULL ,
  `MODIFIED_DATE` DATETIME NULL ,
  `CHANGE_WHO` VARCHAR(45) NULL ,
  `CREATE_DATE` DATETIME NULL ,
  PRIMARY KEY (`CLASSIFICATION_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stool`.`PRODUCT_SPECIFICATION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `stool`.`PRODUCT_SPECIFICATION` (
  `SPECIFICATION_ID` INT NOT NULL ,
  `AVAILABEL_QUANTITY` INT NULL ,
  `WEIGHT_UNIT` TINYINT NULL ,
  `WEIGHT_MIN` DECIMAL(8,2) NULL ,
  `WEIGHT_MAX` DECIMAL(8,2) NULL ,
  `DIMENSION_UNITS` TINYINT NULL ,
  `WIDTH` DECIMAL(8,2) NULL ,
  `LENGTH` DECIMAL(8,2) NULL ,
  `HEIGHT` DECIMAL(8,2) NULL ,
  `CHANGE_WHO` VARCHAR(45) NULL ,
  `MODIFIED_DATE` DATETIME NULL ,
  `CREATE_DATE` DATETIME NULL ,
  PRIMARY KEY (`SPECIFICATION_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stool`.`RETURN_POLICY_TEMPLATE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `stool`.`RETURN_POLICY_TEMPLATE` (
  `RETURN_POLICY_ID` INT NOT NULL ,
  `RETURN_POLICY_NAME` VARCHAR(45) NULL ,
  `RETURN_ADDR_ID` INT NULL ,
  `RETURN_PAYER_ID` INT NULL ,
  `RETURN_DURATION` INT NULL ,
  `RETURN_POLICY_DETAILS` VARCHAR(4000) NULL ,
  `MODIFIED_DATE` DATETIME NULL ,
  `CHANGE_WHO` VARCHAR(45) NULL ,
  `CREATE_DATE` DATETIME NULL ,
  PRIMARY KEY (`RETURN_POLICY_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stool`.`LISTING`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `stool`.`LISTING` (
  `LISTING_ID` INT NOT NULL ,
  `TITLE` VARCHAR(45) NULL ,
  `SHIPPING_POLICY_ID` INT NULL ,
  `RETURN_POLICY_ID` INT NULL ,
  `PAYMENT_POLICY_ID` INT NULL ,
  `LOCATION_POLICY_ID` INT NULL ,
  `PRICE` DECIMAL(19,4) NULL ,
  `QUANTITY` INT NULL ,
  `CLASIFICATION_ID` INT NULL ,
  `PRODUCE` VARCHAR(45) NULL ,
  `MODIFIED_DATE` DATETIME NULL ,
  `CHANGE_WHO` VARCHAR(45) NULL ,
  `CREATE_DATE` DATETIME NULL ,
  PRIMARY KEY (`LISTING_ID`) )
ENGINE = InnoDB;

USE `stool` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
