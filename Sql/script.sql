USE [DeviceLotery]
GO
/****** Object:  Table [dbo].[computer]    Script Date: 25/01/2024 19:11:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[computer](
	[id] [int] NOT NULL,
	[age] [int] NULL,
	[description] [varchar](100) NULL,
	[device_name] [varchar](50) NULL,
	[device_type] [varchar](50) NULL,
	[is_ordered] [bit] NULL,
	[lottery_date] [date] NULL,
	[price] [float] NULL,
	[ready_to_lottery] [bit] NULL,
	[office_id] [int] NOT NULL,
	[battery_life] [varchar](50) NULL,
	[model] [varchar](50) NULL,
	[operating_system] [varchar](50) NULL,
	[serial_number] [varchar](50) NULL,
	[cpu_id] [int] NULL,
	[ram_id] [int] NULL,
	[storage_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cpu]    Script Date: 25/01/2024 19:11:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cpu](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[device_core]    Script Date: 25/01/2024 19:11:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[device_core](
	[id] [int] NOT NULL,
	[age] [int] NULL,
	[description] [varchar](100) NULL,
	[device_name] [varchar](50) NULL,
	[device_type] [varchar](50) NULL,
	[is_ordered] [bit] NULL,
	[lottery_date] [date] NULL,
	[price] [float] NULL,
	[ready_to_lottery] [bit] NULL,
	[office_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hibernate_sequences]    Script Date: 25/01/2024 19:11:54 ******/
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
/****** Object:  Table [dbo].[office]    Script Date: 25/01/2024 19:11:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[office](
	[id] [int] NOT NULL,
	[address] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[other_device]    Script Date: 25/01/2024 19:11:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[other_device](
	[id] [int] NOT NULL,
	[age] [int] NULL,
	[description] [varchar](100) NULL,
	[device_name] [varchar](50) NULL,
	[device_type] [varchar](50) NULL,
	[is_ordered] [bit] NULL,
	[lottery_date] [date] NULL,
	[price] [float] NULL,
	[ready_to_lottery] [bit] NULL,
	[office_id] [int] NOT NULL,
	[additional_info] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[participation]    Script Date: 25/01/2024 19:11:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[participation](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[is_winner] [bit] NULL,
	[device_id] [int] NOT NULL,
	[user_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ram]    Script Date: 25/01/2024 19:11:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ram](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 25/01/2024 19:11:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[id] [int] NOT NULL,
	[role_name] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[storage]    Script Date: 25/01/2024 19:11:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[storage](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tablet]    Script Date: 25/01/2024 19:11:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tablet](
	[id] [int] NOT NULL,
	[age] [int] NULL,
	[description] [varchar](100) NULL,
	[device_name] [varchar](50) NULL,
	[device_type] [varchar](50) NULL,
	[is_ordered] [bit] NULL,
	[lottery_date] [date] NULL,
	[price] [float] NULL,
	[ready_to_lottery] [bit] NULL,
	[office_id] [int] NOT NULL,
	[battery_life] [varchar](50) NULL,
	[operating_system] [varchar](50) NULL,
	[screen_size] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user]    Script Date: 25/01/2024 19:11:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[surname] [varchar](50) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[role_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[computer] ([id], [age], [description], [device_name], [device_type], [is_ordered], [lottery_date], [price], [ready_to_lottery], [office_id], [battery_life], [model], [operating_system], [serial_number], [cpu_id], [ram_id], [storage_id]) VALUES (555, 2, N'brak baterii', N'Lenovo 500E', N'COMPUTER', 0, CAST(N'2024-01-22' AS Date), 299, 1, 2, N'0', N'Lenovo Chromebook 500E II Gattor', N'Lenovo Chromebook 500E II Gattor', N'RA1234', 9, 7, 6)
INSERT [dbo].[computer] ([id], [age], [description], [device_name], [device_type], [is_ordered], [lottery_date], [price], [ready_to_lottery], [office_id], [battery_life], [model], [operating_system], [serial_number], [cpu_id], [ram_id], [storage_id]) VALUES (556, 1, N'', N'ASUS X515JA', N'COMPUTER', 0, NULL, 300, 1, 1, N'12', N'X515JA-BQ3326', N'X515JA-BQ3326', N'AS1298', 10, 7, 6)
INSERT [dbo].[computer] ([id], [age], [description], [device_name], [device_type], [is_ordered], [lottery_date], [price], [ready_to_lottery], [office_id], [battery_life], [model], [operating_system], [serial_number], [cpu_id], [ram_id], [storage_id]) VALUES (557, 2, N'brak RAM', N'LENOVO ThinkPad', N'COMPUTER', 0, NULL, 300, 0, 1, N'12', N'ThinkPad T460s', N'ThinkPad T460s', N'FG123', 9, NULL, 5)
GO
SET IDENTITY_INSERT [dbo].[cpu] ON 

INSERT [dbo].[cpu] ([id], [name], [price]) VALUES (8, N'Intel Core i7-6600U', 0)
INSERT [dbo].[cpu] ([id], [name], [price]) VALUES (9, N'Intel Celeron Quad COre', 40)
INSERT [dbo].[cpu] ([id], [name], [price]) VALUES (10, N'Intel Core i3-1005G1', 0)
SET IDENTITY_INSERT [dbo].[cpu] OFF
GO
INSERT [dbo].[hibernate_sequences] ([sequence_name], [next_val]) VALUES (N'default', 700)
GO
INSERT [dbo].[office] ([id], [address]) VALUES (1, N'Grunwaldzka')
INSERT [dbo].[office] ([id], [address]) VALUES (2, N'Politechnika')
GO
INSERT [dbo].[other_device] ([id], [age], [description], [device_name], [device_type], [is_ordered], [lottery_date], [price], [ready_to_lottery], [office_id], [additional_info]) VALUES (561, 2, N'Myszka USB', N'Myszka logitech', N'OTHER', 0, CAST(N'2024-01-21' AS Date), 20, 1, 1, N'')
INSERT [dbo].[other_device] ([id], [age], [description], [device_name], [device_type], [is_ordered], [lottery_date], [price], [ready_to_lottery], [office_id], [additional_info]) VALUES (562, 2, N'Myszka USB', N'Myszka logitech', N'OTHER', 0, NULL, 20, 0, 1, N'')
INSERT [dbo].[other_device] ([id], [age], [description], [device_name], [device_type], [is_ordered], [lottery_date], [price], [ready_to_lottery], [office_id], [additional_info]) VALUES (563, 2, N'Myszka bezprzewodowa', N'Myszka logitech', N'OTHER', 0, CAST(N'2024-01-22' AS Date), 20, 1, 1, N'Bluetooth')
INSERT [dbo].[other_device] ([id], [age], [description], [device_name], [device_type], [is_ordered], [lottery_date], [price], [ready_to_lottery], [office_id], [additional_info]) VALUES (564, 2, N'Myszka bezprzewodowa', N'Myszka logitech', N'OTHER', 0, NULL, 20, 1, 1, N'Bluetooth')
GO
SET IDENTITY_INSERT [dbo].[participation] ON 

INSERT [dbo].[participation] ([id], [is_winner], [device_id], [user_id]) VALUES (15, 1, 554, 10)
INSERT [dbo].[participation] ([id], [is_winner], [device_id], [user_id]) VALUES (16, 1, 555, 10)
INSERT [dbo].[participation] ([id], [is_winner], [device_id], [user_id]) VALUES (17, 0, 561, 10)
INSERT [dbo].[participation] ([id], [is_winner], [device_id], [user_id]) VALUES (18, 0, 554, 11)
INSERT [dbo].[participation] ([id], [is_winner], [device_id], [user_id]) VALUES (19, 0, 555, 11)
INSERT [dbo].[participation] ([id], [is_winner], [device_id], [user_id]) VALUES (20, 0, 556, 11)
INSERT [dbo].[participation] ([id], [is_winner], [device_id], [user_id]) VALUES (21, 1, 561, 11)
INSERT [dbo].[participation] ([id], [is_winner], [device_id], [user_id]) VALUES (22, 1, 563, 11)
INSERT [dbo].[participation] ([id], [is_winner], [device_id], [user_id]) VALUES (23, 1, 554, 13)
INSERT [dbo].[participation] ([id], [is_winner], [device_id], [user_id]) VALUES (24, 0, 555, 13)
INSERT [dbo].[participation] ([id], [is_winner], [device_id], [user_id]) VALUES (25, 0, 556, 13)
INSERT [dbo].[participation] ([id], [is_winner], [device_id], [user_id]) VALUES (26, 0, 561, 13)
INSERT [dbo].[participation] ([id], [is_winner], [device_id], [user_id]) VALUES (27, 0, 563, 13)
SET IDENTITY_INSERT [dbo].[participation] OFF
GO
SET IDENTITY_INSERT [dbo].[ram] ON 

INSERT [dbo].[ram] ([id], [name], [price]) VALUES (5, N'16 GB', 0)
INSERT [dbo].[ram] ([id], [name], [price]) VALUES (6, N'8 GB', 0)
INSERT [dbo].[ram] ([id], [name], [price]) VALUES (7, N'4 GB', 0)
INSERT [dbo].[ram] ([id], [name], [price]) VALUES (8, N'32 GB', 0)
INSERT [dbo].[ram] ([id], [name], [price]) VALUES (9, N'16GB', NULL)
INSERT [dbo].[ram] ([id], [name], [price]) VALUES (10, N'32GB', NULL)
SET IDENTITY_INSERT [dbo].[ram] OFF
GO
INSERT [dbo].[role] ([id], [role_name]) VALUES (1, N'ADMIN')
INSERT [dbo].[role] ([id], [role_name]) VALUES (2, N'USER')
GO
SET IDENTITY_INSERT [dbo].[storage] ON 

INSERT [dbo].[storage] ([id], [name], [price]) VALUES (5, N'512 GB SSD', 0)
INSERT [dbo].[storage] ([id], [name], [price]) VALUES (6, N'256 GB SSD', 30)
INSERT [dbo].[storage] ([id], [name], [price]) VALUES (7, N'128 GB', 0)
INSERT [dbo].[storage] ([id], [name], [price]) VALUES (8, N'512GB SSD', NULL)
SET IDENTITY_INSERT [dbo].[storage] OFF
GO
INSERT [dbo].[tablet] ([id], [age], [description], [device_name], [device_type], [is_ordered], [lottery_date], [price], [ready_to_lottery], [office_id], [battery_life], [operating_system], [screen_size]) VALUES (559, 2, N'lekko porysowany', N'TABLET BLOW PlatinumTAB8', N'TABLET', 0, NULL, 420, 0, 1, N'', NULL, N'124.5x208.5')
INSERT [dbo].[tablet] ([id], [age], [description], [device_name], [device_type], [is_ordered], [lottery_date], [price], [ready_to_lottery], [office_id], [battery_life], [operating_system], [screen_size]) VALUES (560, 2, N'brak ladowarki', N'TABLET Lenovo Tab M10', N'TABLET', 0, NULL, 120, 0, 2, N'', NULL, N'244.2x153.2mm')
GO
SET IDENTITY_INSERT [dbo].[user] ON 

INSERT [dbo].[user] ([id], [email], [name], [password], [surname], [username], [role_id]) VALUES (5, N'maurycy.niewczas@gmail.com', N'Maurycy', N'$2a$10$x5kWCN6MH4dz1knzP7x2xe1x86ZQsIGsE0aPibbki89qFbR2WNM/m', N'Niewczas', N'admin', 1)
INSERT [dbo].[user] ([id], [email], [name], [password], [surname], [username], [role_id]) VALUES (10, N'maurycy.niewczas@gmail.com', N'Maurycy', N'$2a$10$KZdi5D2Jh9.kxN3tFT5IXOzbLzn7/LkFBM.BzwiMYH6NyVeVfVhOe', N'Niewczas', N'mniewczas', 2)
INSERT [dbo].[user] ([id], [email], [name], [password], [surname], [username], [role_id]) VALUES (11, N'jan.kowalski@gmail.com', N'Jan', N'$2a$10$VLI/RY/GOuxiAiHO11Y.TOGd5YgGVytRiMyzS3vrd4tqEnv0zGHZq', N'Kowalski', N'jkowalski', 2)
INSERT [dbo].[user] ([id], [email], [name], [password], [surname], [username], [role_id]) VALUES (12, N'lewandowski@gmail.com', N'Robert', N'$2a$10$ya0Y1l8A/5LdGPmHTLWb7O/ME3hZyyPLP7vL/t.JGWpipaokCx0uy', N'Lewandowski', N'lewy', 2)
INSERT [dbo].[user] ([id], [email], [name], [password], [surname], [username], [role_id]) VALUES (13, N'mieszko@gmail.com', N'Mieszko', N'$2a$10$5CsbDOdU4uHgHVfGiukUJudGQU3uQaSYbhPLO78BBR85epJYqo6Va', N'Pierwszy', N'Mieszko', 2)
INSERT [dbo].[user] ([id], [email], [name], [password], [surname], [username], [role_id]) VALUES (14, N'zbigniew@gmail.com', N'Zbigniew', N'$2a$10$.3aZgdklAdDs0OSksKthoukslLIgCxuWHepnB2ya/44s8rI7Ug4Mm', N'Zbyszowski', N'Zbigniew', 2)
INSERT [dbo].[user] ([id], [email], [name], [password], [surname], [username], [role_id]) VALUES (15, N'olusia@gmail.com', N'Aleksandra', N'$2a$10$n3//3JmWeORtc1jJLi7HY.wo4nRD4Ds9.h04aMKPx9naPLz0AgDAm', N'Olkowska', N'Aleksandra', 2)
INSERT [dbo].[user] ([id], [email], [name], [password], [surname], [username], [role_id]) VALUES (16, N'postman@gmail.com', N'Maurycy', N'$2a$10$7mvsJKbJycT6SJXccWZzwu0rafHBaT69vfhmCgQCkVhJRgP5jmGZ.', N'Niewczas', N'Postman user', 2)
SET IDENTITY_INSERT [dbo].[user] OFF
GO
ALTER TABLE [dbo].[computer]  WITH CHECK ADD  CONSTRAINT [FK_5oc2tnc41leim7jlq1u0f1kp8] FOREIGN KEY([office_id])
REFERENCES [dbo].[office] ([id])
GO
ALTER TABLE [dbo].[computer] CHECK CONSTRAINT [FK_5oc2tnc41leim7jlq1u0f1kp8]
GO
ALTER TABLE [dbo].[computer]  WITH CHECK ADD  CONSTRAINT [FKabkjlhe47hm3rmo3hwfd9071k] FOREIGN KEY([ram_id])
REFERENCES [dbo].[ram] ([id])
GO
ALTER TABLE [dbo].[computer] CHECK CONSTRAINT [FKabkjlhe47hm3rmo3hwfd9071k]
GO
ALTER TABLE [dbo].[computer]  WITH CHECK ADD  CONSTRAINT [FKg0555ny8xm0kx1wx8kqrhtrms] FOREIGN KEY([cpu_id])
REFERENCES [dbo].[cpu] ([id])
GO
ALTER TABLE [dbo].[computer] CHECK CONSTRAINT [FKg0555ny8xm0kx1wx8kqrhtrms]
GO
ALTER TABLE [dbo].[computer]  WITH CHECK ADD  CONSTRAINT [FKmtop67dfx43p027gmvk4bn3c0] FOREIGN KEY([storage_id])
REFERENCES [dbo].[storage] ([id])
GO
ALTER TABLE [dbo].[computer] CHECK CONSTRAINT [FKmtop67dfx43p027gmvk4bn3c0]
GO
ALTER TABLE [dbo].[device_core]  WITH CHECK ADD  CONSTRAINT [FKkak7ujdpe71w7x1bdacegabxr] FOREIGN KEY([office_id])
REFERENCES [dbo].[office] ([id])
GO
ALTER TABLE [dbo].[device_core] CHECK CONSTRAINT [FKkak7ujdpe71w7x1bdacegabxr]
GO
ALTER TABLE [dbo].[other_device]  WITH CHECK ADD  CONSTRAINT [FK_8m3ubcfpwncbbnc3ql9vwe3ua] FOREIGN KEY([office_id])
REFERENCES [dbo].[office] ([id])
GO
ALTER TABLE [dbo].[other_device] CHECK CONSTRAINT [FK_8m3ubcfpwncbbnc3ql9vwe3ua]
GO
ALTER TABLE [dbo].[participation]  WITH CHECK ADD  CONSTRAINT [FK5hwcfjc4s352miwlliw0ewj2p] FOREIGN KEY([user_id])
REFERENCES [dbo].[user] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[participation] CHECK CONSTRAINT [FK5hwcfjc4s352miwlliw0ewj2p]
GO
ALTER TABLE [dbo].[tablet]  WITH CHECK ADD  CONSTRAINT [FK_8afta2jj94db5vtpc171hson3] FOREIGN KEY([office_id])
REFERENCES [dbo].[office] ([id])
GO
ALTER TABLE [dbo].[tablet] CHECK CONSTRAINT [FK_8afta2jj94db5vtpc171hson3]
GO
ALTER TABLE [dbo].[user]  WITH CHECK ADD  CONSTRAINT [FKdl9dqp078pc03g6kdnxmnlqpc] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([id])
GO
ALTER TABLE [dbo].[user] CHECK CONSTRAINT [FKdl9dqp078pc03g6kdnxmnlqpc]
GO
