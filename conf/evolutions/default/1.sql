# Images schema

# --- !Ups

CREATE TABLE Images (
       id bigint(20) NOT NULL,
       ip bigint(12) NOT NULL,
       password bigint(20) NOT NULL,
       date date NOT NULL,
       PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE Images;
