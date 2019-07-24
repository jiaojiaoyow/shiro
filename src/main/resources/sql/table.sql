#用户信息表
create table user_info(
uid varchar(30) primary key,
username varchar(40),
name varchar(40),
password varchar(60),
salt varchar(60),
state int

)
;
#权限表
create table sys_permission(
permission_id varchar(30) primary key ,
available int ,
name varchar (30),
parent_id varchar (30),
parent_ids varchar (30),
permission varchar(40),
resource_type varchar(30),
url varchar (50)
)
;
#角色表
create table sys_role(
role_id varchar (30) primary key ,
available int ,
description varchar (30),
role varchar (30)
)
;
#角色和权限表
create table sys_role_permission(
permission_id varchar (30) ,
role_id varchar (30),
primary key (permission_id,role_id),
foreign key(role_id) references sys_role(role_id),
foreign key(role_id) references sys_permission(role_id)
)
;
#用户与角色
create table sys_user_role(
role_id varchar (30),
uid varchar (30),
primary key (role_id,uid),
foreign key(uid) references user_info(uid),
foreign key(role_id) references sys_role(role_id)
)



