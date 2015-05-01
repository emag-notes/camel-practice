DROP TABLE IF EXISTS myitems;

CREATE TABLE myitems (
  user_id varchar(255) NOT NULL,
  user_name varchar(255) NOT NULL,
  PRIMARY KEY (user_id)
);

INSERT INTO myitems (user_id, user_name) VALUES ('00001', 'user01');
INSERT INTO myitems (user_id, user_name) VALUES ('00002', 'user02');