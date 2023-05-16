drop table if exists users;


CREATE TABLE users (
    id int not null AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    username varchar(30) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    role varchar(15) NOT NULL,
    PRIMARY KEY (id)
);

insert into users (name, username, password, role) values ('John Doe', 'jdoe1', '123', 'administrator');
insert into users (name, username, password, role) values ('Jane Doe', 'jdoe2', '12', 'nurse');


drop table if exists vaccines;

create table vaccines (
	id serial primary key,
	name varchar(100),
	doses_required integer,
	days_between_doses integer,
	doses_received integer,
	doses_left integer
);


insert into vaccines (name, doses_required, days_between_doses, doses_received, doses_left)
values ('Pfizer/BioNTech', 2, 21, 1000, 1000);

insert into vaccines (name, doses_required, days_between_doses, doses_received, doses_left)
values ('Johnson & Johnson', 1, 0, 500, 500);


drop table if exists patients;

create table patients (
	patient_id serial primary key,
	patient_name varchar(100),
	vaccine_id int,
	vaccine_name varchar(100),
     vaccine_doses_required int,
     vaccine_doses_left int,
	first_dose_date date,
	second_dose_date date
);

INSERT INTO patients (patient_name, vaccine_id, vaccine_name, vaccine_doses_required, vaccine_doses_left, first_dose_date)
VALUES ('John Doe', 1, 'Pfizer/BioNTech', 2, 2, CURRENT_DATE);
