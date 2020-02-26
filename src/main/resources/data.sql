DROP TABLE IF EXISTS position;

CREATE TABLE position (
  id_position INT AUTO_INCREMENT  PRIMARY KEY,
  currency VARCHAR(250) NOT NULL,
  amount VARCHAR(250) NOT NULL,
  id_user INT NOT NULL,
  status VARCHAR(250) NOT NULL
);

INSERT INTO position (currency, amount, id_user,status) VALUES
  ('euro', '3500', 1, 1);

  INSERT INTO position (currency, amount, id_user,status) VALUES
  ('dollars', '1000', 2, 0);
--
--
--
DROP TABLE IF EXISTS user_currency;

CREATE TABLE user_currency (
  id_user INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL unique,
  first_name VARCHAR(250) NOT NULL,
  family_name VARCHAR(250) DEFAULT NULL,
  role VARCHAR(250) NOT NULL
);

INSERT INTO user_currency (user_name, first_name, family_name,role) VALUES
  ('yabo', 'yaakoub', 'borji','ADMINISTRATOR'),
  ('luxtrust', 'lux', 'trust','USER');

DROP TABLE IF EXISTS role;

CREATE TABLE role (
  id_role INT AUTO_INCREMENT  PRIMARY KEY,
  role_name VARCHAR(250) NOT NULL
);

INSERT INTO role (role_name) VALUES
  ('ADMINISTRATOR'),
  ('USER');