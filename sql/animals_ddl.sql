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

/*
выполняемые команды
*/
CREATE TABLE `commands` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `command` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `animal_commands` (
  `animal_id` bigint unsigned NOT NULL,
  `command_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`animal_id`,`command_id`),
  KEY `animal_commands_FK_1` (`command_id`),
  CONSTRAINT `animal_commands_FK` FOREIGN KEY (`animal_id`) REFERENCES `animals` (`id`),
  CONSTRAINT `animal_commands_FK_1` FOREIGN KEY (`command_id`) REFERENCES `commands` (`id`)
);