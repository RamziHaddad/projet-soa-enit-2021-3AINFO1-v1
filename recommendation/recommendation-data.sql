CREATE TABLE recommendations (
    id uuid NOT NULL,
    productId1 character varying(50) NOT NULL,
    productId2 character varying(50) NOT NULL,
    nbrOccurrences int
);


