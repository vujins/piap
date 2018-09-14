
INSERT INTO korisnik (username, password, ime, prezime, opstina, grad, adresa, rodjendan, telefon, zaposlen, odobren, email) 
VALUES ('strahinja', 'strahinja123', 'Strahinja', 'Vujin', 'Zrenjanin', 'Zrenjanin', 'Tamiska 20', '1995-02-15', '062/1981-953', 'zaposlen', 1, 'strahinja.vujin11@gmail.com');
INSERT INTO korisnik (username, password, ime, prezime, opstina, grad, adresa, rodjendan, telefon, zaposlen)
VALUES ('milena', 'milena123', 'Milena', 'Stevanovic', 'Rakovica', 'Beograd', 'Borova 1', '1996-06-26', '065/8266996', 'student');


insert into role (id, tip)
values (1, 'KORISNIK'), (2, 'ADMIN');

insert into korisnik_tip (korisnik_username, role)
values ('strahinja', 1), ('strahinja', 2), ('milena', 1);

INSERT INTO stajaliste (id, naziv)
VALUES (1, 'Beograd'), (2, 'Zrenjanin'), (3, 'Subotica'), (4, 'Perlez'), (5, 'Batajnica'), (6, 'Novi Sad'),
(7, '27. Marta'), (8, 'Glavna Posta'), (9, 'Kneza Milosa'), (10, 'Milosa Pocerca'),
(11, 'Nis'), (12, 'Stajicevo'), (13, 'Ecka'), (14, 'Centa');

insert into vozac (id, datum_zaposlenja, ime, prezime, rodjendan)
values (1, '2017-01-01', 'Mika', 'Mikic', '1995-02-02'), (2, '2018-01-01', 'Pera', 'Peric', '1999-01-01'), (3, '2018-01-01', 'Zika', 'Zikic', '1999-01-01');

insert into slika (id, url)
values (1, 'logo_prevoznika'), (2, 'slika_busa1'), (3, 'slika_busa1');

insert into prevoznik (id, adresa, naziv, telefon, slika_id)
values (1, 'Zrenjanin', 'Lasta', 'telefon1', 1), (2, 'Kikinda', 'Autoprevoz Kikinda', 'telefon2', null), (3, 'Zrenjanin', 'Banat Trans', 'telefon3', null);

insert into autobus(id, broj_sedista, marka, model)
values (1, 20, 'marka', 'model'), (2, 55, 'marka2', 'model2');

insert into autobus_slika (autobus_id, slika_id)
values (1, 2), (1,3);


INSERT INTO linija (polaziste_id, odrediste_id)
VALUES (1, 4), (4, 2), (2, 3);

INSERT INTO linija (polaziste_id, odrediste_id)
VALUES (6, 2), (2, 3), (5, 6);

insert into linija (polaziste_id, odrediste_id)
values (7, 8), (8, 9), (9, 10);

insert into linija (polaziste_id, odrediste_id)
values (11, 1), (1, 14), (14, 4);

insert into medjugradska (id, vozac_id, autobus_id, prevoznik_id, polazak, dolazak)
values (1, 1, 1, 1, '2018-09-07 12:00', '2018-09-07 14:30'), (2, 1, 1, 1, '2018-09-03 11:00', '2018-09-04 19:30'), (3, 2, 2, 2, '2018-09-07 13:00', '2018-09-07 14:30'),
(4, 2, 2, 3, '2018-09-06 09:00', '2018-09-06 11:00'), (5, 2, 2, 3, '2018-09-20 09:00', '2018-09-20 15:00');

insert into medjugradska_linija (medjugradska_id, linija_id)
values (1, 1), (1, 2), (1, 3), (2, 4), (2, 5), (3, 6),
(4, 10), (4, 11), (4, 12), (4, 2), (4, 3);

insert into gradska (id, broj_linije, red_voznje, vozac_id)
values (1, 23, 'nikad', 3), (2, 52, 'nekad :p', 2);

insert into gradska_linija (gradska_id, linija_id)
values (1, 7), (1, 8), (1, 9);



insert into korisnik_rezervacija (korisnik_username, medjugradska_id)
values ('strahinja', 1), ('strahinja', 2), ('milena', 3);


insert into poruka (id, poruka, gradska_id, datum_od, datum_do)
values (1, 'Linija 23 je otkazana', 1, '2018-09-07 12:00', '2018-09-10 12:00');

insert into korisnik_poruka (korisnik_username, poruka_id)
values ('strahinja', 1), ('milena', 1);




