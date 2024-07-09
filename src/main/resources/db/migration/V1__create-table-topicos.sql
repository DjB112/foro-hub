create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(200) not null,
    id_autor bigint not null,
    curso varchar(100) not null,
    status tinyint not null,
    fecha datetime not null,

    primary key (id)
);