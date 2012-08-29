--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.2
-- Dumped by pg_dump version 9.1.2
-- Started on 2012-08-29 19:07:38 EDT

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2134 (class 1262 OID 57465)
-- Name: employee; Type: DATABASE; Schema: -; Owner: wpfeiffe
--

CREATE DATABASE employee WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'C';


ALTER DATABASE employee OWNER TO wpfeiffe;

\connect employee

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 164 (class 3079 OID 11907)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 164
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 161 (class 1259 OID 65684)
-- Dependencies: 5
-- Name: department; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE department (
    id bigint NOT NULL,
    version bigint NOT NULL,
    date_created timestamp without time zone NOT NULL,
    department_text character varying(255) NOT NULL,
    dept_code character varying(10) NOT NULL,
    dept_name character varying(30) NOT NULL,
    last_updated timestamp without time zone NOT NULL,
    mission text
);


ALTER TABLE public.department OWNER TO postgres;

--
-- TOC entry 162 (class 1259 OID 65696)
-- Dependencies: 5
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE employee (
    id bigint NOT NULL,
    version bigint NOT NULL,
    active boolean NOT NULL,
    date_created timestamp without time zone NOT NULL,
    department_id bigint NOT NULL,
    employee_text character varying(255) NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(35) NOT NULL,
    last_updated timestamp without time zone NOT NULL,
    ssn character varying(11) NOT NULL,
    start_date timestamp without time zone NOT NULL,
    title character varying(25) NOT NULL
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- TOC entry 163 (class 1259 OID 65708)
-- Dependencies: 5
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 2138 (class 0 OID 0)
-- Dependencies: 163
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hibernate_sequence', 14, true);


--
-- TOC entry 2130 (class 0 OID 65684)
-- Dependencies: 161
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO department VALUES (2, 0, '2012-07-31 19:37:32.386', 'Accounting:ACCT', 'ACCT', 'Accounting', '2012-07-31 19:37:32.386', '<h1>Charging For Stuff</h1>');
INSERT INTO department VALUES (3, 0, '2012-07-31 19:37:32.392', 'Operations:OPS', 'OPS', 'Operations', '2012-07-31 19:37:32.392', '<h1>Doing Stuff</h1>');
INSERT INTO department VALUES (4, 0, '2012-07-31 19:37:32.401', 'Marketing:MKT', 'MKT', 'Marketing', '2012-07-31 19:37:32.401', '<h1>Selling Stuff</h1>');
INSERT INTO department VALUES (5, 0, '2012-07-31 19:37:32.409', 'Human Resources:HR', 'HR', 'Human Resources', '2012-07-31 19:37:32.409', '<h2>Hiring People to do Stuff</h2>');
INSERT INTO department VALUES (1, 1, '2012-07-31 19:37:32.358', 'MIS:MIS IT', 'MIS IT', 'MIS', '2012-07-31 19:38:11.939', '<h1>Building Techie Stuff</h1>');


--
-- TOC entry 2131 (class 0 OID 65696)
-- Dependencies: 162
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO employee VALUES (6, 0, true, '2012-07-31 19:37:32.415', 1, '111-11-1111:Bill Pfeiffer', 'Bill', 'Pfeiffer', '2012-07-31 19:37:32.415', '111-11-1111', '2012-07-31 19:37:32.173', 'Software Dev Mgr');
INSERT INTO employee VALUES (7, 0, true, '2012-07-31 19:37:32.643', 1, '222-11-1111:Derek Glidden', 'Derek', 'Glidden', '2012-07-31 19:37:32.643', '222-11-1111', '2012-07-31 19:37:32.256', 'Senior Developer');
INSERT INTO employee VALUES (8, 0, true, '2012-07-31 19:37:32.647', 1, '333-11-1111:John Alchin', 'John', 'Alchin', '2012-07-31 19:37:32.647', '333-11-1111', '2012-07-31 19:37:32.266', 'Senior Developer');
INSERT INTO employee VALUES (9, 0, true, '2012-07-31 19:37:32.652', 1, '444-11-1111:Jeremy Naylor', 'Jeremy', 'Naylor', '2012-07-31 19:37:32.652', '444-11-1111', '2012-07-31 19:37:32.278', 'Developer');
INSERT INTO employee VALUES (10, 0, true, '2012-07-31 19:37:32.656', 1, '555-11-1111:Greg Bowman', 'Greg', 'Bowman', '2012-07-31 19:37:32.656', '555-11-1111', '2012-07-31 19:37:32.291', 'Senior Developer');
INSERT INTO employee VALUES (11, 0, true, '2012-07-31 19:37:32.659', 1, '666-11-1111:PJ Tenn', 'PJ', 'Tenn', '2012-07-31 19:37:32.659', '666-11-1111', '2012-07-31 19:37:32.299', 'Developer');
INSERT INTO employee VALUES (12, 0, true, '2012-07-31 19:37:32.661', 1, '777-11-1111:Jeremy Perkins', 'Jeremy', 'Perkins', '2012-07-31 19:37:32.661', '777-11-1111', '2012-07-31 19:37:32.311', 'DBA');
INSERT INTO employee VALUES (13, 0, true, '2012-07-31 19:37:32.667', 1, '888-11-1111:John Vann', 'John', 'Vann', '2012-07-31 19:37:32.667', '888-11-1111', '2012-07-31 19:37:32.324', 'MIS Mgr');
INSERT INTO employee VALUES (14, 0, true, '2012-07-31 19:37:32.671', 1, '999-11-1111:Bob Kollasch', 'Bob', 'Kollasch', '2012-07-31 19:37:32.671', '999-11-1111', '2012-07-31 19:37:32.337', 'Quality Analyst');


--
-- TOC entry 2120 (class 2606 OID 65693)
-- Dependencies: 161 161
-- Name: department_dept_code_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_dept_code_key UNIQUE (dept_code);


--
-- TOC entry 2122 (class 2606 OID 65695)
-- Dependencies: 161 161
-- Name: department_dept_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_dept_name_key UNIQUE (dept_name);


--
-- TOC entry 2124 (class 2606 OID 65691)
-- Dependencies: 161 161
-- Name: department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


--
-- TOC entry 2126 (class 2606 OID 65700)
-- Dependencies: 162 162
-- Name: employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- TOC entry 2128 (class 2606 OID 65702)
-- Dependencies: 162 162
-- Name: employee_ssn_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_ssn_key UNIQUE (ssn);


--
-- TOC entry 2129 (class 2606 OID 65703)
-- Dependencies: 2123 162 161
-- Name: fk4722e6aee2adb49a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT fk4722e6aee2adb49a FOREIGN KEY (department_id) REFERENCES department(id);


--
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2012-08-29 19:07:38 EDT

--
-- PostgreSQL database dump complete
--

