--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE categories (
    id integer NOT NULL,
    category_type character varying(30)
);


ALTER TABLE categories OWNER TO josh;

--
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: josh
--

CREATE SEQUENCE categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE categories_id_seq OWNER TO josh;

--
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: josh
--

ALTER SEQUENCE categories_id_seq OWNED BY categories.id;


--
-- Name: game; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE game (
    id integer NOT NULL,
    category_id integer NOT NULL,
    datetime timestamp without time zone NOT NULL
);


ALTER TABLE game OWNER TO josh;

--
-- Name: game_id_seq; Type: SEQUENCE; Schema: public; Owner: josh
--

CREATE SEQUENCE game_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE game_id_seq OWNER TO josh;

--
-- Name: game_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: josh
--

ALTER SEQUENCE game_id_seq OWNED BY game.id;


--
-- Name: game_results; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE game_results (
    game_id integer,
    player_id integer,
    phrase_id integer,
    iswinner boolean DEFAULT false
);


ALTER TABLE game_results OWNER TO josh;

--
-- Name: phrases; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE phrases (
    id integer NOT NULL,
    phrase character varying(100) NOT NULL,
    category_id integer NOT NULL
);


ALTER TABLE phrases OWNER TO josh;

--
-- Name: phrases_id_seq; Type: SEQUENCE; Schema: public; Owner: josh
--

CREATE SEQUENCE phrases_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE phrases_id_seq OWNER TO josh;

--
-- Name: phrases_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: josh
--

ALTER SEQUENCE phrases_id_seq OWNED BY phrases.id;


--
-- Name: players; Type: TABLE; Schema: public; Owner: josh
--

CREATE TABLE players (
    id integer NOT NULL,
    firstname character varying(20),
    lastname character varying(20),
    username character varying(10),
    password character varying(10),
    email character varying(40)
);


ALTER TABLE players OWNER TO josh;

--
-- Name: players_id_seq; Type: SEQUENCE; Schema: public; Owner: josh
--

CREATE SEQUENCE players_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE players_id_seq OWNER TO josh;

--
-- Name: players_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: josh
--

ALTER SEQUENCE players_id_seq OWNED BY players.id;


--
-- Name: categories id; Type: DEFAULT; Schema: public; Owner: josh
--

ALTER TABLE ONLY categories ALTER COLUMN id SET DEFAULT nextval('categories_id_seq'::regclass);


--
-- Name: game id; Type: DEFAULT; Schema: public; Owner: josh
--

ALTER TABLE ONLY game ALTER COLUMN id SET DEFAULT nextval('game_id_seq'::regclass);


--
-- Name: phrases id; Type: DEFAULT; Schema: public; Owner: josh
--

ALTER TABLE ONLY phrases ALTER COLUMN id SET DEFAULT nextval('phrases_id_seq'::regclass);


--
-- Name: players id; Type: DEFAULT; Schema: public; Owner: josh
--

ALTER TABLE ONLY players ALTER COLUMN id SET DEFAULT nextval('players_id_seq'::regclass);


--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY categories (id, category_type) FROM stdin;
1	Sports Idioms
2	Programming Jargon
\.


--
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: josh
--

SELECT pg_catalog.setval('categories_id_seq', 2, true);


--
-- Data for Name: game; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY game (id, category_id, datetime) FROM stdin;
1	2	2017-04-07 00:43:17.251443
\.


--
-- Name: game_id_seq; Type: SEQUENCE SET; Schema: public; Owner: josh
--

SELECT pg_catalog.setval('game_id_seq', 1, true);


--
-- Data for Name: game_results; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY game_results (game_id, player_id, phrase_id, iswinner) FROM stdin;
\.


--
-- Data for Name: phrases; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY phrases (id, phrase, category_id) FROM stdin;
1	ballpark	1
2	block and tackle	1
3	carry the ball	1
4	come out fighting or come out swinging	1
5	curveball	1
6	down and out	1
7	down for the count; out for the count	1
8	down to the wire	1
9	drop the ball	1
10	drop the gloves	1
11	end run	1
12	hail mary	1
13	Yoda Conditions	2
14	Smug Report	2
15	A duck	2
16	Refuctoring	2
17	Heisenbug	2
18	Jimmy	2
19	Higgs Bugson	2
20	Unicorny	2
21	Hindenbug	2
22	Fear-driven development	2
23	Hydra	2
24	Common Law Feature	2
25	Loch Ness Monster bug	2
26	Rubberducking	2
27	Banana banana banana	2
28	Reality 101 failure	2
29	Mad girlfriend bug	2
30	Hooker code	2
31	Jenga code	2
\.


--
-- Name: phrases_id_seq; Type: SEQUENCE SET; Schema: public; Owner: josh
--

SELECT pg_catalog.setval('phrases_id_seq', 31, true);


--
-- Data for Name: players; Type: TABLE DATA; Schema: public; Owner: josh
--

COPY players (id, firstname, lastname, username, password, email) FROM stdin;
\.


--
-- Name: players_id_seq; Type: SEQUENCE SET; Schema: public; Owner: josh
--

SELECT pg_catalog.setval('players_id_seq', 1, false);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- Name: game game_pkey; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY game
    ADD CONSTRAINT game_pkey PRIMARY KEY (id);


--
-- Name: phrases phrases_pkey; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY phrases
    ADD CONSTRAINT phrases_pkey PRIMARY KEY (id);


--
-- Name: players players_pkey; Type: CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY players
    ADD CONSTRAINT players_pkey PRIMARY KEY (id);


--
-- Name: category_id_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX category_id_unique ON categories USING btree (id);


--
-- Name: game_id_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX game_id_unique ON game USING btree (id);


--
-- Name: phrases_id_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX phrases_id_unique ON phrases USING btree (id);


--
-- Name: phrases_phrase_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX phrases_phrase_unique ON phrases USING btree (phrase);


--
-- Name: user_id_unique; Type: INDEX; Schema: public; Owner: josh
--

CREATE UNIQUE INDEX user_id_unique ON players USING btree (id);


--
-- Name: game game_category_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY game
    ADD CONSTRAINT game_category_id_fkey FOREIGN KEY (category_id) REFERENCES categories(id);


--
-- Name: game_results game_results_game_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY game_results
    ADD CONSTRAINT game_results_game_id_fkey FOREIGN KEY (game_id) REFERENCES game(id);


--
-- Name: game_results game_results_phrase_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY game_results
    ADD CONSTRAINT game_results_phrase_id_fkey FOREIGN KEY (phrase_id) REFERENCES phrases(id);


--
-- Name: game_results game_results_player_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY game_results
    ADD CONSTRAINT game_results_player_id_fkey FOREIGN KEY (player_id) REFERENCES players(id);


--
-- Name: phrases phrases_category_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: josh
--

ALTER TABLE ONLY phrases
    ADD CONSTRAINT phrases_category_id_fkey FOREIGN KEY (category_id) REFERENCES categories(id);


--
-- PostgreSQL database dump complete
--

