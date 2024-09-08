/* Выведите только четные числа от 1 до 10. Пример: 2,4,6,8,10*/

USE final_examination;

DELIMITER $$
CREATE FUNCTION even_nums(first_num INT, last_num INT)
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
    DECLARE res VARCHAR(100) DEFAULT '';

    IF first_num % 2 != 0 THEN
        SET first_num = first_num + 1;
    END IF;

    WHILE first_num <= last_num DO
        SET res = CONCAT(res, ' ', first_num);
        SET first_num = first_num + 2;
    END WHILE;

    RETURN TRIM(res);
END $$

DELIMITER ; 

SELECT even_nums(1, 10) AS 'Чётные числа';
