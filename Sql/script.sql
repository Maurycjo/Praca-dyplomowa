USE [DeviceLotery]
GO
/****** Object:  Table [dbo].[computer]    Script Date: 19/11/2023 16:40:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[computer](
	[id] [int] NOT NULL,
	[serial_number] [varchar](50) NULL,
	[operating_system] [varchar](50) NULL,
	[batery_life] [varchar](50) NULL,
	[model] [varchar](50) NULL,
	[cpu_id] [int] NULL,
	[storage_id] [int] NULL,
	[ram_id] [int] NULL,
	[age] [int] NULL,
	[description] [varchar](100) NULL,
	[device_name] [varchar](50) NULL,
	[price] [float] NULL,
	[ready_to_sell] [bit] NULL,
	[battery_life] [varchar](50) NULL,
	[office_id] [int] NULL,
	[device_type] [varchar](50) NULL,
 CONSTRAINT [PK_Computer] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cpu]    Script Date: 19/11/2023 16:40:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cpu](
	[id] [int] NOT NULL,
	[name] [varchar](50) NOT NULL,
	[price] [float] NULL,
 CONSTRAINT [PK_Cpu] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[device_core]    Script Date: 19/11/2023 16:40:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[device_core](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[device_type] [varchar](50) NULL,
	[device_name] [varchar](50) NULL,
	[price] [float] NULL,
	[description] [varchar](100) NULL,
	[age] [int] NULL,
	[ready_to_sell] [bit] NULL,
	[office_id] [int] NOT NULL,
 CONSTRAINT [PK_device_core] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hibernate_sequences]    Script Date: 19/11/2023 16:40:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hibernate_sequences](
	[sequence_name] [varchar](255) NOT NULL,
	[next_val] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[sequence_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[lottery]    Script Date: 19/11/2023 16:40:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[lottery](
	[id] [int] NOT NULL,
	[device_id] [int] NOT NULL,
	[lottery_date] [date] NULL,
	[is_active] [bit] NOT NULL,
 CONSTRAINT [PK_Lotery] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[office]    Script Date: 19/11/2023 16:40:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[office](
	[id] [int] NOT NULL,
	[address] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Office] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[other_device]    Script Date: 19/11/2023 16:40:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[other_device](
	[id] [int] NOT NULL,
	[additional_info] [varchar](100) NULL,
	[age] [int] NULL,
	[description] [varchar](100) NULL,
	[device_name] [varchar](50) NULL,
	[price] [float] NULL,
	[ready_to_sell] [bit] NULL,
	[office_id] [int] NULL,
	[device_type] [varchar](50) NULL,
 CONSTRAINT [PK_DockingStation] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[participation]    Script Date: 19/11/2023 16:40:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[participation](
	[id] [int] NOT NULL,
	[lottery_id] [int] NOT NULL,
	[user_id] [int] NOT NULL,
	[is_winner] [bit] NOT NULL,
 CONSTRAINT [PK_participation] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ram]    Script Date: 19/11/2023 16:40:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ram](
	[id] [int] NOT NULL,
	[name] [varchar](50) NOT NULL,
	[price] [float] NULL,
 CONSTRAINT [PK_Ram] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 19/11/2023 16:40:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[id] [int] NOT NULL,
	[role_name] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[storage]    Script Date: 19/11/2023 16:40:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[storage](
	[id] [int] NOT NULL,
	[name] [varchar](50) NOT NULL,
	[price] [float] NULL,
 CONSTRAINT [PK_Storage] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tablet]    Script Date: 19/11/2023 16:40:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tablet](
	[id] [int] NOT NULL,
	[screen_size] [varchar](50) NULL,
	[operating_system] [varchar](50) NULL,
	[batery_life] [varchar](50) NULL,
	[age] [int] NULL,
	[description] [varchar](100) NULL,
	[device_name] [varchar](50) NULL,
	[price] [float] NULL,
	[ready_to_sell] [bit] NULL,
	[battery_life] [varchar](50) NULL,
	[office_id] [int] NULL,
	[device_type] [varchar](50) NULL,
 CONSTRAINT [PK_Tablet] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user]    Script Date: 19/11/2023 16:40:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[id] [int] NOT NULL,
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[surname] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[role_id] [int] NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[computer]  WITH CHECK ADD  CONSTRAINT [FK_Computer_Cpu] FOREIGN KEY([cpu_id])
REFERENCES [dbo].[cpu] ([id])
GO
ALTER TABLE [dbo].[computer] CHECK CONSTRAINT [FK_Computer_Cpu]
GO
ALTER TABLE [dbo].[computer]  WITH CHECK ADD  CONSTRAINT [FK_computer_office] FOREIGN KEY([office_id])
REFERENCES [dbo].[office] ([id])
GO
ALTER TABLE [dbo].[computer] CHECK CONSTRAINT [FK_computer_office]
GO
ALTER TABLE [dbo].[computer]  WITH CHECK ADD  CONSTRAINT [FK_Computer_Ram] FOREIGN KEY([ram_id])
REFERENCES [dbo].[ram] ([id])
GO
ALTER TABLE [dbo].[computer] CHECK CONSTRAINT [FK_Computer_Ram]
GO
ALTER TABLE [dbo].[computer]  WITH CHECK ADD  CONSTRAINT [FK_Computer_Storage] FOREIGN KEY([storage_id])
REFERENCES [dbo].[storage] ([id])
GO
ALTER TABLE [dbo].[computer] CHECK CONSTRAINT [FK_Computer_Storage]
GO
ALTER TABLE [dbo].[device_core]  WITH CHECK ADD  CONSTRAINT [FK_device_core_office1] FOREIGN KEY([office_id])
REFERENCES [dbo].[office] ([id])
GO
ALTER TABLE [dbo].[device_core] CHECK CONSTRAINT [FK_device_core_office1]
GO
ALTER TABLE [dbo].[lottery]  WITH CHECK ADD  CONSTRAINT [FK_lottery_device_core] FOREIGN KEY([device_id])
REFERENCES [dbo].[device_core] ([id])
GO
ALTER TABLE [dbo].[lottery] CHECK CONSTRAINT [FK_lottery_device_core]
GO
ALTER TABLE [dbo].[other_device]  WITH CHECK ADD  CONSTRAINT [FK_other_device_office] FOREIGN KEY([office_id])
REFERENCES [dbo].[office] ([id])
GO
ALTER TABLE [dbo].[other_device] CHECK CONSTRAINT [FK_other_device_office]
GO
ALTER TABLE [dbo].[participation]  WITH CHECK ADD  CONSTRAINT [FK_participation_lottery] FOREIGN KEY([lottery_id])
REFERENCES [dbo].[lottery] ([id])
GO
ALTER TABLE [dbo].[participation] CHECK CONSTRAINT [FK_participation_lottery]
GO
ALTER TABLE [dbo].[participation]  WITH CHECK ADD  CONSTRAINT [FK_participation_user] FOREIGN KEY([user_id])
REFERENCES [dbo].[user] ([id])
GO
ALTER TABLE [dbo].[participation] CHECK CONSTRAINT [FK_participation_user]
GO
ALTER TABLE [dbo].[tablet]  WITH CHECK ADD  CONSTRAINT [FK_tablet_office] FOREIGN KEY([office_id])
REFERENCES [dbo].[office] ([id])
GO
ALTER TABLE [dbo].[tablet] CHECK CONSTRAINT [FK_tablet_office]
GO
ALTER TABLE [dbo].[user]  WITH CHECK ADD  CONSTRAINT [FK_User_Role] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([id])
GO
ALTER TABLE [dbo].[user] CHECK CONSTRAINT [FK_User_Role]
GO
