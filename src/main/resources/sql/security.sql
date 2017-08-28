create table users (
  username varchar(50) not null primary key,
  password varchar(255) not null,
  enabled boolean not null);
CREATE TABLE public.authorities (
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL,
  CONSTRAINT authorities_users_fk FOREIGN KEY (username) REFERENCES public.users(username) ON DELETE RESTRICT ON UPDATE CASCADE
)
WITH (
OIDS=FALSE
);
CREATE INDEX authorities_username_idx ON public.authorities (username,authority);
