#1-ая группа ключевые решения
#2 -

DROP TABLE IF EXISTS jc_student_child;
DROP TABLE IF EXISTS jc_student_order;
DROP TABLE IF EXISTS jc_passport_office;
DROP TABLE IF EXISTS jc_register_office;
DROP TABLE IF EXISTS jc_country_struct;
DROP TABLE IF EXISTS jc_street;

CREATE TABLE jc_street
(
  street_code integer not null,
  street_name VARCHAR(300),
  PRIMARY KEY(street_code)
);

CREATE TABLE jc_country_struct
(
  area_id char(12) not null,
  area_name varchar(200),
  PRIMARY KEY(area_id)
);

CREATE TABLE jc_passport_office
(
  p_office_id INTEGER not null,
  p_office_area_id char(12) not null,
  p_office_name VARCHAR(200),
  PRIMARY KEY (p_office_id),
  FOREIGN KEY (p_office_area_id) REFERENCES jc_country_struct(area_id) ON DELETE RESTRICT

);

CREATE TABLE jc_register_office
(
  r_office_id INTEGER not null,
  r_office_area_id char(12) not null,
  r_office_name VARCHAR(200),
  PRIMARY KEY (r_office_id),
  FOREIGN KEY (r_office_area_id) REFERENCES jc_country_struct(area_id) ON DELETE RESTRICT

);

CREATE TABLE jc_student_order
(
  student_order_id SERIAL,
  h_surname varchar(100) not null,
  h_given_name varchar(100) not null,
  h_patronimyc varchar(100) not null,
  h_date_of_birth date not null,
  h_passport_seria VARCHAR(10) NOT NULL ,
  h_passport_number VARCHAR(10) NOT NULL,
  h_passport_date DATE NOT NULL ,
  h_passport_office_id INTEGER NOT NULL ,
  h_post_index varchar(10),
  h_street_code integer not null,
  h_building varchar(10) not null,
  h_extension varchar(10),
  h_apartment varchar(10),
  w_surname varchar(100) not null,
  w_given_name varchar(100) not null,
  w_patronimyc varchar(100) not null,
  w_date_of_birth date not null,
  w_passport_seria VARCHAR(10) NOT NULL ,
  w_passport_number VARCHAR(10) NOT NULL,
  w_passport_date DATE NOT NULL ,
  w_passport_office_id INTEGER NOT NULL ,
  w_post_index varchar(10),
  w_street_code integer not null,
  w_building varchar(10) not null,
  w_extension varchar(10),
  w_apartment varchar(10),
  certificate_id VARCHAR(20) NOT NULL,
  register_office_id INTEGER NOT NULL,
  marriage_date DATE NOT NULL,
  PRIMARY KEY (student_order_id),
  FOREIGN KEY (h_street_code) REFERENCES jc_street(street_code)  ON DELETE RESTRICT,
  FOREIGN KEY (w_street_code) REFERENCES jc_street(street_code) ON DELETE RESTRICT,
  FOREIGN KEY (register_office_id) REFERENCES jc_register_office(r_office_id) ON DELETE RESTRICT
);

CREATE TABLE jc_student_child
(
  student_child_id SERIAL,
  student_order_id INTEGER NOT NULL ,
  c_surname varchar(100) not null,
  c_given_name varchar(100) not null,
  c_patronimyc varchar(100) not null,
  c_date_of_birth date not null,
  c_certificate_number VARCHAR(10) NOT NULL ,
  c_certificate_date DATE NOT NULL ,
  c_register_office_id INTEGER NOT NULL ,
  c_post_index varchar(10),
  c_street_code integer not null,
  c_building varchar(10) not null,
  c_extension varchar(10),
  c_apartment varchar(10),
  PRIMARY KEY (student_child_id),
  FOREIGN KEY (c_street_code) REFERENCES jc_street(street_code)  ON DELETE RESTRICT,
  FOREIGN KEY (c_street_code) REFERENCES jc_street(street_code) ON DELETE RESTRICT,
  FOREIGN KEY (c_register_office_id) REFERENCES jc_register_office(r_office_id) ON DELETE RESTRICT
);