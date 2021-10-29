---
--- drop tables
---



DROP TABLE IF EXISTS payments;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE payments (
    id bigint NOT NULL,
    paymentMode character varying(50) NOT NULL,
    cartName character varying(50) NOT NULL,
    cartNumber bigint,
    secretCode bigint,
    ExpirationDate Date 
);

