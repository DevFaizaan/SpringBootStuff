DROP TABLE IF EXISTS `juice` CASCADE;

CREATE TABLE `juice`(
`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(255),
`amount` INTEGER NOT NULL,
`cost` DOUBLE NOT NULL
);