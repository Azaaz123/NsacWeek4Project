DROP TABLE IF EXISTS `electric_vehicle`;


CREATE TABLE `electric_vehicle` (
	`id` BIGINT AUTO_INCREMENT,
	`car_make` VARCHAR(225) NOT NULL,	
	`car_model` VARCHAR(225) NOT NULL,	
	`release_year` INT NOT NULL,	
	`mile_range` INT NOT NULL,
	PRIMARY KEY (`id`)	
);