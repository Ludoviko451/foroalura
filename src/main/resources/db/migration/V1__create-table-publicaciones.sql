create table publicaciones(

    id bigint not null auto_increment,
    autor varchar(100) not null,
    titulo varchar(100) not null,
    contenido varchar(6) not null,
    fecha varchar(100) not null,

    primary key(id)
);