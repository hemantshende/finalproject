 CREATE TABLE users(
    userId int primary key auto_increment,
    firstname varchar(20),
    lastname varchar(20),
    email varchar(40),
    phoneNo varchar(10),
    password varchar(600),
    role varchar(20)
);

CREATE TABLE address(
    AddressId int primary key auto_increment,
    userId int,
    plotNo varchar(20),
    streetName varchar(20),
    city varchar(20),
    district varchar(20),
    soverignState varchar(20),
    pincode varchar(6),
    foreign key (userId) references users(userId)
    on delete cascade on update cascade
);

CREATE TABLE item(
    itemId int primary key auto_increment,
    type varchar(10),
    itemName varchar(20),
    description varchar(100)
);

CREATE TABLE itemimage(
    itemImgId int primary key auto_increment,
    itemId int,
    data longblob,
    itemImgTime timestamp default current_timestamp not null,
    foreign key (itemId) references item(itemId)
    on delete cascade on update cascade
);

CREATE TABLE toppings(
    toppingId int primary key auto_increment,
    toppingName varchar(10),
    price double
);

CREATE TABLE toppingimage(
    toppingImgId int primary key auto_increment,
    toppingId int,
    data longblob,
    toppingImgTime timestamp default current_timestamp not null,
    foreign key (toppingId) references toppings(toppingId)
    on delete cascade on update cascade
);

CREATE TABLE itemsize(
    sizeId int primary key auto_increment,
    itemId int,
    size varchar(10),
    price double,
    foreign key(itemId) references item(itemId)
    on delete cascade on update cascade
);



CREATE TABLE payments(
    payId int primary key auto_increment,
    userId int,
    totalAmount double, 
    payStatus varchar(10),
    payTimeStamp timestamp default current_timestamp not null,
    mode varchar(30),
    foreign key(userId) references users(userId)
    on delete cascade on update cascade
);

CREATE TABLE deliverystatus(
    deliveryId int primary key auto_increment,
    payId int,
    addressId int,
    userId int,
    deliverystatus varchar(50),
    deliveryTime timestamp default current_timestamp not null,
    foreign key(payId) references payments(payId),
    foreign key(addressId) references address(AddressId) on delete cascade on update cascade,
    foreign key(userId) references users(userId)
    on delete cascade on update cascade
);

CREATE TABLE cart(
    cartId int primary key auto_increment,
    userId int,
    sizeId int,
    toppingId int,
    quantity int,
    price double,
    cartStatus int,
    deliveryId int,
    foreign key(userId) references users (userId) on delete cascade on update cascade,
    foreign key(sizeId) references itemsize (sizeId) on delete cascade on update cascade,
    foreign key(toppingId) references toppings (toppingId) on delete cascade on update cascade,
    foreign key(deliveryId)references deliverystatus(deliveryId) on delete cascade on update cascade
);

CREATE TABLE feedback(
    feedbackId int primary key auto_increment,
    FirstName varchar(20),
    LastName varchar(20),
    email varchar(30),
    phoneNo varchar(10),
    feedback varchar(400),
    feedBackTime timestamp default current_timestamp not null
);







insert into item values(default,'Veg','Margerita','This is what you want');
insert into item values(default,'Veg','Margerita','This is what you want');
insert into item values(default,'Veg','Margerita','This is what you want');
insert into item values(default,'Veg','Margerita','This is what you want');
insert into item values(default,'Veg','Margerita','This is what you want');
insert into item values(default,'Veg','Margerita','This is what you want');
insert into item values(default,'Veg','Margerita','This is what you want');
insert into item values(default,'Non-Veg','Chicken','This is what you want');
insert into item values(default,'Non-Veg','Chicken','This is what you want');
insert into item values(default,'Non-Veg','Chicken','This is what you want');
insert into item values(default,'Non-Veg','Chicken','This is what you want');
insert into item values(default,'Non-Veg','Chicken','This is what you want');

insert into itemsize values(default,4,'Regular',250);
insert into itemsize values(default,4,'Small',150);
insert into itemsize values(default,4,'Large',350);






