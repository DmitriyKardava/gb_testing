USE `друзья человека`;

/*
удалить из талицы всех верблюдов
*/
DELETE FROM animals
WHERE species_id = (SELECT id FROM animal_species WHERE animal_species = 'верблюд');

/*
Объединить таблицы лошади, и ослы в одну таблицу
*/
CREATE TABLE `лошади и ослы` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `birthdate` date NOT NULL,
  `species_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `hnd_species_FK` (`species_id`),
  CONSTRAINT `hnd_species_FK` FOREIGN KEY (`species_id`) REFERENCES `animal_species` (`id`)
);

INSERT INTO `лошади и ослы` (name, birthdate, species_id)
SELECT name, birthdate, species_id FROM animals
WHERE species_id = (SELECT id FROM animal_species WHERE animal_species = 'лошадь')
OR species_id = (SELECT id FROM animal_species WHERE animal_species = 'осел');


/*
Создать новую таблицу “молодые животные” 
в которую попадут все животные старше 1 года, но младше 3 лет 
и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
*/
CREATE TABLE `молодые животные` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `birthdate` date NOT NULL,
  `species_id` bigint unsigned NOT NULL,
  `age_in_mounth` integer NOT NULL,
  PRIMARY KEY (`id`),
  KEY `young_animals_species_FK` (`species_id`),
  CONSTRAINT `yuong_animals_species_FK` FOREIGN KEY (`species_id`) REFERENCES `animal_species` (`id`)
);

INSERT INTO `молодые животные` (name, birthdate, species_id, age_in_mounth)
SELECT name, birthdate, species_id, TIMESTAMPDIFF(MONTH, birthdate, now()) AS age_in_mounth
FROM animals
WHERE TIMESTAMPDIFF(MONTH, birthdate, now()) > 12
AND TIMESTAMPDIFF(MONTH, birthdate, now()) <= 36;

/*
Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
*/
CREATE TABLE `общая таблица` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `birthdate` date NOT NULL,
  `species_id` bigint unsigned NOT NULL,
  `age_in_mounth` integer NOT NULL,
  `table_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ut_species_FK` (`species_id`),
  CONSTRAINT `ut_species_FK` FOREIGN KEY (`species_id`) REFERENCES `animal_species` (`id`)
);
INSERT INTO `общая таблица` (name, birthdate, species_id, age_in_mounth, table_name)
SELECT name, birthdate, species_id, TIMESTAMPDIFF(MONTH, birthdate, now()) AS age_in_mounth, 'animals' AS table_name FROM `animals` 
UNION ALL
SELECT name, birthdate, species_id, TIMESTAMPDIFF(MONTH, birthdate, now()) AS age_in_mounth, 'лошади и ослы' AS table_name FROM `лошади и ослы`
UNION ALL
SELECT name, birthdate, species_id, TIMESTAMPDIFF(MONTH, birthdate, now()) AS age_in_mounth, 'молодые животные' AS table_name FROM `лошади и ослы`
