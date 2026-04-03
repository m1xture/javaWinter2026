use mysql;
create table sales
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    product  VARCHAR(255),
    price    INT,
    quantity INT
);

insert into sales (product, price, quantity)
values ('Laptop', 1000, 5),
       ('Phone', 700, 3),
       ('Tablet', 500, 2),
       ('Printer', 300, 4);

insert into sales (product, price, quantity)
values ('Laptop', 900, 2),
       ('Tablet', 750, 1);
select *
from sales;
select *
from sales
         limit 2;

select sum(price * quantity)
from sales;

select product, avg(price), sum(quantity)
from sales
group by product;