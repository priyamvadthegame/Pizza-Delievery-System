CREATE TABLE POS_TBL_User_Profile (
UserId  VARCHAR(6) NOT NULL,
Firstname VARCHAR(20) NOT NULL,
Lastname VARCHAR(20) NOT NULL,
DateOfBirth DATE NOT NULL,
Gender VARCHAR(7) NOT NULL,
Street VARCHAR(30) NOT NULL,
Location VARCHAR(20) NOT NULL,
City VARCHAR(20) NOT NULL,
User_State VARCHAR(20) NOT NULL,
Pincode VARCHAR(10),
MobileNo int(10),
EmailId VARCHAR(30) NOT NULL,
PRIMARY KEY (UserId)
);

CREATE TABLE POS_TBL_User_Credentials (
UserId  VARCHAR(6) NOT NULL,
Password VARCHAR(20) NOT NULL,
UserType VARCHAR(15),
LoginStatus int(1),
PRIMARY KEY (UserId),
CONSTRAINT POS_TBL_User_Credentials_check_1 CHECK ((UserType in (_utf8mb4'A',_utf8mb4'C'))),
CONSTRAINT POS_TBL_User_Credentials_check_2 CHECK ((LoginStatus in (0,1)))
);

CREATE TABLE POS_TBL_Pizza_Store(
StoreId VARCHAR(6) NOT NULL,
Name VARCHAR(15) NOT NULL,
Street VARCHAR(50) NOT NULL,
MobileNo int(10) NOT NULL,
City VARCHAR(15) NOT NULL,
Store_State VARCHAR(15) NOT NULL,
Pincode VARCHAR(10),
PRIMARY KEY(StoreId)
);

CREATE TABLE POS_TBL_Food(
FoodId VARCHAR(6) NOT NULL,
Name VARCHAR(20) NOT NULL,
FoodType VARCHAR(10) NOT NULL,
FoodSize VARCHAR(15) NOT NULL,
Quantity int(3) NOT NULL,
Price int(4) NOT NULL,
PRIMARY KEY (FoodId),
CONSTRAINT POS_TBL_Food_check_1 CHECK ((FoodType in (_utf8mb4'Veg',_utf8mb4 'Non-Veg'))),
CONSTRAINT POS_TBL_Food_check_2 CHECK ((FoodSize in (_utf8mb4'Small',_utf8mb4'Medium',_utf8mb4'Big')))
);

CREATE TABLE POS_TBL_Order(
OrderId VARCHAR(6) NOT NULL,
UserId VARCHAR(6) NOT NULL,
OrderDate DATE NOT NULL,
StoreId VARCHAR(6) NOT NULL,
TotalPrice int(5) NOT NULL,
OrderStatus VARCHAR(15) NOT NULL,
CartId int(5),
Street VARCHAR(50) NOT NULL,
City VARCHAR(15) NOT NULL,
Order_State VARCHAR(15) NOT NULL,
Pincode VARCHAR(10),
MobileNo VARCHAR(10),
PRIMARY KEY (OrderId),
FOREIGN KEY (UserId) REFERENCES POS_TBL_User_Profile(UserId),
FOREIGN KEY (StoreId) REFERENCES POS_TBL_Pizza_Store(StoreId),
CONSTRAINT POS_TBL_Order_check_1 CHECK ((OrderStatus in (_utf8mb4'Confirmed',_utf8mb4'Delivered',_utf8mb4'Pending',_utf8mb4'Cancelled')))
);

CREATE TABLE POS_TBL_Cart(
CartId int(5),
UserId VARCHAR(6) NOT NULL,
FoodId VARCHAR(6) NOT NULL,
FoodType VARCHAR(10) NOT NULL,
Quantity int(3) NOT NULL,
Cost int(5) NOT NULL,
OrderDate DATE,
FOREIGN KEY (UserId) REFERENCES POS_TBL_User_Profile(UserId),
FOREIGN KEY (FoodId) REFERENCES POS_TBL_Food(FoodId),
CONSTRAINT POS_TBL_Cart_check_1 CHECK ((FoodType in (_utf8mb4'Veg',_utf8mb4 'Non-Veg')))
);

CREATE TABLE POS_TBL_CreditCard(
CreditCardint VARCHAR(16) NOT NULL,
ValidFrom VARCHAR(7) NOT NULL,
ValidTo VARCHAR(7) NOT NULL,
Balance int(10) NOT NULL,
userId VARCHAR(6),
PRIMARY KEY (CreditCardint)
);