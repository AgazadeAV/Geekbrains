CREATE DATABASE final_examination;
USE final_examination;

DELIMITER //
CREATE FUNCTION format_seconds(seconds INT)
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
  DECLARE days INT;
  DECLARE hours INT;
  DECLARE minutes INT;
  DECLARE seconds_left INT;
  
  SET days = FLOOR(seconds / 86400);
  SET seconds_left = seconds % 86400;
  SET hours = FLOOR(seconds_left / 3600);
  SET seconds_left = seconds_left % 3600;
  SET minutes = FLOOR(seconds_left / 60);
  SET seconds_left = seconds_left % 60;
  
  RETURN CONCAT(days, ' дней ', hours, ' часов ', minutes, ' минут ', seconds_left, ' секунд');
END//
DELIMITER ;

SELECT format_seconds(90061) AS "Временной калькулятор 1";
SELECT format_seconds(180122) AS "Временной калькулятор 2";
SELECT format_seconds(270183) AS "Временной калькулятор 3";
SELECT format_seconds(360244) AS "Временной калькулятор 4";
SELECT format_seconds(450305) AS "Временной калькулятор 5";