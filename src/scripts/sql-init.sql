DROP DATABASE IF EXISTS securityservicedb;
DROP USER IF EXISTS `ssadmin`@`%`;
CREATE DATABASE IF NOT EXISTS securityservicedb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `ssadmin`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `securityservicedb`.* TO `ssadmin`@`%`;