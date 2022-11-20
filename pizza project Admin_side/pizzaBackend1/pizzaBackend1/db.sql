tables

1.users
2.address
3.item
4.itemImage
5.itemsize
6.toppings 
7.toppingImage
8.cart
9.order_history
10.payments
11.deliveryStatus
12.feedback



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
    state varchar(20),
    pincode varchar(6),
    foreign key (userId) references users(userId)
);

CREATE TABLE item(
    itemId int primary key auto_increment,
    type varchar(10),
    itemName varchar(20),
    description varchar(100)
);

CREATE TABLE itemImage(
    itemImgId int primary key auto_increment,
    itemId int,
    data longblob,
    itemImgTime timestamp default current_timestamp not null,
    foreign key (itemId) references item(itemId)
);

CREATE TABLE toppings(
    toppingId int primary key auto_increment,
    toppingName varchar(10),
    price double
);

CREATE TABLE toppingImage(
    toppingImgId int primary key auto_increment,
    toppingId int,
    data longblob,
    toppingImgTime timestamp default current_timestamp not null,
    foreign key (toppingId) references toppings(toppingId)
);

CREATE TABLE itemSize(
    sizeId int primary key auto_increment,
    itemId int,
    size varchar(10),
    price double,
    foreign key(itemId) references item(itemId)
);

CREATE TABLE cart(
    cartId int primary key auto_increment,
    userid int,
    sizeId int,
    toppingId int,
    quantity int,
    price double,
    foreign key(userId) references users (userId),
    foreign key(sizeId) references itemSize (sizeId),
    foreign key(toppingId) references toppings (toppingId)
);

payId, (userId)fk, total price, payStatus, payTimeStamp, mode(upi, cod)

CREATE TABLE payments(
    payId int primary key auto_increment,
    userId int,
    totalAmount double, 
    payStatus varchar(10),
    payTimeStamp timestamp default current_timestamp not null,
    mode varchar(10),
    foreign key(userId) references users(userId)
);

CREATE TABLE deliveryStatus(
    deliveryId int primary key auto_increment,
    payId int,
    deliverystatus varchar(10),
    deliveryTime timestamp default current_timestamp not null,
    foreign key(payId) references payments(payId)
);

CREATE TABLE order_history(
    orderHistoryID int primary key auto_increment,
    userid int,
    sizeId int,
    toppingId int,
    quantity int,
    price double,
    payId int,
    AddressId int,
    deliveryId int,
    foreign key(payId) references users (userid),
    foreign key(AddressId) references address (AddressId),
    foreign key(deliveryId) references deliveryStatus (deliveryId),
);

CREATE TABLE feedback(
    feedbackId int primary key auto_increment,
    userId int,
    feedback varchar(100),
    feedBackTime timestamp default current_timestamp not null,
    foreign key(userid) references users(userid)
);
---------------------------------------------------------------------------------
//details about pizaa on specific size
select i.type,i.itemName,i.description,s.size,s.price from item i  join itemSize s on i.itemid=s.itemid where s.sizeId='1';
//list of pizza details with itemsize
select i.type,i.itemName,i.description,s.size,s.price from item i  join itemSize s on i.itemid=s.itemid ;

///payments for specific user
select p.payid ,p.userid,u.firstname,u.lastname,u.email,u.phoneno, p.totalamount, p.mode, p.payTimeStamp from payments p  join users u on p.userid=u.userid;

///sort pizza by price
select i.itemname,s.size,s.price from item i join itemsize s on i.itemid=s.itemid where i.itemname like'%pizza' order by s.price;
//sort cold drink by price
select i.itemname,s.size,s.price from item i join itemsize s on i.itemid=s.itemid where i.itemname like '%colddrink%' order by s.price;
//sort pizza by veg non veg
