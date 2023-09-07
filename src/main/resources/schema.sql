CREATE TABLE Director
(
    id       UUID NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_director PRIMARY KEY (id)
);

CREATE TABLE Writer
(
    id   UUID NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_writer PRIMARY KEY (id)
);

CREATE TABLE Genre
(
    id    UUID NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_genre PRIMARY KEY (id)
);

CREATE TABLE Movie
(
    movie_id     UUID    NOT NULL,
    rank        INTEGER NOT NULL,
    title       VARCHAR(255),
    thumbnail   VARCHAR(255),
    rating      VARCHAR(255),
    id          VARCHAR(255),
    year        INTEGER NOT NULL,
    image       VARCHAR(255),
    description VARCHAR(255),
    trailer     VARCHAR(255),
    imdbid      VARCHAR(255),
    CONSTRAINT pk_movie PRIMARY KEY (movie_id)
);

CREATE TABLE Movie_director
(
    Movie_movie_id UUID NOT NULL,
    director_id   UUID NOT NULL,
    CONSTRAINT pk_movie_director PRIMARY KEY (Movie_movie_id, director_id)
);

CREATE TABLE Movie_genre
(
    Movie_movie_id UUID NOT NULL,
    genre_id      UUID NOT NULL,
    CONSTRAINT pk_movie_genre PRIMARY KEY (Movie_movie_id, genre_id)
);

CREATE TABLE Movie_writers
(
    Movie_movie_id UUID NOT NULL,
    writers_id    UUID NOT NULL,
    CONSTRAINT pk_movie_writers PRIMARY KEY (Movie_movie_id, writers_id)
);