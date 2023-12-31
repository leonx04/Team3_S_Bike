USE [BanXeDap]
GO
/****** Object:  Table [dbo].[BanhXe]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BanhXe](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ChatLieu] [nvarchar](max) NULL,
	[KichThuoc] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_BanhXe] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaCTSP] [nchar](10) NULL,
	[Model] [nchar](10) NULL,
	[MauSac] [nvarchar](50) NULL,
	[GiaTien] [decimal](18, 0) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [int] NULL,
	[IDSanPham] [int] NULL,
	[IDKhungXe] [int] NULL,
	[IDBanhXe] [int] NULL,
	[IDYenXe] [int] NULL,
	[IDLopXe] [int] NULL,
	[IDPhuocGiamXoc] [int] NULL,
	[IDPhanhXe] [int] NULL,
	[IDHeThongTruyenDong] [int] NULL,
	[IDGhiDong] [int] NULL,
	[IDHinhAnhXe] [int] NULL,
	[IDThuongHieu] [int] NULL,
 CONSTRAINT [PK_ChiTietSanPham] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSanPham_KhuyenMai]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham_KhuyenMai](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaCTSP_KhuyenMai] [nchar](10) NULL,
	[GiaCu] [decimal](18, 0) NULL,
	[GiaMoi] [decimal](18, 0) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
	[IDKhuyenMai] [int] NOT NULL,
	[IDChiTietSanPham] [int] NULL,
 CONSTRAINT [PK_ChiTietSanPham_KhuyenMai] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GhiDong]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GhiDong](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[LoaiGhiDong] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_GhiDong] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HeThongTruyenDonh]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HeThongTruyenDonh](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[LoaiLip] [nvarchar](50) NULL,
	[SoLip] [nvarchar](50) NULL,
	[LoaiDia] [nvarchar](50) NULL,
	[SoLuongDia] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_HeThongTruyenDonh] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhAnhXe]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhAnhXe](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[HinhAnh] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[created_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_HinhAnhXe] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhThucThanhToan]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhThucThanhToan](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[TenHTTT] [nvarchar](max) NULL,
	[MoTa] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_HinhThucThanhToan] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaHD] [nchar](10) NULL,
	[TenNguoiNhan] [nvarchar](max) NULL,
	[DiaChiNhanHnag] [nvarchar](max) NULL,
	[SDTNguoiNhan] [nchar](15) NULL,
	[NgayDatHang] [date] NULL,
	[NgayNhanHang] [date] NULL,
	[NgayGuiHang] [date] NULL,
	[GhiChu] [nvarchar](max) NULL,
	[PhiVanChuyen] [decimal](18, 0) NULL,
	[TongTien] [decimal](18, 0) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted] [nvarchar](50) NULL,
	[IDKhachHang] [int] NULL,
	[IDNhanVien] [int] NULL,
	[IDHinhThucThanhToan] [int] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaHDCT] [nchar](10) NULL,
	[SoLuong] [float] NULL,
	[DonGia] [decimal](18, 0) NULL,
	[ThanhTien] [decimal](18, 0) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
	[IDHoaDon] [int] NULL,
	[IDChiTietSanPham] [int] NULL,
 CONSTRAINT [PK_HoaDonChiTiet] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaKH] [nchar](10) NULL,
	[TenKH] [nvarchar](max) NULL,
	[SDT] [nchar](15) NULL,
	[Email] [nvarchar](max) NULL,
	[DiaChi] [nvarchar](max) NULL,
	[NgaySinh] [date] NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhungXe]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhungXe](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ChatLieu] [nvarchar](50) NULL,
	[KichThuoc] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhungXe] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaKM] [nchar](10) NULL,
	[GiaTriPhanTram] [nvarchar](50) NULL,
	[GiaTriTienMat] [decimal](18, 0) NULL,
	[NgayBatDau] [date] NULL,
	[NgayKetThuc] [date] NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhuyenMai] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichSuGiaoDich]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LichSuGiaoDich](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaLSGD] [nchar](10) NULL,
	[MaHD] [nchar](10) NULL,
	[MoTa] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
	[IDHoaDon] [int] NULL,
 CONSTRAINT [PK_LichSuGiaoDich] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LopXe]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LopXe](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[KichThuoc] [nvarchar](50) NULL,
	[LoaiLop] [nvarchar](max) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_LopXe] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaNV] [nchar](10) NULL,
	[TenNV] [nvarchar](max) NULL,
	[SoDienThoai] [nchar](15) NULL,
	[SoCCCD] [nchar](20) NULL,
	[Email] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[GioiTinh] [bit] NULL,
	[ChucVu] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhanhXe]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanhXe](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[LoaiPhanh] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_PhanhXe] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhuocGiamXoc]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhuocGiamXoc](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[LoaiPhuoc] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_PhuocGiamXoc] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaSP] [nchar](10) NULL,
	[TenSP] [nvarchar](50) NULL,
	[MaCode] [nchar](10) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThuongHieu](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[TenThuongHieu] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NULL,
	[create_by] [nvarchar](50) NULL,
	[updat_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_ThuongHieu] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[YenXe]    Script Date: 13/11/2023 12:32:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[YenXe](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[LoaiYenXe] [nvarchar](50) NULL,
	[TrangThai] [nvarchar](50) NULL,
	[create_at] [date] NOT NULL,
	[create_by] [nvarchar](50) NULL,
	[update_at] [date] NULL,
	[update_by] [nvarchar](50) NULL,
	[Deleted_by] [nvarchar](50) NULL,
 CONSTRAINT [PK_YenXe] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[BanhXe] ADD  CONSTRAINT [DF_BanhXe_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[BanhXe] ADD  CONSTRAINT [DF_BanhXe_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  CONSTRAINT [DF_ChiTietSanPham_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  CONSTRAINT [DF_ChiTietSanPham_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[ChiTietSanPham_KhuyenMai] ADD  CONSTRAINT [DF_ChiTietSanPham_KhuyenMai_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[ChiTietSanPham_KhuyenMai] ADD  CONSTRAINT [DF_ChiTietSanPham_KhuyenMai_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[GhiDong] ADD  CONSTRAINT [DF_GhiDong_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[GhiDong] ADD  CONSTRAINT [DF_GhiDong_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[HeThongTruyenDonh] ADD  CONSTRAINT [DF_HeThongTruyenDonh_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[HeThongTruyenDonh] ADD  CONSTRAINT [DF_HeThongTruyenDonh_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[HinhAnhXe] ADD  CONSTRAINT [DF_HinhAnhXe_created_at]  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[HinhAnhXe] ADD  CONSTRAINT [DF_HinhAnhXe_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[HinhThucThanhToan] ADD  CONSTRAINT [DF_HinhThucThanhToan_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[HinhThucThanhToan] ADD  CONSTRAINT [DF_HinhThucThanhToan_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [DF_HoaDon_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [DF_HoaDon_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  CONSTRAINT [DF_HoaDonChiTiet_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  CONSTRAINT [DF_HoaDonChiTiet_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[KhachHang] ADD  CONSTRAINT [DF_KhachHang_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[KhachHang] ADD  CONSTRAINT [DF_KhachHang_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[KhungXe] ADD  CONSTRAINT [DF_KhungXe_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[KhungXe] ADD  CONSTRAINT [DF_KhungXe_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  CONSTRAINT [DF_KhuyenMai_update_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  CONSTRAINT [DF_KhuyenMai_update_at_1]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[LichSuGiaoDich] ADD  CONSTRAINT [DF_LichSuGiaoDich_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[LichSuGiaoDich] ADD  CONSTRAINT [DF_LichSuGiaoDich_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[LopXe] ADD  CONSTRAINT [DF_LopXe_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[LopXe] ADD  CONSTRAINT [DF_LopXe_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [DF_NhanVien_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [DF_NhanVien_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[PhanhXe] ADD  CONSTRAINT [DF_PhanhXe_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[PhanhXe] ADD  CONSTRAINT [DF_PhanhXe_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[PhuocGiamXoc] ADD  CONSTRAINT [DF_PhuocGiamXoc_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[PhuocGiamXoc] ADD  CONSTRAINT [DF_PhuocGiamXoc_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[ThuongHieu] ADD  CONSTRAINT [DF_ThuongHieu_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[ThuongHieu] ADD  CONSTRAINT [DF_ThuongHieu_updat_at]  DEFAULT (getdate()) FOR [updat_at]
GO
ALTER TABLE [dbo].[YenXe] ADD  CONSTRAINT [DF_YenXe_create_at]  DEFAULT (getdate()) FOR [create_at]
GO
ALTER TABLE [dbo].[YenXe] ADD  CONSTRAINT [DF_YenXe_update_at]  DEFAULT (getdate()) FOR [update_at]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_BanhXe] FOREIGN KEY([IDBanhXe])
REFERENCES [dbo].[BanhXe] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_BanhXe]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_GhiDong] FOREIGN KEY([IDGhiDong])
REFERENCES [dbo].[GhiDong] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_GhiDong]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_HeThongTruyenDonh] FOREIGN KEY([IDHeThongTruyenDong])
REFERENCES [dbo].[HeThongTruyenDonh] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_HeThongTruyenDonh]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_HinhAnhXe] FOREIGN KEY([IDHinhAnhXe])
REFERENCES [dbo].[HinhAnhXe] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_HinhAnhXe]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_KhungXe] FOREIGN KEY([IDKhungXe])
REFERENCES [dbo].[KhungXe] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_KhungXe]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_LopXe] FOREIGN KEY([IDLopXe])
REFERENCES [dbo].[LopXe] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_LopXe]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_PhanhXe] FOREIGN KEY([IDPhanhXe])
REFERENCES [dbo].[PhanhXe] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_PhanhXe]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_PhuocGiamXoc] FOREIGN KEY([IDPhuocGiamXoc])
REFERENCES [dbo].[PhuocGiamXoc] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_PhuocGiamXoc]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_SanPham] FOREIGN KEY([IDSanPham])
REFERENCES [dbo].[SanPham] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_SanPham]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_ThuongHieu] FOREIGN KEY([IDThuongHieu])
REFERENCES [dbo].[ThuongHieu] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_ThuongHieu]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_YenXe] FOREIGN KEY([IDYenXe])
REFERENCES [dbo].[YenXe] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_YenXe]
GO
ALTER TABLE [dbo].[ChiTietSanPham_KhuyenMai]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_KhuyenMai_ChiTietSanPham] FOREIGN KEY([IDChiTietSanPham])
REFERENCES [dbo].[ChiTietSanPham] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham_KhuyenMai] CHECK CONSTRAINT [FK_ChiTietSanPham_KhuyenMai_ChiTietSanPham]
GO
ALTER TABLE [dbo].[ChiTietSanPham_KhuyenMai]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_KhuyenMai_KhuyenMai] FOREIGN KEY([IDKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([ID])
GO
ALTER TABLE [dbo].[ChiTietSanPham_KhuyenMai] CHECK CONSTRAINT [FK_ChiTietSanPham_KhuyenMai_KhuyenMai]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_HinhThucThanhToan] FOREIGN KEY([IDHinhThucThanhToan])
REFERENCES [dbo].[HinhThucThanhToan] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_HinhThucThanhToan]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([IDKhachHang])
REFERENCES [dbo].[KhachHang] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([IDNhanVien])
REFERENCES [dbo].[NhanVien] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_ChiTietSanPham] FOREIGN KEY([IDChiTietSanPham])
REFERENCES [dbo].[ChiTietSanPham] ([ID])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_ChiTietSanPham]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_HoaDon] FOREIGN KEY([IDHoaDon])
REFERENCES [dbo].[HoaDon] ([ID])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[LichSuGiaoDich]  WITH CHECK ADD  CONSTRAINT [FK_LichSuGiaoDich_HoaDon] FOREIGN KEY([IDHoaDon])
REFERENCES [dbo].[HoaDon] ([ID])
GO
ALTER TABLE [dbo].[LichSuGiaoDich] CHECK CONSTRAINT [FK_LichSuGiaoDich_HoaDon]
GO
