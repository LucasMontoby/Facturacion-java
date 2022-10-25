use java;

create table clientes (id int primary key auto_increment not null, 
				dni	 varchar(11),
                nombre varchar(100),
                apellido varchar(45),
                fecha_nacimiento date
                );
                
create table venta (id int primary key auto_increment not null,
						fecha_alta date,
                        total double,
                        clientes_id int,
                        CONSTRAINT `fk_clientes_id` FOREIGN KEY (`clientes_id`) REFERENCES `clientes` (`id`));
                        
create table productos (id int primary key auto_increment not null, 	
						sku varchar(50),
                        descripcion varchar(150),
                        precio_compra double,
                        precio_venta double,
                        stock int,
                        fecha_alta date
                        );

                        create table detalle_venta (id int primary key auto_increment not null,
								venta_id int,
                                detalle_id int,
                                productos_id int,
                                cantidad int,
                                subtotal double,
                                CONSTRAINT `fk_venta_id` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`id`),
                                CONSTRAINT `fk_productos_id` FOREIGN KEY (`productos_id`) REFERENCES `productos` (`id`));
                                
---------------------------------------------------------------------------------------------------------
SELECT * FROM java.productos;
INSERT INTO productos (sku, descripción, precio_compra, precio_venta, stock, fecha_alta) 
VALUES ('', 'Lucas', 'Montoby', '1983-02-15'), 
('29682960', 'Agustín', 'Montoby', '1980-02-15'),
('29682961', 'Nicolas', 'Montoby', '1979-02-15');


SELECT * FROM java.productos;
INSERT INTO productos (sku, descripcion, precio_compra, precio_venta, stock, fecha_alta) 
VALUES ('12345', 'Cocacola', '300', '400', '10', '2021-09-10'), 
('123456', 'Fanta', '300', '400', '10', '2021-08-10'), 
('123457', 'Sprite', '300', '400', '10', '2021-07-10');


