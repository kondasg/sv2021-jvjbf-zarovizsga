CREATE TABLE `players` (
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `team_id` bigint(20) UNSIGNED,
    `name` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
    `birtdate` date NOT NULL,
    `position` varchar(30),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`team_id`) REFERENCES `teams`(`id`)
) ENGINE=InnoDB;