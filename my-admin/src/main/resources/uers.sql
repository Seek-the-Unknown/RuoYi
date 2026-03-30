-- create table books_users(
--                                 id int(11) auto_increment primary key comment '用户编号',
--                                 name varchar(20) null comment '姓名',
--                                 education varchar(30) null comment '学历',
--                                 age int null comment '年龄'
-- )comment '用户信息表';
-- create table books_type(
--                              type_id int auto_increment primary key comment '硬件类型ID',
--                              type_name varchar(100) not null comment '硬件类型名称'
-- )comment '硬件类型表';

create table books_information(
                     book_id int auto_increment primary key comment '图书ID',
                     book_name varchar(100) not null comment '图书名称',
                     book_author varchar(100) not null comment '图书作者',
                     book_image varchar(255) comment '图书封面',
                     type_id int comment '图书类型ID',
                     foreign key (type_id) references books_type(type_id) on delete cascade on update cascade
)comment '图书信息表';
