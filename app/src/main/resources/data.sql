INSERT INTO `cwa`.`register_users`
(`id`,`email`,`first_name`,`last_name`,`password`,`is_active`)
VALUES
(1,'AdamM@gmail.com','Adam','Melerowicz','passAdamM',true),
(2,'SzymonR@gmail.com','Szymon','Rzepa','passSzymonR',true),
(3,'Stachu@gmail.com','Stachu','Wilkowski','StachuPass',true),
(4,'Ania@gmail.com','Ania','Ankowska','AniaPass',true);

INSERT INTO `cwa`.`user_roles`
(`id`,`description`,`role`)
VALUES
(1,'Administrator','ROLE_ADMIN'),
(2,'Użytkownik','ROLE_USER');

INSERT INTO `cwa`.`register_users_roles`
(`user_id`,`roles_id`)
VALUES
(1,1),
(1,2),
(2,1),
(2,2),
(3,2),
(4,2);
