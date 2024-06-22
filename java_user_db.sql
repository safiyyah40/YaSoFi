-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2024 at 05:12 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_user_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `datadokter`
--

CREATE TABLE `datadokter` (
  `id` int(11) NOT NULL,
  `iddokter` varchar(100) NOT NULL,
  `namadokter` varchar(100) NOT NULL,
  `specialis` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datadokter`
--

INSERT INTO `datadokter` (`id`, `iddokter`, `namadokter`, `specialis`) VALUES
(11, 'DOC-001', 'dr. Andi, Sp.P', 'Saluran Pernafasan');

-- --------------------------------------------------------

--
-- Table structure for table `datapasien`
--

CREATE TABLE `datapasien` (
  `id` int(29) NOT NULL,
  `nopasien` varchar(20) NOT NULL,
  `namapasien` varchar(50) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datapasien`
--

INSERT INTO `datapasien` (`id`, `nopasien`, `namapasien`, `tanggal_lahir`, `alamat`) VALUES
(125, 'PAS-001', 'Rudi Junaidi', '2005-06-02', 'Cempaka Mas');

-- --------------------------------------------------------

--
-- Table structure for table `dataperiksa`
--

CREATE TABLE `dataperiksa` (
  `id` int(20) NOT NULL,
  `idperiksa` varchar(20) NOT NULL,
  `nopasien` varchar(30) NOT NULL,
  `tgl` date NOT NULL,
  `diagnosa` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dataperiksa`
--

INSERT INTO `dataperiksa` (`id`, `idperiksa`, `nopasien`, `tgl`, `diagnosa`) VALUES
(62, 'PRS-001', 'PAS-001', '2024-06-22', 'Sesak Napas');

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `id` int(20) NOT NULL,
  `kodeobat` varchar(20) NOT NULL,
  `namaobat` varchar(30) NOT NULL,
  `harga` int(100) NOT NULL,
  `stok` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`id`, `kodeobat`, `namaobat`, `harga`, `stok`) VALUES
(1, 'THT-001', 'Feromen 10ml', 50000, 10),
(2, 'THT-002', 'Benadryl Original 50ml', 27000, 15),
(3, 'THT-003', 'Betadine Lozenges Menthol', 19000, 21),
(4, 'SLP-001', 'Procold', 4000, 12),
(5, 'SLP-002', 'Acetaminophen', 52000, 19),
(6, 'SLP-003', 'Symbicort Turbuhaler', 42000, 19),
(7, 'SLN-001', 'Buscopan Tablet', 22000, 25),
(8, 'SLN-002', 'Polysilane Suspensi', 30000, 15),
(9, 'SLN-003', 'Norit 125 mg', 20000, 20),
(10, 'PAK-001', 'Antihistamin', 27000, 20),
(11, 'PAK-002', 'Sanmol Tablet', 5000, 28),
(12, 'PAK-003', 'Domperidone', 150000, 30),
(13, 'PEK-001', 'Glucophage', 22000, 29),
(14, 'PEK-002', 'Amaryl Tablet', 20000, 6),
(15, 'PEK-003', 'Kombiglyze XR', 35000, 14),
(16, 'PMA-001', 'Terapi Fotodinamik', 1500000, 3),
(17, 'PMA-002', 'Vitamin Lutein', 500000, 20),
(18, 'PMA-003', 'Cendo Catarlent', 50000, 24);

-- --------------------------------------------------------

--
-- Table structure for table `resep_obat`
--

CREATE TABLE `resep_obat` (
  `idperiksa` varchar(50) NOT NULL,
  `kodeobat` varchar(50) NOT NULL,
  `namaobat` varchar(50) NOT NULL,
  `jumlahobat` int(50) NOT NULL,
  `hargaobat` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `resep_obat`
--

INSERT INTO `resep_obat` (`idperiksa`, `kodeobat`, `namaobat`, `jumlahobat`, `hargaobat`) VALUES
('PRS-001', 'SLP-003', 'Symbicort Turbuhaler', 2, 84000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `no_trans` varchar(100) NOT NULL,
  `idpasien` varchar(100) NOT NULL,
  `idperiksa` varchar(50) NOT NULL,
  `namapasien` varchar(50) NOT NULL,
  `namadokter` varchar(100) NOT NULL,
  `specialis` varchar(100) NOT NULL,
  `kodeobat` varchar(100) NOT NULL,
  `namaobat` varchar(100) NOT NULL,
  `jumlahobat` int(100) NOT NULL,
  `hargaobat` int(100) NOT NULL,
  `hargapemeriksaan` int(100) NOT NULL,
  `total` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id`, `no_trans`, `idpasien`, `idperiksa`, `namapasien`, `namadokter`, `specialis`, `kodeobat`, `namaobat`, `jumlahobat`, `hargaobat`, `hargapemeriksaan`, `total`) VALUES
(43, 'TRS-001', 'PAS-001', 'PRS-001', 'Rudi Junaidi', 'dr. Andi, Sp.P', 'Saluran Pernafasan', 'SLP-003', 'Symbicort Turbuhaler', 2, 84000, 300000, 384000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `nomor_telpon` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `username`, `nomor_telpon`, `alamat`, `password`) VALUES
(9, 'koko', '083928190321', 'beting', 'd1d7deed561e422c64137a9e498b8a58ba8e2033e921b33893619ff2482b883d'),
(10, 'bedil', '083902819031321', 'kalibaru', '28a2e710d1f4a6251f0ea2d391c0b2e39161f7cf84b4403ab7c3601a2a8c25fd'),
(11, 'arya', '08893289829423', 'Semper', '8d67bc63b89af142c490dbddaf44d04a5db11495'),
(12, 'Arya', '085693686253', 'Semper', '8d67bc63b89af142c490dbddaf44d04a5db11495'),
(13, 'yahdillah', '082111485562', 'Jl.Kalibaru Barat 7', '4b6ae3e1fa8aa3dc1165e319092a0485c9698a56');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datadokter`
--
ALTER TABLE `datadokter`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `datapasien`
--
ALTER TABLE `datapasien`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dataperiksa`
--
ALTER TABLE `dataperiksa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `datadokter`
--
ALTER TABLE `datadokter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `datapasien`
--
ALTER TABLE `datapasien`
  MODIFY `id` int(29) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=126;

--
-- AUTO_INCREMENT for table `dataperiksa`
--
ALTER TABLE `dataperiksa`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `obat`
--
ALTER TABLE `obat`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
