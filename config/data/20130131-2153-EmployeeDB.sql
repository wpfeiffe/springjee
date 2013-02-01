--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.2
-- Dumped by pg_dump version 9.1.2
-- Started on 2013-01-31 21:55:32 EST

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 164 (class 1259 OID 90313)
-- Dependencies: 5
-- Name: department; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE department (
    id bigint NOT NULL,
    version bigint NOT NULL,
    department_text character varying(255) NOT NULL,
    dept_code character varying(10) NOT NULL,
    dept_name character varying(30) NOT NULL,
    mission text
);


ALTER TABLE public.department OWNER TO postgres;

--
-- TOC entry 165 (class 1259 OID 90325)
-- Dependencies: 5
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE employee (
    id bigint NOT NULL,
    version bigint NOT NULL,
    active boolean NOT NULL,
    department_id bigint NOT NULL,
    employee_text character varying(255) NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(35) NOT NULL,
    ssn character varying(11) NOT NULL,
    start_date timestamp without time zone NOT NULL,
    title character varying(25) NOT NULL
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 90407)
-- Dependencies: 2140 2141 5
-- Name: user_acct; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE user_acct (
    user_id bigint NOT NULL,
    version bigint,
    login character varying(30),
    password character varying(4096),
    cred_expire_date timestamp without time zone,
    acct_expire_date timestamp without time zone,
    acct_locked boolean DEFAULT false NOT NULL,
    acct_enabled boolean DEFAULT true NOT NULL
);


ALTER TABLE public.user_acct OWNER TO postgres;

--
-- TOC entry 2167 (class 0 OID 0)
-- Dependencies: 168
-- Name: TABLE user_acct; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE user_acct IS 'User table for Spring Security';


--
-- TOC entry 2168 (class 0 OID 0)
-- Dependencies: 168
-- Name: COLUMN user_acct.user_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN user_acct.user_id IS 'Unique identifier pk for user';


--
-- TOC entry 2169 (class 0 OID 0)
-- Dependencies: 168
-- Name: COLUMN user_acct.version; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN user_acct.version IS 'Counter value for ORM optimistic locking';


--
-- TOC entry 2170 (class 0 OID 0)
-- Dependencies: 168
-- Name: COLUMN user_acct.login; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN user_acct.login IS 'User will login with this value';


--
-- TOC entry 2171 (class 0 OID 0)
-- Dependencies: 168
-- Name: COLUMN user_acct.password; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN user_acct.password IS 'Hashed password value to authenticate user';


--
-- TOC entry 2172 (class 0 OID 0)
-- Dependencies: 168
-- Name: COLUMN user_acct.cred_expire_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN user_acct.cred_expire_date IS 'Expire date for credentials (password)';


--
-- TOC entry 2173 (class 0 OID 0)
-- Dependencies: 168
-- Name: COLUMN user_acct.acct_expire_date; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN user_acct.acct_expire_date IS 'Expire date for this user account';


--
-- TOC entry 2174 (class 0 OID 0)
-- Dependencies: 168
-- Name: COLUMN user_acct.acct_locked; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN user_acct.acct_locked IS 'Is account locked';


--
-- TOC entry 2175 (class 0 OID 0)
-- Dependencies: 168
-- Name: COLUMN user_acct.acct_enabled; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN user_acct.acct_enabled IS 'Is account enabled';


--
-- TOC entry 167 (class 1259 OID 90405)
-- Dependencies: 168 5
-- Name: user_acct_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_acct_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_acct_user_id_seq OWNER TO postgres;

--
-- TOC entry 2176 (class 0 OID 0)
-- Dependencies: 167
-- Name: user_acct_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user_acct_user_id_seq OWNED BY user_acct.user_id;


--
-- TOC entry 2177 (class 0 OID 0)
-- Dependencies: 167
-- Name: user_acct_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_acct_user_id_seq', 2, true);


--
-- TOC entry 170 (class 1259 OID 90420)
-- Dependencies: 5
-- Name: user_role; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE user_role (
    user_role_id bigint NOT NULL,
    role_name character varying(30) NOT NULL,
    version bigint NOT NULL,
    user_id bigint NOT NULL
);


ALTER TABLE public.user_role OWNER TO postgres;

--
-- TOC entry 2178 (class 0 OID 0)
-- Dependencies: 170
-- Name: TABLE user_role; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE user_role IS 'Roles associated to user,  provides authorization function';


--
-- TOC entry 2179 (class 0 OID 0)
-- Dependencies: 170
-- Name: COLUMN user_role.user_role_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN user_role.user_role_id IS 'Unique identifier for this user role association';


--
-- TOC entry 2180 (class 0 OID 0)
-- Dependencies: 170
-- Name: COLUMN user_role.role_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN user_role.role_name IS 'Role indicating specific authorization type';


--
-- TOC entry 2181 (class 0 OID 0)
-- Dependencies: 170
-- Name: COLUMN user_role.version; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN user_role.version IS 'Value for ORM optimistic locking';


--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 170
-- Name: COLUMN user_role.user_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN user_role.user_id IS 'Foreign key establishing association to User table';


--
-- TOC entry 169 (class 1259 OID 90418)
-- Dependencies: 170 5
-- Name: user_role_user_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_role_user_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_role_user_role_id_seq OWNER TO postgres;

--
-- TOC entry 2183 (class 0 OID 0)
-- Dependencies: 169
-- Name: user_role_user_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user_role_user_role_id_seq OWNED BY user_role.user_role_id;


--
-- TOC entry 2184 (class 0 OID 0)
-- Dependencies: 169
-- Name: user_role_user_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_role_user_role_id_seq', 3, true);


--
-- TOC entry 2139 (class 2604 OID 90410)
-- Dependencies: 168 167 168
-- Name: user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE user_acct ALTER COLUMN user_id SET DEFAULT nextval('user_acct_user_id_seq'::regclass);


--
-- TOC entry 2142 (class 2604 OID 90423)
-- Dependencies: 170 169 170
-- Name: user_role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE user_role ALTER COLUMN user_role_id SET DEFAULT nextval('user_role_user_role_id_seq'::regclass);


--
-- TOC entry 2161 (class 0 OID 90313)
-- Dependencies: 164
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY department (id, version, department_text, dept_code, dept_name, mission) FROM stdin;
1	0	MIS:MIS	MIS	MIS	<h1>Building Techie Stuff</h1>
2	0	Accounting:ACCT	ACCT	Accounting	<h1>Charging For Stuff</h1>
3	0	Operations:OPS	OPS	Operations	<h1>Doing Stuff</h1>
4	0	Marketing:MKT	MKT	Marketing	<h1>Selling Stuff</h1>
5	0	Human Resources:HR	HR	Human Resources	<h2>Hiring People to do Stuff</h2>
\.


--
-- TOC entry 2162 (class 0 OID 90325)
-- Dependencies: 165
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY employee (id, version, active, department_id, employee_text, first_name, last_name, ssn, start_date, title) FROM stdin;
6	0	t	1	111-11-1111:Bill Pfeiffer	Bill	Pfeiffer	111-11-1111	2013-01-19 06:55:09.283	Software Dev Mgr
7	0	t	1	222-11-1111:Derek Glidden	Derek	Glidden	222-11-1111	2013-01-19 06:55:09.346	Senior Developer
8	0	t	1	333-11-1111:John Alchin	John	Alchin	333-11-1111	2013-01-19 06:55:09.358	Senior Developer
9	0	t	1	444-11-1111:Jeremy Naylor	Jeremy	Naylor	444-11-1111	2013-01-19 06:55:09.367	Developer
10	0	t	1	555-11-1111:Greg Bowman	Greg	Bowman	555-11-1111	2013-01-19 06:55:09.377	Senior Developer
11	0	t	1	666-11-1111:PJ Tenn	PJ	Tenn	666-11-1111	2013-01-19 06:55:09.387	Developer
12	0	t	1	777-11-1111:Jeremy Perkins	Jeremy	Perkins	777-11-1111	2013-01-19 06:55:09.398	DBA
13	0	t	1	888-11-1111:John Vann	John	Vann	888-11-1111	2013-01-19 06:55:09.408	MIS Mgr
14	0	t	1	999-11-1111:Bob Kollasch	Bob	Kollasch	999-11-1111	2013-01-19 06:55:09.422	Quality Analyst
15	0	t	3	This is an employee	Greg	Johnson	667-29-5840	2013-01-31 21:38:30.787	Manager
16	0	t	2	This is an employee	Jennifer	Johnson	784-81-5381	2013-01-31 21:38:45.599	Accounts Recievable
\.


--
-- TOC entry 2163 (class 0 OID 90407)
-- Dependencies: 168
-- Data for Name: user_acct; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_acct (user_id, version, login, password, cred_expire_date, acct_expire_date, acct_locked, acct_enabled) FROM stdin;
1	1	wpfeiffe	$2a$10$TfXwl./br6HrkLgFj0ya3uwp2MdykYyjwTEzIKZu27qWqqmzCujYa	2080-01-01 00:00:00	2080-01-01 00:00:00	f	t
2	1	admin	$2a$10$TfXwl./br6HrkLgFj0ya3uwp2MdykYyjwTEzIKZu27qWqqmzCujYa	2080-01-01 00:00:00	2080-01-01 00:00:00	f	t
\.


--
-- TOC entry 2164 (class 0 OID 90420)
-- Dependencies: 170
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_role (user_role_id, role_name, version, user_id) FROM stdin;
1	ROLE_ADMIN	1	1
2	ROLE_USER	1	1
3	ROLE_ADMIN	1	2
\.


--
-- TOC entry 2144 (class 2606 OID 90322)
-- Dependencies: 164 164
-- Name: department_dept_code_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_dept_code_key UNIQUE (dept_code);


--
-- TOC entry 2146 (class 2606 OID 90324)
-- Dependencies: 164 164
-- Name: department_dept_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_dept_name_key UNIQUE (dept_name);


--
-- TOC entry 2148 (class 2606 OID 90320)
-- Dependencies: 164 164
-- Name: department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


--
-- TOC entry 2150 (class 2606 OID 90329)
-- Dependencies: 165 165
-- Name: employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- TOC entry 2152 (class 2606 OID 90331)
-- Dependencies: 165 165
-- Name: employee_ssn_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_ssn_key UNIQUE (ssn);


--
-- TOC entry 2154 (class 2606 OID 90417)
-- Dependencies: 168 168
-- Name: login_uc; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY user_acct
    ADD CONSTRAINT login_uc UNIQUE (login);


--
-- TOC entry 2156 (class 2606 OID 90415)
-- Dependencies: 168 168
-- Name: user_id_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY user_acct
    ADD CONSTRAINT user_id_pk PRIMARY KEY (user_id);


--
-- TOC entry 2158 (class 2606 OID 90425)
-- Dependencies: 170 170
-- Name: user_role_id_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_id_pk PRIMARY KEY (user_role_id);


--
-- TOC entry 2159 (class 2606 OID 90332)
-- Dependencies: 165 164 2147
-- Name: fk4722e6aee2adb49a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT fk4722e6aee2adb49a FOREIGN KEY (department_id) REFERENCES department(id);


--
-- TOC entry 2160 (class 2606 OID 90426)
-- Dependencies: 2155 168 170
-- Name: user_role_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_user_fk FOREIGN KEY (user_id) REFERENCES user_acct(user_id);


-- Completed on 2013-01-31 21:55:32 EST

--
-- PostgreSQL database dump complete
--

