create database banco;
use banco;
create table direcciones(
id int not null primary key auto_increment,
calle varchar(20) not null,
colonia varchar (20) not null,
numeroCasa varchar(5) not null
);

create table clientes(
id int not null primary key auto_increment,
nombre varchar (30) not null,
apellido_paterno varchar(20) not null,
apellido_materno varchar(20) not null,
fecha_nacimiento date not null,
edad int ,
correoElectronico varchar(50) not null unique,
contraseña blob(16) not null,
codigo_direccion int not null,
foreign key (codigo_direccion) references direcciones(id)
);

create table cuentas(
numero_cuenta int(8) not null unique primary key auto_increment,
monto decimal default 0,
fecha_apertura TIMESTAMP DEFAULT NOW(),
codigo_cliente int not null,
foreign key (codigo_cliente) references clientes(id)
);
ALTER TABLE cuentas AUTO_INCREMENT = 10000000;
create table transferencias(
id int not null primary key auto_increment,
monto decimal not null,
fecha TIMESTAMP DEFAULT NOW(),
codigo_emisor int not null,
codigo_receptor int not null,
foreign key (codigo_emisor) references cuentas(numero_cuenta),
foreign key (codigo_receptor) references cuentas(numero_cuenta)
);

create table retirosSinCuenta(
folio int not null primary key auto_increment,
contraseña int(8) not null,
monto decimal not null,
fecha TIMESTAMP DEFAULT NOW(),
cuenta_retirada int not null,
foreign key (cuenta_retirada) references cuentas(numero_cuenta)
);

