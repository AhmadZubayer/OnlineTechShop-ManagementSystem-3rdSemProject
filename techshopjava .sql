-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 05, 2025 at 03:52 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `techshopjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `serial` int(11) NOT NULL,
  `C_USERNAME` varchar(10) NOT NULL,
  `PRODUCT_ID` varchar(9) NOT NULL,
  `QUANTITY` int(11) NOT NULL DEFAULT 1,
  `ADDED_DATE` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`serial`, `C_USERNAME`, `PRODUCT_ID`, `QUANTITY`, `ADDED_DATE`) VALUES
(7, '069', 'CONSL001', 1, '2025-02-02 12:02:56'),
(8, '069', 'CONSL002', 1, '2025-02-02 12:02:58'),
(181, 'trino10', 'CONSL002', 1, '2025-02-04 13:28:15'),
(182, 'trino10', 'CONSL004', 1, '2025-02-04 13:28:16'),
(183, 'trino10', 'CPU004', 1, '2025-02-04 13:30:22'),
(184, 'trino10', 'COL003', 1, '2025-02-04 13:30:22'),
(185, 'trino10', 'MEM003', 4, '2025-02-04 13:30:22'),
(187, 'trino10', 'PSU003', 1, '2025-02-04 13:30:22'),
(188, 'trino10', 'CASE001', 1, '2025-02-04 13:30:22'),
(221, 'zubayer369', 'CONSL002', 1, '2025-02-05 07:03:35');

-- --------------------------------------------------------

--
-- Stand-in structure for view `cartdetails`
-- (See below for the actual view)
--
CREATE TABLE `cartdetails` (
`PRODUCT_NAME` varchar(255)
,`QUANTITY` int(11)
,`PRICE` decimal(10,2)
,`VAT` decimal(3,2)
,`TOTAL_PRICE` decimal(21,3)
,`VAT_AMOUNT` decimal(23,3)
,`C_USERNAME` varchar(10)
);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `C_USERNAME` varchar(10) NOT NULL,
  `CUSTOMER_NAME` varchar(20) NOT NULL,
  `PHONE_NO` int(15) NOT NULL,
  `EMAIL` varchar(30) NOT NULL,
  `ADDRESS` varchar(30) NOT NULL,
  `PASSWORD` varchar(11) NOT NULL,
  `DATE_REGISTERED` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`C_USERNAME`, `CUSTOMER_NAME`, `PHONE_NO`, `EMAIL`, `ADDRESS`, `PASSWORD`, `DATE_REGISTERED`) VALUES
('001', 'Anik', 1842823300, 'anik@gmail.com', 'dhaka', '1234', '2025-01-15'),
('002', 'Zubayer', 1842823300, 'mahin@gmail.com', 'Dhaka', 'Dhaka', '2025-01-15'),
('005', 'Naveed', 176969669, 'naveed@gmail', 'mirpur', '123', '2025-01-15'),
('007', '45', 1234567891, 's@s.s', '45', '45', '2025-01-18'),
('009', 'wahid', 1234567899, 'a@a.a', '12', '11', '2025-01-19'),
('069', 'Anik', 1234467899, 'a@s.s', '123', '12', '2025-02-02'),
('333', 'disha', 1234567898, 'w@w.w', 'dhaka', '12', '2025-01-19'),
('hello', 'hello', 1234567890, 'hello@aiub.edu', 'dhaka', '121', '2025-01-15'),
('labib001', 'labib', 1234569899, 'labib@l.com', 'dhaka', '11', '2025-02-04'),
('niloy001', 'Niloy', 1986277963, 'niloy@m.mail', 'dhaka', '000', '2025-02-04'),
('t3', 't3', 1234567894, 'e@e.e', '1', '1', '2025-02-04'),
('test', 'test', 1534833131, 't@t.t', 'test', '1', '2025-02-04'),
('test2', 'test2', 1717757777, '2@2.2', 'test2', '2', '2025-02-04'),
('trino10', 'trino', 1234567896, 'tt@t.t', 'dhaka', '11', '2025-02-04'),
('wahid99', 'wahid', 1234587891, 'f@f.f', 'Dhaka', '11', '2025-02-05'),
('zubayer369', 'AhmadZubayer', 1842823300, 'hello@gmail.com', 'dhaka', '1234', '2025-01-15'),
('zubayer399', 'zubayer', 1234567895, 'h@h.h', 'gg', '123', '2025-02-05');

-- --------------------------------------------------------

--
-- Table structure for table `discounts`
--

CREATE TABLE `discounts` (
  `discount_code` varchar(5) NOT NULL,
  `discount_percentage` decimal(3,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `discounts`
--

INSERT INTO `discounts` (`discount_code`, `discount_percentage`) VALUES
('IDBQ', 0.20);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `empID` varchar(5) NOT NULL,
  `empEmail` varchar(100) NOT NULL,
  `empPhone` varchar(15) NOT NULL,
  `empName` varchar(100) NOT NULL,
  `empPassword` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`empID`, `empEmail`, `empPhone`, `empName`, `empPassword`) VALUES
('54734', 'ahmadzubayer007@gmail.com', '01404183980', 'Ahmad Zubayer', '007');

-- --------------------------------------------------------

--
-- Table structure for table `orderlist`
--

CREATE TABLE `orderlist` (
  `orderID` int(11) NOT NULL,
  `paymentID` int(11) DEFAULT NULL,
  `C_USERNAME` varchar(10) DEFAULT NULL,
  `orderDate` date DEFAULT NULL,
  `product_list` varchar(1000) NOT NULL,
  `total_price` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderlist`
--

INSERT INTO `orderlist` (`orderID`, `paymentID`, `C_USERNAME`, `orderDate`, `product_list`, `total_price`) VALUES
(8, 37, '001', '2025-02-04', 'CONSL002(1), CONSL008(1), CONSL007(1), CONSL003(3)', '2920.42'),
(9, 39, '001', '2025-02-04', 'CONSL002(1), CONSL004(1), CONSL007(2), GAME003(1), GAME004(1)', '2451.12'),
(10, 41, 'zubayer369', '2025-02-04', 'CONSL003(1), CONSL008(1), GACC003(1), GACC006(1), GACC005(1)', '1972.19'),
(15, 46, '001', '2025-02-04', 'CONSL002(1), GAME003(1), GAME005(1)', '636.73'),
(17, 48, 'zubayer369', '2025-02-04', 'CONSL002(1), GAME003(1)', '570.74'),
(18, 49, '001', '2025-02-04', 'CONSL004(1)', '230.10'),
(19, 50, '001', '2025-02-04', 'CONSL003(1), GACC003(1), COL003(1), SSD004(1)', '1225.70'),
(21, 52, 'zubayer369', '2025-02-05', 'CPU003(1), COL004(1), MBD004(1), MEM004(3), GPU003(1), SSD002(1), PSU003(1), CASE004(1)', '4609.1'),
(22, 53, 'zubayer369', '2025-02-05', 'CONSL002(2), CONSL004(3), CONSL007(2), CONSL008(1), CONSL001(1), CPU003(1), COL003(1), MBD003(1), MEM004(1), SSD003(1), PSU003(1), CONSL003(1)', '7036.76'),
(24, 55, 'zubayer369', '2025-02-05', 'CONSL002(2)', '998.5'),
(25, 56, 'zubayer369', '2025-02-05', 'CONSL002(2)', '998.5'),
(26, 57, 'zubayer369', '2025-02-05', 'CONSL002(3)', '1497.75'),
(27, 58, 'zubayer369', '2025-02-05', 'CONSL002(2)', '998.5'),
(28, 59, 'zubayer399', '2025-02-05', 'CONSL003(1)', '450.21'),
(29, 60, 'wahid99', '2025-02-05', 'CONSL001(1), CPU002(1), COL003(1), MBD004(1), MEM004(4), GPU003(1), SSD003(1), PSU004(1), CASE003(1)', '5679.62'),
(30, 61, '001', '2025-02-05', 'CONSL003(2), CONSL004(5), CONSL002(2), CONSL008(2), CONSL007(1), CONSL001(1)', '6390.11'),
(31, 62, '001', '2025-02-05', 'CONSL002(1), CONSL003(1), CONSL004(1)', '1179.57'),
(32, 63, '001', '2025-02-05', 'CONSL004(1)', '230.1'),
(33, 64, '001', '2025-02-05', 'CONSL004(1)', '229.64'),
(34, 65, '001', '2025-02-05', '', '0.0');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `paymentID` int(11) NOT NULL,
  `cartID` int(11) NOT NULL,
  `c_username` varchar(50) NOT NULL,
  `payment_date` date NOT NULL,
  `payment_method` enum('bkash','card','cash on delivery','not paid') NOT NULL DEFAULT 'not paid',
  `totalPaid` decimal(15,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`paymentID`, `cartID`, `c_username`, `payment_date`, `payment_method`, `totalPaid`) VALUES
(10, 0, '001', '2025-02-03', 'bkash', NULL),
(11, 0, '001', '2025-02-03', 'bkash', NULL),
(12, 0, '001', '2025-02-03', 'bkash', NULL),
(13, 0, '001', '2025-02-03', 'bkash', NULL),
(14, 0, '001', '2025-02-03', 'bkash', 0.00),
(15, 0, '001', '2025-02-03', 'bkash', 0.00),
(16, 0, '001', '2025-02-03', 'bkash', NULL),
(17, 0, '001', '2025-02-03', 'bkash', NULL),
(18, 0, '001', '2025-02-03', 'bkash', 729.35),
(19, 0, '001', '2025-02-03', 'bkash', 729.35),
(20, 0, '001', '2025-02-03', 'bkash', 729.35),
(21, 0, '001', '2025-02-03', 'bkash', 729.35),
(22, 0, '001', '2025-02-03', 'bkash', 686.22),
(23, 0, '001', '2025-02-03', 'bkash', 686.22),
(24, 0, '001', '2025-02-04', 'card', 1980.41),
(25, 0, '001', '2025-02-04', 'card', 1980.41),
(26, 0, 'labib001', '2025-02-04', 'cash on delivery', 2453.64),
(27, 0, 'labib001', '2025-02-04', 'cash on delivery', 2453.64),
(28, 0, 'labib001', '2025-02-04', 'bkash', 0.00),
(29, 0, 'labib001', '2025-02-04', 'bkash', 0.00),
(30, 0, '001', '2025-02-04', 'bkash', 1552.20),
(31, 0, '001', '2025-02-04', 'bkash', 1552.20),
(32, 0, '001', '2025-02-04', 'bkash', 680.32),
(33, 0, '001', '2025-02-04', 'bkash', 680.32),
(34, 0, '001', '2025-02-04', 'card', 499.25),
(35, 0, '001', '2025-02-04', 'card', 499.25),
(36, 0, '001', '2025-02-04', 'bkash', 2920.42),
(37, 0, '001', '2025-02-04', 'bkash', 2920.42),
(38, 0, '001', '2025-02-04', 'cash on delivery', 2451.12),
(39, 0, '001', '2025-02-04', 'cash on delivery', 2451.12),
(40, 0, 'zubayer369', '2025-02-04', 'bkash', 1972.19),
(41, 0, 'zubayer369', '2025-02-04', 'bkash', 1972.19),
(42, 1, '001', '2025-02-04', 'card', 729.35),
(43, 2, 'zubayer369', '2025-02-04', 'card', 1480.71),
(44, 3, 'labib001', '2025-02-04', 'card', 2303.40),
(45, 4, '001', '2025-02-04', 'card', 230.10),
(46, 5, '001', '2025-02-04', 'bkash', 636.73),
(47, 6, 'zubayer369', '2025-02-04', 'cash on delivery', 4011.90),
(48, 7, 'zubayer369', '2025-02-04', 'card', 570.74),
(49, 8, '001', '2025-02-04', 'bkash', 230.10),
(50, 9, '001', '2025-02-04', 'card', 1225.70),
(51, 10, 'niloy001', '2025-02-04', 'card', 230.10),
(52, 11, 'zubayer369', '2025-02-05', 'card', 4609.10),
(53, 12, 'zubayer369', '2025-02-05', 'bkash', 7036.76),
(54, 13, 'zubayer369', '2025-02-05', 'bkash', 998.50),
(55, 14, 'zubayer369', '2025-02-05', 'bkash', 998.50),
(56, 15, 'zubayer369', '2025-02-05', 'bkash', 998.50),
(57, 16, 'zubayer369', '2025-02-05', 'card', 1497.75),
(58, 17, 'zubayer369', '2025-02-05', 'bkash', 998.50),
(59, 18, 'zubayer399', '2025-02-05', 'bkash', 450.21),
(60, 19, 'wahid99', '2025-02-05', 'bkash', 5679.62),
(61, 20, '001', '2025-02-05', 'bkash', 6390.11),
(62, 21, '001', '2025-02-05', 'bkash', 1179.57),
(63, 22, '001', '2025-02-05', 'bkash', 230.10),
(64, 23, '001', '2025-02-05', 'card', 229.64),
(65, 24, '001', '2025-02-05', 'card', 0.00);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `PRODUCT_ID` varchar(9) NOT NULL,
  `PRODUCT_NAME` varchar(255) NOT NULL,
  `BRAND` varchar(255) NOT NULL,
  `CATEGORY` varchar(255) NOT NULL,
  `PRICE` decimal(10,2) NOT NULL,
  `VAT` decimal(3,2) DEFAULT 0.00,
  `AVAILABLE_QUANTITY` int(11) NOT NULL,
  `SOLD` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`PRODUCT_ID`, `PRODUCT_NAME`, `BRAND`, `CATEGORY`, `PRICE`, `VAT`, `AVAILABLE_QUANTITY`, `SOLD`) VALUES
('CASE001', 'CORSAIR iCUE 5000T RGB Mid-Tower ATX PC', 'CORSAIR', 'CASE', 129.99, 3.20, 35, 55),
('CASE002', 'Cooler Master TD500 MAX ATX Mid-Tower Case', 'Cooler Master', 'CASE', 149.99, 0.50, 40, 60),
('CASE003', 'ASUS ROG Strix Helios GX601 White Edition RGB', 'ASUS', 'CASE', 329.99, 1.20, 45, 35),
('CASE004', 'CORSAIR iCUE 5000T RGB', 'CORSAIR', 'CASE', 199.99, 3.20, 50, 40),
('COL001', 'CORSAIR iCUE Link H150i LCD Liquid CPU Cooler', 'CORSAIR', 'COOLER', 229.99, 0.50, 55, 45),
('COL002', 'CORSAIR iCUE Link H100X LCD Liquid CPU Cooler', 'CORSAIR', 'COOLER', 249.99, 1.20, 60, 50),
('COL003', 'Corsair H100x RGB Elite Liquid CPU Cooler', 'Corsair', 'COOLER', 119.99, 3.20, 30, 35),
('COL004', 'MSI MAG CORELIQUID I360 White', 'MSI', 'COOLER', 296.99, 0.50, 35, 40),
('CONSL001', 'PlayStation 5 ', 'Sony', 'Gaming Consoles', 1999.00, 0.05, 20, 150),
('CONSL002', 'PlayStation 5', 'Sony', 'Gaming Consoles', 499.00, 0.05, 20, 150),
('CONSL003', 'XBOX Series X', 'Microsoft', 'Gaming Consoles', 449.99, 0.05, 20, 150),
('CONSL004', 'XBOX Series S', 'Microsoft', 'Gaming Consoles', 229.99, 0.05, 20, 150),
('CONSL005', 'Valve Steam Deck', 'Valve', 'Gaming Consoles', 396.00, 0.05, 20, 150),
('CONSL006', 'Nintendo Switch', 'Nintendo', 'Gaming Consoles', 299.99, 0.05, 20, 150),
('CONSL007', 'ROG Ally X', 'ASUS', 'Gaming Consoles', 799.99, 0.05, 20, 150),
('CONSL008', 'PlayStation 4', 'Sony', 'Gaming Consoles', 270.00, 0.05, 20, 150),
('CPU001', 'AMD Threadripper Pro 7995WX', 'AMD', 'CPU', 9999.00, 0.50, 45, 30),
('CPU002', 'AMD Ryzen 9 9950X', 'AMD', 'CPU', 629.99, 1.20, 50, 40),
('CPU003', 'Intel® Core™ i9-14900KS', 'Intel', 'CPU', 750.99, 3.20, 35, 60),
('CPU004', 'Intel Core-i7-14700K', 'Intel', 'CPU', 389.00, 0.50, 40, 50),
('GACC001', '55\" SAMSUNG Odyssey Ark', 'SAMSUNG', 'Accessories', 1799.99, 0.15, 10, 0),
('GACC002', 'Thrustmaster T-GT II Racing Wheel', 'Thrustmaster', 'Accessories', 799.99, 0.15, 10, 0),
('GACC003', 'SONY WH-1000XM5 Wireless', 'SONY', 'Accessories', 449.99, 0.15, 10, 0),
('GACC004', 'RAZER Barracuda Pro', 'RAZER', 'Accessories', 249.99, 0.15, 10, 0),
('GACC005', 'SteelSeries Arctis Pro', 'SteelSeries', 'Accessories', 399.99, 0.15, 10, 0),
('GACC006', 'RAZER Naga V2 Pro', 'RAZER', 'Accessories', 399.99, 0.15, 10, 0),
('GACC007', 'RAZER Blackwidow V4 Pro', 'RAZER', 'Accessories', 399.99, 0.15, 10, 0),
('GACC008', 'RAZER Wolverine V3 Pro', 'RAZER', 'Accessories', 199.99, 0.15, 10, 0),
('GAME001', 'Grand Theft Auto VI', 'Rockstar Games', 'GAMES', 0.00, 9.99, 100, 0),
('GAME002', 'Forza Horizon 5', 'Playground Games', 'GAMES', 55.00, 9.99, 200, 50),
('GAME003', 'Microsoft Flight Simulator', 'Microsoft', 'GAMES', 65.00, 9.99, 150, 40),
('GAME004', 'Call of Duty: Infinite Warfare', 'Activision', 'GAMES', 45.00, 9.99, 300, 120),
('GAME005', 'Red Dead Redemption 2', 'Rockstar Games', 'GAMES', 59.99, 9.99, 180, 70),
('GAME006', 'Cyberpunk 2077', 'CD Projekt Red', 'GAMES', 69.99, 9.99, 160, 90),
('GAME007', 'Halo Infinite', '343 Industries', 'GAMES', 45.00, 9.99, 250, 100),
('GAME008', 'Elder Ring', 'FromSoftware', 'GAMES', 59.99, 9.99, 140, 60),
('GPU001', 'NVIDIA RTX A6000', 'NVIDIA', 'GPU', 4999.99, 1.20, 30, 55),
('GPU002', 'ASUS ROG STRIX GEFORCE RTX 4090', 'ASUS', 'GPU', 1999.99, 3.20, 45, 60),
('GPU003', 'ASUS ROG STRIX GEFORCE RTX 4080 Super', 'ASUS', 'GPU', 1699.99, 0.50, 50, 40),
('GPU004', 'ASUS ROG STRIX GEFORCE RTX 4080 Super WHITE', 'ASUS', 'GPU', 1899.99, 1.20, 55, 35),
('MBD001', 'ASUS ROG Maximus XII Formula Z490', 'ASUS', 'MOTHERBOARD', 579.99, 1.20, 50, 35),
('MBD002', 'ASUS ROG Strix B650-A Gaming WiFi 6E AM5 (LGA1718)', 'ASUS', 'MOTHERBOARD', 549.99, 3.20, 55, 40),
('MBD003', 'GIGABYTE B650E AORUS Elite X', 'GIGABYTE', 'MOTHERBOARD', 329.99, 0.50, 60, 45),
('MBD004', 'MSI MPG Z790 Carbon MAX WiFi II Gaming Motherboard', 'MSI', 'MOTHERBOARD', 449.99, 1.20, 30, 50),
('MEM001', 'CORSAIR VENGEANCE RGB DDR5 RAM 64GB', 'CORSAIR', 'MEMORY', 229.99, 3.20, 40, 45),
('MEM002', 'CORSAIR VENGEANCE RGB DDR5 RAM 96GB', 'CORSAIR', 'MEMORY', 449.99, 0.50, 50, 50),
('MEM003', 'CORSAIR VENGEANCE RGB DDR5 RAM 128GB', 'CORSAIR', 'MEMORY', 629.99, 1.20, 35, 45),
('MEM004', 'CORSAIR Dominator Titanium RGB DDR5 RAM 64GB', 'CORSAIR', 'MEMORY', 229.99, 3.20, 40, 40),
('PCOMP001', 'GEFORCE RTX 3080', 'NVIDIA', 'GPU', 699.00, 1.20, 10, 50),
('PCOMP002', 'AMD Ryzen 9', 'AMD', 'CPU', 499.00, 3.20, 25, 80),
('PCOMP003', 'Corsair RAM', 'Corsair', 'MEMORY', 79.00, 0.50, 50, 150),
('PCOMP004', 'Intel i9 11900K', 'Intel', 'CPU', 549.00, 3.20, 12, 75),
('PCOMP005', 'ASUS TUF Z490', 'ASUS', 'MOTHERBOARD', 229.00, 0.50, 15, 90),
('PCOMP006', 'NZXT H510 Case', 'NZXT', 'CASE', 99.00, 1.20, 30, 250),
('PCOMP007', 'Cooler Master Hyper 212', 'Cooler Master', 'COOLER', 35.00, 3.20, 40, 320),
('PCOMP008', 'Crucial MX500 SSD 1TB', 'Crucial', 'SSD', 129.00, 0.50, 50, 400),
('PCOMP009', 'Samsung 970 EVO 1TB', 'Samsung', 'SSD', 149.00, 1.20, 30, 260),
('PCOMP010', 'MSI B550 Tomahawk', 'MSI', 'MOTHERBOARD', 189.00, 3.20, 15, 120),
('PCOMP011', 'EVGA 750W Power Supply', 'EVGA', 'PSU', 109.00, 0.50, 20, 150),
('PCOMP012', 'G.Skill Trident Z 16GB', 'G.Skill', 'MEMORY', 89.00, 1.20, 30, 260),
('PCOMP013', 'Corsair RM850 Power Supply', 'Corsair', 'PSU', 129.00, 3.20, 25, 180),
('PCOMP014', 'AMD Radeon RX 6800', 'AMD', 'GPU', 579.00, 0.50, 10, 75),
('PSU001', 'Corsair HX1500i 1500W Platinum', 'Corsair', 'PSU', 396.99, 1.20, 40, 45),
('PSU002', 'ROG Thor 1200W Platinum', 'ASUS', 'PSU', 326.99, 3.20, 45, 50),
('PSU003', 'ASUS ROG STRIX 1000W Gold', 'ASUS', 'PSU', 299.99, 0.50, 50, 55),
('PSU004', 'ASUS ROG Strix 1000W Gold Aura White Edition', 'ASUS', 'PSU', 210.99, 1.20, 55, 60),
('SSD001', 'SABRENT 8TB Rocket 4 PLUS NVMe 4.0 Gen4', 'SABRENT', 'SSD', 299.99, 0.50, 30, 45),
('SSD002', 'SAMSUNG 980 PRO SSD 1TB PCIe 4.0 NVMe Gen 4 Gaming', 'SAMSUNG', 'SSD', 149.99, 1.20, 35, 50),
('SSD003', 'Corsair MP600 PRO LPX 8TB M.2 NVMe PCIe x4 Gen4', 'Corsair', 'SSD', 249.99, 3.20, 40, 55),
('SSD004', 'MSI SPATIUM M480 PRO PCIe 4.0 NVMe M.2 4TB', 'MSI', 'SSD', 199.99, 0.50, 45, 60);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplierid` int(11) NOT NULL,
  `suppliername` varchar(255) NOT NULL,
  `supplieremail` varchar(255) NOT NULL,
  `supplierbrand` varchar(255) NOT NULL,
  `productId` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplierid`, `suppliername`, `supplieremail`, `supplierbrand`, `productId`) VALUES
(1, 'CORSAIR', 'contact@corsair.com', 'CORSAIR', 'CASE001'),
(2, 'Cooler Master', 'contact@coolermaster.com', 'Cooler Master', 'CASE002'),
(3, 'ASUS', 'contact@asus.com', 'ASUS', 'CASE003'),
(4, 'CORSAIR', 'contact@corsair.com', 'CORSAIR', 'CASE004'),
(5, 'CORSAIR', 'contact@corsair.com', 'CORSAIR', 'COL001'),
(6, 'CORSAIR', 'contact@corsair.com', 'CORSAIR', 'COL002'),
(7, 'Corsair', 'contact@corsair.com', 'Corsair', 'COL003'),
(8, 'MSI', 'contact@msi.com', 'MSI', 'COL004'),
(9, 'Sony', 'contact@sony.com', 'Sony', 'CONSL001'),
(10, 'Sony', 'contact@sony.com', 'Sony', 'CONSL002'),
(11, 'Microsoft', 'contact@microsoft.com', 'Microsoft', 'CONSL003'),
(12, 'Microsoft', 'contact@microsoft.com', 'Microsoft', 'CONSL004'),
(13, 'Valve', 'contact@valve.com', 'Valve', 'CONSL005'),
(14, 'Nintendo', 'contact@nintendo.com', 'Nintendo', 'CONSL006'),
(15, 'ASUS', 'contact@asus.com', 'ASUS', 'CONSL007'),
(16, 'Sony', 'contact@sony.com', 'Sony', 'CONSL008'),
(17, 'AMD', 'contact@amd.com', 'AMD', 'CPU001'),
(18, 'AMD', 'contact@amd.com', 'AMD', 'CPU002'),
(19, 'Intel', 'contact@intel.com', 'Intel', 'CPU003'),
(20, 'Intel', 'contact@intel.com', 'Intel', 'CPU004'),
(21, 'SAMSUNG', 'contact@samsung.com', 'SAMSUNG', 'GACC001'),
(22, 'Thrustmaster', 'contact@thrustmaster.com', 'Thrustmaster', 'GACC002'),
(23, 'SONY', 'contact@sony.com', 'SONY', 'GACC003'),
(24, 'RAZER', 'contact@razer.com', 'RAZER', 'GACC004'),
(25, 'SteelSeries', 'contact@steelseries.com', 'SteelSeries', 'GACC005'),
(26, 'RAZER', 'contact@razer.com', 'RAZER', 'GACC006'),
(27, 'RAZER', 'contact@razer.com', 'RAZER', 'GACC007'),
(28, 'RAZER', 'contact@razer.com', 'RAZER', 'GACC008'),
(29, 'Rockstar Games', 'contact@rockstargames.com', 'Rockstar Games', 'GAME001'),
(30, 'Playground Games', 'contact@playgroundgames.com', 'Playground Games', 'GAME002'),
(31, 'Microsoft', 'contact@microsoft.com', 'Microsoft', 'GAME003'),
(32, 'Activision', 'contact@activision.com', 'Activision', 'GAME004'),
(33, 'Rockstar Games', 'contact@rockstargames.com', 'Rockstar Games', 'GAME005'),
(34, 'CD Projekt Red', 'contact@cdprojektred.com', 'CD Projekt Red', 'GAME006'),
(35, '343 Industries', 'contact@343industries.com', '343 Industries', 'GAME007'),
(36, 'FromSoftware', 'contact@fromsoftware.com', 'FromSoftware', 'GAME008'),
(37, 'NVIDIA', 'contact@nvidia.com', 'NVIDIA', 'GPU001'),
(38, 'ASUS', 'contact@asus.com', 'ASUS', 'GPU002'),
(39, 'ASUS', 'contact@asus.com', 'ASUS', 'GPU003'),
(40, 'ASUS', 'contact@asus.com', 'ASUS', 'GPU004'),
(41, 'ASUS', 'contact@asus.com', 'ASUS', 'MBD001'),
(42, 'ASUS', 'contact@asus.com', 'ASUS', 'MBD002'),
(43, 'GIGABYTE', 'contact@gigabyte.com', 'GIGABYTE', 'MBD003'),
(44, 'MSI', 'contact@msi.com', 'MSI', 'MBD004'),
(45, 'CORSAIR', 'contact@corsair.com', 'CORSAIR', 'MEM001'),
(46, 'CORSAIR', 'contact@corsair.com', 'CORSAIR', 'MEM002'),
(47, 'CORSAIR', 'contact@corsair.com', 'CORSAIR', 'MEM003'),
(48, 'CORSAIR', 'contact@corsair.com', 'CORSAIR', 'MEM004'),
(49, 'NVIDIA', 'contact@nvidia.com', 'NVIDIA', 'PCOMP001'),
(50, 'AMD', 'contact@amd.com', 'AMD', 'PCOMP002'),
(51, 'Corsair', 'contact@corsair.com', 'Corsair', 'PCOMP003'),
(52, 'Intel', 'contact@intel.com', 'Intel', 'PCOMP004'),
(53, 'ASUS', 'contact@asus.com', 'ASUS', 'PCOMP005'),
(54, 'NZXT', 'contact@nzxt.com', 'NZXT', 'PCOMP006'),
(55, 'Cooler Master', 'contact@coolermaster.com', 'Cooler Master', 'PCOMP007'),
(56, 'Crucial', 'contact@crucial.com', 'Crucial', 'PCOMP008'),
(57, 'Samsung', 'contact@samsung.com', 'Samsung', 'PCOMP009'),
(58, 'MSI', 'contact@msi.com', 'MSI', 'PCOMP010'),
(59, 'EVGA', 'contact@evga.com', 'EVGA', 'PCOMP011'),
(60, 'G.Skill', 'contact@gskill.com', 'G.Skill', 'PCOMP012'),
(61, 'Corsair', 'contact@corsair.com', 'Corsair', 'PCOMP013'),
(62, 'AMD', 'contact@amd.com', 'AMD', 'PCOMP014'),
(63, 'Corsair', 'contact@corsair.com', 'Corsair', 'PSU001'),
(64, 'ASUS', 'contact@asus.com', 'ASUS', 'PSU002'),
(65, 'ASUS', 'contact@asus.com', 'ASUS', 'PSU003'),
(66, 'ASUS', 'contact@asus.com', 'ASUS', 'PSU004'),
(67, 'SABRENT', 'contact@sabrent.com', 'SABRENT', 'SSD001'),
(68, 'SAMSUNG', 'contact@samsung.com', 'SAMSUNG', 'SSD002'),
(69, 'Corsair', 'contact@corsair.com', 'Corsair', 'SSD003'),
(70, 'MSI', 'contact@msi.com', 'MSI', 'SSD004');

-- --------------------------------------------------------

--
-- Structure for view `cartdetails`
--
DROP TABLE IF EXISTS `cartdetails`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `cartdetails`  AS SELECT `p`.`PRODUCT_NAME` AS `PRODUCT_NAME`, `c`.`QUANTITY` AS `QUANTITY`, `p`.`PRICE` AS `PRICE`, `p`.`VAT` AS `VAT`, round(`c`.`QUANTITY` * `p`.`PRICE`,3) AS `TOTAL_PRICE`, round(`c`.`QUANTITY` * `p`.`PRICE` * `p`.`VAT` / 100,3) AS `VAT_AMOUNT`, `c`.`C_USERNAME` AS `C_USERNAME` FROM (`cart` `c` join `products` `p`) WHERE `c`.`PRODUCT_ID` = `p`.`PRODUCT_ID` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`serial`),
  ADD KEY `C_USERNAME` (`C_USERNAME`),
  ADD KEY `PRODUCT_ID` (`PRODUCT_ID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`C_USERNAME`);

--
-- Indexes for table `discounts`
--
ALTER TABLE `discounts`
  ADD PRIMARY KEY (`discount_code`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`empID`),
  ADD UNIQUE KEY `empEmail` (`empEmail`),
  ADD UNIQUE KEY `empPhone` (`empPhone`);

--
-- Indexes for table `orderlist`
--
ALTER TABLE `orderlist`
  ADD PRIMARY KEY (`orderID`),
  ADD KEY `paymentID` (`paymentID`),
  ADD KEY `C_USERNAME` (`C_USERNAME`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`paymentID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`PRODUCT_ID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supplierid`),
  ADD KEY `productId` (`productId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `serial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=237;

--
-- AUTO_INCREMENT for table `orderlist`
--
ALTER TABLE `orderlist`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `paymentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `supplierid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`C_USERNAME`) REFERENCES `customer` (`C_USERNAME`),
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `products` (`PRODUCT_ID`);

--
-- Constraints for table `orderlist`
--
ALTER TABLE `orderlist`
  ADD CONSTRAINT `orderlist_ibfk_1` FOREIGN KEY (`paymentID`) REFERENCES `payment` (`paymentID`),
  ADD CONSTRAINT `orderlist_ibfk_2` FOREIGN KEY (`C_USERNAME`) REFERENCES `customer` (`C_USERNAME`);

--
-- Constraints for table `supplier`
--
ALTER TABLE `supplier`
  ADD CONSTRAINT `supplier_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `products` (`PRODUCT_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
