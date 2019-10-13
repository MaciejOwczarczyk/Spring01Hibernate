use Book2;

INSERT INTO Category (name) values ('category1');

INSERT into authors (email, firstName, lastName, pesel, yearOfBirth) VALUES ('name@email.pl', 'firstName', 'lastName', 93342313465, 1990);
INSERT into authors (email, firstName, lastName, pesel, yearOfBirth) VALUES ('name2@email.pl', 'first2Name', 'last2Name', 93342413465, 1980);
INSERT into authors (email, firstName, lastName, pesel, yearOfBirth) VALUES ('name3@email.pl', 'first3Name', 'last3Name', 93342315465, 1995);
INSERT into authors (email, firstName, lastName, pesel, yearOfBirth) VALUES ('name4@email.pl', 'first4Name', 'last4Name', 93342313465, 1991);
INSERT into authors (email, firstName, lastName, pesel, yearOfBirth) VALUES ('name5@email.pl', 'first5Name', 'last5Name', 93342313565, 1992);

insert into publishers (name, nip, regon) value ('pubblisher', '3762764522', '146222089');
insert into publishers (name, nip, regon) value ('pubblisher2', '3732764522', '141132089');
insert into publishers (name, nip, regon) value ('pubblisher3', '3442764522', '146922089');
insert into publishers (name, nip, regon) value ('pubblisher4', '3332764522', '146939111');
insert into publishers (name, nip, regon) value ('pubblisher5', '3222764522', '126939022');
insert into publishers (name, nip, regon) value ('pubblisher6', '3112764522', '116939022');

insert into books (proposition, description, pages, rating, title, category_id, publisher_id) VALUES (false, 'description', 3, 1.00, 'title',1, 1);
insert into books (proposition, description, pages, rating, title, category_id, publisher_id) VALUES (false, 'description', 3, 3.00, 'title2',1, 2);
insert into books (proposition, description, pages, rating, title, category_id, publisher_id) VALUES (false, 'description', 1, 2.00, 'title3',1, 2);
insert into books (proposition, description, pages, rating, title, category_id, publisher_id) VALUES (false, 'description', 3, 4.00, 'title4',1, 1);
insert into books (proposition, description, pages, rating, title, category_id, publisher_id) VALUES (false, 'description', 3, 5.50, 'title5',1, 5);
insert into books (proposition, description, pages, rating, title, category_id, publisher_id) VALUES (false, 'description', 3, 6.10, 'title6',1, 4);



insert into books_authors (book_id, authors_id) VALUES (1, 1);
insert into books_authors (book_id, authors_id) VALUES (2, 2);
insert into books_authors (book_id, authors_id) VALUES (1, 2);
insert into books_authors (book_id, authors_id) VALUES (2, 1);
insert into books_authors (book_id, authors_id) VALUES (3, 4);
