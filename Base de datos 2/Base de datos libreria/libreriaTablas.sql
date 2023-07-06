CREATE TABLE Author(
	AuthorID int NOT NULL PRIMARY KEY,
	AuthorName varchar(50)
);

CREATE TABLE Category(
	CategoryID int NOT NULL PRIMARY KEY,
	CategoryDescription varchar(MAX)
);

CREATE TABLE Customer(
	CustomerID int NOT NULL PRIMARY KEY,
	FirstName varchar(50),
	LastName varchar(50),
	ZipCode int,
	City varchar(50),
	StateP varchar(50),
);

CREATE TABLE Book_Order(
	OrderID int NOT NULL PRIMARY KEY,
	Cus_CustomerID int,
	CustomerID int,
	OrderDate date,
	FOREIGN KEY (Cus_CustomerID) REFERENCES Customer(CustomerID)
);

CREATE TABLE Book(
	BookID int NOT NULL PRIMARY KEY,
	CategoryID int,
	Title varchar(100),
	ISBN varchar(200),
	YearR int,
	Price int, 
	NoPages int,
	BookDescription varchar(MAX),
	FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);

CREATE TABLE Ordering(
	BookID int,
	OrderID int,
	Price int,
	FOREIGN KEY (BookID) REFERENCES Book(BookID),
	FOREIGN KEY (OrderID) REFERENCES Book_Order(OrderID)
	
);

CREATE TABLE Author_Book(
	AuthorID int,
	BookID int,
	FOREIGN KEY (AuthorID) REFERENCES Author(AuthorID),
	FOREIGN KEY (BookID) REFERENCES Book(BookID)
);

