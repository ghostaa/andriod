create table user(id integer not null primary key autoincrement, name varchar); 
create table record (id integer not null primary key autoincrement, times varchar);   




insert into user(name) values ("ghost");
delete from user where id=2;



CREATE TABLE user 
( 
  id integer NOT NULL PRIMARY KEY AUTOINCREMENT , 
  name varchar 
) ;
CREATE TABLE record 
( 
  id integer NOT NULL PRIMARY KEY AUTOINCREMENT , 
  times varchar ,  
  user_id integer, 
  constraint 'record_user_fk' foreign key ('user_id') references 'user'('id')

) ;

===================
    CREATE TABLE 'dage' (
   'id' integer NOT NULL PRIMARY KEY  autoincrement ,
   'name' varchar
 );
 
 CREATE TABLE 'xiaodi' (
   'id' integer NOT NULL PRIMARY KEY autoincrement,
   'dage_id' int ,
  'name' varchar,
  CONSTRAINT 'xiaodi_ibfk_1' FOREIGN KEY ('dage_id') REFERENCES 'dage' ('id')
) ;