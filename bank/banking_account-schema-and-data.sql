---
--- drop tables
---



DROP TABLE IF EXISTS banking_account;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE banking_account (
    id bigint NOT NULL,
    accountNumber character varying(50) NOT NULL,
    accountType character varying(50) NOT NULL,
    accountStatus  character varying(50) NOT NULL,
    availableBalance decimal,
);

INSERT INTO public.banking_account(id,accountNumber, accountType, accountStatus,availableBalance)	VALUES (1,'compte1','courant','PENDING',123);
INSERT INTO public.banking_account(id,accountNumber, accountType, accountStatus,availableBalance)	VALUES (2,'compte2','epargne','ACTIVE',225);

