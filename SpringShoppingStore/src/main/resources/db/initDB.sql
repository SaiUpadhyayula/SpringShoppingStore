DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `Address_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Address_1` varchar(200) NOT NULL,
  `Address_2` varchar(45) NOT NULL,
  `City` varchar(30) NOT NULL,
  `Zip` varchar(45) NOT NULL,
  `State` varchar(45) NOT NULL,
  `FullName` varchar(45) NOT NULL,
  PRIMARY KEY (`Address_Id`)
)

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `Category_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Category_Id`)
)

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `Customer_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(45) DEFAULT NULL,
  `Last_Name` varchar(45) DEFAULT NULL,
  `User_Name` varchar(45) NOT NULL,
  `Pass` varchar(45) NOT NULL,
  `Email_Address` varchar(45) NOT NULL,
  `Phone_Number` varchar(45) DEFAULT NULL,
  `Active` int(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`Customer_Id`)
)

DROP TABLE IF EXISTS `customeractivation`;
CREATE TABLE `customeractivation` (
  `Activation_Key` bigint(25) unsigned NOT NULL AUTO_INCREMENT,
  `Customer_Id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Activation_Key`) USING BTREE,
  KEY `FK_useractivation_1` (`Customer_Id`)
)

DROP TABLE IF EXISTS `customeraddress`;
CREATE TABLE `customeraddress` (
  `CustomerAddress_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Address_Id` int(10) unsigned NOT NULL,
  `Customer_Id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`CustomerAddress_Id`),
  KEY `FK_CustomerAddress_1` (`Customer_Id`),
  KEY `FK_customeraddress_2` (`Address_Id`),
  CONSTRAINT `FK_CustomerAddress_1` FOREIGN KEY (`Customer_Id`) REFERENCES `customer` (`Customer_Id`),
  CONSTRAINT `FK_customeraddress_2` FOREIGN KEY (`Address_Id`) REFERENCES `address` (`Address_Id`)
)

DROP TABLE IF EXISTS `emaildetails`;
CREATE TABLE `emaildetails` (
  `UserName` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`UserName`)
)

DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `OrderItem_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Price` decimal(10,2) NOT NULL,
  `Quantity` int(10) unsigned NOT NULL,
  `Category_Id` int(10) unsigned NOT NULL,
  `SubCategory_Id` int(10) unsigned NOT NULL,
  `Order_Id` bigint(20) unsigned NOT NULL,
  `Product_Id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`OrderItem_Id`),
  KEY `FK_orderitem_1` (`Category_Id`),
  KEY `FK_orderitem_2` (`SubCategory_Id`),
  KEY `FK_orderitem_3` (`Order_Id`),
  KEY `FK_orderitem_4` (`Product_Id`),
  CONSTRAINT `FK_orderitem_1` FOREIGN KEY (`Category_Id`) REFERENCES `category` (`Category_Id`),
  CONSTRAINT `FK_orderitem_2` FOREIGN KEY (`SubCategory_Id`) REFERENCES `subcategory` (`SubCategory_Id`),
  CONSTRAINT `FK_orderitem_3` FOREIGN KEY (`Order_Id`) REFERENCES `orders` (`Order_Id`),
  CONSTRAINT `FK_orderitem_4` FOREIGN KEY (`Product_Id`) REFERENCES `product` (`Product_Id`)
)

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `Order_Id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `CreatedDate` datetime NOT NULL,
  `UpdatedDate` datetime DEFAULT NULL,
  `Email_Address` varchar(45) NOT NULL,
  `Order_Status` varchar(45) NOT NULL,
  `Order_SubTotal` decimal(10,2) NOT NULL,
  `Customer_Id` int(10) unsigned NOT NULL,
  `Address_Id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Order_Id`),
  KEY `FK_orders_1` (`Customer_Id`),
  KEY `FK_orders_2` (`Address_Id`),
  CONSTRAINT `FK_orders_1` FOREIGN KEY (`Customer_Id`) REFERENCES `customer` (`Customer_Id`),
  CONSTRAINT `FK_orders_2` FOREIGN KEY (`Address_Id`) REFERENCES `address` (`Address_Id`)
)

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `CC_Number` varchar(45) NOT NULL,
  `CC_Name` varchar(45) NOT NULL,
  `CC_CVV` int(3) unsigned NOT NULL,
  `CC_Expiry_Month` int(2) unsigned NOT NULL,
  `CC_Expiry_Year` int(4) unsigned NOT NULL,
  `Customer_Id` int(10) unsigned NOT NULL,
  KEY `FK_payment_1` (`Customer_Id`),
  CONSTRAINT `FK_payment_1` FOREIGN KEY (`Customer_Id`) REFERENCES `customer` (`Customer_Id`)
)

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `Product_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Featured` tinyint(1) NOT NULL,
  `Price` decimal(10,0) NOT NULL,
  `Available` tinyint(1) NOT NULL,
  `Category_Id` int(10) unsigned NOT NULL,
  `Description` blob NOT NULL,
  `SubCategory_Id` int(10) unsigned NOT NULL,
  `Manufacturer` varchar(45) NOT NULL,
  PRIMARY KEY (`Product_Id`),
  KEY `FK_product_1` (`Category_Id`),
  KEY `FK_product_2` (`SubCategory_Id`),
  CONSTRAINT `FK_product_1` FOREIGN KEY (`Category_Id`) REFERENCES `category` (`Category_Id`),
  CONSTRAINT `FK_product_2` FOREIGN KEY (`SubCategory_Id`) REFERENCES `subcategory` (`SubCategory_Id`)
)

DROP TABLE IF EXISTS `rating`;
CREATE TABLE `rating` (
  `Rating_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Rating` varchar(10) NOT NULL,
  `Review_ID` int(10) unsigned NOT NULL,
  `Product_Id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Rating_ID`),
  KEY `FK_rating_1` (`Review_ID`),
  KEY `FK_rating_2` (`Product_Id`),
  CONSTRAINT `FK_rating_1` FOREIGN KEY (`Review_ID`) REFERENCES `review` (`Review_Id`),
  CONSTRAINT `FK_rating_2` FOREIGN KEY (`Product_Id`) REFERENCES `product` (`Product_Id`)
)

DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `Review_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Customer_Id` int(10) unsigned NOT NULL,
  `ReviewText` blob NOT NULL,
  `SubmittedDate` datetime NOT NULL,
  `Product_Id` int(10) unsigned NOT NULL,
  `ReviewTitle` varchar(45) NOT NULL,
  `Rating` varchar(10) NOT NULL,
  PRIMARY KEY (`Review_Id`),
  KEY `FK_Review_1` (`Customer_Id`),
  KEY `FK_review_2` (`Product_Id`),
  CONSTRAINT `FK_Review_1` FOREIGN KEY (`Customer_Id`) REFERENCES `customer` (`Customer_Id`),
  CONSTRAINT `FK_review_2` FOREIGN KEY (`Product_Id`) REFERENCES `product` (`Product_Id`)
)

DROP TABLE IF EXISTS `reviewsummary`;
CREATE TABLE `reviewsummary` (
  `Summary_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Review_ID` int(10) unsigned NOT NULL,
  `Helpful` tinyint(1) NOT NULL,
  `Not_Helpful` tinyint(1) NOT NULL,
  PRIMARY KEY (`Summary_Id`),
  KEY `FK_ReviewSummary_1` (`Review_ID`),
  CONSTRAINT `FK_ReviewSummary_1` FOREIGN KEY (`Review_ID`) REFERENCES `review` (`Review_Id`)
)

DROP TABLE IF EXISTS `subcategory`;
CREATE TABLE `subcategory` (
  `SubCategory_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Category_Id` int(10) unsigned NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`SubCategory_Id`),
  KEY `FK_subcategory_1` (`Category_Id`),
  CONSTRAINT `FK_subcategory_1` FOREIGN KEY (`Category_Id`) REFERENCES `category` (`Category_Id`)
)

DROP TABLE IF EXISTS `wishlistdetails`;
CREATE TABLE `wishlistdetails` (
  `Details_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Product_Id` int(10) unsigned NOT NULL,
  `Customer_Id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Details_Id`) USING BTREE,
  KEY `FK_wishlistdetails_2` (`Customer_Id`),
  KEY `FK_wishlistdetails_3` (`Product_Id`),
  CONSTRAINT `FK_wishlistdetails_2` FOREIGN KEY (`Customer_Id`) REFERENCES `customer` (`Customer_Id`),
  CONSTRAINT `FK_wishlistdetails_3` FOREIGN KEY (`Product_Id`) REFERENCES `product` (`Product_Id`)
)
