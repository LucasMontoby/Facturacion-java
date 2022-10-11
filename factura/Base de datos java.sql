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
                        cliente_id int);
                        
create table detalle_venta (id int primary key auto_increment not null,
								venta_id int,
                                detalle_id int,
                                producto_id int,
                                cantidad_id int,
                                subtotal double);

create table productos (id int primary key auto_increment not null, 	
						sku varchar(50),
                        descripcion varchar(150),
                        precioCompra double,
                        precioVenta double,
                        stock int,
                        fecha_alta date
                        );