---
--- drop tables
---



DROP TABLE IF EXISTS payments;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE payments (
    id bigint NOT NULL,
    amount decimal,
    paymentMode character varying(50) NOT NULL,
    cartName character varying(50) NOT NULL,
    cartNumber bigint,
    secretCode bigint,
    expirationDate Date,
    fromAccountNumber character varying(50) NOT NULL
);
INSERT INTO public.payments(id,amount, paymentMode, cartName,cartNumber,secretCode,expirationDate,fromAccountNumber)	VALUES (1,147,'credit','carte1',123,125,'02/02/2021','compte1');
INSERT INTO public.payments(id,amount, paymentMode, cartName,cartNumber,secretCode,expirationDate,fromAccountNumber)	VALUES (2,159,'paypal','carte2',225,5632,'02/01/2022','compte2');


