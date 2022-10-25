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
