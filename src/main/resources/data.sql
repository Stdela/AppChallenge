  INSERT INTO Role (
        id,
        role_description,
        role_name
    )
    VALUES
	(1,'rol de administrador', 'ROLE_ADMIN'),
    (2,'rol de usuario','USER');
   
INSERT INTO app_user (
        id,
        creation_date,
       deleted_at,
        is_deleted,
        email,
        name,
        last_name,
        last_update,
        password,id_role)
    VALUES
    (1,current_timestamp(),NULL,0,'mariano@gmail.com','Mariano','Forte',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',1),
    (2,current_timestamp(),NULL,0,'carolina@gmail.com','Carolina','Flash',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',1),
    (3,current_timestamp(),NULL,0,'elena@gmail.com','Elena','Mendez',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',1),
    (4,current_timestamp(),NULL,0,'Aitor@gmail.com','Aitor','Liri',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',1),
    (5,current_timestamp(),NULL,0,'Andres@gmail.com','Andres','Benegas',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',1),
    (6,current_timestamp(),NULL,0,'Elba@gmail.com','Elba','Klun',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',1),
    (7,current_timestamp(),NULL,0,'Jazmin@gmail.com','Jazmin','Flor',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',1),
    (8,current_timestamp(),NULL,0,'Maira@gmail.com','Maira','Falcon',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',1),
    (9,current_timestamp(),NULL,0,'Nicolas@gmail.com','Nicolas','Amarilla',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',1),
    (10,current_timestamp(),NULL,0,'Federico@gmail.com','Federico','Lopez',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',1),

    (11,current_timestamp(),NULL,0,'Belen@gmail.com','Belen','Milanesi',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',2),
    (12,current_timestamp(),NULL,0,'Florencia@gmail.com','Florencia','Perez',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',2),
    (13,current_timestamp(),NULL,0,'Jessica@gmail.com','Jessica','Artaud',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',2),
    (14,current_timestamp(),NULL,0,'Cecilio@gmail.com','Cecilio','Principe',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',2),
    (15,current_timestamp(),NULL,0,'Beatriz@gmail.com','Beatriz','Almo',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',2),
    (16,current_timestamp(),NULL,0,'Juliana@gmail.com','Juliana','Chavez',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',2),
    (17,current_timestamp(),NULL,0,'Pedro@gmail.com','Pedro','Escamozo',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',2),
    (18,current_timestamp(),NULL,0,'Selena@gmail.com','Selena','Gomez',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',2),
    (19,current_timestamp(),NULL,0,'Luis@gmail.com','Luis','Spinetta',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',2),
    (20,current_timestamp(),NULL,0,'Abril@gmail.com','Abril','Sierra',current_timestamp(),'$2a$10$GceBTMx5xPcFs8skaMTH2.taB0mzHt7U3fY2J0Mjevj0ARq81XK0i',2);
  ;
 

   
   
 /*  INSERT INTO product (id, name, price, count) VALUES
(, 'Smartphone', 299.99, 100),
(2, 'Televisor LED', 499.99, 50),
(3, 'Tableta', 199.99, 200),
(4, 'Cámara digital', 199.99, 75),
(5, 'Auriculares inalámbricos', 79.99, 150),
(6, 'Portátil', 899.99, 90),
(7, 'Reproductor de Blu-ray', 99.99, 120),
(8, 'Altavoces Bluetooth', 49.99, 30),
(9, 'Reloj inteligente', 149.99, 40),
(10, 'Consola de videojuegos', 399.99, 60);*/
