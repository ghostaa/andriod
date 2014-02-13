

CREATE TABLE user 
( 
  id integer NOT NULL PRIMARY KEY AUTOINCREMENT , 
  name varchar 
) ;
CREATE TABLE record 
( 
  id integer NOT NULL PRIMARY KEY AUTOINCREMENT , 
  times long ,  
  user_id integer
) ;

