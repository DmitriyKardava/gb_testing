DROP DATABASE IF EXISTS `друзья человека`;
CREATE DATABASE `друзья человека`; 

USE `друзья человека`;

/*
Типы животных
*/
CREATE TABLE `animal_types` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `animal_type` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `animal_types_un` (`animal_type`)
);

/*
Виды животных
*/
CREATE TABLE `animal_species` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `animal_species` varchar(100) NOT NULL,
  `type_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `animal_species_un` (`animal_species`),
  KEY `animal_types_FK` (`type_id`),
  CONSTRAINT `animal_types_FK` FOREIGN KEY (`type_id`) REFERENCES `animal_types` (`id`)
);

/*
Животные
*/
CREATE TABLE `animals` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `birthdate` date NOT NULL,
  `species_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `animal_species_FK` (`species_id`),
  CONSTRAINT `animal_species_FK` FOREIGN KEY (`species_id`) REFERENCES `animal_species` (`id`)
);
