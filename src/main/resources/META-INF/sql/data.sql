use Book3;

INSERT into authors (firstName, lastName) VALUES ('name', 'lastName');
INSERT into authors (firstName, lastName) VALUES ('name2', 'lastName2');
INSERT into authors (firstName, lastName) VALUES ('name3', 'lastName3');
INSERT into authors (firstName, lastName) VALUES ('name4', 'lastName4');
INSERT into authors (firstName, lastName) VALUES ('name5', 'lastName5');

insert into publishers (name) value ('pubblisher');
insert into publishers (name) value ('pubblisher2');
insert into publishers (name) value ('pubblisher3');
insert into publishers (name) value ('pubblisher4');
insert into publishers (name) value ('pubblisher5');

insert into books (description, rating, title, publisher_id) VALUES ('description', 10.00, 'title', 1);
insert into books (description, rating, title, publisher_id) VALUES ('description2', 11.00, 'title2', 2);
insert into books (description, rating, title, publisher_id) VALUES ('description3', 12.00, 'title3', 2);
insert into books (description, rating, title, publisher_id) VALUES ('description4', 13.00, 'title4', 3);
insert into books (description, rating, title, publisher_id) VALUES ('description5', 14.00, 'title5', 1);

insert into books_authors (book_id, authors_id) VALUES (1, 1);
insert into books_authors (book_id, authors_id) VALUES (2, 2);
insert into books_authors (book_id, authors_id) VALUES (1, 2);
insert into books_authors (book_id, authors_id) VALUES (2, 1);
insert into books_authors (book_id, authors_id) VALUES (3, 4);