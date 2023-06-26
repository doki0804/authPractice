CREATE TABLE "product" (
	"p_Index"	int		NOT NULL,
	"p_Name"	varchar(50)		NULL,
	"p_Id"	varchar(50)		NULL,
	"p_Price"	varchar(20)		NULL,
	"p_Pcs"	int		NULL,
	"manufacturer"	varchar(50)		NULL,
	"created_Date"	varchar(50)		NULL,
	"expiration_Date"	varchar(50)		NULL
);

CREATE TABLE "customer" (
	"c_Index"	int		NOT NULL,
	"c_Name"	varchar(50)		NULL,
	"c_Phone"	varchar(20)		NULL,
	"c_Adress"	varchar(100)		NULL
);

CREATE TABLE "order" (
	"o_Index"	int		NOT NULL,
	"c_Index"	int		NOT NULL,
	"o_Number"	int		NULL,
	"order_Date"	varchar(50)		NULL,
	"order_State"	varchar(20)		NULL
);

CREATE TABLE "order_Item" (
	"oi_Index"	int		NOT NULL,
	"o_Index"	int		NOT NULL,
	"p_Index"	int		NOT NULL
);

CREATE TABLE "employee" (
	"e_Number"	int		NOT NULL,
	"m_Number"	int		NOT NULL,
	"e_Name"	varchar(50)		NULL,
	"e_Phone"	varchar(20)		NULL
);

CREATE TABLE "manager" (
	"m_Number"	int		NOT NULL,
	"id"	varchar(50)		NULL,
	"password"	varchar(50)		NULL,
	"m_Name"	varchar(50)		NULL,
	"m_Phone"	varchar(20)		NULL,
	"email"	varchar(60)		NULL
);

CREATE TABLE "assign" (
	"e_Number"	int		NOT NULL,
	"oi_Index"	int		NOT NULL,
	"assign_Date"	varchar(50)		NULL,
	"complete_Date"	varchar(50)		NULL,
	"state"	varchar(20)		NULL
);

ALTER TABLE "product" ADD CONSTRAINT "PK_PRODUCT" PRIMARY KEY (
	"p_Index"
);

ALTER TABLE "customer" ADD CONSTRAINT "PK_CUSTOMER" PRIMARY KEY (
	"c_Index"
);

ALTER TABLE "order" ADD CONSTRAINT "PK_ORDER" PRIMARY KEY (
	"o_Index"
);

ALTER TABLE "order_Item" ADD CONSTRAINT "PK_ORDER_ITEM" PRIMARY KEY (
	"oi_Index"
);

ALTER TABLE "employee" ADD CONSTRAINT "PK_EMPLOYEE" PRIMARY KEY (
	"e_Number"
);

ALTER TABLE "manager" ADD CONSTRAINT "PK_MANAGER" PRIMARY KEY (
	"m_Number"
);

