                           *****************UC1******************
=============UC1.(Ability to create A payroll service database)=========

mysql> create databases payroll_services;
Query OK, 1 row affected (0.01 sec)

mysql> show databases;
+----------------------+
| Database             |
+----------------------+                     |
| information_schema   |
| mysql                |
| payroll_services     |
| performance_schema   |
| sys                  |
+----------------------+
5 rows in set (0.01 sec)

mysql> use payroll_services;
Database changed
mysql> select database();
+------------------+
| database()       |
+------------------+
| payroll_services |
+------------------+SELECT*FROM employee_payroll;

1 row in set (0.00 sec)

                        *****************************UC2********************************
===========UC2.(Ability to create a employee payroll table in the payroll service database to manage employee payrolls)=============

mysql> CREATE TABLE employee_payroll(id INT unsigned NOT NULL AUTO_INCREMENT,name VARCHAR(150) NOT NULL,salary Double NOT NULL,start DATE NOT NULL,PRIMARY KEY(id));
Query OK, 0 rows affected (0.00 sec)

mysql> desc employee_payroll;
+--------+--------------+------+-----+---------+----------------+
| Field  | Type         | Null | Key | Default | Extra          |
+--------+--------------+------+-----+---------+----------------+
| id     | int unsigned | NO   | PRI | NULL    | auto_increment |
| name   | varchar(150) | NO   |     | NULL    |                |
| salary | double       | NO   |     | NULL    |                |
| start  | date         | NO   |     | NULL    |                |
+--------+--------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)

                    **************************UC3**********************************

===============UC3(Ability to create employee payroll data in the payroll service database as part of CRUD Operation)====================

mysql> insert into employee_payroll(name,salary,start)VALUES('Bill',1000000.00,'2010-10-30'),('Tersia',2000000.00,'2019-11-13'),('Charlie',300000.00,'2020-05-21');
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

                    ************************UC4*************************************

===============UC4(Ability to retrieve all the employee payroll data that is added to payroll service database)===========================

mysql> SELECT*FROM employee_payroll;
+----+---------+---------+------------+
| id | name    | salary  | start      |
+----+---------+---------+------------+
|  1 | Bill    | 1000000 | 2010-10-30 |
|  2 | Tersia  | 2000000 | 2019-11-13 |
|  3 | Charlie |  300000 | 2020-05-21 |
+----+---------+---------+------------+
3 rows in set (0.00 sec)

                    **************************UC5***********************************

==============UC5(Ability to retrieve salary data for a particular employee as well as all employees who have joined in a particular data range from the payroll service database)============

mysql> select  salary from employee_payroll where name ='Bill';
+---------+
| salary  |
+---------+
| 1000000 |
+---------+
1 row in set (0.00 sec)

mysql> SELECT * FROM employee_payroll WHERE start BETWEEN CAST('2010-01-01' AS DATE) AND DATE(now());
+----+---------+---------+------------+
| id | name    | salary  | start      |
+----+---------+---------+------------+
|  1 | Bill    | 1000000 | 2010-10-30 |
|  2 | Tersia  | 2000000 | 2019-11-13 |
|  3 | Charlie |  300000 | 2020-05-21 |
+----+---------+---------+------------+
3 rows in set (0.00 sec)

mysql> select * from employee_payroll where start_date between cast('2019-11-13' AS
DATE) and DATE(NOW());
+----+---------+--------+------------+
| id | name    | salary | start_date |
+----+---------+--------+------------+
|  2 | Tersia  | 200000 | 2019-11-13 |
|  3 | Charlie | 300000 | 2020-05-21 |
+----+---------+--------+------------+
2 rows in set (0.00 sec)

                **************************UC6***********************************

===============UC6(Ability to add Gender to Employee Payroll Table and Update the Rows to reflect the correct Employee Gender)================

mysql> update employee_payroll set gender = 'M' where name = 'Bill' or name = 'charlie';
Query OK, 2 rows affected (0.00 sec)
mysql> select * from employee_payroll;
+----+---------+--------+---------+------------+
| id | name    | gender | salary  | start      |
+----+---------+--------+---------+------------+
|  1 | Bill    | M      | 1000000 | 2010-10-30 |
|  2 | Tersia  | NULL   | 2000000 | 2019-11-13 |
|  3 | Charlie | M      |  300000 | 2020-05-21 |
+----+---------+--------+---------+------------+
3 rows in set (0.00 sec)
mysql> desc employee_payroll;
+--------+--------------+------+-----+---------+----------------+
| Field  | Type         | Null | Key | Default | Extra          |
+--------+--------------+------+-----+---------+----------------+
| id     | int unsigned | NO   | PRI | NULL    | auto_increment |
| name   | varchar(150) | NO   |     | NULL    |                |
| gender | char(1)      | YES  |     | NULL    |                |
| salary | double       | NO   |     | NULL    |                |
| start  | date         | NO   |     | NULL    |                |
+--------+--------------+------+-----+---------+----------------+
5 rows in set (0.00 sec)

              **************************UC7***********************************

=============UC7(Ability to find sum, average, min, max and number of male and female employees)======================

mysql> select AVG(salary) from employee_payroll;
+-------------+
| AVG(salary) |
+-------------+
|     1100000 |
+-------------+
1 row in set (0.00 sec)

mysql> select AVG(salary) from employee_payroll where gender ='M' GROUP BY gender;
+-------------+
| AVG(salary) |
+-------------+
|      650000 |
+-------------+
1 row in set (0.00 sec)
mysql> select AVG(salary) from employee_payroll GROUP BY gender;
+-------------+
| AVG(salary) |
+-------------+
|      650000 |
|     2000000 |
+-------------+
2 rows in set (0.03 sec)

mysql> select gender,AVG(salary) from employee_payroll GROUP BY gender;
+--------+-------------+
| gender | AVG(salary) |
+--------+-------------+
| M      |      650000 |
| F      |     2000000 |
+--------+-------------+
2 rows in set (0.00 sec)

mysql> select gender,SUM(salary) from employee_payroll GROUP BY gender;
+--------+-------------+
| gender | SUM(salary) |
+--------+-------------+
| M      |     1300000 |
| F      |     2000000 |
+--------+-------------+
2 rows in set (0.00 sec)

mysql> select gender,max(salary) from employee_payroll GROUP BY gender;
+--------+-------------+
| gender | max(salary) |
+--------+-------------+
| M      |     1000000 |
| F      |     2000000 |
+--------+-------------+
2 rows in set (0.00 sec)

mysql> select gender,min(salary) from employee_payroll GROUP BY gender;
+--------+-------------+
| gender | min(salary) |
+--------+-------------+
| M      |      300000 |
| F      |     2000000 |
+--------+-------------+

