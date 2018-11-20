--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-11-20 12:02:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 16394)
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria (
    id integer NOT NULL,
    descricao character varying NOT NULL
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16400)
-- Name: categoria_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categoria_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categoria_id_seq OWNER TO postgres;

--
-- TOC entry 2864 (class 0 OID 0)
-- Dependencies: 197
-- Name: categoria_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categoria_id_seq OWNED BY public.categoria.id;


--
-- TOC entry 198 (class 1259 OID 16402)
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcionario (
    login character varying NOT NULL,
    nome character varying NOT NULL,
    senha character varying NOT NULL,
    salario numeric NOT NULL
);


ALTER TABLE public.funcionario OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16408)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    id integer NOT NULL,
    descricao character varying NOT NULL,
    preco numeric NOT NULL,
    categoria_id integer NOT NULL,
    img character varying DEFAULT ''::character varying
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16414)
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produto_id_seq OWNER TO postgres;

--
-- TOC entry 2868 (class 0 OID 0)
-- Dependencies: 200
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;


--
-- TOC entry 204 (class 1259 OID 32923)
-- Name: produto_venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto_venda (
    id_venda integer NOT NULL,
    id_produto integer NOT NULL,
    quantidade integer NOT NULL,
    preco_unitario numeric NOT NULL
);


ALTER TABLE public.produto_venda OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16416)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    login character varying NOT NULL,
    nome character varying NOT NULL,
    senha character varying NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 32917)
-- Name: venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.venda (
    id integer NOT NULL,
    cliente_login character varying NOT NULL
);


ALTER TABLE public.venda OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 32915)
-- Name: venda_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.venda_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.venda_id_seq OWNER TO postgres;

--
-- TOC entry 2871 (class 0 OID 0)
-- Dependencies: 202
-- Name: venda_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.venda_id_seq OWNED BY public.venda.id;


--
-- TOC entry 2700 (class 2604 OID 16422)
-- Name: categoria id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria ALTER COLUMN id SET DEFAULT nextval('public.categoria_id_seq'::regclass);


--
-- TOC entry 2701 (class 2604 OID 16423)
-- Name: produto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto ALTER COLUMN id SET DEFAULT nextval('public.produto_id_seq'::regclass);


--
-- TOC entry 2703 (class 2604 OID 32920)
-- Name: venda id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda ALTER COLUMN id SET DEFAULT nextval('public.venda_id_seq'::regclass);


--
-- TOC entry 2845 (class 0 OID 16394)
-- Dependencies: 196
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria (id, descricao) FROM stdin;
4	CD
5	Box
6	DVD
7	Blu-Ray
\.


--
-- TOC entry 2847 (class 0 OID 16402)
-- Dependencies: 198
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.funcionario (login, nome, senha, salario) FROM stdin;
Teste	testador	123456	10
Sr.DBA	dba	amo dbs	10000
123	1232233	123	12332
\.


--
-- TOC entry 2848 (class 0 OID 16408)
-- Dependencies: 199
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produto (id, descricao, preco, categoria_id, img) FROM stdin;
1	CD 1	14.99	4	Sinal 2 PWM setup.jpeg
2	asd	24	4	tran.jpg
\.


--
-- TOC entry 2853 (class 0 OID 32923)
-- Dependencies: 204
-- Data for Name: produto_venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produto_venda (id_venda, id_produto, quantidade, preco_unitario) FROM stdin;
\.


--
-- TOC entry 2850 (class 0 OID 16416)
-- Dependencies: 201
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (login, nome, senha) FROM stdin;
qwe	qwe	qwe
bixiguinha	Sr. Bixiga	123
admin	admin	123
\.


--
-- TOC entry 2852 (class 0 OID 32917)
-- Dependencies: 203
-- Data for Name: venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.venda (id, cliente_login) FROM stdin;
\.


--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 197
-- Name: categoria_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categoria_id_seq', 7, true);


--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 200
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_id_seq', 2, true);


--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 202
-- Name: venda_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.venda_id_seq', 1, false);


--
-- TOC entry 2705 (class 2606 OID 16425)
-- Name: categoria categoria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pk PRIMARY KEY (id);


--
-- TOC entry 2707 (class 2606 OID 16427)
-- Name: funcionario funcionario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pk PRIMARY KEY (login);


--
-- TOC entry 2719 (class 2606 OID 32930)
-- Name: produto_venda pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto_venda
    ADD CONSTRAINT pkey PRIMARY KEY (id_venda, id_produto);


--
-- TOC entry 2710 (class 2606 OID 16429)
-- Name: produto produto_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pk PRIMARY KEY (id);


--
-- TOC entry 2712 (class 2606 OID 16431)
-- Name: usuario usuario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (login);


--
-- TOC entry 2715 (class 2606 OID 32922)
-- Name: venda venda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_pkey PRIMARY KEY (id);


--
-- TOC entry 2713 (class 1259 OID 32951)
-- Name: fki_cliente_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_cliente_fkey ON public.venda USING btree (cliente_login);


--
-- TOC entry 2708 (class 1259 OID 16432)
-- Name: fki_produto_categoria_id_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_produto_categoria_id_fk ON public.produto USING btree (categoria_id);


--
-- TOC entry 2716 (class 1259 OID 32942)
-- Name: fki_produto_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_produto_fkey ON public.produto_venda USING btree (id_produto);


--
-- TOC entry 2717 (class 1259 OID 32936)
-- Name: fki_venda_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_venda_fkey ON public.produto_venda USING btree (id_venda);


--
-- TOC entry 2721 (class 2606 OID 32946)
-- Name: venda cliente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT cliente_fkey FOREIGN KEY (cliente_login) REFERENCES public.usuario(login);


--
-- TOC entry 2720 (class 2606 OID 16433)
-- Name: produto produto_categoria_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_categoria_id_fk FOREIGN KEY (categoria_id) REFERENCES public.categoria(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2723 (class 2606 OID 32937)
-- Name: produto_venda produto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto_venda
    ADD CONSTRAINT produto_fkey FOREIGN KEY (id_produto) REFERENCES public.produto(id);


--
-- TOC entry 2722 (class 2606 OID 32931)
-- Name: produto_venda venda_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto_venda
    ADD CONSTRAINT venda_fkey FOREIGN KEY (id_venda) REFERENCES public.venda(id);


--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: appweb
--

REVOKE ALL ON SCHEMA public FROM postgres;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO appweb;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- TOC entry 2863 (class 0 OID 0)
-- Dependencies: 196
-- Name: TABLE categoria; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.categoria TO appweb;


--
-- TOC entry 2865 (class 0 OID 0)
-- Dependencies: 197
-- Name: SEQUENCE categoria_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.categoria_id_seq TO appweb;


--
-- TOC entry 2866 (class 0 OID 0)
-- Dependencies: 198
-- Name: TABLE funcionario; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.funcionario TO appweb;


--
-- TOC entry 2867 (class 0 OID 0)
-- Dependencies: 199
-- Name: TABLE produto; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.produto TO appweb;


--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 200
-- Name: SEQUENCE produto_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.produto_id_seq TO appweb;


--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 201
-- Name: TABLE usuario; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.usuario TO appweb;


-- Completed on 2018-11-20 12:02:17

--
-- PostgreSQL database dump complete
--

