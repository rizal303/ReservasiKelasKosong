-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2016 at 03:59 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_finalpbo2`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_detail_ruang`
--

CREATE TABLE IF NOT EXISTS `tb_detail_ruang` (
  `id_dt_ruang` char(10) NOT NULL,
  `kode_ruang` varchar(10) NOT NULL,
  `jam` char(6) NOT NULL,
  `hari` char(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_detail_ruang`
--

INSERT INTO `tb_detail_ruang` (`id_dt_ruang`, `kode_ruang`, `jam`, `hari`) VALUES
('DR0001', '4.2.1', '2', 'Senin'),
('DR0002', '4.2.1', '1', 'Senin'),
('DR0003', '4.2.1', '3', 'Senin'),
('DR0004', '4.2.1', '4', 'Senin'),
('DR0005', '4.2.1', '5', 'Senin'),
('DR0006', '4.2.1', '1', 'Selasa'),
('DR0007', '4.2.1', '2', 'Selasa'),
('DR0008', '4.2.1', '3', 'Selasa'),
('DR0009', '4.2.1', '4', 'Selasa'),
('DR10', '4.2.1', '5', 'Selasa'),
('DR11', '4.2.1', '1', 'Rabu'),
('DR12', '4.2.1', '2', 'Rabu'),
('DR13', '4.2.1', '3', 'Rabu');

-- --------------------------------------------------------

--
-- Table structure for table `tb_dosen`
--

CREATE TABLE IF NOT EXISTS `tb_dosen` (
  `nik` varchar(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `tgl_lahir` date NOT NULL,
  `jkel` char(11) NOT NULL,
  `telp` char(12) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_dosen`
--

INSERT INTO `tb_dosen` (`nik`, `nama`, `alamat`, `tgl_lahir`, `jkel`, `telp`, `email`) VALUES
('DS0001', 'Steven William', 'Yogyakarta', '2016-05-05', 'Wanita', '080796574567', 'StevenW@gmail.com'),
('DS0002', 'Yuli Astuti', 'condong catur', '1980-06-09', 'Wanita', '098789876476', 'yuli@gmail.com'),
('DS0003', 'Heri Sismoro', 'Kalasan Yogyakarta', '1980-06-09', 'Pria', '098789876476', 'heri123@gmail.com'),
('DS0005', 'Alfie Nur Rahmi', 'sleman', '1992-06-09', 'Wanita', '098789876476', 'alfie23@gmail.com'),
('DS0006', 'Tristanto Aji Saputra', 'Bantul', '1980-06-12', 'Pria', '098776548947', 'aji23@gmail.com'),
('DS0007', 'I Ketut Handayani', 'Bali', '1966-09-15', 'Wanita', '08629374859', 'Ketut@gmail.com'),
('DS0008', 'Achmad Fauzi', 'Jl.Condong Catur ', '1966-09-15', 'Pria', '08629374859', 'Fauzi@gmail.com'),
('DS10', 'Bety Wulan Sari', 'imogiri', '1989-06-08', 'Wanita', '086989481324', 'bety@gmail.com'),
('DS11', 'Jaeni ', 'sleman', '1980-06-09', 'Pria', '098789876476', 'jaeni23@gmail.com'),
('DS12', 'Audith Setiadi', 'Yogyakarta', '1970-06-09', 'Pria', '082937485973', 'Audith@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `tb_dt_matkul`
--

CREATE TABLE IF NOT EXISTS `tb_dt_matkul` (
  `kode_detail` varchar(11) NOT NULL,
  `nik` varchar(11) NOT NULL,
  `kode_matkul` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_dt_matkul`
--

INSERT INTO `tb_dt_matkul` (`kode_detail`, `nik`, `kode_matkul`) VALUES
('DT0001', 'DS0002', 'JD0007'),
('DT0002', 'DS0007', 'JD10');

-- --------------------------------------------------------

--
-- Table structure for table `tb_jadwal`
--

CREATE TABLE IF NOT EXISTS `tb_jadwal` (
  `kode_jadwal` varchar(11) NOT NULL,
  `kode_detail` varchar(11) NOT NULL,
  `id_dt_ruang` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_jadwal`
--

INSERT INTO `tb_jadwal` (`kode_jadwal`, `kode_detail`, `id_dt_ruang`) VALUES
('JD0001', 'DT0001', 'DR0001'),
('JD0002', 'DT0004', 'DR0005'),
('JD0003', 'DT0002', 'DR0004');

-- --------------------------------------------------------

--
-- Table structure for table `tb_jam`
--

CREATE TABLE IF NOT EXISTS `tb_jam` (
  `jam` char(6) NOT NULL,
  `waktu_mulai` char(5) NOT NULL,
  `waktu_selesai` char(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_jam`
--

INSERT INTO `tb_jam` (`jam`, `waktu_mulai`, `waktu_selesai`) VALUES
('1', '07:00', '08:40'),
('2', '08:50', '10:30'),
('3', '10:40', '12:20'),
('4', '12:30', '14:10'),
('5', '14:20', '16:00');

-- --------------------------------------------------------

--
-- Table structure for table `tb_matkul`
--

CREATE TABLE IF NOT EXISTS `tb_matkul` (
  `id_matkul` varchar(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `semester` char(6) NOT NULL,
  `sks` char(4) NOT NULL,
  `jenis` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_matkul`
--

INSERT INTO `tb_matkul` (`id_matkul`, `nama`, `semester`, `sks`, `jenis`) VALUES
('JD0001', 'Pemrograman Berbasis Obyek', 'Genap', '4', 'Wajib'),
('JD0002', 'Pemrograman Basis Data', 'Genap', '4', 'Wajib'),
('JD0003', 'Analisis Perancangan Informasi', 'Genap', '4', 'Wajib'),
('JD0004', 'Kewirausahaan', 'Genap', '2', 'Wajib'),
('JD0005', 'Agama', 'Ganjil', '2', 'Tidak Wajib'),
('JD0006', 'Jaringan Komputer', 'Genap', '4', 'Wajib'),
('JD0007', 'Bahasa Inggris 4', 'Genap', '4', 'Tidak Wajib'),
('JD0008', 'E-commerce', 'Genap', '4', 'Wajib'),
('JD0009', 'Bahasa Indonesia', 'Ganjil', '2', 'Wajib'),
('JD10', 'Akuntansi ', 'Ganjil', '4', 'Wajib'),
('JD12', 'multimedia', 'Genap', '4', 'Wajib'),
('JD13', 'Sistem Informasi Akuntansi', 'Genap', '4', 'Wajib'),
('JD14', 'Jaringan Komputer 2', 'Ganjil', '4', 'Wajib'),
('JD15', 'Bahasa Inggris 1', 'Ganjil', '4', 'Wajib'),
('JD16', 'Bahasa Inggris 2', 'Genap', '4', 'Wajib'),
('JD17', 'Bahasa Inggris 3', 'Ganjil', '4', 'Wajib'),
('JD18', 'Pemrograman Web Lanjut', 'Ganjil', '4', 'Wajib'),
('JD19', 'Manajemen Bisnis', 'Ganjil', '2', 'Wajib'),
('JD20', 'Animasi 3D', 'Genap', '4', 'Wajib');

-- --------------------------------------------------------

--
-- Table structure for table `tb_permintaan`
--

CREATE TABLE IF NOT EXISTS `tb_permintaan` (
  `hari` varchar(6) NOT NULL,
  `jam` char(6) NOT NULL,
  `tgl` date NOT NULL,
  `ruang` varchar(11) NOT NULL,
  `nik` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_ruang`
--

CREATE TABLE IF NOT EXISTS `tb_ruang` (
  `id_ruang` varchar(10) NOT NULL,
  `gedung` char(4) NOT NULL,
  `lantai` char(4) NOT NULL,
  `nomer` char(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_ruang`
--

INSERT INTO `tb_ruang` (`id_ruang`, `gedung`, `lantai`, `nomer`) VALUES
('4.2.1', '4', '2', '1'),
('4.2.2', '4', '2', '2'),
('4.2.3', '4', '2', '3'),
('4.2.4', '4', '2', '4'),
('4.2.5', '4', '2', '5'),
('4.2.6', '4', '2', '6'),
('4.3.1', '4', '3', '1'),
('4.3.2', '4', '3', '2'),
('4.3.3', '4', '3', '3'),
('4.3.4', '4', '3', '4'),
('4.3.5', '4', '3', '5'),
('4.3.6', '4', '3', '6'),
('5.2.1', '5', '2', '1'),
('5.2.2', '5', '2', '2'),
('5.2.3', '5', '2', '3'),
('5.2.4', '5', '2', '4'),
('5.2.5', '5', '2', '5'),
('5.2.6', '5', '2', '6'),
('5.3.1', '5', '3', '1'),
('5.3.2', '5', '3', '2'),
('5.3.3', '5', '3', '3'),
('5.3.4', '5', '3', '4'),
('5.3.5', '5', '3', '5'),
('5.3.6', '5', '3', '6'),
('6.2.1', '6', '2', '1'),
('6.2.2', '6', '2', '2'),
('6.2.3', '6', '2', '3'),
('6.2.4', '6', '2', '4'),
('6.2.5', '6', '2', '5'),
('6.3.1', '6', '3', '1');

-- --------------------------------------------------------

--
-- Table structure for table `tb_staff`
--

CREATE TABLE IF NOT EXISTS `tb_staff` (
  `id_admin` char(4) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `username` varchar(10) NOT NULL,
  `pass` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_staff`
--

INSERT INTO `tb_staff` (`id_admin`, `nama`, `username`, `pass`) VALUES
('8687', 'Heri Irawan', 'Heri', '8687'),
('8697', 'Reza Pratama', 'Reza', '8697'),
('8715', 'Ikhwan Candra Nugraha', 'Ikhwan', '8715');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_detail_ruang`
--
ALTER TABLE `tb_detail_ruang`
  ADD PRIMARY KEY (`id_dt_ruang`);

--
-- Indexes for table `tb_dosen`
--
ALTER TABLE `tb_dosen`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `tb_dt_matkul`
--
ALTER TABLE `tb_dt_matkul`
  ADD PRIMARY KEY (`kode_detail`);

--
-- Indexes for table `tb_jadwal`
--
ALTER TABLE `tb_jadwal`
  ADD PRIMARY KEY (`kode_jadwal`);

--
-- Indexes for table `tb_jam`
--
ALTER TABLE `tb_jam`
  ADD PRIMARY KEY (`jam`);

--
-- Indexes for table `tb_matkul`
--
ALTER TABLE `tb_matkul`
  ADD PRIMARY KEY (`id_matkul`);

--
-- Indexes for table `tb_permintaan`
--
ALTER TABLE `tb_permintaan`
  ADD KEY `fk_permintaan` (`nik`);

--
-- Indexes for table `tb_ruang`
--
ALTER TABLE `tb_ruang`
  ADD PRIMARY KEY (`id_ruang`);

--
-- Indexes for table `tb_staff`
--
ALTER TABLE `tb_staff`
  ADD PRIMARY KEY (`id_admin`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
