-- DROP TABLE public.addresses;
CREATE TABLE public.addresses
(
    "postalCode" integer NOT NULL,
    street text COLLATE pg_catalog."default" NOT NULL,
    city text COLLATE pg_catalog."default" NOT NULL,
    country text COLLATE pg_catalog."default" NOT NULL,
    id integer NOT NULL DEFAULT nextval('addresses_id_seq'::regclass),
    CONSTRAINT addresses_pk PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.addresses
    OWNER to "Studierende";
    

-- DROP TABLE public.persons;
CREATE TABLE public.persons
(
    id integer NOT NULL DEFAULT nextval('persons_id_seq'::regclass),
    "firstName" text COLLATE pg_catalog."default",
    "lastName" text COLLATE pg_catalog."default",
    birthdate date,
    gender character(1) COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default",
    phone integer,
    address integer,
    CONSTRAINT persons_pkey PRIMARY KEY (id),
    CONSTRAINT address_fk FOREIGN KEY (id)
        REFERENCES public.addresses (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.persons
    OWNER to "Studierende";
    
       
-- DROP TABLE public.patients;
CREATE TABLE public.patients
(
    "healthInsuranceName" text COLLATE pg_catalog."default" NOT NULL,
    patient_id integer NOT NULL,
    CONSTRAINT patient_pk PRIMARY KEY (patient_id),
    CONSTRAINT patient_id FOREIGN KEY (patient_id)
        REFERENCES public.persons (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.patients
    OWNER to "Studierende";
    