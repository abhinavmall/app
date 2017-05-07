CREATE TABLE driver
(
    id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    email varchar(100) DEFAULT NULL,
	latitude float( 10, 6 ) NOT NULL ,
  	longitude float( 10, 6 ) NOT NULL ,
    status varchar(100) DEFAULT 'AVAILABLE',
    PRIMARY KEY (id)
);

insert into driver(id, name, email, latitude, longitude) values(1,'D1','D1@gmail.com', 28.585294, 77.366216);
insert into driver(id, name, email, latitude, longitude) values(2,'D2','D2@gmail.com', 28.583278, 77.363126);
insert into driver(id, name, email, latitude, longitude) values(3,'D3','D3@gmail.com', 28.580178, 77.362740);
insert into driver(id, name, email, latitude, longitude) values(4,'D4','D4@gmail.com', 28.582498, 77.366215);
insert into driver(id, name, email, latitude, longitude) values(5,'D5','D5@gmail.com', 28.585324, 77.363833);

CREATE TABLE orders
(
    order_id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_name varchar(100) NOT NULL,
    customer_latitude float( 10, 6 ) NOT NULL ,
  	customer_longitude float( 10, 6 ) NOT NULL ,
    driver_id int(11),
    FOREIGN KEY fk_driver(driver_id) REFERENCES driver(id)
);
