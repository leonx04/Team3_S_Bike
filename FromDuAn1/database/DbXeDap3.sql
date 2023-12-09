--CREATE DATABASE [DbXeDap3]
--GO
USE [DbXeDap3]
GO
/****** Object:  Table [dbo].[BanhXe]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BanhXe](
	[IDBanhXe] [int] IDENTITY(1,1) NOT NULL,
	[MaBX] [nchar](10) NULL,
	[TenBX] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
 CONSTRAINT [PK_BanhXe] PRIMARY KEY CLUSTERED 
(
	[IDBanhXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham](
	[IDCTSP] [int] IDENTITY(1,1) NOT NULL,
	[MaCTSP] [nchar](10) NULL,
	[HinhAnh] [nvarchar](max) NULL,
	[SoLuong] [int] NULL,
	[GiaTien] [decimal](18, 0) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[IDThuongHieu] [int] NULL,
	[IDMauSac] [int] NULL,
	[IDGhiDong] [int] NULL,
	[IDHeThongTruyenDong] [int] NULL,
	[IDKhungXe] [int] NULL,
	[IDLopXe] [int] NULL,
	[IDPhanhXe] [int] NULL,
	[IDBanhXe] [int] NULL,
	[IDSanPham] [int] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
 CONSTRAINT [PK_ChiTietSanPham] PRIMARY KEY CLUSTERED 
(
	[IDCTSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HeThongTruyenDong]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HeThongTruyenDong](
	[IDHeThongTruyenDong] [int] IDENTITY(1,1) NOT NULL,
	[MaHTTD] [nchar](10) NULL,
	[TenHTTD] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
 CONSTRAINT [PK_HeThongTruyenDong] PRIMARY KEY CLUSTERED 
(
	[IDHeThongTruyenDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhThucThanhToan]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhThucThanhToan](
	[IDHinhThucThanhToan] [int] IDENTITY(1,1) NOT NULL,
	[MaHTTT] [nchar](10) NULL,
	[TenHTTT] [nvarchar](max) NULL,
	[MoTa] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
 CONSTRAINT [PK_HinhThucThanhToan] PRIMARY KEY CLUSTERED 
(
	[IDHinhThucThanhToan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[IDHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[MaHD] [nchar](10) NULL,
	[TenNguoiNhan] [nvarchar](max) NULL,
	[DiaChiNhanHang] [nvarchar](max) NULL,
	[SDTNguoiNhanHang] [nchar](20) NULL,
	[NgayDatHang] [date] NULL,
	[NgayGuiHang] [date] NULL,
	[GhiChu] [nvarchar](max) NULL,
	[PhiVanChuyen] [decimal](18, 0) NULL,
	[TongTien] [decimal](18, 0) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](50) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
	[IDKhachHang] [int] NULL,
	[IDNhanVien] [int] NULL,
	[IDHinhThucThanhToan] [int] NULL,
	[IDKhuyenMai] [int] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[IDHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[IDHoaDonChiTiet] [int] IDENTITY(1,1) NOT NULL,
	[MaHDCT] [nchar](10) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [decimal](18, 0) NULL,
	[ThanhTien] [decimal](18, 0) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
	[IDHoaDon] [int] NULL,
	[IDCTSP] [int] NULL,
 CONSTRAINT [PK_HoaDonChiTiet] PRIMARY KEY CLUSTERED 
(
	[IDHoaDonChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[IDGhiDong]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GhiDong](
	[IDGhiDong] [int] IDENTITY(1,1) NOT NULL,
	[MaGD] [nchar](10) NULL,
	[TenGD] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
 CONSTRAINT [PK_IDGhiDong] PRIMARY KEY CLUSTERED 
(
	[IDGhiDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[IDKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[MaKH] [nchar](10) NULL,
	[TenKH] [nvarchar](max) NULL,
	[SDT] [nchar](20) NULL,
	[Email] [nvarchar](max) NULL,
	[DiaChi] [nvarchar](max) NULL,
	[NgaySinh] [date] NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[IDKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhungXe]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhungXe](
	[IDKhungXe] [int] IDENTITY(1,1) NOT NULL,
	[MaKX] [nchar](10) NULL,
	[TenKX] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
 CONSTRAINT [PK_KhungXe] PRIMARY KEY CLUSTERED 
(
	[IDKhungXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[IDKhuyenMai] [int] IDENTITY(1,1) NOT NULL,
	[MaKM] [nchar](10) NULL,
	[TenKM] [nvarchar](max) NULL,
	[SoLuong] [int] NULL,
	[HinhThuc] [nvarchar](max) NULL,
	[MucGiamGia] [int] NULL,
	[ThoiGianBatDau] [date] NULL,
	[ThoiGianKetThuc] [date] NULL,
	[MoTa] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
 CONSTRAINT [PK_KhuyenMai] PRIMARY KEY CLUSTERED 
(
	[IDKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichSuGiaoDich]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LichSuGiaoDich](
	[IDLichSuGiaoDich] [int] IDENTITY(1,1) NOT NULL,
	[MaLSGD] [nchar](10) NULL,
	[MoTa] [nvarchar](max) NULL,
	[HanhDong] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [datetime] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [datetime] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
	[IDHoaDon] [int] NULL,
 CONSTRAINT [PK_LichSuGiaoDich] PRIMARY KEY CLUSTERED 
(
	[IDLichSuGiaoDich] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[IDMauSac] [int] IDENTITY(1,1) NOT NULL,
	[MaMS] [nchar](10) NULL,
	[TenMS] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
 CONSTRAINT [PK_MauSac] PRIMARY KEY CLUSTERED 
(
	[IDMauSac] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[IDNhanVien] [int] IDENTITY(1,1) NOT NULL,
	[MaNV] [nchar](10) NULL,
	[TenNV] [nvarchar](max) NULL,
	[SoDienThoai] [nchar](20) NULL,
	[SoCCCD] [nchar](20) NULL,
	[Email] [nvarchar](max) NULL,
	[MatKhau] [nchar](20) NULL,
	[NgaySinh] [date] NULL,
	[GioiTinh] [nvarchar](50) NULL,
	[ChucVu] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[IDNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhanhXe]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanhXe](
	[IDPhanhXe] [int] IDENTITY(1,1) NOT NULL,
	[MaPX] [nchar](10) NULL,
	[TenPX] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
 CONSTRAINT [PK_PhanhXe] PRIMARY KEY CLUSTERED 
(
	[IDPhanhXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[IDSanPham] [int] IDENTITY(1,1) NOT NULL,
	[MaSP] [nchar](10) NULL,
	[TenSP] [nvarchar](max) NULL,
	[MaHex] [nchar](10) NULL,
	[Model] [nvarchar](max) NULL,
	[SoLuong] [int] NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted] [nvarchar](max) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[IDSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 11/22/2023 1:01:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThuongHieu](
	[IDThuongHieu] [int] IDENTITY(1,1) NOT NULL,
	[MaTH] [nchar](10) NULL,
	[TenTH] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
 CONSTRAINT [PK_ThuongHieu] PRIMARY KEY CLUSTERED 
(
	[IDThuongHieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
CREATE TABLE [dbo].[LopXe](
	[IDLopXe] [int] IDENTITY(1,1) NOT NULL,
	[MaLX] [nchar](10) NULL,
	[TenLX] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](max) NULL,
	[Create_at] [date] NULL,
	[Create_by] [nvarchar](max) NULL,
	[Update_at] [date] NULL,
	[Update_by] [nvarchar](max) NULL,
	[Deleted_by] [nvarchar](max) NULL,
 CONSTRAINT [PK_LopXe] PRIMARY KEY CLUSTERED 
(
	[IDLopXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

ALTER TABLE [dbo].[LopXe] ADD CONSTRAINT [DF_LopXe_Create_at] DEFAULT (getdate()) FOR [Create_at]
GO

ALTER TABLE [dbo].[LopXe] ADD CONSTRAINT [DF_LopXe_Update_at] DEFAULT (getdate()) FOR [Update_at]  
GO
   
ALTER TABLE [dbo].[ChiTietSanPham] WITH CHECK ADD CONSTRAINT [FK_ChiTietSanPham_LopXe] FOREIGN KEY([IDLopXe])
REFERENCES [dbo].[LopXe] ([IDLopXe])
GO

ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_LopXe]
GO

ALTER TABLE [dbo].[BanhXe] ADD  CONSTRAINT [DF_BanhXe_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[BanhXe] ADD  CONSTRAINT [DF_BanhXe_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  CONSTRAINT [DF_ChiTietSanPham_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  CONSTRAINT [DF_ChiTietSanPham_Create_at_1]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[HeThongTruyenDong] ADD  CONSTRAINT [DF_HeThongTruyenDong_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[HeThongTruyenDong] ADD  CONSTRAINT [DF_HeThongTruyenDong_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[HinhThucThanhToan] ADD  CONSTRAINT [DF_HinhThucThanhToan_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[HinhThucThanhToan] ADD  CONSTRAINT [DF_HinhThucThanhToan_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [DF_HoaDon_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [DF_HoaDon_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  CONSTRAINT [DF_HoaDonChiTiet_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  CONSTRAINT [DF_HoaDonChiTiet_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[GhiDong] ADD  CONSTRAINT [DF_GhiDong_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[GhiDong] ADD  CONSTRAINT [DF_GhiDong_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[KhachHang] ADD  CONSTRAINT [DF_KhachHang_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[KhachHang] ADD  CONSTRAINT [DF_KhachHang_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[KhungXe] ADD  CONSTRAINT [DF_KhungXe_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[KhungXe] ADD  CONSTRAINT [DF_KhungXe_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  CONSTRAINT [DF_KhuyenMai_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  CONSTRAINT [DF_KhuyenMai_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[MauSac] ADD  CONSTRAINT [DF_MauSac_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[MauSac] ADD  CONSTRAINT [DF_MauSac_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [DF_NhanVien_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [DF_NhanVien_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[PhanhXe] ADD  CONSTRAINT [DF_PhanhXe_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[PhanhXe] ADD  CONSTRAINT [DF_PhanhXe_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[ThuongHieu] ADD  CONSTRAINT [DF_ThuongHieu_Create_at]  DEFAULT (getdate()) FOR [Create_at]
GO
ALTER TABLE [dbo].[ThuongHieu] ADD  CONSTRAINT [DF_ThuongHieu_Update_at]  DEFAULT (getdate()) FOR [Update_at]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_BanhXe] FOREIGN KEY([IDBanhXe])
REFERENCES [dbo].[BanhXe] ([IDBanhXe])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_BanhXe]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_HeThongTruyenDong] FOREIGN KEY([IDHeThongTruyenDong])
REFERENCES [dbo].[HeThongTruyenDong] ([IDHeThongTruyenDong])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_HeThongTruyenDong]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_GhiDong] FOREIGN KEY([IDGhiDong])
REFERENCES [dbo].[GhiDong] ([IDGhiDong])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_GhiDong]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_KhungXe] FOREIGN KEY([IDKhungXe])
REFERENCES [dbo].[KhungXe] ([IDKhungXe])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_KhungXe]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_MauSac] FOREIGN KEY([IDMauSac])
REFERENCES [dbo].[MauSac] ([IDMauSac])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_MauSac]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_PhanhXe] FOREIGN KEY([IDPhanhXe])
REFERENCES [dbo].[PhanhXe] ([IDPhanhXe])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_PhanhXe]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_SanPham] FOREIGN KEY([IDSanPham])
REFERENCES [dbo].[SanPham] ([IDSanPham])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_SanPham]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_ThuongHieu] FOREIGN KEY([IDThuongHieu])
REFERENCES [dbo].[ThuongHieu] ([IDThuongHieu])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_ThuongHieu]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_HinhThucThanhToan] FOREIGN KEY([IDHinhThucThanhToan])
REFERENCES [dbo].[HinhThucThanhToan] ([IDHinhThucThanhToan])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_HinhThucThanhToan]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([IDKhachHang])
REFERENCES [dbo].[KhachHang] ([IDKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhuyenMai] FOREIGN KEY([IDKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([IDKhuyenMai])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhuyenMai]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([IDNhanVien])
REFERENCES [dbo].[NhanVien] ([IDNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_ChiTietSanPham] FOREIGN KEY([IDCTSP])
REFERENCES [dbo].[ChiTietSanPham] ([IDCTSP])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_ChiTietSanPham]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_HoaDon] FOREIGN KEY([IDHoaDon])
REFERENCES [dbo].[HoaDon] ([IDHoaDon])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[LichSuGiaoDich]  WITH CHECK ADD  CONSTRAINT [FK_LichSuGiaoDich_HoaDon] FOREIGN KEY([IDHoaDon])
REFERENCES [dbo].[HoaDon] ([IDHoaDon])
GO
ALTER TABLE [dbo].[LichSuGiaoDich] CHECK CONSTRAINT [FK_LichSuGiaoDich_HoaDon]
GO
