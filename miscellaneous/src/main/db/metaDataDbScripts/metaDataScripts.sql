/*Table 1: ml_Categories
Capture all categories for all countries = site_id*/

CREATE TABLE `ml_categories` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `meli_category_id` varchar(100) DEFAULT NULL,
  `meli_category_name` varchar(200) DEFAULT NULL,
  `site_id` varchar(100) DEFAULT NULL,
  `has_attributes` tinyint(1) NOT NULL DEFAULT '0',
  `root_id` varchar(20) NOT NULL DEFAULT '0',
  `listing_allowed` enum('1','0') NOT NULL DEFAULT '0',
  `buying_allowed` enum('1','0') NOT NULL DEFAULT '0',
  PRIMARY KEY (`category_id`),
  KEY `meli_category_id` (`meli_category_id`),
  KEY `root_id` (`root_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28039 DEFAULT CHARSET=utf8 ;


/*Table 2:  ml_Category_Attributes
If a category has attributes, then thoe attributes are cpatured in this table. 
Ex: For fashion, it can be size, primary color , seconary color.*/

CREATE TABLE `ml_category_attributes` (
  `attribute_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `meli_attribute_id` varchar(200) DEFAULT NULL,
  `meli_attribute_name` varchar(100) DEFAULT NULL,
  `meli_attribute_type` varchar(200) DEFAULT NULL,
  `required` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`attribute_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


/*Table 3: ml_Category_Attribute_values
Table to capture all possible values for an attribute. 
Ex: For size in category xxxx, values can be 5,6,7,8,9,10...etc*/

CREATE TABLE `ml_category_attribute_values` (
  `value_id` int(11) NOT NULL AUTO_INCREMENT,
  `attribute_id` int(11) NOT NULL,
  `meli_value_id` varchar(200) DEFAULT NULL,
  `meli_value_name` varchar(100) DEFAULT NULL,
  `meli_value_name_extended` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`value_id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;