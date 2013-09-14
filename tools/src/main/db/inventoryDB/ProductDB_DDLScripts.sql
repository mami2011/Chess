SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `PRODUCTDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `PRODUCTDB` ;



-- -----------------------------------------------------
-- Table `PRODUCTDB`.`MERCHANT_PRODUCT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`MERCHANT_PRODUCT` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`MERCHANT_PRODUCT` (
  `MERCHANT_PRODUCT_ID` BIGINT NOT NULL AUTO_INCREMENT ,
  `TITLE` VARCHAR(256) NULL ,
  `SKU` VARCHAR(64) NULL ,
  `ACCOUNT_ID` BIGINT NULL ,
  `PRODUCT_CODE` VARCHAR(64) NULL ,
  `PRODUCT_CODE_TYPE` TINYINT NULL ,
  `AVAILABLE_QUANTITY` INT NULL ,
  `COST` DECIMAL(18,4) NULL ,
  `CREATED_DATE` DATETIME NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  `LAST_MODIFIED_APP` TINYINT NULL ,
  PRIMARY KEY (`MERCHANT_PRODUCT_ID`) )
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `PRODUCTDB`.`PRODUCT_DESCRIPTION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`PRODUCT_DESCRIPTION` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`PRODUCT_DESCRIPTION` (
  `PRODUCT_DESCRIPTION_ID` BIGINT NOT NULL ,
  `DESCRIPTION_NAME` VARCHAR(64) NULL ,
  `PRODUCT_ID` BIGINT NOT NULL ,
  `DESCRIPTION_TEXT` TEXT NULL ,
  `CREATED_DATE` DATETIME NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  PRIMARY KEY (`PRODUCT_DESCRIPTION_ID`) ,
  INDEX `fk_MERCHANT_PRODUCT_DESCRIPTION_MERCHANT_PRODUCT1_idx` (`PRODUCT_ID` ASC) ,
  CONSTRAINT `fk_MERCHANT_PRODUCT_DESCRIPTION_MERCHANT_PRODUCT1`
    FOREIGN KEY (`PRODUCT_ID` )
    REFERENCES `PRODUCTDB`.`MERCHANT_PRODUCT` (`MERCHANT_PRODUCT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCTDB`.`MERCHANT_PRODUCT_GROUP`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`MERCHANT_PRODUCT_GROUP` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`MERCHANT_PRODUCT_GROUP` (
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
-- Table `PRODUCTDB`.`PRODUCT_VARIATION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`PRODUCT_VARIATION` ;
CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`PRODUCT_VARIATION` (
  `PRODUCT_VARIATIONS_ID` BIGINT NOT NULL ,
  `TITLE` VARCHAR(64) NULL ,
  `PRODUCT_ID` BIGINT NULL ,
  `SKU` VARCHAR(64) NULL ,
  `AVAILBLE_QUANTITY` INT NULL ,
  `PRICE` DECIMAL(18,4) NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  `CREATE_DATE` DATETIME NULL ,
  PRIMARY KEY (`PRODUCT_VARIATIONS_ID`) ,
  INDEX `fk_PRODUCT_VARIATION_MERCHANT_PRODUCT1_idx` (`PRODUCT_ID` ASC) ,
  CONSTRAINT `fk_PRODUCT_VARIATION_MERCHANT_PRODUCT1`
    FOREIGN KEY (`PRODUCT_ID` )
    REFERENCES `PRODUCTDB`.`MERCHANT_PRODUCT` (`MERCHANT_PRODUCT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`PRODUCT_VARIATION` (
  `PRODUCT_VARIATIONS_ID` BIGINT NOT NULL ,
  `TITLE` VARCHAR(64) NULL ,
  `PRODUCT_ID` BIGINT NULL ,
  `SKU` VARCHAR(64) NULL ,
  `AVAILBLE_QUANTITY` INT NULL ,
  `PRICE` DECIMAL(18,4) NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  `CREATE_DATE` DATETIME NULL ,
  PRIMARY KEY (`PRODUCT_VARIATIONS_ID`) ,
  INDEX `fk_PRODUCT_VARIATION_MERCHANT_PRODUCT1_idx` (`PRODUCT_ID` ASC) ,
  CONSTRAINT `fk_PRODUCT_VARIATION_MERCHANT_PRODUCT1`
    FOREIGN KEY (`PRODUCT_ID` )
    REFERENCES `PRODUCTDB`.`MERCHANT_PRODUCT` (`MERCHANT_PRODUCT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `PRODUCTDB`.`IMAGE_GROUP`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`IMAGE_GROUP` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`IMAGE_GROUP` (
  `IMAGE_GROUP_ID` INT NOT NULL ,
  `IMAGE_GROUP_NAME` VARCHAR(45) NULL ,
  `SELLER_ID` INT NULL ,
  PRIMARY KEY (`IMAGE_GROUP_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCTDB`.`IMAGE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`IMAGE` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`IMAGE` (
  `IMAGE_ID` BIGINT NOT NULL ,
  `ACCOUNT_ID` BIGINT NULL ,
  `IMAGE_NAME` VARCHAR(64) NULL ,
  `SORT_ORDER_ID` TINYINT NULL ,
  `REF_ID` BIGINT NULL ,
  `REF_TYPE` TINYINT NULL ,
  `IMAGE_FORMAT` TINYINT NULL ,
  `HOSTED_URL` VARCHAR(1028) NULL ,
  `HASH` VARCHAR(64) NULL ,
  `SIZE` VARCHAR(32) NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  `CREATE_DATE` DATETIME NULL ,
  PRIMARY KEY (`IMAGE_ID`) ,
  INDEX `fk_IMAGE_PRODUCT_VARIATION1_idx` (`REF_ID` ASC) ,
  CONSTRAINT `fk_IMAGE_PRODUCT_VARIATION1`
    FOREIGN KEY (`REF_ID` )
    REFERENCES `PRODUCTDB`.`PRODUCT_VARIATION` (`PRODUCT_VARIATIONS_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_IMAGE_MERCHANT_PRODUCT1`
    FOREIGN KEY (`REF_ID` )
    REFERENCES `PRODUCTDB`.`MERCHANT_PRODUCT` (`MERCHANT_PRODUCT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCTDB`.`PRODUCT_SPECIFICATION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`PRODUCT_SPECIFICATION` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`PRODUCT_SPECIFICATION` (
  `PRODUCT_SPECIFICATION_ID` BIGINT NOT NULL ,
  `REF_ID` BIGINT NOT NULL ,
  `REF_TYPE` TINYINT NULL ,
  `WEIGHT_UNIT` TINYINT NULL ,
  `WEIGHT` DECIMAL(8,2) NULL ,
  `DIMENSION_UNIT` TINYINT NULL ,
  `WIDTH` DECIMAL(8,2) NULL ,
  `LENGTH` DECIMAL(8,2) NULL ,
  `HEIGHT` DECIMAL(8,2) NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  `CREATE_DATE` DATETIME NULL ,
  PRIMARY KEY (`PRODUCT_SPECIFICATION_ID`) ,
  INDEX `fk_PRODUCT_SPECIFICATION_PRODUCT_VARIATION1_idx` (`REF_ID` ASC) ,
  CONSTRAINT `fk_PRODUCT_SPECIFICATION_PRODUCT_VARIATION1`
    FOREIGN KEY (`REF_ID` )
    REFERENCES `PRODUCTDB`.`PRODUCT_VARIATION` (`PRODUCT_VARIATIONS_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCT_SPECIFICATION_MERCHANT_PRODUCT1`
    FOREIGN KEY (`REF_ID` )
    REFERENCES `PRODUCTDB`.`MERCHANT_PRODUCT` (`MERCHANT_PRODUCT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCTDB`.`PRODUCT_ATTRIBUTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`PRODUCT_ATTRIBUTE` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`PRODUCT_ATTRIBUTE` (
  `PRODUCT_ATTRIBUTE_ID` BIGINT NOT NULL ,
  `ATTR_NAME` VARCHAR(64) NULL ,
  `PRODUCT_SPECIFICATION_ID` BIGINT NULL ,
  `ATTR_CHAR_VALUE` VARCHAR(64) NULL ,
  `ATTR_NUM_VALUE` DECIMAL(18,4) NULL ,
  `ATTR_DATE_VALUE` DATETIME NULL ,
  `ATTR_DATA_TYPE` TINYINT NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  `CREATED_DATE` DATETIME NULL ,
  PRIMARY KEY (`PRODUCT_ATTRIBUTE_ID`) ,
  INDEX `fk_PRODUCT_ATTRIBUTE_PRODUCT_SPECIFICATION1_idx` (`PRODUCT_SPECIFICATION_ID` ASC) ,
  CONSTRAINT `fk_PRODUCT_ATTRIBUTE_PRODUCT_SPECIFICATION1`
    FOREIGN KEY (`PRODUCT_SPECIFICATION_ID` )
    REFERENCES `PRODUCTDB`.`PRODUCT_SPECIFICATION` (`PRODUCT_SPECIFICATION_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCTDB`.`PRODUCT_CLASSIFICATION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`PRODUCT_CLASSIFICATION` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`PRODUCT_CLASSIFICATION` (
  `CLASSIFICATION_ID` BIGINT NOT NULL ,
  `CLASSIFICATION_NAME` VARCHAR(45) NULL ,
  `MARKET_ID` INT NULL ,
  `MARKET_REF_ID` VARCHAR(45) NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  `LAST_MODIFIED_APP` TINYINT NULL ,
  PRIMARY KEY (`CLASSIFICATION_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCTDB`.`RETURN_POLICY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`RETURN_POLICY` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`RETURN_POLICY` (
  `POLICY_ID` BIGINT NOT NULL ,
  `POLICY_NAME` VARCHAR(45) NULL ,
  `ACCOUNT_ID` BIGINT NULL ,
  `RETURN_ADDR_ID` INT NULL ,
  `PAYER_ID` INT NULL ,
  `RETURN_DURATION` INT NULL ,
  `POLICY_DETAILS` VARCHAR(4000) NULL ,
  `STATUS` TINYINT NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  `LAST_MODIFIED_APP` TINYINT NULL ,
  PRIMARY KEY (`POLICY_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCTDB`.`SHIPPING_SERVICE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`SHIPPING_SERVICE` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`SHIPPING_SERVICE` (
  `SHIPPING_SERVICE_ID` INT NOT NULL ,
  `NAME` VARCHAR(45) NULL ,
  `TYPE` TINYINT NULL ,
  `SITE` TINYINT NULL ,
  `STATUS` TINYINT NULL ,
  `SERVICE_CATEGORY` TINYINT NULL ,
  `CREATED_DATE` DATETIME NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  PRIMARY KEY (`SHIPPING_SERVICE_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCTDB`.`SHIPPING_POLICY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`SHIPPING_POLICY` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`SHIPPING_POLICY` (
  `POLICY_ID` BIGINT NOT NULL ,
  `POLICY_NAME` VARCHAR(45) NULL ,
  `SHIP_TYPE` TINYINT NULL ,
  `ACCOUNT_ID` BIGINT NULL ,
  `SHIP_SERVICE_ID` INT NULL ,
  `SHIP_CARRIER_ID` INT NULL ,
  `COST` DECIMAL(18,4) NULL ,
  `STATUS` TINYINT NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  `LAST_MODIFIED_APP` TINYINT NULL ,
  PRIMARY KEY (`POLICY_ID`) ,
  INDEX `fk_SHIPPING_POLICY_SHIPPING_SERVICE1_idx` (`SHIP_SERVICE_ID` ASC) ,
  CONSTRAINT `fk_SHIPPING_POLICY_SHIPPING_SERVICE1`
    FOREIGN KEY (`SHIP_SERVICE_ID` )
    REFERENCES `PRODUCTDB`.`SHIPPING_SERVICE` (`SHIPPING_SERVICE_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCTDB`.`LISTING`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`LISTING` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`LISTING` (
  `LISTING_ID` BIGINT NOT NULL ,
  `TITLE` VARCHAR(45) NULL ,
  `REF_ID` BIGINT NOT NULL ,
  `REF_TYPE` TINYINT NULL ,
  `ACCOUNT_ID` BIGINT NULL ,
  `SHIPPING_POLICY_ID` BIGINT NULL ,
  `RETURN_POLICY_ID` BIGINT NULL ,
  `LOCATION_POLICY_ID` BIGINT NULL ,
  `PRICE` DECIMAL(18,4) NULL ,
  `QUANTITY` INT NULL ,
  `CLASIFICATION_ID` BIGINT NULL ,
  `PRODUCE` VARCHAR(45) NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  `LAST_MODIFIED_APP` VARCHAR(45) NULL ,
  PRIMARY KEY (`LISTING_ID`) ,
  INDEX `fk_LISTING_MERCHANT_PRODUCT1_idx` (`REF_ID` ASC) ,
  INDEX `fk_LISTING_PRODUCT_VARIATION1_idx` (`REF_ID` ASC) ,
  INDEX `fk_LISTING_RETURN_POLICY1_idx` (`RETURN_POLICY_ID` ASC) ,
  INDEX `fk_LISTING_SHIPPING_POLICY1_idx` (`SHIPPING_POLICY_ID` ASC) ,
  CONSTRAINT `fk_LISTING_MERCHANT_PRODUCT1`
    FOREIGN KEY (`REF_ID` )
    REFERENCES `PRODUCTDB`.`MERCHANT_PRODUCT` (`MERCHANT_PRODUCT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LISTING_PRODUCT_VARIATION1`
    FOREIGN KEY (`REF_ID` )
    REFERENCES `PRODUCTDB`.`PRODUCT_VARIATION` (`PRODUCT_VARIATIONS_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LISTING_RETURN_POLICY1`
    FOREIGN KEY (`RETURN_POLICY_ID` )
    REFERENCES `PRODUCTDB`.`RETURN_POLICY` (`POLICY_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LISTING_SHIPPING_POLICY1`
    FOREIGN KEY (`SHIPPING_POLICY_ID` )
    REFERENCES `PRODUCTDB`.`SHIPPING_POLICY` (`POLICY_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `PRODUCTDB`.`BATCH_JOB`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`BATCH_JOB` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`BATCH_JOB` (
  `BATCH_JOB_ID` BIGINT NOT NULL ,
  `ACCOUNT_ID` BIGINT NULL ,
  `SITE_ID` INT NULL ,
  `FILE_ID` BIGINT NOT NULL ,
  `FILE_NAME` VARCHAR(256) NULL ,
  `STATUS` TINYINT NULL ,
  `REQ_LOCATION` VARCHAR(512) NULL ,
  `RES_LOCATION` VARCHAR(512) NULL ,
  `SELLER_NOTES` VARCHAR(512) NULL ,
  `USECASE` TINYINT NULL ,
  `TOTAL_RECORDS` BIGINT NULL ,
  `PROCESSED_RECORDS` BIGINT NULL ,
  `ERROR_COUNT` BIGINT NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  PRIMARY KEY (`BATCH_JOB_ID`, `FILE_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PRODUCTDB`.`BATCH_WORK_LOG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PRODUCTDB`.`BATCH_WORK_LOG` ;

CREATE  TABLE IF NOT EXISTS `PRODUCTDB`.`BATCH_WORK_LOG` (
  `BATCH_WORK_LOG_ID` BIGINT NOT NULL ,
  `BATCH_ID` BIGINT NOT NULL ,
  `FILE_ID` BIGINT NOT NULL ,
  `ACCOUNT_ID` BIGINT NULL ,
  `RECORD_ID` BIGINT NULL ,
  `REQUEST` BLOB NULL ,
  `RESPONSE` BLOB NULL ,
  `STATUS` TINYINT NULL ,
  `API_ACTION` VARCHAR(64) NULL ,
  `SITE_ID` INT NULL ,
  `CREATED_DATE` DATETIME NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL ,
  PRIMARY KEY (`BATCH_WORK_LOG_ID`, `BATCH_ID`, `FILE_ID`) ,
  INDEX `fk_BATCH_WORK_LOG_BATCH_JOB1_idx` (`BATCH_ID` ASC, `FILE_ID` ASC) ,
  CONSTRAINT `fk_BATCH_WORK_LOG_BATCH_JOB1`
    FOREIGN KEY (`BATCH_ID` , `FILE_ID` )
    REFERENCES `PRODUCTDB`.`BATCH_JOB` (`BATCH_JOB_ID` , `FILE_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


USE `PRODUCTDB` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
