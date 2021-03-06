USE [master]
GO
/****** Object:  Database [PDV]    Script Date: 08/06/2017 16:47:28 ******/
CREATE DATABASE [PDV]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PDV', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\PDV.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PDV_log', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\PDV_log.ldf' , SIZE = 1072KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PDV] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PDV].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PDV] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PDV] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PDV] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PDV] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PDV] SET ARITHABORT OFF 
GO
ALTER DATABASE [PDV] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [PDV] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PDV] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PDV] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PDV] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PDV] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PDV] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PDV] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PDV] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PDV] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PDV] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PDV] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PDV] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PDV] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PDV] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PDV] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PDV] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PDV] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PDV] SET  MULTI_USER 
GO
ALTER DATABASE [PDV] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PDV] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PDV] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PDV] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [PDV] SET DELAYED_DURABILITY = DISABLED 
GO
USE [PDV]
GO
/****** Object:  User [ecordero]    Script Date: 08/06/2017 16:47:28 ******/
CREATE USER [ecordero] FOR LOGIN [ecordero] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[TAccount]    Script Date: 08/06/2017 16:47:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TAccount](
	[userName] [char](9) NOT NULL,
	[clave] [varchar](15) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TClientes]    Script Date: 08/06/2017 16:47:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TClientes](
	[CodigoCliente] [int] IDENTITY(1,1) NOT NULL,
	[Cedula] [char](9) NOT NULL,
	[NombreCliente] [varchar](250) NOT NULL,
	[Alias] [varchar](250) NULL,
	[Telefono1] [char](8) NOT NULL,
	[Telefono2] [char](8) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Direccion] [varchar](255) NOT NULL,
	[ReferidoPor] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CodigoCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TCompras]    Script Date: 08/06/2017 16:47:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TCompras](
	[IdCompra] [int] NOT NULL,
	[CodigoProducto] [char](15) NOT NULL,
	[NombreProducto] [varchar](255) NOT NULL,
	[CantidadActual] [int] NOT NULL,
	[AgregarCantidad] [int] NOT NULL,
	[CantidadTotal] [int] NOT NULL,
	[PrecioCompra] [char](15) NULL,
	[PrecioVenta] [char](15) NULL,
	[SubTotal] [char](15) NULL,
	[Total] [char](15) NULL,
	[Proveedor] [varchar](255) NOT NULL,
	[FechaCompra] [date] NULL,
	[TipoCompra] [varchar](15) NULL,
	[numfactura] [varchar](10) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TInventario]    Script Date: 08/06/2017 16:47:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TInventario](
	[IdArticulo] [char](15) NOT NULL,
	[NombreArticulo] [varchar](255) NOT NULL,
	[Unidad] [varchar](30) NOT NULL,
	[Cantidad] [int] NOT NULL,
	[PrecioCompra] [char](15) NULL,
	[PrecioVenta] [char](15) NULL,
	[CantidadReserva] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdArticulo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TPagos]    Script Date: 08/06/2017 16:47:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TPagos](
	[CodPago] [int] NOT NULL,
	[IdCliente] [int] NOT NULL,
	[Cedula] [char](9) NOT NULL,
	[NombreCliente] [varchar](200) NOT NULL,
	[FechaUltPago] [date] NOT NULL,
	[Total] [char](15) NULL,
	[Abono] [char](15) NULL,
	[Saldo] [char](15) NULL,
	[numFactura] [int] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TProveedor]    Script Date: 08/06/2017 16:47:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TProveedor](
	[CodigoProveedor] [int] IDENTITY(1,1) NOT NULL,
	[NombreProveedor] [varchar](255) NOT NULL,
	[Empresa] [varchar](255) NOT NULL,
	[Telefono1] [char](8) NOT NULL,
	[Telefono2] [char](8) NULL,
	[Email] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CodigoProveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TUsuarios]    Script Date: 08/06/2017 16:47:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TUsuarios](
	[id] [char](9) NOT NULL,
	[nombre] [varchar](30) NOT NULL,
	[apellidos] [varchar](50) NOT NULL,
	[telefono] [char](8) NOT NULL,
	[rol] [varchar](15) NOT NULL,
	[direccion] [varchar](250) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[fechaNacimiento] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TVentas]    Script Date: 08/06/2017 16:47:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TVentas](
	[IdVenta] [int] NOT NULL,
	[CodigoProducto] [varchar](15) NOT NULL,
	[NombreProducto] [varchar](200) NOT NULL,
	[PrecioVenta] [char](15) NULL,
	[Cantidad] [int] NOT NULL,
	[SubTotal] [char](15) NULL,
	[Total] [char](15) NULL,
	[NombreCliente] [varchar](200) NOT NULL,
	[FechaVenta] [date] NOT NULL,
	[TipoVenta] [varchar](20) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
USE [master]
GO
ALTER DATABASE [PDV] SET  READ_WRITE 
GO
