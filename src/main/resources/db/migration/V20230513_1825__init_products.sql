INSERT INTO categories (name)
VALUES ('monitor'),
       ('processor'),
       ('RAM'),
       ('SSD'),
       ('HDD'),
       ('graphics card'),
       ('power unit'),
       ('motherboard');

INSERT INTO products (name, image, description, category_id, quantity, price)
VALUES ('AOC 23.8" LED LCD G2490VXA','files/monitor_1.jpg','1920x1080 144',1,10,22770),
       ('SAMSUNG 27" LS27AG320NMXUE Odyssey','files/monitor_2.jpg','1920x1080,H178°/V178°,AMD FreeSync,VGA+HDMI, BlackAudiojack,WALL',1,15,22800),
       ('ASUS 24" VG24VQE CURVED','files/monitor_3.png','1920x1080 165Hrz 2xHDMI,DP',1,20,23562);

INSERT INTO products (name, image, description, category_id, quantity, price)
VALUES ('Intel Core i3-7100','files/processor_1.jpg','3.9GHz, 3MB Cache L3, EMT64, Tray, Skylake',2,3,6255),
       ('Intel Core i5-7500','files/processor_2.jpg','3.4-3.8GHz,6MB Cache L3,EMT64,Tray,Kabylake',2,7,8730),
       ('Intel Core i9-13900K','files/processor_3.jpg','3.0-5.8GHz, 36MB Cache, Intel® UHD Graphics 770, Raptor Lake, 24 Cores + 32 Threads, Tray',2,10,54945);

INSERT INTO products (name, image, description, category_id, quantity, price)
VALUES ('Geil Pristine [GP44GB2666C19SC]','files/ram_1.jpg','DDR4 4GB PC-21400 (2666MHz)',3,14,1233),
       ('Kingston FURY Renegade CL19 [KF440C19RB1/16]','files/ram_2.jpg','DDR4 16GB PC-32000 (4000MHz)',3,17,6291);

INSERT INTO products (name, image, description, category_id, quantity, price)
VALUES ('FORESEE P900F128GH','files/ssd_1.jpg','SSD 128GB',4,1,1723),
       ('Kingston A400','files/ssd_1.jpg','SSD 240GB, TCL 2.5',4,24,2317);

INSERT INTO products (name, image, description, category_id, quantity, price)
VALUES ('Seagate BarraCuda ','files/hdd_1.jpg','5TB, 5400rpm, 128MB, SATA III',5,13,11343);

INSERT INTO products (name, image, description, category_id, quantity, price)
VALUES ('PALIT GeForce GT1030','files/card_1.jpg','2GB DDR4,1227Mhz,64Bit,DVI+HDMI',6,9,9180),
       ('GEFORCE GTX1660 SUPER','files/card_2.jpg','6GB GDDR6 192bit 1785Mhz PCI-E 3xDP HDMI GIGABYTE GV-N166SD6-6GD',6,24,24156),
       ('GEFORCE RTX3060','files/card_3.jpg','12GB GDDR6 192bit 1807Mhz 2xDP 2xHDMI GIGABYTE GV-N3060EAGLE OC-12GD',6,33,36531),
       ('GeForce RTX 4080 TRINITY','files/card_4.jpg','OC 16GB GDDR6X, Engine clock 2520MHz, Memory clock 22400MHz, 256Bit, 3xDP, HDMI [ZT-D40810J-10P]',6,3,144254);

INSERT INTO products (name, image, description, category_id, quantity, price)
VALUES ('DEEPCOOL PF500D','files/unit_1.jpg','500W 80 PLUS certified 100-240V/ATX12V 2.3 & SSI EPS 12V Black flat',7,55,3780),
       ('DEEPCOOL DN500','files/unit_2.jpg','500W 80 PLUS 230V EU certified 200-240V/Intel ATX12V 2.3&SSI EPS 12V',7,33,3915);

INSERT INTO products (name, image, description, category_id, quantity, price)
VALUES ('MB LGA1700 GIGABYTE B760M GAMING','files/motherboard_1.jpg','DDR4,2xDDR4,10xUSB,6xSATAIII,mATX,PCIe16x, PCIe1x,VGA HDMI,DP',8,11,10989),
       ('MSI PRO B660M-B','files/motherboard_1.jpg','DDR4, LGA1700, Intel B660, 2xDDR4, 4xSATA3, 1xPCI-E 3.0x16,1xPCI-E 3.0x1,Sound8Ch, 4SATA+1M2, RAID, 4USB3.2+2USB2.0,1xVGA, 1xHDMI, mATX',8,12,11583);

